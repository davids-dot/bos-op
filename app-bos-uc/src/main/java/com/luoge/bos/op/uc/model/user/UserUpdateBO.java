package com.luoge.bos.op.uc.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserUpdateBO {

    @NotNull
    private int id;

    @NotBlank
    @Size(min = 1, max = 20)
    private String name;

    @Size(min = 8, max = 30)
    private String mobile;

    @Email
    private String email;

    private String avatar;

    @Size(max = 100)
    private String remark;

    public int getId() {
        return id;
    }

    public UserUpdateBO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserUpdateBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserUpdateBO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserUpdateBO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserUpdateBO setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public UserUpdateBO setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
