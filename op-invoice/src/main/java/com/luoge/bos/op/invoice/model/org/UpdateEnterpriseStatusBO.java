package com.luoge.bos.op.invoice.model.org;

import jakarta.validation.constraints.NotNull;

public class UpdateEnterpriseStatusBO {
    @NotNull
    private Integer enterpriseId;
    /**
     * 更改状态 1-启用  2-停用
     */
    @NotNull
    private Integer status;

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public UpdateEnterpriseStatusBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UpdateEnterpriseStatusBO setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
