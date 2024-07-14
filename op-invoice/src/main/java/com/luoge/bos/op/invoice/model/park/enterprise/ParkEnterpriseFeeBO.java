package com.luoge.bos.op.invoice.model.park.enterprise;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.luoge.bos.op.core.serialize.BigDecimalSerializer;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkEnterpriseFeeBO {
    /**
     * 企业id
     */
    @NotNull
    private Integer id;
    /**
     * 服务费费率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal feeRate;
    /**
     * 服务费支付方
     */
    private Integer serviceFeePayerId;
    /**
     * 所属客户
     */
    private Integer customerId;
    /**
     * 客户经理
     */
    private String customerManager;
    /**
     * 园区服务商id
     */
    private Integer parkProviderId;
    /**
     * 园区服务商
     */
    private String parkProviderName;
    /**
     * 园区服务商附加税税率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal parkProviderAdditionalTaxRate;
    /**
     * 园区服务商水利基金税率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal parkProviderWaterTaxRate;
    /**
     * 园区服务商印花税税率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal parkProviderStampTaxRate;
    /**
     * 园区服务商个税税率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal parkProviderIncomeTaxRate;
    /**
     * 园区服务商服务费费率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal parkProviderServiceFeeRate;
    /**
     * 渠道商id
     */
    private Integer distributorId;
    /**
     * 渠道商
     */
    private String distributorName;
    /**
     * 渠道商服务费费率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal distributorServiceFeeRate;
    /**
     * 个人所得税计算方式  1-附征率 2-应税所得，累计减半
     */
    private Integer parkProviderIncomeTaxType;
    @JsonIgnore
    private LocalDateTime updateTime;
    /**
     * 园区服务商增值税税率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal parkProviderValueAddedTaxRate;
    /**
     * 增值税计算公式
     */
    private Integer valueAddedTaxFormulaId;
    /**
     * 附加税计算公式
     */
    private Integer additionalTaxFormulaId;
    /**
     * 水利基金计算公式
     */
    private Integer waterTaxFormulaId;
    /**
     * 印花税计算公式
     */
    private Integer stampTaxFormulaId;
    /**
     * 个人所得税计算公式
     */
    private Integer incomeTaxFormulaId;
    /**
     * 增值税免税 1 免税 2 非免税
     */
    private Integer valueAddedTaxType;
    /**
     * 是否包税
     */
    private Integer isIncludeTax;
    /**
     * 包税税率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal includeTaxRate;

    public Integer getId() {
        return id;
    }

    public ParkEnterpriseFeeBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public ParkEnterpriseFeeBO setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
        return this;
    }

    public Integer getServiceFeePayerId() {
        return serviceFeePayerId;
    }

    public ParkEnterpriseFeeBO setServiceFeePayerId(Integer serviceFeePayerId) {
        this.serviceFeePayerId = serviceFeePayerId;
        return this;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public ParkEnterpriseFeeBO setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getCustomerManager() {
        return customerManager;
    }

    public ParkEnterpriseFeeBO setCustomerManager(String customerManager) {
        this.customerManager = customerManager;
        return this;
    }

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public ParkEnterpriseFeeBO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }

    public Integer getDistributorId() {
        return distributorId;
    }

    public ParkEnterpriseFeeBO setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public ParkEnterpriseFeeBO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public BigDecimal getParkProviderAdditionalTaxRate() {
        return parkProviderAdditionalTaxRate;
    }

    public ParkEnterpriseFeeBO setParkProviderAdditionalTaxRate(BigDecimal parkProviderAdditionalTaxRate) {
        this.parkProviderAdditionalTaxRate = parkProviderAdditionalTaxRate;
        return this;
    }

    public BigDecimal getParkProviderWaterTaxRate() {
        return parkProviderWaterTaxRate;
    }

    public ParkEnterpriseFeeBO setParkProviderWaterTaxRate(BigDecimal parkProviderWaterTaxRate) {
        this.parkProviderWaterTaxRate = parkProviderWaterTaxRate;
        return this;
    }

    public BigDecimal getParkProviderStampTaxRate() {
        return parkProviderStampTaxRate;
    }

    public ParkEnterpriseFeeBO setParkProviderStampTaxRate(BigDecimal parkProviderStampTaxRate) {
        this.parkProviderStampTaxRate = parkProviderStampTaxRate;
        return this;
    }

    public BigDecimal getParkProviderIncomeTaxRate() {
        return parkProviderIncomeTaxRate;
    }

    public ParkEnterpriseFeeBO setParkProviderIncomeTaxRate(BigDecimal parkProviderIncomeTaxRate) {
        this.parkProviderIncomeTaxRate = parkProviderIncomeTaxRate;
        return this;
    }

    public BigDecimal getParkProviderServiceFeeRate() {
        return parkProviderServiceFeeRate;
    }

    public ParkEnterpriseFeeBO setParkProviderServiceFeeRate(BigDecimal parkProviderServiceFeeRate) {
        this.parkProviderServiceFeeRate = parkProviderServiceFeeRate;
        return this;
    }

    public BigDecimal getDistributorServiceFeeRate() {
        return distributorServiceFeeRate;
    }

    public ParkEnterpriseFeeBO setDistributorServiceFeeRate(BigDecimal distributorServiceFeeRate) {
        this.distributorServiceFeeRate = distributorServiceFeeRate;
        return this;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public ParkEnterpriseFeeBO setDistributorName(String distributorName) {
        this.distributorName = distributorName;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public ParkEnterpriseFeeBO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Integer getParkProviderIncomeTaxType() {
        return parkProviderIncomeTaxType;
    }

    public ParkEnterpriseFeeBO setParkProviderIncomeTaxType(Integer parkProviderIncomeTaxType) {
        this.parkProviderIncomeTaxType = parkProviderIncomeTaxType;
        return this;
    }

    public BigDecimal getParkProviderValueAddedTaxRate() {
        return parkProviderValueAddedTaxRate;
    }

    public ParkEnterpriseFeeBO setParkProviderValueAddedTaxRate(BigDecimal parkProviderValueAddedTaxRate) {
        this.parkProviderValueAddedTaxRate = parkProviderValueAddedTaxRate;
        return this;
    }

    public Integer getValueAddedTaxFormulaId() {
        return valueAddedTaxFormulaId;
    }

    public ParkEnterpriseFeeBO setValueAddedTaxFormulaId(Integer valueAddedTaxFormulaId) {
        this.valueAddedTaxFormulaId = valueAddedTaxFormulaId;
        return this;
    }

    public Integer getAdditionalTaxFormulaId() {
        return additionalTaxFormulaId;
    }

    public ParkEnterpriseFeeBO setAdditionalTaxFormulaId(Integer additionalTaxFormulaId) {
        this.additionalTaxFormulaId = additionalTaxFormulaId;
        return this;
    }

    public Integer getWaterTaxFormulaId() {
        return waterTaxFormulaId;
    }

    public ParkEnterpriseFeeBO setWaterTaxFormulaId(Integer waterTaxFormulaId) {
        this.waterTaxFormulaId = waterTaxFormulaId;
        return this;
    }

    public Integer getStampTaxFormulaId() {
        return stampTaxFormulaId;
    }

    public ParkEnterpriseFeeBO setStampTaxFormulaId(Integer stampTaxFormulaId) {
        this.stampTaxFormulaId = stampTaxFormulaId;
        return this;
    }

    public Integer getIncomeTaxFormulaId() {
        return incomeTaxFormulaId;
    }

    public ParkEnterpriseFeeBO setIncomeTaxFormulaId(Integer incomeTaxFormulaId) {
        this.incomeTaxFormulaId = incomeTaxFormulaId;
        return this;
    }

    public Integer getValueAddedTaxType() {
        return valueAddedTaxType;
    }

    public ParkEnterpriseFeeBO setValueAddedTaxType(Integer valueAddedTaxType) {
        this.valueAddedTaxType = valueAddedTaxType;
        return this;
    }

    public Integer getIsIncludeTax() {
        return isIncludeTax;
    }

    public ParkEnterpriseFeeBO setIsIncludeTax(Integer isIncludeTax) {
        this.isIncludeTax = isIncludeTax;
        return this;
    }

    public BigDecimal getIncludeTaxRate() {
        return includeTaxRate;
    }

    public ParkEnterpriseFeeBO setIncludeTaxRate(BigDecimal includeTaxRate) {
        this.includeTaxRate = includeTaxRate;
        return this;
    }
}
