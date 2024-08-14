package com.luoge.bos.invoice.model.query;

public class ListEnterpriseFeeBO {
    /**
     * 企业名称
     */
    private String name;
    /**
     * 服务商id
     */
    private Integer providerId;
    /**
     * 渠道商id
     */
    private Integer distributorId;
    /**
     * 开始时间
     */
    private Long startTime;
    /**
     * 结束时间
     */
    private Long endTime;


    public String getName() {
        return name;
    }

    public ListEnterpriseFeeBO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public ListEnterpriseFeeBO setProviderId(Integer providerId) {
        this.providerId = providerId;
        return this;
    }

    public Integer getDistributorId() {
        return distributorId;
    }

    public ListEnterpriseFeeBO setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
        return this;
    }

    public Long getStartTime() {
        return startTime;
    }

    public ListEnterpriseFeeBO setStartTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    public Long getEndTime() {
        return endTime;
    }

    public ListEnterpriseFeeBO setEndTime(Long endTime) {
        this.endTime = endTime;
        return this;
    }

}
