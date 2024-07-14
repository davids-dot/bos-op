package com.luoge.bos.op.invoice.model.report;

public class ListEnterpriseMonthReportBO {
    /**
     * 园区服务商id
     */
    private Integer providerId;
    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 客户经理
     */
    private String customerManager;
    /**
     * 客户名称
     */
    private String customer;
    /**
     * 渠道商
     */
    private String distributorName;
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

    public ListEnterpriseMonthReportBO setProviderId(Integer providerId) {
        this.providerId = providerId;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public ListEnterpriseMonthReportBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getCustomerManager() {
        return customerManager;
    }

    public ListEnterpriseMonthReportBO setCustomerManager(String customerManager) {
        this.customerManager = customerManager;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public ListEnterpriseMonthReportBO setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public ListEnterpriseMonthReportBO setDistributorName(String distributorName) {
        this.distributorName = distributorName;
        return this;
    }

    public Long getStartMonth() {
        return startMonth;
    }

    public ListEnterpriseMonthReportBO setStartMonth(Long startMonth) {
        this.startMonth = startMonth;
        return this;
    }

    public Long getEndMonth() {
        return endMonth;
    }

    public ListEnterpriseMonthReportBO setEndMonth(Long endMonth) {
        this.endMonth = endMonth;
        return this;
    }
}
