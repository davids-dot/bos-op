package com.luoge.bos.invoice.model.report;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.luoge.bos.core.serialize.BigDecimalSerializer;

import java.math.BigDecimal;

public class SummaryEnterpriseReportBO {
    /**
     * 累计开票额
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal total;
    /**
     * 应收服务费
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal serviceFee;
    /**
     * 应付服务商金额
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal providerAmount;
    /**
     * 应付渠道商金额
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal distributorAmount;
    /**
     * 应归属收入
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal income;

    public static final SummaryEnterpriseReportBO EMPTY_SUMMARY = new SummaryEnterpriseReportBO(BigDecimal.ZERO, BigDecimal.ZERO,
            BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);

    public SummaryEnterpriseReportBO() {
    }

    public SummaryEnterpriseReportBO(BigDecimal total, BigDecimal serviceFee,
                                     BigDecimal providerAmount, BigDecimal distributorAmount,
                                     BigDecimal income) {
        this.total = total;
        this.serviceFee = serviceFee;
        this.providerAmount = providerAmount;
        this.distributorAmount = distributorAmount;
        this.income = income;
    }


    public BigDecimal getTotal() {
        return total;
    }

    public SummaryEnterpriseReportBO setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public SummaryEnterpriseReportBO setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public BigDecimal getProviderAmount() {
        return providerAmount;
    }

    public SummaryEnterpriseReportBO setProviderAmount(BigDecimal providerAmount) {
        this.providerAmount = providerAmount;
        return this;
    }

    public BigDecimal getDistributorAmount() {
        return distributorAmount;
    }

    public SummaryEnterpriseReportBO setDistributorAmount(BigDecimal distributorAmount) {
        this.distributorAmount = distributorAmount;
        return this;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public SummaryEnterpriseReportBO setIncome(BigDecimal income) {
        this.income = income;
        return this;
    }
}
