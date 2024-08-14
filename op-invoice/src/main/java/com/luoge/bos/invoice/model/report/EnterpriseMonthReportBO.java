package com.luoge.bos.invoice.model.report;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

public class EnterpriseMonthReportBO {
    /**
     * 企业id
     */
    @ExcelIgnore
    private Integer enterpriseId;
    /**
     * 企业名称
     */
    @ExcelProperty("企业名称")
    private String enterpriseName;
    /**
     * 月份
     */
    @ExcelProperty("月份")
    private String month;
    /**
     * 累计开票额
     */
    @ExcelProperty("累计开票额")
    private String invoiceTotalAmount;
    /**
     * 应收服务费
     */
    @ExcelProperty("应收服务费")
    private String serviceFee;
    /**
     * 客户名称
     */
    @ExcelProperty("客户名称")
    private String customer;
    /**
     * 客户经理
     */
    @ExcelProperty("客户经理")
    private String customerManager;
    /**
     * 园区服务商id
     */
    @ExcelIgnore
    private Integer parkProviderId;
    /**
     * 园区服务商名称
     */
    @ExcelProperty("园区服务商")
    private String parkProviderName;
    /**
     * 应付服务商金额
     */
    @ExcelProperty("应付服务商金额")
    private String parkProviderAmount;
    /**
     * 渠道商id
     */
    @ExcelIgnore
    private Integer distributorId;
    /**
     * 渠道商名称
     */
    @ExcelProperty("渠道商")
    private String distributorName;
    /**
     * 应付渠道商金额
     */
    @ExcelProperty("应付渠道商金额")
    private String distributorFee;
    /**
     * 应归属收入
     */
    @ExcelProperty("应归属收入")
    private String income;


    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public EnterpriseMonthReportBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public EnterpriseMonthReportBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public EnterpriseMonthReportBO setMonth(String month) {
        this.month = month;
        return this;
    }

    public String getInvoiceTotalAmount() {
        return invoiceTotalAmount;
    }

    public EnterpriseMonthReportBO setInvoiceTotalAmount(String invoiceTotalAmount) {
        this.invoiceTotalAmount = invoiceTotalAmount;
        return this;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public EnterpriseMonthReportBO setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public EnterpriseMonthReportBO setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getCustomerManager() {
        return customerManager;
    }

    public EnterpriseMonthReportBO setCustomerManager(String customerManager) {
        this.customerManager = customerManager;
        return this;
    }

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public EnterpriseMonthReportBO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public EnterpriseMonthReportBO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public String getParkProviderAmount() {
        return parkProviderAmount;
    }

    public EnterpriseMonthReportBO setParkProviderAmount(String parkProviderAmount) {
        this.parkProviderAmount = parkProviderAmount;
        return this;
    }

    public Integer getDistributorId() {
        return distributorId;
    }

    public EnterpriseMonthReportBO setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
        return this;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public EnterpriseMonthReportBO setDistributorName(String distributorName) {
        this.distributorName = distributorName;
        return this;
    }

    public String getDistributorFee() {
        return distributorFee;
    }

    public EnterpriseMonthReportBO setDistributorFee(String distributorFee) {
        this.distributorFee = distributorFee;
        return this;
    }

    public String getIncome() {
        return income;
    }

    public EnterpriseMonthReportBO setIncome(String income) {
        this.income = income;
        return this;
    }
}
