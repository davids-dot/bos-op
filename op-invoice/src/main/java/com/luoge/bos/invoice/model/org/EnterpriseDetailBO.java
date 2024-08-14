package com.luoge.bos.invoice.model.org;

public class EnterpriseDetailBO {
    private Integer id;
    /**
     * 机构id
     */
    private Integer orgId;
    /**
     * 名称
     */
    private String name;
    /**
     * 税号
     */
    private String taxNo;
    /**
     * 企业类型
     */
    private Integer type;
    /**
     * 所属省份code
     */
    private String region;
    /**
     * 所属省份名称
     */
    private String regionName;
    /**
     * 所属行业code
     */
    private String industryCode;
    /**
     * 地址
     */
    private String address;
    /**
     * 开户行
     */
    private String bankName;
    /**
     * 银行账号
     */
    private String bankAccount;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 描述
     */
    private String remark;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 税局用户
     */
    private String bureauUser;
    /**
     * 税局密码
     */
    private String bureauPassword;
    /**
     * 税局身份类型
     */
    private Integer bureauIdentityType;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新时间
     */
    private Long updateTime;


    public Integer getId() {
        return id;
    }

    public EnterpriseDetailBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public EnterpriseDetailBO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getName() {
        return name;
    }

    public EnterpriseDetailBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public EnterpriseDetailBO setTaxNo(String taxNo) {
        this.taxNo = taxNo;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public EnterpriseDetailBO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public EnterpriseDetailBO setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getRegionName() {
        return regionName;
    }

    public EnterpriseDetailBO setRegionName(String regionName) {
        this.regionName = regionName;
        return this;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public EnterpriseDetailBO setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EnterpriseDetailBO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public EnterpriseDetailBO setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public EnterpriseDetailBO setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public EnterpriseDetailBO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public EnterpriseDetailBO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public EnterpriseDetailBO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getBureauUser() {
        return bureauUser;
    }

    public EnterpriseDetailBO setBureauUser(String bureauUser) {
        this.bureauUser = bureauUser;
        return this;
    }

    public String getBureauPassword() {
        return bureauPassword;
    }

    public EnterpriseDetailBO setBureauPassword(String bureauPassword) {
        this.bureauPassword = bureauPassword;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public EnterpriseDetailBO setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public EnterpriseDetailBO setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Integer getBureauIdentityType() {
        return bureauIdentityType;
    }

    public EnterpriseDetailBO setBureauIdentityType(Integer bureauIdentityType) {
        this.bureauIdentityType = bureauIdentityType;
        return this;
    }
}
