package com.luoge.app.uc.model;

import java.io.Serializable;

public class VerificationCodeBO implements Serializable {

    private String userIdentifier;

    private String verificationCode;

    private long sendTime;

    public VerificationCodeBO() {

    }

    public VerificationCodeBO(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public VerificationCodeBO setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
        return this;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public VerificationCodeBO setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
        return this;
    }

    public long getSendTime() {
        return sendTime;
    }

    public VerificationCodeBO setSendTime(long sendTime) {
        this.sendTime = sendTime;
        return this;
    }

}
