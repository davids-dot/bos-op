package com.luoge.bos.invoice.model.org;

public class ListEnterpriseRegistrationBO {
    /**
     * 法人姓名
     */
    private String corporateName;
    /**
     * 园区服务商id
     */
    private Integer parkProviderId;
    /**
     * 申请单状态
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

    public String getCorporateName() {
        return corporateName;
    }

    public ListEnterpriseRegistrationBO setCorporateName(String corporateName) {
        this.corporateName = corporateName;
        return this;
    }

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public ListEnterpriseRegistrationBO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ListEnterpriseRegistrationBO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Long getStartTime() {
        return startTime;
    }

    public ListEnterpriseRegistrationBO setStartTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    public Long getEndTime() {
        return endTime;
    }

    public ListEnterpriseRegistrationBO setEndTime(Long endTime) {
        this.endTime = endTime;
        return this;
    }
}
