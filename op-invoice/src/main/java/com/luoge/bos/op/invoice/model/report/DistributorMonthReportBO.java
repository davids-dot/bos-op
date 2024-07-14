package com.luoge.bos.op.invoice.model.report;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

public class DistributorMonthReportBO {
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
     * 月份
     */
    @ExcelProperty("月份")
    private String month;
    /**
     * 累计开票额
     */
    @ExcelProperty("累计开票额")
    private String totalAmount;
    /**
     * 应付佣金
     */
    @ExcelProperty("应付佣金")
    private String totalFee;

    public Integer getDistributorId() {
        return distributorId;
    }

    public DistributorMonthReportBO setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
        return this;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public DistributorMonthReportBO setDistributorName(String distributorName) {
        this.distributorName = distributorName;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public DistributorMonthReportBO setMonth(String month) {
        this.month = month;
        return this;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public DistributorMonthReportBO setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public DistributorMonthReportBO setTotalFee(String totalFee) {
        this.totalFee = totalFee;
        return this;
    }
}
