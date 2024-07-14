package com.luoge.bos.op.invoice.model.collect;

import java.math.BigDecimal;

public class SummaryHistoryBO {

    private BigDecimal invoiceTotal;

    private BigDecimal invoiceTotalAmount;

    private BigDecimal invoiceTotalTax;

    private BigDecimal valueAddedTax;

    public SummaryHistoryBO() {
    }

    public SummaryHistoryBO(BigDecimal invoiceTotal,
                            BigDecimal invoiceTotalAmount,
                            BigDecimal invoiceTotalTax,
                            BigDecimal valueAddedTax) {
        this.invoiceTotal = invoiceTotal;
        this.invoiceTotalAmount = invoiceTotalAmount;
        this.invoiceTotalTax = invoiceTotalTax;
        this.valueAddedTax = valueAddedTax;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public SummaryHistoryBO setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
        return this;
    }

    public BigDecimal getInvoiceTotalAmount() {
        return invoiceTotalAmount;
    }

    public SummaryHistoryBO setInvoiceTotalAmount(BigDecimal invoiceTotalAmount) {
        this.invoiceTotalAmount = invoiceTotalAmount;
        return this;
    }

    public BigDecimal getInvoiceTotalTax() {
        return invoiceTotalTax;
    }

    public SummaryHistoryBO setInvoiceTotalTax(BigDecimal invoiceTotalTax) {
        this.invoiceTotalTax = invoiceTotalTax;
        return this;
    }

    public BigDecimal getValueAddedTax() {
        return valueAddedTax;
    }

    public SummaryHistoryBO setValueAddedTax(BigDecimal valueAddedTax) {
        this.valueAddedTax = valueAddedTax;
        return this;
    }
}
