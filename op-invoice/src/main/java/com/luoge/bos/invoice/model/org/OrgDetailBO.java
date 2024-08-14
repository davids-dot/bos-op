package com.luoge.bos.invoice.model.org;

import jakarta.validation.constraints.NotBlank;

public class OrgDetailBO {

    private Integer id;
    /**
     * 名称
     */
    @NotBlank
    private String name;
    /**
     * 描述
     */
    private String remark;

    /**
     * 管理员姓名
     */
    @NotBlank
    private String adminName;
    /**
     * 管理员手机号
     */
    @NotBlank
    private String adminPhone;
    /**
     * 管理员电子邮箱
     */
    private String adminEmail;
    /**
     * 管理员初始账号
     */
    @NotBlank
    private String adminAccount;
    /**
     * 管理员初始密码
     */
    private String adminPassword;

    public Integer getId() {
        return id;
    }

    public OrgDetailBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrgDetailBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public OrgDetailBO setRemark(String remark) {
        this.remark = remark;
        return this;
    }


    public String getAdminName() {
        return adminName;
    }

    public OrgDetailBO setAdminName(String adminName) {
        this.adminName = adminName;
        return this;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public OrgDetailBO setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
        return this;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public OrgDetailBO setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
        return this;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public OrgDetailBO setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
        return this;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public OrgDetailBO setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
        return this;
    }

}
