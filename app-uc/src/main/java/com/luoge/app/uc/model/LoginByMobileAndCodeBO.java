package com.luoge.app.uc.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginByMobileAndCodeBO {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String mobile;
    /**
     * 密码
     */
    @NotBlank(message = "验证码不能为空")
    @Size(min = 6, max = 6, message = "请输入6位验证码")
    private String verifyCode;
    /**
     * wx login 返回的code
     */
    @NotBlank(message = "code 不能为空")
    private String code;

    public String getMobile() {
        return mobile;
    }

    public LoginByMobileAndCodeBO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public LoginByMobileAndCodeBO setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
        return this;
    }

    public String getCode() {
        return code;
    }

    public LoginByMobileAndCodeBO setCode(String code) {
        this.code = code;
        return this;
    }
}
