package com.luoge.bos.data.entity;

import java.time.LocalDateTime;

public class UserDO {

    /**
     * 新增用户时忽略id
     */
    private Integer id;

    private Integer orgId;

    private String name;

    private String username;

    private String mobile;

    private String email;

    private String passwd;

    private String avatar;

    private Integer status;

    private String remark;

    private Boolean admin;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public UserDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public UserDO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserDO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPasswd() {
        return passwd;
    }

    public UserDO setPasswd(String passwd) {
        this.passwd = passwd;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserDO setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UserDO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public UserDO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public UserDO setAdmin(Boolean admin) {
        this.admin = admin;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public UserDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public UserDO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

}
