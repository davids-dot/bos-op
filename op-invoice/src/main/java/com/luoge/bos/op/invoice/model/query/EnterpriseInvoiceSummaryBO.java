package com.luoge.bos.op.invoice.model.query;

import java.math.BigDecimal;

public class EnterpriseInvoiceSummaryBO {
    /**
     * 累计开票金额
     */
    private BigDecimal total;
    /**
     * 应收服务费
     */
    private BigDecimal serviceFee;
    /**
     * 应付服务商金额合计
     */
    private BigDecimal parkProviderAmount;
    /**
     * 应付渠道商金额合计
     */
    private BigDecimal distributorFee;
    /**
     * 应归属收入合计
     */
    private BigDecimal income;

    public static EnterpriseInvoiceSummaryBO emptySummary() {
        return new EnterpriseInvoiceSummaryBO()
                .setTotal(BigDecimal.ZERO)
                .setServiceFee(BigDecimal.ZERO)
                .setParkProviderAmount(BigDecimal.ZERO)
                .setDistributorFee(BigDecimal.ZERO)
                .setIncome(BigDecimal.ZERO);
    }

    public BigDecimal getTotal() {
        return total;
    }

    public EnterpriseInvoiceSummaryBO setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public EnterpriseInvoiceSummaryBO setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public BigDecimal getParkProviderAmount() {
        return parkProviderAmount;
    }

    public EnterpriseInvoiceSummaryBO setParkProviderAmount(BigDecimal parkProviderAmount) {
        this.parkProviderAmount = parkProviderAmount;
        return this;
    }

    public BigDecimal getDistributorFee() {
        return distributorFee;
    }

    public EnterpriseInvoiceSummaryBO setDistributorFee(BigDecimal distributorFee) {
        this.distributorFee = distributorFee;
        return this;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public EnterpriseInvoiceSummaryBO setIncome(BigDecimal income) {
        this.income = income;
        return this;
    }
}
