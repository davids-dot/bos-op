package com.luoge.bos.op.invoice.model.report;

public class ListParkProviderMonthReportBO {
    /**
     * 园区服务商id
     */
    private Integer providerId;
    /**
     * 开始月份
     */
    private Long startMonth;
    /**
     * 结束月份
     */
    private Long endMonth;


    public Integer getProviderId() {
        return providerId;
    }

    public ListParkProviderMonthReportBO setProviderId(Integer providerId) {
        this.providerId = providerId;
        return this;
    }

    public Long getStartMonth() {
        return startMonth;
    }

    public ListParkProviderMonthReportBO setStartMonth(Long startMonth) {
        this.startMonth = startMonth;
        return this;
    }

    public Long getEndMonth() {
        return endMonth;
    }

    public ListParkProviderMonthReportBO setEndMonth(Long endMonth) {
        this.endMonth = endMonth;
        return this;
    }
}
