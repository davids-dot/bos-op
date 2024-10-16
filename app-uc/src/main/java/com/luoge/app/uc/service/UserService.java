package com.luoge.app.uc.service;

import cn.hutool.core.bean.BeanUtil;
import com.luoge.app.uc.auth.CacheService;
import com.luoge.app.uc.model.User;
import com.luoge.app.uc.model.UserUpdateBO;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.data.UserDao;
import com.luoge.bos.data.entity.UserDO;
import com.luoge.ns.core.R;
import com.luoge.ns.uc.core.UCCode;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private CacheService cacheService;


//    @Resource
//    private EnterpriseService enterpriseService;
//
//    @Resource
//    private ThirdUserDao thirdUserDao;

//    public List<UserVO> listUser(int orgId, String name) {
//        var users = userDao.list(orgId, name);
//        return users.stream().map(this::toUserVO).collect(Collectors.toList());
//    }
//
//    public UserVO getUser(int orgId, int userId) {
//        UserDO user = userDao.get(orgId, userId);
//        return toUserVO(user);
//    }
//
//    public R<Void> insert(int orgId, UserCreateBO userCreateBO) {
//        var userDO = userDao.getByUsername(userCreateBO.getUsername());
//        if (Objects.nonNull(userDO)) {
//            return R.fail(UCCode.INVALID_USERNAME);
//        }
//        userDO = userDao.getByMobile(userCreateBO.getMobile());
//        if (Objects.nonNull(userDO)) {
//            return R.fail(UCCode.INVALID_MOBILE);
//        }
//
//        if (StringUtils.isNotBlank(userCreateBO.getEmail())) {
//            userDO = userDao.getByEmail(userCreateBO.getEmail());
//            if (Objects.nonNull(userDO)) {
//                return R.fail(UCCode.INVALID_EMAIL);
//            }
//        }
//
//        var user = BeanUtil.copyProperties(userCreateBO, UserDO.class);
//        user.setEmail(StringUtils.isBlank(user.getEmail()) ? null : user.getEmail());
//
//        // 密码加密存储
//        user.setPasswd(crypt(user.getPasswd()));
//        user.setOrgId(orgId);
//        LocalDateTime now = DateUtil.nowTime();
//        user.setCreateTime(now);
//        user.setUpdateTime(now);
//        userDao.insert(user);
//        return R.SUCCESS;
//    }
//
//    public R<UserDO> update(int orgId, UserUpdateBO userUpdateBO) {
//        var userDO = userDao.getByMobile(userUpdateBO.getMobile());
//        if (Objects.nonNull(userDO) && !Objects.equals(userDO.getId(), userUpdateBO.getId())) {
//            return R.fail(UCCode.INVALID_MOBILE);
//        }
//        if (StringUtils.isNotBlank(userUpdateBO.getEmail())) {
//            userDO = userDao.getByEmail(userUpdateBO.getEmail());
//            if (Objects.nonNull(userDO) && !Objects.equals(userDO.getId(), userUpdateBO.getId())) {
//                return R.fail(UCCode.INVALID_EMAIL);
//            }
//        }
//
//        var user = BeanUtil.copyProperties(userUpdateBO, UserDO.class);
//        user.setEmail(StringUtils.isBlank(user.getEmail()) ? null : user.getEmail());
//        user.setOrgId(orgId);
//        user.setUpdateTime(DateUtil.nowTime());
//        userDao.update(user);
//
//        // 刷新缓存用户信息
//        User cacheUser = cacheService.getUser(userDO.getId());
//        if (cacheUser != null) {
//            cacheUser.setName(user.getName());
//            cacheUser.setEmail(user.getEmail());
//            cacheUser.setMobile(user.getMobile());
//            cacheUser.setRemark(user.getRemark());
//            cacheService.setUser(cacheUser.getId(), cacheUser);
//        }
//        return R.success(userDO);
//    }
//
//    public void resetPasswd(int orgId, int userId, String passwd) {
//        userDao.resetPasswd(orgId, userId, crypt(passwd));
//    }
//
//    public void updateStatus(int orgId, int userId, int status) {
//        userDao.updateStatus(orgId, userId, status);
//    }
//
//    public List<Integer> listUserRoles(int orgId, int userId) {
//        return userDao.listUserRoles(orgId, userId);
//    }
//
//    @Transactional
//    public void setUserRoles(int orgId, int userId, List<Integer> roleIds) {
//        userDao.deleteUserRoles(orgId, userId);
//        if (CollectionUtil.isNotEmpty(roleIds)) {
//            userDao.insertUserRoles(orgId, userId, roleIds, new Date());
//        }
//    }

//    public UserDO getByLoginName(String loginName) {
//        UserDO userDO;
//        return (userDO = userDao.getByUsername(loginName)) != null ? userDO : userDao.getByMobile(loginName);
//    }

    public UserDO getByMobile(String phoneNumber) {
        return userDao.getByMobile(phoneNumber);
    }


    public User getFromCache(int userId) {
        return cacheService.getUser(userId);
    }

//    public String getEmail(String loginName) {
//        UserDO user = getByLoginName(loginName);
//        if (Objects.nonNull(user)) {
//            return user.getEmail();
//        }
//        return StringUtils.EMPTY;
//    }
//
//    public R<Void> changePasswd(int orgId, int userId, String oldPassword, String newPassword) {
//        UserDO userDO = userDao.get(orgId, userId);
//        if (Objects.isNull(userDO)) {
//            return R.fail(UCCode.NOT_EXIST_USER);
//        }
//        String oldCryptPassword = userDO.getPasswd();
//        if (!Objects.equals(oldCryptPassword, crypt(oldPassword))) {
//            return R.fail(UCCode.WRONG_PASSWORD);
//        }
//        String newCryptPassword = crypt(newPassword);
//        if (Objects.equals(oldCryptPassword, newCryptPassword)) {
//            return R.fail(UCCode.SAME_PASSWORD_AS_OLD);
//        }
//        userDao.resetPasswd(orgId, userId, newCryptPassword);
//        cacheService.invalidateUser(userId);
//        return R.SUCCESS;
//    }

    public UserDO get(long userId) {
        return userDao.getById((int) userId);
    }

    public R<UserDO> update(int orgId, UserUpdateBO userUpdateBO) {
        var userDO = userDao.getByMobile(userUpdateBO.getMobile());
        if (Objects.nonNull(userDO) && !Objects.equals(userDO.getId(), userUpdateBO.getId())) {
            return R.fail(UCCode.INVALID_MOBILE);
        }
        if (StringUtils.isNotBlank(userUpdateBO.getEmail())) {
            userDO = userDao.getByEmail(userUpdateBO.getEmail());
            if (Objects.nonNull(userDO) && !Objects.equals(userDO.getId(), userUpdateBO.getId())) {
                return R.fail(UCCode.INVALID_EMAIL);
            }
        }

        var user = BeanUtil.copyProperties(userUpdateBO, UserDO.class);
        user.setEmail(StringUtils.isBlank(user.getEmail()) ? null : user.getEmail());
        user.setOrgId(orgId);
        user.setUpdateTime(DateUtil.nowTime());
        userDao.update(user);

        // 刷新缓存用户信息
        User cacheUser = cacheService.getUser(userDO.getId());
        if (cacheUser != null) {
            cacheUser.setName(user.getName());
            cacheUser.setEmail(user.getEmail());
            cacheUser.setMobile(user.getMobile());
            cacheUser.setRemark(user.getRemark());
            cacheService.setUser(cacheUser.getId(), cacheUser);
        }
        return R.success(userDO);
    }
//
//    public List<EnterpriseUser> listEnterpriseUsers(int orgId, int enterpriseId, String thirdAppId) {
//        List<UserDO> users = enterpriseService.listEnterpriseUsers(orgId, enterpriseId, null);
//        if (CollectionUtils.isEmpty(users)) {
//            return Collections.emptyList();
//        }
//        List<EnterpriseUser> enterpriseUsers = users.stream()
//                .map(x -> new EnterpriseUser()
//                        .setId(x.getId())
//                        .setName(x.getName())
//                        .setMobile(x.getMobile()))
//                .collect(Collectors.toList());
//
//        List<Integer> userIds = enterpriseUsers
//                .stream()
//                .map(EnterpriseUser::getId)
//                .toList();
//
//        Map<Integer, Integer> userStatusMap = thirdUserDao.listEnterpriseUserStatus(orgId, userIds, thirdAppId)
//                .stream()
//                .collect(Collectors.toMap(EnterpriseUser::getId, EnterpriseUser::getBindStatus));
//
//        enterpriseUsers.forEach(x -> {
//            Integer userStatus = userStatusMap.get(x.getId());
//            if (Objects.isNull(userStatus)) {
//                x.setBindStatus(UserBindStatus.NOT_BIND.bindStatus);
//            } else {
//                x.setBindStatus(userStatus);
//            }
//        });
//
//        return enterpriseUsers;
//    }
//
//    private UserVO toUserVO(UserDO user) {
//        return new UserVO()
//                .setId(user.getId())
//                .setName(user.getName())
//                .setUsername(user.getUsername())
//                .setMobile(user.getMobile())
//                .setEmail(user.getEmail())
//                .setAvatar(user.getAvatar())
//                .setStatus(user.getStatus())
//                .setRemark(user.getRemark())
//                .setAdmin(Objects.equals(user.getAdmin(), true) ? 1 : 0);
//    }
//
//    private String crypt(String passwd) {
//        Digester digester = new Digester(DigestAlgorithm.MD5);
//        return digester.digestHex(passwd);
//    }
}
