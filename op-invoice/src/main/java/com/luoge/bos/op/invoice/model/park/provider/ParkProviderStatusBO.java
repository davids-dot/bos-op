package com.luoge.bos.op.invoice.model.park.provider;

import jakarta.validation.constraints.NotNull;

public class ParkProviderStatusBO {
    @NotNull
    private Integer id;
    @NotNull(message = "status不能为空")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public ParkProviderStatusBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ParkProviderStatusBO setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
