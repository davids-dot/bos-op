package com.luoge.bos.uc.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.luoge.bos.data.NsUserDao;
import com.luoge.bos.data.entity.UserDO;
import com.luoge.bos.uc.core.UCCode;
import com.luoge.bos.uc.model.user.UserCreateBO;
import com.luoge.bos.uc.model.user.UserUpdateBO;
import com.luoge.bos.uc.model.user.UserVO;
import com.luoge.bos.uc.utils.DateUtil;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AppUserService {

    @Resource
    private NsUserDao nsUserDao;

    private AuthenticationService authenticationService;

    /**
     * 使用set方法注入，避免循环依赖报错
     */
    @Autowired
    public void setAuthenticationService(@Lazy AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public List<UserVO> listUser(int orgId, String name) {
        var users = nsUserDao.list(orgId, name);
        return users.stream().map(userDO -> BeanUtil.copyProperties(userDO, UserVO.class)).collect(Collectors.toList());
    }

    public R<Void> insert(int orgId, UserCreateBO userCreateBO) {
        var user = BeanUtil.copyProperties(userCreateBO, UserDO.class);

        var userDO = nsUserDao.getByUsername(user.getUsername());
        if (Objects.nonNull(userDO)) {
            return R.fail(UCCode.INVALID_USERNAME);
        }
        userDO = nsUserDao.getByMobile(user.getMobile());
        if (Objects.nonNull(userDO)) {
            return R.fail(UCCode.INVALID_MOBILE);
        }
        userDO = nsUserDao.getByEmail(user.getEmail());
        if (Objects.nonNull(userDO)) {
            return R.fail(UCCode.INVALID_EMAIL);
        }

        // 密码加密存储
        user.setPasswd(crypt(user.getPasswd()));
        user.setOrgId(orgId);
        LocalDateTime now = DateUtil.nowTime();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        nsUserDao.insert(user);
        return R.SUCCESS;
    }

    public R<Void> update(int orgId, UserUpdateBO userUpdateBO) {
        var userDO = nsUserDao.getByMobile(userUpdateBO.getMobile());
        if (Objects.nonNull(userDO) && !Objects.equals(userDO.getId(), userUpdateBO.getId())) {
            return R.fail(UCCode.INVALID_MOBILE);
        }
        userDO = nsUserDao.getByEmail(userUpdateBO.getEmail());
        if (Objects.nonNull(userDO) && !Objects.equals(userDO.getId(), userUpdateBO.getId())) {
            return R.fail(UCCode.INVALID_EMAIL);
        }

        var user = BeanUtil.copyProperties(userUpdateBO, UserDO.class);
        user.setOrgId(orgId);
        user.setUpdateTime(DateUtil.nowTime());
        nsUserDao.update(user);
        return R.SUCCESS;
    }

    public void resetPasswd(int orgId, int userId, String passwd) {
        nsUserDao.resetPasswd(orgId, userId, crypt(passwd));
    }

    public void updateStatus(int orgId, int userId, int status) {
        nsUserDao.updateStatus(orgId, userId, status);
    }

    public List<Integer> listUserRoles(int orgId, int userId) {
        return nsUserDao.listUserRoles(orgId, userId);
    }

    @Transactional
    public void setUserRoles(int orgId, int userId, List<Integer> roleIds) {
        nsUserDao.deleteUserRoles(orgId, userId);
        if (CollectionUtil.isNotEmpty(roleIds)) {
            nsUserDao.insertUserRoles(orgId, userId, roleIds, new Date());
        }
    }

    private String crypt(String passwd) {
        Digester digester = new Digester(DigestAlgorithm.MD5);
        return digester.digestHex(passwd);
    }


    public UserDO getByLoginName(String loginName) {
        UserDO userDO;
        return (userDO = nsUserDao.getByUsername(loginName)) != null ? userDO : nsUserDao.getByMobile(loginName);
    }

    public String getEmail(String loginName) {
        UserDO user = getByLoginName(loginName);
        if (Objects.nonNull(user)) {
            return user.getEmail();
        }
        return StringUtils.EMPTY;
    }

    public R<Void> changePasswd(int orgId, int userId, String oldPassword, String newPassword) {
        UserDO userDO = nsUserDao.get(orgId, userId);
        if (Objects.isNull(userDO)) {
            return R.fail(UCCode.NOT_EXIST_USER);
        }
        String oldCryptPassword = userDO.getPasswd();
        if (!Objects.equals(oldCryptPassword, crypt(oldPassword))) {
            return R.fail(UCCode.WRONG_PASSWORD);
        }
        String newCryptPassword = crypt(newPassword);
        if (Objects.equals(oldCryptPassword, newCryptPassword)) {
            return R.fail(UCCode.SAME_PASSWORD_AS_OLD);
        }
        nsUserDao.resetPasswd(orgId, userId, newCryptPassword);
        authenticationService.signOut(userId);
        return R.SUCCESS;
    }

    public UserDO get(long userId) {
        return nsUserDao.getById((int) userId);
    }

    public UserDO getByPhoneNumber(String phoneNumber) {
        return nsUserDao.getByMobile(phoneNumber);
    }
}
