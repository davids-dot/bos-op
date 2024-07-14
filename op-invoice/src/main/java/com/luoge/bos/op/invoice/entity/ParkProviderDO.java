package com.luoge.bos.op.invoice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkProviderDO {
    private Integer id;

    private String name;

    private String remark;

    private Integer status;

    private String accountName;

    private String accountOpenBank;

    private String accountBank;

    private String accountNo;

    private BigDecimal serviceFeeRate;

    private BigDecimal additionalTaxRate;

    private BigDecimal waterTaxRate;

    private BigDecimal stampTaxRate;

    private BigDecimal incomeTaxRate;

    private Integer incomeTaxType;

    private BigDecimal registrationFee;

    private BigDecimal parkProviderRegistrationFee;

    private Boolean isMiniAppShow;

    private Integer valueAddedTaxFormulaId;

    private Integer additionalTaxFormulaId;

    private Integer waterTaxFormulaId;

    private Integer stampTaxFormulaId;

    private Integer incomeTaxFormulaId;

    private BigDecimal valueAddedTaxRate;

    private Integer valueAddedTaxType;

    private Boolean isIncludeTax;

    private BigDecimal includeTaxRate;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public ParkProviderDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ParkProviderDO setName(String name) {
        this.name = name;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public ParkProviderDO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ParkProviderDO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public ParkProviderDO setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public String getAccountOpenBank() {
        return accountOpenBank;
    }

    public ParkProviderDO setAccountOpenBank(String accountOpenBank) {
        this.accountOpenBank = accountOpenBank;
        return this;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public ParkProviderDO setAccountBank(String accountBank) {
        this.accountBank = accountBank;
        return this;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public ParkProviderDO setAccountNo(String accountNo) {
        this.accountNo = accountNo;
        return this;
    }

    public BigDecimal getServiceFeeRate() {
        return serviceFeeRate;
    }

    public ParkProviderDO setServiceFeeRate(BigDecimal serviceFeeRate) {
        this.serviceFeeRate = serviceFeeRate;
        return this;
    }

    public BigDecimal getAdditionalTaxRate() {
        return additionalTaxRate;
    }

    public ParkProviderDO setAdditionalTaxRate(BigDecimal additionalTaxRate) {
        this.additionalTaxRate = additionalTaxRate;
        return this;
    }

    public BigDecimal getWaterTaxRate() {
        return waterTaxRate;
    }

    public ParkProviderDO setWaterTaxRate(BigDecimal waterTaxRate) {
        this.waterTaxRate = waterTaxRate;
        return this;
    }

    public BigDecimal getStampTaxRate() {
        return stampTaxRate;
    }

    public ParkProviderDO setStampTaxRate(BigDecimal stampTaxRate) {
        this.stampTaxRate = stampTaxRate;
        return this;
    }

    public BigDecimal getIncomeTaxRate() {
        return incomeTaxRate;
    }

    public ParkProviderDO setIncomeTaxRate(BigDecimal incomeTaxRate) {
        this.incomeTaxRate = incomeTaxRate;
        return this;
    }

    public Integer getIncomeTaxType() {
        return incomeTaxType;
    }

    public ParkProviderDO setIncomeTaxType(Integer incomeTaxType) {
        this.incomeTaxType = incomeTaxType;
        return this;
    }

    public BigDecimal getRegistrationFee() {
        return registrationFee;
    }

    public ParkProviderDO setRegistrationFee(BigDecimal registrationFee) {
        this.registrationFee = registrationFee;
        return this;
    }

    public BigDecimal getParkProviderRegistrationFee() {
        return parkProviderRegistrationFee;
    }

    public ParkProviderDO setParkProviderRegistrationFee(BigDecimal parkProviderRegistrationFee) {
        this.parkProviderRegistrationFee = parkProviderRegistrationFee;
        return this;
    }

    public Boolean getMiniAppShow() {
        return isMiniAppShow;
    }

    public ParkProviderDO setMiniAppShow(Boolean miniAppShow) {
        isMiniAppShow = miniAppShow;
        return this;
    }


    public Integer getValueAddedTaxType() {
        return valueAddedTaxType;
    }

    public ParkProviderDO setValueAddedTaxType(Integer valueAddedTaxType) {
        this.valueAddedTaxType = valueAddedTaxType;
        return this;
    }


    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ParkProviderDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public ParkProviderDO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public BigDecimal getValueAddedTaxRate() {
        return valueAddedTaxRate;
    }

    public ParkProviderDO setValueAddedTaxRate(BigDecimal valueAddedTaxRate) {
        this.valueAddedTaxRate = valueAddedTaxRate;
        return this;
    }

    public Integer getValueAddedTaxFormulaId() {
        return valueAddedTaxFormulaId;
    }

    public ParkProviderDO setValueAddedTaxFormulaId(Integer valueAddedTaxFormulaId) {
        this.valueAddedTaxFormulaId = valueAddedTaxFormulaId;
        return this;
    }

    public Integer getAdditionalTaxFormulaId() {
        return additionalTaxFormulaId;
    }

    public ParkProviderDO setAdditionalTaxFormulaId(Integer additionalTaxFormulaId) {
        this.additionalTaxFormulaId = additionalTaxFormulaId;
        return this;
    }

    public Integer getWaterTaxFormulaId() {
        return waterTaxFormulaId;
    }

    public ParkProviderDO setWaterTaxFormulaId(Integer waterTaxFormulaId) {
        this.waterTaxFormulaId = waterTaxFormulaId;
        return this;
    }

    public Integer getStampTaxFormulaId() {
        return stampTaxFormulaId;
    }

    public ParkProviderDO setStampTaxFormulaId(Integer stampTaxFormulaId) {
        this.stampTaxFormulaId = stampTaxFormulaId;
        return this;
    }

    public Integer getIncomeTaxFormulaId() {
        return incomeTaxFormulaId;
    }

    public ParkProviderDO setIncomeTaxFormulaId(Integer incomeTaxFormulaId) {
        this.incomeTaxFormulaId = incomeTaxFormulaId;
        return this;
    }

    public Boolean getIncludeTax() {
        return isIncludeTax;
    }

    public ParkProviderDO setIncludeTax(Boolean includeTax) {
        isIncludeTax = includeTax;
        return this;
    }

    public BigDecimal getIncludeTaxRate() {
        return includeTaxRate;
    }

    public ParkProviderDO setIncludeTaxRate(BigDecimal includeTaxRate) {
        this.includeTaxRate = includeTaxRate;
        return this;
    }

    @Override
    public String toString() {
        return "ParkProviderDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountName='" + accountName + '\'' +
                ", serviceFeeRate=" + serviceFeeRate +
                ", additionalTaxRate=" + additionalTaxRate +
                ", waterTaxRate=" + waterTaxRate +
                ", stampTaxRate=" + stampTaxRate +
                ", incomeTaxRate=" + incomeTaxRate +
                ", incomeTaxType=" + incomeTaxType +
                '}';
    }
}