package com.luoge.app.uc.auth;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.luoge.app.uc.core.Constants;
import com.luoge.app.uc.model.User;
import com.luoge.app.uc.model.VerificationCodeBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CacheService {
    private static final Logger logger = LoggerFactory.getLogger(CacheService.class);

    //    @Resource
//    private PermissionDao permissionDao;
//    @Resource
//    private ApiKeyService apiKeyService;
//
//    @CacheUpdate(name = Constants.CACHE_VERIFICATION_CODE, key = "#mobile", value = "#code")
//    public void setVerificationCode(String mobile, VerificationCodeBO code) {
//    }
//
    @Cached(name = Constants.CACHE_VERIFICATION_CODE, key = "#mobile", expire = Constants.CACHE_VERIFICATION_CODE_EXPIRE_MINUTES, timeUnit = TimeUnit.MINUTES, cacheType = CacheType.REMOTE)
    public VerificationCodeBO getVerificationCode(String mobile) {
        return null;
    }
//
//    @CacheInvalidate(name = Constants.CACHE_VERIFICATION_CODE, key = "#mobile")
//    public void invalidateVerificationCode(String mobile) {
//    }
//
//    @Cached(name = Constants.CACHE_PERMISSION_RESOURCE, expire = Constants.CACHE_PERMISSION_EXPIRE_DAYS, timeUnit = TimeUnit.DAYS, cacheType = CacheType.REMOTE)
//    public Map<String, List<String>> getPermissionResource() {
//        logger.debug("查询权限列表并缓存");
//        return permissionDao.listWithResources().stream()
//                .collect(Collectors.toMap(PermissionDO::getCode,
//                        permission -> permission.getResources().stream()
//                                .map(ResourceDO::getUrl).collect(Collectors.toList())));
//    }
//
//    @Cached(name = Constants.CACHE_PERMISSION_MENU, expire = Constants.CACHE_PERMISSION_EXPIRE_DAYS, timeUnit = TimeUnit.DAYS, cacheType = CacheType.REMOTE)
//    public Map<String, List<MenuDO>> getPermissionMenu() {
//        return permissionDao.listWithMenus().stream()
//                .collect(Collectors.toMap(PermissionDO::getCode, PermissionDO::getMenus));
//    }
//
//    @CacheInvalidate(name = Constants.CACHE_PERMISSION_MENU)
//    public void invalidatePermissionMenu() {
//    }
//
//    @CacheInvalidate(name = Constants.CACHE_PERMISSION_RESOURCE)
//    public void invalidatePermissionResource() {
//    }
//
//    @CacheUpdate(name = Constants.CACHE_USER, key = "#userId", value = "#user")
//    public void setUser(int userId, User user) {
//        logger.debug("更新用户登录缓存.");
//    }
//
//    @Cached(name = Constants.CACHE_USER, key = "#userId", expire = Constants.CACHE_USER_EXPIRE_HOURS, timeUnit = TimeUnit.HOURS, cacheType = CacheType.REMOTE)
//    public User getUser(int userId) {
//        return null;
//    }
//
//    @CacheInvalidate(name = Constants.CACHE_USER, key = "#userId")
//    public void invalidateUser(int userId) {
//        logger.debug("用户ID: {} 退出系统.", userId);
//    }
//
//    @Cached(name = Constants.CACHE_APIKEY, key = "#orgId + ':' + #apiKey", expire = Constants.CACHE_USER_EXPIRE_HOURS, timeUnit = TimeUnit.HOURS, cacheType = CacheType.REMOTE)
//    public ApiKey getApiKey(int orgId, String apiKey) {
//        return apiKeyService.getApiKey(orgId, apiKey);
//    }

    @CacheInvalidate(name = Constants.CACHE_APIKEY, key = "#orgId + ':' + #apiKey")
    public void invalidateApiKey(int orgId, String apiKey) {
    }


    @CacheUpdate(name = Constants.CACHE_USER, key = "#userId", value = "#user")
    public void setUser(int userId, User user) {
        logger.debug("更新用户登录缓存.");
    }


    @CacheUpdate(name = Constants.CACHE_VERIFICATION_CODE, key = "#mobile", value = "#code")
    public void setVerificationCode(String mobile, VerificationCodeBO code) {
    }

    @Cached(name = com.luoge.ns.uc.core.Constants.CACHE_USER, key = "#userId", expire = com.luoge.ns.uc.core.Constants.CACHE_USER_EXPIRE_HOURS, timeUnit = TimeUnit.HOURS, cacheType = CacheType.REMOTE)
    public User getUser(int userId) {
        return null;
    }
}
