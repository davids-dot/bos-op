package com.luoge.bos.op.invoice.model.collect;

public class ListInvoiceBO {
    private Integer parkProviderId;
    private String enterpriseName;
    private Long startTime;
    private Long endTime;

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public ListInvoiceBO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public ListInvoiceBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public Long getStartTime() {
        return startTime;
    }

    public ListInvoiceBO setStartTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    public Long getEndTime() {
        return endTime;
    }

    public ListInvoiceBO setEndTime(Long endTime) {
        this.endTime = endTime;
        return this;
    }
}
