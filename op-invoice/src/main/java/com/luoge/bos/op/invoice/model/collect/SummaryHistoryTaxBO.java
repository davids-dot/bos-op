package com.luoge.bos.op.invoice.model.collect;

import java.math.BigDecimal;

public class SummaryHistoryTaxBO {
    /**
     * 企业id
     */
    private Integer enterpriseId;
    /**
     * 专票税额
     */
    private BigDecimal specialTax;
    /**
     * 普票税额
     */
    private BigDecimal normalTax;
    /**
     * 虚拟专票税额
     */
    private BigDecimal virtualSpecialTax;
    /**
     * 虚拟普票税额
     */
    private BigDecimal virtualNormalTax;

    public SummaryHistoryTaxBO() {
    }

    public SummaryHistoryTaxBO(BigDecimal specialTax, BigDecimal normalTax, BigDecimal virtualSpecialTax, BigDecimal virtualNormalTax) {
        this.specialTax = specialTax;
        this.normalTax = normalTax;
        this.virtualSpecialTax = virtualSpecialTax;
        this.virtualNormalTax = virtualNormalTax;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public SummaryHistoryTaxBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public BigDecimal getSpecialTax() {
        return specialTax;
    }

    public SummaryHistoryTaxBO setSpecialTax(BigDecimal specialTax) {
        this.specialTax = specialTax;
        return this;
    }

    public BigDecimal getNormalTax() {
        return normalTax;
    }

    public SummaryHistoryTaxBO setNormalTax(BigDecimal normalTax) {
        this.normalTax = normalTax;
        return this;
    }

    public BigDecimal getVirtualSpecialTax() {
        return virtualSpecialTax;
    }

    public SummaryHistoryTaxBO setVirtualSpecialTax(BigDecimal virtualSpecialTax) {
        this.virtualSpecialTax = virtualSpecialTax;
        return this;
    }

    public BigDecimal getVirtualNormalTax() {
        return virtualNormalTax;
    }

    public SummaryHistoryTaxBO setVirtualNormalTax(BigDecimal virtualNormalTax) {
        this.virtualNormalTax = virtualNormalTax;
        return this;
    }
}
