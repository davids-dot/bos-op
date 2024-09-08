package com.luoge.bos.data.configuration.wx;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信小程序配置类
 */
@Component
@ConfigurationProperties(value = "wx")
public class WxConfig {
    private WxMiniApp miniApp;

    /**
     * 小程序测试账号
     */
    private WxTestUser testUser;

    public WxMiniApp getMiniApp() {
        return miniApp;
    }

    public void setMiniApp(WxMiniApp miniApp) {
        this.miniApp = miniApp;
    }


    public WxTestUser getTestUser() {
        return testUser;
    }

    public WxConfig setTestUser(WxTestUser testUser) {
        this.testUser = testUser;
        return this;
    }
}