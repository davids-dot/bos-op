package com.luoge.app.uc.model;

import jakarta.validation.constraints.NotBlank;

public class LoginByCodeBO {
    /**
     * 登录code
     */
    @NotBlank(message = "code 不能为空")
    private String code;

    public String getCode() {
        return code;
    }

    public LoginByCodeBO setCode(String code) {
        this.code = code;
        return this;
    }
}
