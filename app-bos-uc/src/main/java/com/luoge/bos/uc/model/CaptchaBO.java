package com.luoge.bos.uc.model;

public class CaptchaBO {

    private Integer userId;

    private String captcha;

    private long sendTime;

    public CaptchaBO() {

    }

    public CaptchaBO(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public CaptchaBO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getCaptcha() {
        return captcha;
    }

    public CaptchaBO setCaptcha(String captcha) {
        this.captcha = captcha;
        return this;
    }

    public long getSendTime() {
        return sendTime;
    }

    public CaptchaBO setSendTime(long sendTime) {
        this.sendTime = sendTime;
        return this;
    }

}
