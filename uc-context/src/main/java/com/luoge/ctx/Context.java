package com.luoge.ctx;

public class Context {
    private Integer orgId;
    private Integer enterpriseId;
    private Integer userId;

    public Integer getOrgId() {
        return orgId;
    }

    public Context setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public Context setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Context setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }
}
