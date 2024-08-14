package com.luoge.bos.invoice.model.collect;

import jakarta.validation.constraints.NotNull;

public class TriggerTaskBO {
    @NotNull
    private Long startTime;
    @NotNull
    private Long endTime;

    private Integer enterpriseId;

    public Long getStartTime() {
        return startTime;
    }

    public TriggerTaskBO setStartTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    public Long getEndTime() {
        return endTime;
    }

    public TriggerTaskBO setEndTime(Long endTime) {
        this.endTime = endTime;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public TriggerTaskBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }
}
