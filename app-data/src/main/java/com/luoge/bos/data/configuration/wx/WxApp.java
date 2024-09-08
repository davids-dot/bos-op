package com.luoge.bos.data.configuration.wx;

public class WxApp {
    private String appId;
    private String name;
    private String secret;

    public String getAppId() {
        return appId;
    }

    public WxApp setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getName() {
        return name;
    }

    public WxApp setName(String name) {
        this.name = name;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public WxApp setSecret(String secret) {
        this.secret = secret;
        return this;
    }

}
