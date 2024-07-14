package com.luoge.bos.op.invoice.model.query;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

public class EnterpriseFeeBO {
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
     * 累计开票额
     */
    @ExcelProperty("累计开票额")
    private String totalAmount;
    /**
     * 应收服务费
     */
    @ExcelProperty("应收服务费")
    private String totalFee;
    /**
     * 园区服务商
     */
    @ExcelProperty("园区服务商")
    private String parkProviderName;
    /**
     * 应付服务商金额
     */
    @ExcelProperty("应付服务商金额")
    private String parkProviderAmount;
    /**
     * 渠道商
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

    /**
     * 开始时间
     */
    @ExcelIgnore
    private Long startTime;
    /**
     * 结束时间
     */
    @ExcelIgnore
    private Long endTime;

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public EnterpriseFeeBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public EnterpriseFeeBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public EnterpriseFeeBO setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public EnterpriseFeeBO setTotalFee(String totalFee) {
        this.totalFee = totalFee;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public EnterpriseFeeBO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public String getParkProviderAmount() {
        return parkProviderAmount;
    }

    public EnterpriseFeeBO setParkProviderAmount(String parkProviderAmount) {
        this.parkProviderAmount = parkProviderAmount;
        return this;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public EnterpriseFeeBO setDistributorName(String distributorName) {
        this.distributorName = distributorName;
        return this;
    }

    public String getDistributorFee() {
        return distributorFee;
    }

    public EnterpriseFeeBO setDistributorFee(String distributorFee) {
        this.distributorFee = distributorFee;
        return this;
    }

    public String getIncome() {
        return income;
    }

    public EnterpriseFeeBO setIncome(String income) {
        this.income = income;
        return this;
    }

    public Long getStartTime() {
        return startTime;
    }

    public EnterpriseFeeBO setStartTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    public Long getEndTime() {
        return endTime;
    }

    public EnterpriseFeeBO setEndTime(Long endTime) {
        this.endTime = endTime;
        return this;
    }

}
