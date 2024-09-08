package com.luoge.app.uc.core;

public enum ThirdUserType {
    /**
     * 小程序用户
     */
    WX_MINI_APP_USER(1),
    /**
     * 公众号平台 用户
     */
    WX_OFFICIAL_ACCOUNT_USER(3);

    public final int type;

    ThirdUserType(int type) {
        this.type = type;
    }
}
