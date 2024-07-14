package com.luoge.bos.op.invoice.model.org;

public class EnterpriseCountBO {
    private Integer orgId;
    private Integer count;

    public Integer getOrgId() {
        return orgId;
    }

    public EnterpriseCountBO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public EnterpriseCountBO setCount(Integer count) {
        this.count = count;
        return this;
    }
}
