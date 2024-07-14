package com.luoge.bos.op.invoice.model.park.provider;

import java.math.BigDecimal;

public class EnterpriseParkProviderFeeRate {
    /**
     * 园区服务商的附加税税率
     */
    private BigDecimal parkProviderAdditionalTaxRate;
    /**
     * 园区服务商的水利基金税率
     */
    private BigDecimal parkProviderWaterTaxRate;
    /**
     * 园区服务商的印花税税率
     */
    private BigDecimal parkProviderStampTaxRate;
    /**
     * 园区服务商的个人所得税税率
     */
    private BigDecimal parkProviderIncomeTaxRate;
    /**
     * 园区服务商的服务费费率
     */
    private BigDecimal parkProviderServiceFeeRate;

    private Integer valueAddedTaxType;
    /**
     * 包税税率
     */
    private BigDecimal includeTaxRate;


    public BigDecimal getParkProviderAdditionalTaxRate() {
        return parkProviderAdditionalTaxRate;
    }

    public EnterpriseParkProviderFeeRate setParkProviderAdditionalTaxRate(BigDecimal parkProviderAdditionalTaxRate) {
        this.parkProviderAdditionalTaxRate = parkProviderAdditionalTaxRate;
        return this;
    }

    public BigDecimal getParkProviderWaterTaxRate() {
        return parkProviderWaterTaxRate;
    }

    public EnterpriseParkProviderFeeRate setParkProviderWaterTaxRate(BigDecimal parkProviderWaterTaxRate) {
        this.parkProviderWaterTaxRate = parkProviderWaterTaxRate;
        return this;
    }

    public BigDecimal getParkProviderStampTaxRate() {
        return parkProviderStampTaxRate;
    }

    public EnterpriseParkProviderFeeRate setParkProviderStampTaxRate(BigDecimal parkProviderStampTaxRate) {
        this.parkProviderStampTaxRate = parkProviderStampTaxRate;
        return this;
    }

    public BigDecimal getParkProviderIncomeTaxRate() {
        return parkProviderIncomeTaxRate;
    }

    public EnterpriseParkProviderFeeRate setParkProviderIncomeTaxRate(BigDecimal parkProviderIncomeTaxRate) {
        this.parkProviderIncomeTaxRate = parkProviderIncomeTaxRate;
        return this;
    }

    public BigDecimal getParkProviderServiceFeeRate() {
        return parkProviderServiceFeeRate;
    }

    public EnterpriseParkProviderFeeRate setParkProviderServiceFeeRate(BigDecimal parkProviderServiceFeeRate) {
        this.parkProviderServiceFeeRate = parkProviderServiceFeeRate;
        return this;
    }

    public Integer getValueAddedTaxType() {
        return valueAddedTaxType;
    }

    public EnterpriseParkProviderFeeRate setValueAddedTaxType(Integer valueAddedTaxType) {
        this.valueAddedTaxType = valueAddedTaxType;
        return this;
    }

    public BigDecimal getIncludeTaxRate() {
        return includeTaxRate;
    }

    public EnterpriseParkProviderFeeRate setIncludeTaxRate(BigDecimal includeTaxRate) {
        this.includeTaxRate = includeTaxRate;
        return this;
    }

    @Override
    public String toString() {
        return "EnterpriseParkProviderFeeRate{" +
                "parkProviderAdditionalTaxRate=" + parkProviderAdditionalTaxRate +
                ", parkProviderWaterTaxRate=" + parkProviderWaterTaxRate +
                ", parkProviderStampTaxRate=" + parkProviderStampTaxRate +
                ", parkProviderIncomeTaxRate=" + parkProviderIncomeTaxRate +
                ", parkProviderServiceFeeRate=" + parkProviderServiceFeeRate +
                ", valueAddedTaxType=" + valueAddedTaxType +
                '}';
    }
}
