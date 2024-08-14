package com.luoge.bos.uc.model.user;

import jakarta.validation.constraints.NotBlank;

public class ChangePasswordBO {
    /**
     * 原密码
     */
    @NotBlank(message = "原密码不能为空")
    private String oldPassword;

    /**
     * 修改后的密码
     */
    @NotBlank(message = "新密码不能为空")
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public ChangePasswordBO setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
        return this;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public ChangePasswordBO setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }
}
