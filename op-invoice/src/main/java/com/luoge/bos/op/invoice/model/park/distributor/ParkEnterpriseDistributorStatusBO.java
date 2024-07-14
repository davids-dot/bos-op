package com.luoge.bos.op.invoice.model.park.distributor;

import jakarta.validation.constraints.NotNull;

public class ParkEnterpriseDistributorStatusBO {
    @NotNull
    private Integer id;
    @NotNull(message = "status不能为空")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public ParkEnterpriseDistributorStatusBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ParkEnterpriseDistributorStatusBO setStatus(Integer status) {
        this.status = status;
        return this;
    }
}

