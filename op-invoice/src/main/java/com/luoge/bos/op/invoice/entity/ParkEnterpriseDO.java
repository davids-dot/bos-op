package com.luoge.bos.op.invoice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkEnterpriseDO {
    private Integer id;

    private Integer orgId;

    private Integer enterpriseId;

    private String enterpriseName;

    private BigDecimal serviceFeeRate;

    private Integer serviceFeePayerId;

    private Integer customerId;

    private String customerManager;

    private Integer parkProviderId;

    private Integer valueAddedTaxType;

    private BigDecimal parkProviderValueAddedTaxRate;

    private BigDecimal parkProviderAdditionalTaxRate;

    private BigDecimal parkProviderWaterTaxRate;

    private BigDecimal parkProviderStampTaxRate;

    private BigDecimal parkProviderIncomeTaxRate;

    private BigDecimal parkProviderServiceFeeRate;

    private Integer distributorId;

    private BigDecimal distributorServiceFeeRate;

    private BigDecimal includeTaxRate;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public ParkEnterpriseDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public ParkEnterpriseDO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public ParkEnterpriseDO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public ParkEnterpriseDO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public BigDecimal getServiceFeeRate() {
        return serviceFeeRate;
    }

    public ParkEnterpriseDO setServiceFeeRate(BigDecimal serviceFeeRate) {
        this.serviceFeeRate = serviceFeeRate;
        return this;
    }

    public Integer getServiceFeePayerId() {
        return serviceFeePayerId;
    }

    public ParkEnterpriseDO setServiceFeePayerId(Integer serviceFeePayerId) {
        this.serviceFeePayerId = serviceFeePayerId;
        return this;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public ParkEnterpriseDO setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getCustomerManager() {
        return customerManager;
    }

    public ParkEnterpriseDO setCustomerManager(String customerManager) {
        this.customerManager = customerManager;
        return this;
    }

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public ParkEnterpriseDO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }

    public Integer getDistributorId() {
        return distributorId;
    }

    public ParkEnterpriseDO setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ParkEnterpriseDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public ParkEnterpriseDO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Integer getValueAddedTaxType() {
        return valueAddedTaxType;
    }

    public ParkEnterpriseDO setValueAddedTaxType(Integer valueAddedTaxType) {
        this.valueAddedTaxType = valueAddedTaxType;
        return this;
    }

    public BigDecimal getParkProviderAdditionalTaxRate() {
        return parkProviderAdditionalTaxRate;
    }

    public ParkEnterpriseDO setParkProviderAdditionalTaxRate(BigDecimal parkProviderAdditionalTaxRate) {
        this.parkProviderAdditionalTaxRate = parkProviderAdditionalTaxRate;
        return this;
    }

    public BigDecimal getParkProviderWaterTaxRate() {
        return parkProviderWaterTaxRate;
    }

    public ParkEnterpriseDO setParkProviderWaterTaxRate(BigDecimal parkProviderWaterTaxRate) {
        this.parkProviderWaterTaxRate = parkProviderWaterTaxRate;
        return this;
    }

    public BigDecimal getParkProviderStampTaxRate() {
        return parkProviderStampTaxRate;
    }

    public ParkEnterpriseDO setParkProviderStampTaxRate(BigDecimal parkProviderStampTaxRate) {
        this.parkProviderStampTaxRate = parkProviderStampTaxRate;
        return this;
    }

    public BigDecimal getParkProviderIncomeTaxRate() {
        return parkProviderIncomeTaxRate;
    }

    public ParkEnterpriseDO setParkProviderIncomeTaxRate(BigDecimal parkProviderIncomeTaxRate) {
        this.parkProviderIncomeTaxRate = parkProviderIncomeTaxRate;
        return this;
    }

    public BigDecimal getParkProviderServiceFeeRate() {
        return parkProviderServiceFeeRate;
    }

    public ParkEnterpriseDO setParkProviderServiceFeeRate(BigDecimal parkProviderServiceFeeRate) {
        this.parkProviderServiceFeeRate = parkProviderServiceFeeRate;
        return this;
    }

    public BigDecimal getDistributorServiceFeeRate() {
        return distributorServiceFeeRate;
    }

    public ParkEnterpriseDO setDistributorServiceFeeRate(BigDecimal distributorServiceFeeRate) {
        this.distributorServiceFeeRate = distributorServiceFeeRate;
        return this;
    }

    public BigDecimal getParkProviderValueAddedTaxRate() {
        return parkProviderValueAddedTaxRate;
    }

    public ParkEnterpriseDO setParkProviderValueAddedTaxRate(BigDecimal parkProviderValueAddedTaxRate) {
        this.parkProviderValueAddedTaxRate = parkProviderValueAddedTaxRate;
        return this;
    }

    public BigDecimal getIncludeTaxRate() {
        return includeTaxRate;
    }

    public ParkEnterpriseDO setIncludeTaxRate(BigDecimal includeTaxRate) {
        this.includeTaxRate = includeTaxRate;
        return this;
    }

    @Override
    public String toString() {
        return "ParkEnterpriseDO{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", enterpriseId=" + enterpriseId +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", serviceFeeRate=" + serviceFeeRate +
                ", serviceFeePayerId=" + serviceFeePayerId +
                ", customerId=" + customerId +
                ", customerManager='" + customerManager + '\'' +
                ", parkProviderId=" + parkProviderId +
                ", parkProviderAdditionalTaxRate=" + parkProviderAdditionalTaxRate +
                ", parkProviderWaterTaxRate=" + parkProviderWaterTaxRate +
                ", parkProviderStampTaxRate=" + parkProviderStampTaxRate +
                ", parkProviderIncomeTaxRate=" + parkProviderIncomeTaxRate +
                ", parkProviderServiceFeeRate=" + parkProviderServiceFeeRate +
                ", distributorId=" + distributorId +
                ", distributorServiceFeeRate=" + distributorServiceFeeRate +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}