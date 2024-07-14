package com.luoge.bos.op.invoice.model.report;

import java.math.BigDecimal;

/**
 * 发票月度汇总金额
 */
public class SummaryMonthInvoiceFee {
    /**
     * 企业id
     */
    private Integer enterpriseId;
    /**
     * 月份
     */
    private String month;
    /**
     * 总 价税合计
     */
    private BigDecimal invoiceTotal;
    /**
     * 总 不含税金额
     */
    private BigDecimal invoiceTotalAmount;
    /**
     * 总 服务费
     */
    private BigDecimal serviceFee;
    /**
     * 总 税额
     */
    private BigDecimal invoiceTotalTax;
    /**
     * 总 专票税额
     */
    private BigDecimal invoiceSpecialTax;
    /**
     * 总 普票税额
     */
    private BigDecimal invoiceNormalTax;

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public SummaryMonthInvoiceFee setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public SummaryMonthInvoiceFee setMonth(String month) {
        this.month = month;
        return this;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public SummaryMonthInvoiceFee setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
        return this;
    }

    public BigDecimal getInvoiceTotalAmount() {
        return invoiceTotalAmount;
    }

    public SummaryMonthInvoiceFee setInvoiceTotalAmount(BigDecimal invoiceTotalAmount) {
        this.invoiceTotalAmount = invoiceTotalAmount;
        return this;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public SummaryMonthInvoiceFee setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public BigDecimal getInvoiceTotalTax() {
        return invoiceTotalTax;
    }

    public SummaryMonthInvoiceFee setInvoiceTotalTax(BigDecimal invoiceTotalTax) {
        this.invoiceTotalTax = invoiceTotalTax;
        return this;
    }

    public BigDecimal getInvoiceSpecialTax() {
        return invoiceSpecialTax;
    }

    public SummaryMonthInvoiceFee setInvoiceSpecialTax(BigDecimal invoiceSpecialTax) {
        this.invoiceSpecialTax = invoiceSpecialTax;
        return this;
    }

    public BigDecimal getInvoiceNormalTax() {
        return invoiceNormalTax;
    }

    public SummaryMonthInvoiceFee setInvoiceNormalTax(BigDecimal invoiceNormalTax) {
        this.invoiceNormalTax = invoiceNormalTax;
        return this;
    }
}
