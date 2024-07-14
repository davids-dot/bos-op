package com.luoge.bos.op.invoice.model.collect;

import cn.hutool.core.util.ObjectUtil;
import com.luoge.bos.op.core.utils.Numbers;
import com.luoge.bos.op.invoice.entity.InvoiceDO;

import java.math.BigDecimal;
import java.util.Objects;

import static com.luoge.bos.op.core.types.InvoiceType.ELECTRONIC_FULL_GENERAL;
import static com.luoge.bos.op.core.types.InvoiceType.ELECTRONIC_FULL_SPECIAL;


public class SeasonSummaryDailyBO {
    /**
     * 企业id
     */
    private Integer enterpriseId;
    /**
     * 累计价税合计
     */
    private BigDecimal invoiceTotal;
    /**
     * 累计不含税金额
     */
    private BigDecimal invoiceTotalAmount;

    /**
     * 累计税额
     */
    private BigDecimal invoiceTotalTax;
    /**
     * 累计专票税额
     */
    private BigDecimal invoiceSpecialTax;
    /**
     * 累计普票税额
     */
    private BigDecimal invoiceNormalTax;
    /**
     * 配置公式-累计税额
     */
    private BigDecimal virtualInvoiceTotalTax;
    /**
     * 配置公式-累计专票税额
     */
    private BigDecimal virtualInvoiceSpecialTax;
    /**
     * 配置公式-累计普票税额
     */
    private BigDecimal virtualInvoiceNormalTax;

    /**
     * 本季度历史已缴纳的增值税合计
     */
    private BigDecimal historyValueTax;

    public static SeasonSummaryDailyBO emptySummary() {
        return new SeasonSummaryDailyBO()
                .setInvoiceTotal(BigDecimal.ZERO)
                .setInvoiceTotalAmount(BigDecimal.ZERO)
                .setInvoiceTotalTax(BigDecimal.ZERO)
                .setInvoiceSpecialTax(BigDecimal.ZERO)
                .setInvoiceNormalTax(BigDecimal.ZERO)
                .setHistoryValueTax(BigDecimal.ZERO)
                .setVirtualInvoiceSpecialTax(BigDecimal.ZERO)
                .setVirtualInvoiceNormalTax(BigDecimal.ZERO)
                .setVirtualInvoiceTotalTax(BigDecimal.ZERO);
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public SeasonSummaryDailyBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public SeasonSummaryDailyBO setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
        return this;
    }

    public BigDecimal getInvoiceTotalAmount() {
        return invoiceTotalAmount;
    }

    public SeasonSummaryDailyBO setInvoiceTotalAmount(BigDecimal invoiceTotalAmount) {
        this.invoiceTotalAmount = invoiceTotalAmount;
        return this;
    }

    public BigDecimal getInvoiceTotalTax() {
        return invoiceTotalTax;
    }

    public SeasonSummaryDailyBO setInvoiceTotalTax(BigDecimal invoiceTotalTax) {
        this.invoiceTotalTax = invoiceTotalTax;
        return this;
    }

    public BigDecimal getInvoiceSpecialTax() {
        return invoiceSpecialTax;
    }

    public SeasonSummaryDailyBO setInvoiceSpecialTax(BigDecimal invoiceSpecialTax) {
        this.invoiceSpecialTax = invoiceSpecialTax;
        return this;
    }

    public BigDecimal getInvoiceNormalTax() {
        return invoiceNormalTax;
    }

    public SeasonSummaryDailyBO setInvoiceNormalTax(BigDecimal invoiceNormalTax) {
        this.invoiceNormalTax = invoiceNormalTax;
        return this;
    }

    public BigDecimal getHistoryValueTax() {
        return historyValueTax;
    }

    public SeasonSummaryDailyBO setHistoryValueTax(BigDecimal historyValueTax) {
        this.historyValueTax = historyValueTax;
        return this;
    }

    public BigDecimal getVirtualInvoiceTotalTax() {
        return virtualInvoiceTotalTax;
    }

    public SeasonSummaryDailyBO setVirtualInvoiceTotalTax(BigDecimal virtualInvoiceTotalTax) {
        this.virtualInvoiceTotalTax = virtualInvoiceTotalTax;
        return this;
    }

    public BigDecimal getVirtualInvoiceSpecialTax() {
        return virtualInvoiceSpecialTax;
    }

    public SeasonSummaryDailyBO setVirtualInvoiceSpecialTax(BigDecimal virtualInvoiceSpecialTax) {
        this.virtualInvoiceSpecialTax = virtualInvoiceSpecialTax;
        return this;
    }

    public BigDecimal getVirtualInvoiceNormalTax() {
        return virtualInvoiceNormalTax;
    }

    public SeasonSummaryDailyBO setVirtualInvoiceNormalTax(BigDecimal virtualInvoiceNormalTax) {
        this.virtualInvoiceNormalTax = virtualInvoiceNormalTax;
        return this;
    }

    public void addInvoice(InvoiceDO invoice) {
        if (Objects.isNull(invoice)) {
            return;
        }

        invoiceTotal = Numbers.add(invoiceTotal, invoice.getTotal());
        invoiceTotalAmount = Numbers.add(invoiceTotalAmount, invoice.getTotalAmount());
        invoiceTotalTax = Numbers.add(invoiceTotalTax, invoice.getTotalTax());
        // 计算增值税
        BigDecimal valueAddedTax = invoice.getTotal().multiply(ObjectUtil.isEmpty(invoice.getInvoiceTaxRate()) ? new BigDecimal("0") : invoice.getInvoiceTaxRate());
        virtualInvoiceTotalTax = Numbers.add(virtualInvoiceTotalTax, valueAddedTax);
        if (Objects.equals(ELECTRONIC_FULL_SPECIAL.type, invoice.getType())) {
            invoiceSpecialTax = Numbers.add(invoiceSpecialTax, invoice.getTotalTax());
            virtualInvoiceSpecialTax = Numbers.add(virtualInvoiceSpecialTax, valueAddedTax);
        } else if (Objects.equals(ELECTRONIC_FULL_GENERAL.type, invoice.getType())) {
            invoiceNormalTax = Numbers.add(invoiceNormalTax, invoice.getTotalTax());
            virtualInvoiceNormalTax = Numbers.add(virtualInvoiceNormalTax, valueAddedTax);
        }

    }

    public void addValueAddedTax(BigDecimal valueAddedTax) {
        if (Objects.isNull(valueAddedTax)) {
            return;
        }
        historyValueTax = Numbers.add(historyValueTax, valueAddedTax);
    }
}
