package com.luoge.app.uc.wx;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.util.WxMaConfigHolder;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.alibaba.fastjson2.JSONObject;
import com.luoge.app.uc.auth.AuthnService;
import com.luoge.app.uc.auth.CacheService;
import com.luoge.app.uc.model.LoginByCodeBO;
import com.luoge.app.uc.model.LoginResultBO;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.ns.core.Code;
import com.luoge.ns.core.R;
import com.luoge.ns.uc.core.UCCode;
import jakarta.annotation.Resource;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Service
public class WxUserService {
    private static final Logger logger = LoggerFactory.getLogger(WxUserService.class);

    @Resource
    private WxMaService wxMaService;
    @Resource
    private WxMpService wxMpService;
//    @Resource
//    private ThirdUserDao thirdUserDao;
//    @Resource
//    private UserService userService;
//    @Lazy
//    @Resource
//    private AuthnService authnService;
//    @Resource
//    private CacheService cacheService;
//    @Resource
//    private UserDao userDao;
//
//    @Resource
//    private OrgDao orgDao;
//
//    @Resource
//    private WxConfig wxConfig;
//
//
//    /**
//     * 绑定后的用户在小程序上直接登录
//     */
//    public R<LoginResultBO> loginMiniApp(LoginByCodeBO loginByCodeBO, String appId) {
//        if (!wxMaService.switchover(appId)) {
//            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appId));
//        }
//        try {
//            WxMaJscode2SessionResult sessionInfo = wxMaService.getUserService().getSessionInfo(loginByCodeBO.getCode());
//            if (Objects.isNull(sessionInfo)) {
//                return R.fail(UCCode.WX_CODE_NOT_VALID);
//            }
//            String openid = sessionInfo.getOpenid();
//            ThirdUserDO thirdUser = thirdUserDao.getByOpenId(openid, ThirdUserType.WX_MINI_APP_USER.type,
//                    appId);
//            if (Objects.isNull(thirdUser) || Objects.isNull(thirdUser.getUserId())) {
//                return R.fail(UCCode.WX_USER_NOT_BIND);
//            }
//            UserDO userDO = userService.get(thirdUser.getUserId());
//            if (Objects.isNull(userDO)) {
//                return R.fail(UCCode.WX_USER_NOT_BIND);
//            }
//
//            return authnService.signIn(userDO);
//        } catch (WxErrorException e) {
//            logger.error(e.getMessage(), e);
//            return R.fail(UCCode.WX_BUSINESS_ERROR, e.getError().getErrorMsg());
//        } finally {
//            WxMaConfigHolder.remove();//清理ThreadLocal
//        }
//    }
//
//    /**
//     * 在小程序上登录并绑定
//     */
//    public R<LoginResultBO> loginAndBindByUserAndCode(LoginByUserAndCodeBO loginByUserAndCodeBO, String appId) {
//        if (!wxMaService.switchover(appId)) {
//            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appId));
//        }
//        try {
//            WxMaJscode2SessionResult sessionInfo = wxMaService.getUserService().getSessionInfo(loginByUserAndCodeBO.getCode());
//            if (Objects.isNull(sessionInfo)) {
//                return R.fail(UCCode.WX_CODE_NOT_VALID);
//            }
//            String openId = sessionInfo.getOpenid();
//            UserDO userDO = userDao.getByUsername(loginByUserAndCodeBO.getUserName());
//            Digester digester = new Digester(DigestAlgorithm.MD5);
//            String encryptPassword = digester.digestHex(loginByUserAndCodeBO.getPassword());
//            if (Objects.isNull(userDO) || !Objects.equals(encryptPassword, userDO.getPasswd())) {
//                return R.fail(UCCode.ERR_AUTH_TYPE_USERNAME);
//            }
//
//            return checkAndLoginForSysUser(userDO.getId(), openId, sessionInfo.getUnionid(), appId, userDO);
//        } catch (WxErrorException e) {
//            logger.error(e.getMessage(), e);
//            return R.fail(UCCode.WX_BUSINESS_ERROR, e.getError().getErrorMsg());
//        } finally {
//            WxMaConfigHolder.remove();//清理ThreadLocal
//        }
//    }
//
//    private void updateUserIdByUnionId(int userId, String unionId) {
//        thirdUserDao.updateUserIdByUnionId(userId, unionId);
//    }
//
//    /**
//     * 获取用户绑定的 unionId
//     */
//    public String getBindUnionId(int userId, String appId) {
//        ThirdUserDO openAppUser = thirdUserDao.getByUserId(userId,
//                ThirdUserType.WX_MINI_APP_USER.type, appId);
//        return Objects.isNull(openAppUser) ? StringUtils.EMPTY : openAppUser.getUnionId();
//    }
//
//    public Long getUserIdByUnionId(String unionId) {
//        List<ThirdUserDO> thirdUserDOS = thirdUserDao.getByUnionId(unionId, ThirdUserType.WX_MINI_APP_USER.type);
//        return CollectionUtil.isEmpty(thirdUserDOS) ? null : thirdUserDOS.getFirst().getUserId();
//    }
//
//    /**
//     * 根据 unionId 获取 用户的公众号的 openId
//     */
//    public String getOfficialAccountOpenIdByUnionId(int userId, String unionId, String appId) {
//        // 先查数据库， 看是否有公众号的 openId
//        ThirdUserDO officialAccountUser = thirdUserDao.getByUserId(userId,
//                ThirdUserType.WX_OFFICIAL_ACCOUNT_USER.type, appId);
//        if (Objects.nonNull(officialAccountUser)) {
//            return officialAccountUser.getOpenId();
//        }
//        return StringUtils.EMPTY;
//    }
//
//
//    @Transactional
//    public R<LoginResultBO> loginAndBindMiniAppByPhone(LoginByMobileAndCodeBO loginByPhoneBO, String appId) {
//        if (!wxMaService.switchover(appId)) {
//            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appId));
//        }
//        try {
//            WxMaJscode2SessionResult sessionInfo = wxMaService.getUserService().getSessionInfo(loginByPhoneBO.getCode());
//            if (Objects.isNull(sessionInfo)) {
//                return R.fail(UCCode.WX_CODE_NOT_VALID);
//            }
//            String openId = sessionInfo.getOpenid();
//            String unionId = sessionInfo.getUnionid();
//
//            // 校验验证码正确
//            var processingVerifyCode = cacheService.getVerificationCode(loginByPhoneBO.getMobile());
//            if (Objects.isNull(processingVerifyCode)) {
//                return R.fail(UCCode.VERIFICATION_CODE_EXPIRED);
//            }
//
//            if (!Objects.equals(processingVerifyCode.getVerificationCode(), loginByPhoneBO.getVerifyCode())) {
//                return R.fail(UCCode.WRONG_VERIFICATION_CODE);
//            }
//
//            // 是系统用户
//            UserDO userDO = userDao.getByMobile(loginByPhoneBO.getMobile());
//            if (Objects.nonNull(userDO)) {
//                return checkAndLoginForSysUser(userDO.getId(), openId, unionId, appId, userDO);
//            }
//            // 手机号
//            UserDO newUser = registerNewUser(loginByPhoneBO.getMobile(), openId, unionId, appId);
//            // 如果手机号 不是系统用户
//            return authnService.signIn(newUser);
//        } catch (WxErrorException e) {
//            logger.error(e.getMessage(), e);
//            return R.fail(UCCode.WX_BUSINESS_ERROR, e.getError().getErrorMsg());
//        } finally {
//            WxMaConfigHolder.remove();//清理ThreadLocal
//        }
//    }
//
//
//    private R<LoginResultBO> checkAndLoginForSysUser(Integer userId, String openId, String unionId, String appId, UserDO userDO) {
//        WxUserBindStatus wxUserBindStatus = checkUserBindStatus(userId, openId, appId);
//        switch (wxUserBindStatus) {
//            case SYS_USER_HAS_BIND_OTHER -> {
//                return R.fail(UCCode.WX_SYS_USER_HAS_BIND_OTHER);
//            }
//            case WX_USER_HAS_BIND_OTHER -> {
//                return R.fail(UCCode.WX_USER_HAS_BIND_OTHER);
//            }
//            case NOT_BIND_WX_USER -> {
//                return signInAndBind(userDO, unionId, openId, appId);
//            }
//            case HAS_BIND -> {
//                return authnService.signIn(userDO);
//            }
//        }
//        return R.fail(Code.SYSTEM_ERROR);
//    }
//
//    private R<LoginResultBO> signInAndBind(UserDO userDO, String unionId, String openId, String appId) {
//        R<LoginResultBO> r = authnService.signIn(userDO);
//        if (r.ok()) {
//            int userId = r.getData().getUserId();
//            saveMiniAppBindId(userId, openId, unionId, userDO.getStatus(), appId);
//            updateUserIdByUnionId(userId, unionId);
//        }
//        return r;
//    }
//
//    /**
//     * 检查微信用户绑定状态
//     */
//    private WxUserBindStatus checkUserBindStatus(Integer userId, String miniAppOpenId, String appId) {
//        ThirdUserDO existBindUser = thirdUserDao.getByUserId(userId, ThirdUserType.WX_MINI_APP_USER.type, appId);
//
//        // 系统用户已绑定微信账号
//        if (Objects.nonNull(existBindUser)) {
//            if (!Objects.equals(existBindUser.getOpenId(), miniAppOpenId)) {
//                return WxUserBindStatus.SYS_USER_HAS_BIND_OTHER;
//            }
//            return WxUserBindStatus.HAS_BIND;
//        }
//
//        // 微信账号已绑定用户
//        existBindUser = thirdUserDao.getByOpenId(miniAppOpenId, ThirdUserType.WX_MINI_APP_USER.type, appId);
//        if (Objects.nonNull(existBindUser)) {
//            if (!Objects.equals(existBindUser.getUserId().intValue(), userId)) {
//                return WxUserBindStatus.WX_USER_HAS_BIND_OTHER;
//            }
//            return WxUserBindStatus.HAS_BIND;
//        }
//        return WxUserBindStatus.NOT_BIND_WX_USER;
//    }
//
//
//    public UserDO registerNewUser(String phoneNumber, String openId, String unionId, String appId) {
//        LocalDateTime now = DateUtil.nowTime();
//        OrgDO newOrg = new OrgDO()
//                .setName(phoneNumber)
//                .setRemark("用户注册自动创建的机构")
//                .setCreateTime(now)
//                .setUpdateTime(now);
//        orgDao.insert(newOrg);
//
//        UserDO newUser = new UserDO()
//                .setOrgId(newOrg.getId())
//                .setName(phoneNumber)
//                .setUsername(phoneNumber)
//                .setMobile(phoneNumber)
//                .setPasswd("")
//                .setStatus(UserStatus.NORMAL.value)
//                .setAdmin(true)
//                .setCreateTime(now)
//                .setUpdateTime(now);
//        userDao.insertAdmin(newUser);
//
//        saveMiniAppBindId(newUser.getId(), openId, unionId, UserStatus.NORMAL.value, appId);
//        return newUser;
//    }
//
//    public void saveOfficialAccountBindId(Long userId, String openId, String unionId) {
//        LocalDateTime now = DateUtil.nowTime();
//        // 公众号
//        ThirdUserDO officialAccountAppUser = new ThirdUserDO()
//                .setType(ThirdUserType.WX_OFFICIAL_ACCOUNT_USER.type)
//                .setAppId(wxConfig.getMp().getFirst().getAppid())
//                .setOpenId(openId)
//                .setUnionId(unionId)
//                .setUserId(userId)
//                .setStatus(UserStatus.NORMAL.value)
//                .setCreateTime(now)
//                .setUpdateTime(now);
//        thirdUserDao.saveOrDoNothing(officialAccountAppUser);
//    }
//
//    private void saveMiniAppBindId(long userId, String openId, String unionId, Integer userStatus, String appId) {
//        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
//        // 小程序
//        ThirdUserDO miniAppUser = new ThirdUserDO()
//                .setType(ThirdUserType.WX_MINI_APP_USER.type)
//                .setAppId(appId)
//                .setOpenId(openId)
//                .setUnionId(unionId)
//                .setUserId(userId)
//                .setStatus(userStatus)
//                .setCreateTime(now)
//                .setUpdateTime(now);
//        thirdUserDao.saveOrDoNothing(miniAppUser);
//    }
//
//    public WxMpUser getOfficialAccountUserInfo(String openId) {
//        try {
//            return wxMpService.getUserService().userInfo(openId);
//        } catch (WxErrorException e) {
//            logger.error("get user info error", e);
//            return null;
//        }
//    }
//
//    public void deleteOfficialAccountBindId(String openId) {
//        thirdUserDao.deleteByOpenId(ThirdUserType.WX_OFFICIAL_ACCOUNT_USER.type, wxConfig.getMp().getFirst().getAppid(),
//                openId);
//    }
//
//    /**
//     * 根据验证码登录
//     */
//    public R<LoginResultBO> bindUser(LoginByMobileAndCodeBO loginByPhoneBO, String appId) {
//        logger.info("risk bindUser params:{}, appId:{}", JSONObject.toJSONString(loginByPhoneBO), appId);
//        if (!wxMaService.switchover(appId)) {
//            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appId));
//        }
//        try {
//            WxMaJscode2SessionResult sessionInfo = wxMaService.getUserService().getSessionInfo(loginByPhoneBO.getCode());
//            if (Objects.isNull(sessionInfo)) {
//                return R.fail(UCCode.WX_CODE_NOT_VALID);
//            }
//            // 校验验证码
//            var processingVerifyCode = cacheService.getVerificationCode(loginByPhoneBO.getMobile());
//            if (Objects.isNull(processingVerifyCode)) {
//                return R.fail(UCCode.VERIFICATION_CODE_EXPIRED);
//            }
//
//            // 校验是否发版提供测试用户 发版提供用户验证码固定
//            if (!Objects.equals(processingVerifyCode.getVerificationCode(), loginByPhoneBO.getVerifyCode())) {
//                return R.fail(UCCode.WRONG_VERIFICATION_CODE);
//            }
//
//            // 是否系统用户
//            UserDO userDO = userDao.getByMobile(loginByPhoneBO.getMobile());
//            if (ObjectUtil.isEmpty(userDO)) {
//                return R.fail(UCCode.NOT_USER_PHONE_NUMBER);
//            }
//
//            // 校验用户小程序绑定关系并返回
//            return checkAndLoginForSysUser(userDO.getId(), sessionInfo.getOpenid(), sessionInfo.getUnionid(), appId, userDO);
//        } catch (WxErrorException e) {
//            logger.error(e.getMessage(), e);
//            return R.fail(UCCode.WX_BUSINESS_ERROR, e.getError().getErrorMsg());
//        } finally {
//            WxMaConfigHolder.remove();//清理ThreadLocal
//        }
//    }
}
