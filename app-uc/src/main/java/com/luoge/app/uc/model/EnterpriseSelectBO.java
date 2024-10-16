package com.luoge.app.uc.model;

public class EnterpriseSelectBO {
    private int id;
    private String name;
    private Integer type;
    private String taxNo;
    private String regionCode;
    private String regionName;
    // 税号
    protected String upstreamUsername;

    // 发票扩展字段
    private String bankName;
    private String bankAccount;
    private String address;
    private String phone;


    public int getId() {
        return id;
    }

    public EnterpriseSelectBO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EnterpriseSelectBO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public EnterpriseSelectBO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public EnterpriseSelectBO setTaxNo(String taxNo) {
        this.taxNo = taxNo;
        return this;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public EnterpriseSelectBO setRegionCode(String regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public String getRegionName() {
        return regionName;
    }

    public EnterpriseSelectBO setRegionName(String regionName) {
        this.regionName = regionName;
        return this;
    }

    public String getUpstreamUsername() {
        return upstreamUsername;
    }

    public EnterpriseSelectBO setUpstreamUsername(String upstreamUsername) {
        this.upstreamUsername = upstreamUsername;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public EnterpriseSelectBO setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public EnterpriseSelectBO setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EnterpriseSelectBO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public EnterpriseSelectBO setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
