package com.luoge.bos.op.invoice.model.org;


public class UserBO {
    private Integer orgId;

    private String name;

    private String username;

    private String mobile;

    private String email;

    private String passwd;

    private Integer admin;

    public Integer getOrgId() {
        return orgId;
    }

    public UserBO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserBO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserBO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserBO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPasswd() {
        return passwd;
    }

    public UserBO setPasswd(String passwd) {
        this.passwd = passwd;
        return this;
    }

    public Integer getAdmin() {
        return admin;
    }

    public UserBO setAdmin(Integer admin) {
        this.admin = admin;
        return this;
    }
}