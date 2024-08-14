package com.luoge.bos.invoice.model.collect;

import java.math.BigDecimal;

/**
 * 季度合计
 */
public class SeasonSummaryBO {
    /**
     * 累计价税合计（包含本月）
     */
    private BigDecimal invoiceTotal;
    /**
     * 累计不含税金额（包含本月）
     */
    private BigDecimal invoiceTotalAmount;
    /**
     * 累计税额（包含本月）
     */
    private BigDecimal invoiceTotalTax;
    /**
     * 累计专票税额(包含本月)
     */
    private BigDecimal invoiceSpecialTax;
    /**
     * 累计普票税额（包含本月）
     */
    private BigDecimal invoiceNormalTax;
    /**
     * 本季度 历史各月(不包含本月) 已缴纳的 增值税合计
     */
    private BigDecimal historyValueTax;

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public SeasonSummaryBO setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
        return this;
    }

    public BigDecimal getInvoiceTotalTax() {
        return invoiceTotalTax;
    }

    public SeasonSummaryBO setInvoiceTotalTax(BigDecimal invoiceTotalTax) {
        this.invoiceTotalTax = invoiceTotalTax;
        return this;
    }

    public BigDecimal getHistoryValueTax() {
        return historyValueTax;
    }

    public SeasonSummaryBO setHistoryValueTax(BigDecimal historyValueTax) {
        this.historyValueTax = historyValueTax;
        return this;
    }

    public BigDecimal getInvoiceTotalAmount() {
        return invoiceTotalAmount;
    }

    public SeasonSummaryBO setInvoiceTotalAmount(BigDecimal invoiceTotalAmount) {
        this.invoiceTotalAmount = invoiceTotalAmount;
        return this;
    }

    public BigDecimal getInvoiceSpecialTax() {
        return invoiceSpecialTax;
    }

    public SeasonSummaryBO setInvoiceSpecialTax(BigDecimal invoiceSpecialTax) {
        this.invoiceSpecialTax = invoiceSpecialTax;
        return this;
    }

    public BigDecimal getInvoiceNormalTax() {
        return invoiceNormalTax;
    }

    public SeasonSummaryBO setInvoiceNormalTax(BigDecimal invoiceNormalTax) {
        this.invoiceNormalTax = invoiceNormalTax;
        return this;
    }
}
