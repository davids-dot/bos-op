package com.luoge.bos.data.configuration.wx;

public class WxApp {
    private String appId;
    private String name;
    private String secret;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecret() {
        return secret;
    }

    public WxApp setSecret(String secret) {
        this.secret = secret;
        return this;
    }
}
