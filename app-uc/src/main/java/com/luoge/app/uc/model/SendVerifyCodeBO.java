package com.luoge.app.uc.model;

import jakarta.validation.constraints.NotBlank;

public class SendVerifyCodeBO {
    /**
     * 手机号码
     */
    @NotBlank(message = "手机号不能为空")
    private String mobile;
    /**
     * 验证码类型
     *
     */
    private Integer type;
    /**
     * 校验手机号码是否存在
     * null,1-不校验 2-校验
     */
    private Integer check;

    public String getMobile() {
        return mobile;
    }

    public SendVerifyCodeBO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public SendVerifyCodeBO setType(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getCheck() {
        return check;
    }

    public SendVerifyCodeBO setCheck(Integer check) {
        this.check = check;
        return this;
    }
}
