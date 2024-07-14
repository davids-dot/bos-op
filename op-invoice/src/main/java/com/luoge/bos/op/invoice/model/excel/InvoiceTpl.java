package com.luoge.bos.op.invoice.model.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import java.math.BigDecimal;

/**
 * Excel 发票列表模板
 */
public class InvoiceTpl {
    @ExcelIgnore
    private String id;
    @ExcelProperty("发票号")
    private String invoiceNo;
    @ExcelProperty("购买方信息")
    private String buyerName;
    @ExcelProperty("价税合计")
    private String total;
    @ExcelProperty("服务费率(%)")
    private String serviceFeeRate;
    @ExcelProperty("应收服务费")
    private String serviceFee;
    /**
     * 应付服务商金额
     */
    @ExcelProperty("应付服务商金额")
    private String parkProviderAmount;
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
    @ExcelProperty("发票来源")
    private String sourceType;
    @ExcelProperty("开票时间")
    private String issueTime;

    public String getId() {
        return id;
    }

    public InvoiceTpl setId(String id) {
        this.id = id;
        return this;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public InvoiceTpl setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
        return this;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public InvoiceTpl setBuyerName(String buyerName) {
        this.buyerName = buyerName;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public InvoiceTpl setTotal(String total) {
        this.total = total;
        return this;
    }

    public String getServiceFeeRate() {
        return serviceFeeRate;
    }

    public InvoiceTpl setServiceFeeRate(String serviceFeeRate) {
        this.serviceFeeRate = serviceFeeRate;
        return this;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public InvoiceTpl setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public String getParkProviderAmount() {
        return parkProviderAmount;
    }

    public InvoiceTpl setParkProviderAmount(String parkProviderAmount) {
        this.parkProviderAmount = parkProviderAmount;
        return this;
    }

    public String getDistributorFee() {
        return distributorFee;
    }

    public InvoiceTpl setDistributorFee(String distributorFee) {
        this.distributorFee = distributorFee;
        return this;
    }

    public String getIncome() {
        return income;
    }

    public InvoiceTpl setIncome(String income) {
        this.income = income;
        return this;
    }

    public String getSourceType() {
        return sourceType;
    }

    public InvoiceTpl setSourceType(String sourceType) {
        this.sourceType = sourceType;
        return this;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public InvoiceTpl setIssueTime(String issueTime) {
        this.issueTime = issueTime;
        return this;
    }
}
