package com.luoge.bos.op.invoice.model.org;

public class OrgEnterpriseBO {
    private Integer orgId;
    private String orgName;
    private Integer enterpriseId;
    private String enterpriseName;
    private String taxNo;

    public Integer getOrgId() {
        return orgId;
    }

    public OrgEnterpriseBO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public OrgEnterpriseBO setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public OrgEnterpriseBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public OrgEnterpriseBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public OrgEnterpriseBO setTaxNo(String taxNo) {
        this.taxNo = taxNo;
        return this;
    }
}
