package com.luoge.app.uc.model;

import jakarta.validation.constraints.*;

public class SaveEnterpriseBO {
    @NotNull
    private Integer appId;

    private Integer id;

    @NotBlank
    @Size(min = 1, max = 100)
    protected String name;

    @Max(value = 2)
    @Min(value = 1)
    protected Integer type;

    @NotBlank
    @Size(min = 1, max = 20)
    protected String taxNo;

    @NotBlank
    @Size(min = 1, max = 50)
    private String bankName;

    @NotBlank
    @Size(min = 1, max = 20)
    private String bankAccount;

    @NotBlank
    @Size(min = 1, max = 100)
    private String address;

    @NotBlank
    @Size(min = 1, max = 20)
    private String phone;

    @NotBlank
    @Size(min = 1, max = 6)
    protected String regionCode;
    /**
     * 暂时不添加
     */
    @NotBlank
    @Size(min = 1, max = 20)
    protected String industryCode;

    @Size(min = 0, max = 500)
    private String remark;

    /**
     * 企业简称
     */
    @NotBlank(message = "企业简称不能为空")
    @Size(min = 1, max = 20)
    private String shortName;

    @NotBlank
    @Size(min = 1, max = 50)
    private String upstreamUsername;

    @NotBlank
    @Size(min = 1, max = 30)
    private String upstreamPasswd;

    @NotNull
    private Integer bureauIdentityType;

    public Integer getAppId() {
        return appId;
    }

    public SaveEnterpriseBO setAppId(Integer appId) {
        this.appId = appId;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public SaveEnterpriseBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveEnterpriseBO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public SaveEnterpriseBO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public SaveEnterpriseBO setTaxNo(String taxNo) {
        this.taxNo = taxNo;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public SaveEnterpriseBO setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public SaveEnterpriseBO setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SaveEnterpriseBO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public SaveEnterpriseBO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public SaveEnterpriseBO setRegionCode(String regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public SaveEnterpriseBO setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public SaveEnterpriseBO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public SaveEnterpriseBO setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getUpstreamUsername() {
        return upstreamUsername;
    }

    public SaveEnterpriseBO setUpstreamUsername(String upstreamUsername) {
        this.upstreamUsername = upstreamUsername;
        return this;
    }

    public String getUpstreamPasswd() {
        return upstreamPasswd;
    }

    public SaveEnterpriseBO setUpstreamPasswd(String upstreamPasswd) {
        this.upstreamPasswd = upstreamPasswd;
        return this;
    }

    public Integer getBureauIdentityType() {
        return bureauIdentityType;
    }

    public SaveEnterpriseBO setBureauIdentityType(Integer bureauIdentityType) {
        this.bureauIdentityType = bureauIdentityType;
        return this;
    }
}
