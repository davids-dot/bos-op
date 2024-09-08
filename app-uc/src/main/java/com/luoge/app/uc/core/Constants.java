package com.luoge.app.uc.core;

public interface Constants {

    // 缓存
    String CACHE_PERMISSION_RESOURCE = "permission:resource:";
    String CACHE_PERMISSION_MENU = "permission:menu:";
    String CACHE_USER = "user:";
    String CACHE_APIKEY = "apikey:";
    String CACHE_VERIFICATION_CODE = "verification:code:";

    // 用户缓存过期时间,小时
    int CACHE_USER_EXPIRE_HOURS = 4;
    // 验证码过期时间,分钟
    int CACHE_VERIFICATION_CODE_EXPIRE_MINUTES = 15;
    // 权限缓存过期时间,天
    int CACHE_PERMISSION_EXPIRE_DAYS = 365 * 10;

    int ZERO = 0;

    int ONE = 1;

    int PLATFORM_ENTERPRISE_ID = 0;

    /**
     * 微信模板消息单行字段最大长度
     */
    int WX_MSG_MAX_LENGTH = 20;


    long VERIFICATION_EXPIRED_DURATION = 60 * 1000;

    // 权限相关
    int ROLE_NAME_EXIST = 11100;
    int PERMISSION_NAME_EXIST = 11101;
    int MAX_UPLOAD_SIZE_EXCEEDED = 11200;
    int UPLOAD_ERROR = 11201;
    int REFERRER_CAN_NOT_BLANK = 11210;


    // 微信小程序页面
    String WX_INVOICE_DETAIL_PAGE = "pages/blueInvoice/detail?id=#{invoiceId}&enterpriseId=#{enterpriseId}";

    String WX_ENTERPRISE_REGISTRATION_DETAIL_PAGE = "pages/business/detail?id=#{id}";

    String WX_INVOICE_APPLY_PAGE = "pages/blueInvoiceApply/detail?id=#{id}&enterpriseId=#{enterpriseId}";

    // h5 页面
    String H5_TAX_BUREAU_PAGE = "#{h5Host}/h5/invoice/tax-login?jwt=#{jwt}";

}
