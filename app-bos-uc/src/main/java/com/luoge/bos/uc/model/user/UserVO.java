package com.luoge.bos.uc.model.user;

public class UserVO {

    private int id;

    private String name;

    private String username;

    private String mobile;

    private String email;

    private String avatar;

    private Integer status;

    private String remark;

    private Integer admin;

    public int getId() {
        return id;
    }

    public UserVO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserVO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserVO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserVO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserVO setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UserVO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public UserVO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getAdmin() {
        return admin;
    }

    public UserVO setAdmin(Integer admin) {
        this.admin = admin;
        return this;
    }
}
