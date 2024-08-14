package com.luoge.bos.uc.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreateBO {

    @NotBlank
    @Size(min = 1, max = 20)
    private String name;

    @NotBlank
    @Size(min = 1, max = 30)
    private String username;

    @NotBlank
    private String passwd;

    @Size(min = 8, max = 30)
    private String mobile;

    @Email
    private String email;

    private String avatar;

    @Size(max = 100)
    private String remark;

    public String getName() {
        return name;
    }

    public UserCreateBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserCreateBO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPasswd() {
        return passwd;
    }

    public UserCreateBO setPasswd(String passwd) {
        this.passwd = passwd;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserCreateBO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserCreateBO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserCreateBO setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public UserCreateBO setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
