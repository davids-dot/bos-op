package com.luoge.bos.op.invoice.model.park.enterprise;

public class ListParkEnterpriseBO {
    /**
     * 企业名称
     */
    private String name;
    /**
     * 机构id
     */
    private Integer orgId;
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

    public ListParkEnterpriseBO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public ListParkEnterpriseBO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public Long getStartTime() {
        return startTime;
    }

    public ListParkEnterpriseBO setStartTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    public Long getEndTime() {
        return endTime;
    }

    public ListParkEnterpriseBO setEndTime(Long endTime) {
        this.endTime = endTime;
        return this;
    }
}
