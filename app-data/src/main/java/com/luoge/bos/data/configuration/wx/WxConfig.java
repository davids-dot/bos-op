package com.luoge.bos.invoice.configuration.wx;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信小程序配置类
 */
@Component
@ConfigurationProperties(value = "wx")
public class WxConfig {
    private WxMiniApp miniApp;

    public WxMiniApp getMiniApp() {
        return miniApp;
    }

    public void setMiniApp(WxMiniApp miniApp) {
        this.miniApp = miniApp;
    }
}