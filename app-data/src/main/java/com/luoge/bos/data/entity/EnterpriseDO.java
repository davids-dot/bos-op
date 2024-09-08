package com.luoge.bos.invoice.entity.uc;

import java.time.LocalDateTime;

public class EnterpriseDO {
    private Integer id;

    private Integer orgId;

    private String name;

    private Integer type;

    private String taxNo;

    private String regionCode;

    private String industryCode;

    private String bank;

    private String account;

    private String address;

    private String phone;

    private String remark;

    private Integer status;

    private String upstreamUsername;

    private String upstreamPasswd;

    private Integer bureauIdentityType;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public EnterpriseDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public EnterpriseDO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getName() {
        return name;
    }

    public EnterpriseDO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public EnterpriseDO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public EnterpriseDO setTaxNo(String taxNo) {
        this.taxNo = taxNo;
        return this;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public EnterpriseDO setRegionCode(String regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public EnterpriseDO setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
        return this;
    }

    public String getBank() {
        return bank;
    }

    public EnterpriseDO setBank(String bank) {
        this.bank = bank;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public EnterpriseDO setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EnterpriseDO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public EnterpriseDO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public EnterpriseDO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public EnterpriseDO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getUpstreamUsername() {
        return upstreamUsername;
    }

    public EnterpriseDO setUpstreamUsername(String upstreamUsername) {
        this.upstreamUsername = upstreamUsername;
        return this;
    }

    public String getUpstreamPasswd() {
        return upstreamPasswd;
    }

    public EnterpriseDO setUpstreamPasswd(String upstreamPasswd) {
        this.upstreamPasswd = upstreamPasswd;
        return this;
    }

    public Integer getBureauIdentityType() {
        return bureauIdentityType;
    }

    public EnterpriseDO setBureauIdentityType(Integer bureauIdentityType) {
        this.bureauIdentityType = bureauIdentityType;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public EnterpriseDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public EnterpriseDO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}