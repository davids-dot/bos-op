package com.luoge.app.uc.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class EnterpriseBO {

    private Integer id;
    private Integer orgId;
    protected String name;
    protected Integer type;
    protected String taxNo;

    private String regionCode;
    protected String regionName;

    // 发票扩展字段
    protected String bankName;
    protected String bankAccount;
    protected String address;
    protected String phone;
    private Integer bureauIdentityType;

    // 风控扩展字段
    private String industryCode;
    private String industryName;

    protected Integer status;
    protected String upstreamUsername;

    protected String upstreamPasswd;
    protected String remark;
    /**
     * 企业简称
     */
    protected String shortName;

    // 绑定的用户数量
    protected Integer userCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public EnterpriseBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public EnterpriseBO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getName() {
        return name;
    }

    public EnterpriseBO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public EnterpriseBO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public EnterpriseBO setTaxNo(String taxNo) {
        this.taxNo = taxNo;
        return this;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public EnterpriseBO setRegionCode(String regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public String getRegionName() {
        return regionName;
    }

    public EnterpriseBO setRegionName(String regionName) {
        this.regionName = regionName;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public EnterpriseBO setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public EnterpriseBO setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EnterpriseBO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public EnterpriseBO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Integer getBureauIdentityType() {
        return bureauIdentityType;
    }

    public EnterpriseBO setBureauIdentityType(Integer bureauIdentityType) {
        this.bureauIdentityType = bureauIdentityType;
        return this;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public EnterpriseBO setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
        return this;
    }

    public String getIndustryName() {
        return industryName;
    }

    public EnterpriseBO setIndustryName(String industryName) {
        this.industryName = industryName;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public EnterpriseBO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getUpstreamUsername() {
        return upstreamUsername;
    }

    public EnterpriseBO setUpstreamUsername(String upstreamUsername) {
        this.upstreamUsername = upstreamUsername;
        return this;
    }

    public String getUpstreamPasswd() {
        return upstreamPasswd;
    }

    public EnterpriseBO setUpstreamPasswd(String upstreamPasswd) {
        this.upstreamPasswd = upstreamPasswd;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public EnterpriseBO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public EnterpriseBO setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public EnterpriseBO setUserCount(Integer userCount) {
        this.userCount = userCount;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public EnterpriseBO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public EnterpriseBO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
