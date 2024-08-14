package com.luoge.bos.invoice.model.report;

public class ListDistributorMonthReportBO {
    /**
     * 渠道商id
     */
    private Integer distributorId;
    /**
     * 开始月份
     */
    private Long startMonth;
    /**
     * 结束月份
     */
    private Long endMonth;

    public Integer getDistributorId() {
        return distributorId;
    }

    public ListDistributorMonthReportBO setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
        return this;
    }

    public Long getStartMonth() {
        return startMonth;
    }

    public ListDistributorMonthReportBO setStartMonth(Long startMonth) {
        this.startMonth = startMonth;
        return this;
    }

    public Long getEndMonth() {
        return endMonth;
    }

    public ListDistributorMonthReportBO setEndMonth(Long endMonth) {
        this.endMonth = endMonth;
        return this;
    }
}
