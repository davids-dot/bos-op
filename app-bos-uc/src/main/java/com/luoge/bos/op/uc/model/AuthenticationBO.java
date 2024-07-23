package com.luoge.bos.op.uc.model;

public class AuthenticationBO {

    /**
     * 登录方式：1-用户名+口令，2-手机号码+验证码
     */
    private int type = 1;

    private String username;

    private String passwd;

    private String mobile;

    private String verificationCode;

    public int getType() {
        return type;
    }

    public AuthenticationBO setType(int type) {
        this.type = type;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public AuthenticationBO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public AuthenticationBO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getPasswd() {
        return passwd;
    }

    public AuthenticationBO setPasswd(String passwd) {
        this.passwd = passwd;
        return this;
    }


    public String getVerificationCode() {
        return verificationCode;
    }

    public AuthenticationBO setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
        return this;
    }
}
