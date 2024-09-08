package com.luoge.app.uc.auth;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.luoge.app.uc.core.UserStatus;
import com.luoge.app.uc.model.LoginResultBO;
import com.luoge.app.uc.model.SmsPurpose;
import com.luoge.app.uc.model.User;
import com.luoge.app.uc.model.VerificationCodeBO;
import com.luoge.app.uc.service.NotificationCenterService;
import com.luoge.app.uc.service.UserService;
import com.luoge.bos.core.BosAppCode;
import com.luoge.bos.data.PermissionDao;
import com.luoge.bos.data.UserDao;
import com.luoge.bos.data.configuration.wx.WxConfig;
import com.luoge.bos.data.entity.PermissionDO;
import com.luoge.bos.data.entity.UserDO;
import com.luoge.bos.data.model.SendSmsBO;
import com.luoge.bos.uc.core.Constants;
import com.luoge.bos.uc.core.HashIds;
import com.luoge.bos.uc.core.UCCode;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AuthnService {

    @Resource
    private UserDao userDao;

    @Resource
    private PermissionDao permissionDao;

    @Resource
    private CacheService cacheService;

    @Resource
    private UserService userService;

    @Resource
    private NotificationCenterService notificationCenterService;
//
    @Resource
    private WxConfig wxConfig;


    /**
     * 将对应的用户设置为 登录状态
     */
    public R<LoginResultBO> signIn(UserDO userDO) {
        // 检查用户状态
        if (UserStatus.isLock(userDO.getStatus())) {
            return R.fail(BosAppCode.USER_STATUS_LOCK);
        } else if (UserStatus.isDisable(userDO.getStatus())) {
            return R.fail(BosAppCode.USER_STATUS_DISABLE);
        }

        User cacheUser = buildCacheUser(userDO);
        List<Integer> roles = userDao.listUserRoles(userDO.getOrgId(), userDO.getId());
        cacheUser.setRoles(roles);
        List<String> permissions;
        if (userDO.getAdmin()) {
            permissions = permissionDao.listWithMenus()
                    .stream()
                    .map(PermissionDO::getCode).collect(Collectors.toList());
        } else {
            permissions = ObjectUtil.isEmpty(roles) ? new ArrayList<>() : userDao.listUserPermissions(userDO.getOrgId(), userDO.getId());
        }
        cacheUser.setPermissions(permissions);
        cacheService.setUser(cacheUser.getId(), cacheUser);
        String token = HashIds.encode(cacheUser.getOrgId(), cacheUser.getId());

        return R.success(new LoginResultBO()
                .setToken(token)
                .setUserId(userDO.getId()));
    }


//    public R<String> signInByUserName(SignInUserBO user) {
//        UserDO userDO = userDao.getByUsername(user.getUsername());
//        Digester digester = new Digester(DigestAlgorithm.MD5);
//        String password = digester.digestHex(user.getPasswd());
//        if (Objects.isNull(userDO) || !Objects.equals(password, userDO.getPasswd())) {
//            return R.fail(UCCode.ERR_AUTH_TYPE_USERNAME);
//        }
//        R<LoginResultBO> r = signIn(userDO);
//        if (r.failed()) {
//            return R.fail(r);
//        }
//        return R.success(r.getData().getToken());
//    }

//    public R<String> signInByMobile(SignInUserBO user) {
//        UserDO userDO = userDao.getByMobile(user.getMobile());
//        if (Objects.isNull(userDO)) {
//            return R.fail(UCCode.NOT_USER_PHONE_NUMBER);
//        }
//        VerificationCodeBO verification = cacheService.getVerificationCode(user.getMobile());
//        if (Objects.isNull(verification)) {
//            return R.fail(UCCode.VERIFICATION_CODE_EXPIRED);
//        }
//        if (!Objects.equals(verification.getVerificationCode(), user.getVerifyCode())) {
//            return R.fail(UCCode.WRONG_VERIFICATION_CODE);
//        }
//        R<LoginResultBO> r = signIn(userDO);
//        if (r.failed()) {
//            return R.fail(r);
//        }
//        return R.success(r.getData().getToken());
//    }


//    public R<Void> changePassword(FindPasswordBO verificationBO) {
//        UserDO userDO = userService.getByMobile(verificationBO.getMobile());
//        if (Objects.isNull(userDO)) {
//            return R.fail(UCCode.NOT_EXIST_USER);
//        }
//        Integer userId = userDO.getId();
//        VerificationCodeBO verification = cacheService.getVerificationCode(verificationBO.getMobile());
//        if (Objects.isNull(verification)) {
//            return R.fail(UCCode.VERIFICATION_CODE_EXPIRED);
//        }
//        if (!Objects.equals(verification.getVerificationCode(), verificationBO.getVerifyCode())) {
//            return R.fail(UCCode.WRONG_VERIFICATION_CODE);
//        }
//        userService.resetPasswd(userDO.getOrgId(), userId, verificationBO.getPassword());
//        cacheService.invalidateVerificationCode(verificationBO.getMobile());
//        return R.SUCCESS;
//    }

    public R<Void> sendVerifyCode(String mobile, int type) {
        VerificationCodeBO verification = cacheService.getVerificationCode(mobile);
        if (Objects.nonNull(verification) && System.currentTimeMillis() - verification.getSendTime() < Constants.VERIFICATION_EXPIRED_DURATION) {
            return R.fail(UCCode.VERIFICATION_NOT_EXPIRED);
        }

        verification = new VerificationCodeBO()
                .setVerificationCode(RandomUtil.randomNumbers(6))
                .setSendTime(System.currentTimeMillis());

        // 校验是否发版提供测试用户 发版提供测试用户验证码 固定为配置的验证码
        if (checkIsTestUser(mobile)) {
            verification.setVerificationCode(wxConfig.getTestUser().getVerifyCode());
            cacheService.setVerificationCode(mobile, verification);
            return R.SUCCESS;
        }

        SendSmsBO sendSmsBO = new SendSmsBO()
                .setReceiver(mobile)
                .setParams(Map.of("verificationCode", verification.getVerificationCode()));

        R<Void> sendR = notificationCenterService.sendSmsMessage(sendSmsBO, SmsPurpose.LOGIN_VERIFY);
        if (sendR.failed()) {
            return R.fail(sendR);
        }

        cacheService.setVerificationCode(mobile, verification);
        return R.SUCCESS;
    }

    /**
     * 根据手机号获取验证码
     */
    public R<Void> sendVerifyCode(String mobile, int type, Integer check) {
        // check = 2,需求要校验用户是否存在，其他则不校验
        if (check != null && check == 2) {
            UserDO userDO = userService.getByMobile(mobile);
            if (Objects.isNull(userDO)) {
                return R.fail(UCCode.NOT_USER_PHONE_NUMBER);
            }
        }
        return sendVerifyCode(mobile, type);
    }

    /**
     * 校验是否发版提供测试用户
     * 发版提供测试用户验证码固定
     */
    private boolean checkIsTestUser(String mobile) {
        return StrUtil.equals(wxConfig.getTestUser().getMobile(), mobile);
    }

    private User buildCacheUser(UserDO userDO) {
        User cacheUser = new User();
        cacheUser.setId(userDO.getId());
        cacheUser.setName(userDO.getName());
        cacheUser.setUsername(userDO.getUsername());
        cacheUser.setOrgId(userDO.getOrgId());
        cacheUser.setEmail(userDO.getEmail());
        cacheUser.setMobile(userDO.getMobile());
        cacheUser.setRemark(userDO.getRemark());
        return cacheUser;
    }
}
