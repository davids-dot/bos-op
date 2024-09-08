package com.luoge.app.uc.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private int id;
    private int orgId;
    private String name;
    private String username;
    private String mobile;
    private String email;
    private String remark;
    private List<Integer> roles;
    private List<String> permissions;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public int getOrgId() {
        return orgId;
    }

    public User setOrgId(int orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public User setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public User setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public User setRoles(List<Integer> roles) {
        this.roles = roles;
        return this;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public User setPermissions(List<String> permissions) {
        this.permissions = permissions;
        return this;
    }
}
