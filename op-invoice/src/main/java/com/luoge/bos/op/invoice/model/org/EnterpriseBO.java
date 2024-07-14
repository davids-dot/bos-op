package com.luoge.bos.op.invoice.model.org;

public class EnterpriseBO {
    private Integer id;
    /**
     * 机构id
     */
    private Integer orgId;
    /**
     * 所属机构
     */
    private String orgName;
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
     * 所属省份
     */
    private String region;
    /**
     * 所属省份名称
     */
    private String regionName;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Long createTime;

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

    public String getOrgName() {
        return orgName;
    }

    public EnterpriseBO setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public String getName() {
        return name;
    }

    public EnterpriseBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public EnterpriseBO setTaxNo(String taxNo) {
        this.taxNo = taxNo;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public EnterpriseBO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public EnterpriseBO setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getRegionName() {
        return regionName;
    }

    public EnterpriseBO setRegionName(String regionName) {
        this.regionName = regionName;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public EnterpriseBO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public EnterpriseBO setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }
}
