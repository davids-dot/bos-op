package com.luoge.app.uc.model;

public enum WxUserBindStatus {
    /**
     * 当前系统用户已绑定其他微信账号
     */
    SYS_USER_HAS_BIND_OTHER(1),
    /**
     * 当前微信账号已绑定其他用户
     */
    WX_USER_HAS_BIND_OTHER(2),
    /**
     * 当前系统用户未绑定微信账号
     */
    NOT_BIND_WX_USER(3),
    /**
     * 当前系统用户已绑定当前微信账号
     */
    HAS_BIND(4);

    public final int status;

    WxUserBindStatus(int status) {
        this.status = status;
    }

}
