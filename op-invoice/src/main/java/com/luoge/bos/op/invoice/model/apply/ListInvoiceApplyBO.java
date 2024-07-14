package com.luoge.bos.op.invoice.model.apply;

public class ListInvoiceApplyBO {
    /**
     * 园区服务商
     */
    private Integer parkProviderId;
    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 审核状态
     */
    private Integer status;
    /**
     * 开始时间
     */
    private Long startTime;
    /**
     * 结束时间
     */
    private Long endTime;

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public ListInvoiceApplyBO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public ListInvoiceApplyBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ListInvoiceApplyBO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Long getStartTime() {
        return startTime;
    }

    public ListInvoiceApplyBO setStartTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    public Long getEndTime() {
        return endTime;
    }

    public ListInvoiceApplyBO setEndTime(Long endTime) {
        this.endTime = endTime;
        return this;
    }
}