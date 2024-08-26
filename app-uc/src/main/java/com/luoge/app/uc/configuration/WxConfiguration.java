package com.luoge.app.uc.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WxConfiguration {

    @Value("${wx.miniApp.invoice.appId")
    private String appId;

    public String getAppId() {
        return appId;
    }

    public WxConfiguration setAppId(String appId) {
        this.appId = appId;
        return this;
    }
}
