package com.luoge.bos.op.uc.service;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.luoge.bos.op.uc.core.AuthenticationType;
import com.luoge.bos.op.uc.core.UserStatus;
import com.luoge.bos.op.uc.dao.BosUserDao;
import com.luoge.bos.op.uc.dao.PermissionDao;
import com.luoge.bos.op.uc.model.AuthenticationBO;
import com.luoge.bos.op.uc.model.CaptchaBO;
import com.luoge.bos.op.uc.model.permission.PermissionVO;
import com.luoge.bos.uc.core.HashIds;
import com.luoge.bos.uc.core.UCCode;
import com.luoge.bos.op.uc.entity.UserDO;
import com.luoge.bos.uc.model.User;
import com.luoge.ns.core.R;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class AuthenticationService {

    private Cache<Integer, User> userCache;

    private Cache<Integer, CaptchaBO> captchaCache;

    @Resource
    private BosUserDao bosUserDao;

    @Resource
    private PermissionDao permissionDao;

    @PostConstruct
    private void init() {
        userCache = Caffeine.newBuilder()
                .initialCapacity(100)
                .expireAfterAccess(4, TimeUnit.HOURS).build();

        captchaCache = Caffeine.newBuilder()
                .initialCapacity(100)
                .expireAfterWrite(15, TimeUnit.MINUTES).build();
    }

    public R<String> signIn(@RequestBody AuthenticationBO user) {
        UserDO userDO;
        if (AuthenticationType.isUserName(user.getType())) {
            userDO = bosUserDao.getByUsername(user.getUsername());
            Digester digester = new Digester(DigestAlgorithm.MD5);
            String password = digester.digestHex(user.getPasswd());
            if (Objects.isNull(userDO) || !Objects.equals(password, userDO.getPasswd())) {
                return R.fail(UCCode.ERR_AUTH_TYPE_USERNAME);
            }
        } else if (AuthenticationType.isMobile(user.getType())) {
            userDO = bosUserDao.getByMobile(user.getMobile());
            if (Objects.isNull(userDO)) {
                return R.fail(UCCode.NOT_USER_PHONE_NUMBER);
            }
            Integer userId = userDO.getId();
            CaptchaBO verification = captchaCache.getIfPresent(userId);
            if (Objects.isNull(verification)) {
                return R.fail(UCCode.CAPTCHA_EXPIRED);
            }
            if (!Objects.equals(verification.getCaptcha(), user.getVerificationCode())) {
                return R.fail(UCCode.WRONG_CAPTCHA);
            }
        } else {
            return R.fail(UCCode.ERR_AUTH_TYPE);
        }

        // 检查用户状态
        if (UserStatus.isLock(userDO.getStatus())) {
            return R.fail(UCCode.USER_STATUS_LOCK);
        } else if (UserStatus.isDisable(userDO.getStatus())) {
            return R.fail(UCCode.USER_STATUS_DISABLE);
        }

        User cacheUser = new User();
        cacheUser.setId(userDO.getId());
        cacheUser.setName(userDO.getName());
        cacheUser.setOrgId(userDO.getOrgId());

        List<Integer> roles = bosUserDao.listUserRoles(userDO.getOrgId(), userDO.getId());
        cacheUser.setRoles(roles);
        List<String> permissions;
        if (userDO.getAdmin()) {
            permissions = permissionDao.list().stream().map(PermissionVO::getCode).collect(Collectors.toList());
        } else {
            permissions = ObjectUtil.isEmpty(roles) ? new ArrayList<>() : bosUserDao.listUserPermissions(userDO.getOrgId(), roles);
        }
        cacheUser.setPermissions(permissions);

        this.userCache.put(cacheUser.getId(), cacheUser);
        String token = HashIds.encode(cacheUser.getOrgId(), cacheUser.getId());

        return R.success(token);
    }



    public void signOut(int userId) {
        this.userCache.invalidate(userId);
    }

    public User getUser(int userId) {
        return this.userCache.getIfPresent(userId);
    }
}
