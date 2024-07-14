package com.luoge.bos.op.invoice.model.park.provider;

import java.math.BigDecimal;

public class ParkProviderDetailBO {
    private Integer id;

    private String name;

    private String remark;

    private Integer status;

    private String accountName;

    private String accountOpenBank;

    private String accountBank;

    private String accountNo;

    private BigDecimal serviceFeeRate;

    private Integer valueAddedTaxType;

    private BigDecimal additionalTaxRate;

    private BigDecimal waterTaxRate;

    private BigDecimal stampTaxRate;

    private BigDecimal incomeTaxRate;

    private Integer incomeTaxType;
    /**
     * 应收工商注册费
     */
    private BigDecimal registrationFee;
    /**
     * 应付园区服务商注册费
     */
    private BigDecimal parkProviderRegistrationFee;
    /**
     * 移动端是否可见（勾选后移动端可查到该数据）
     */
    private Boolean isMiniAppShow = false;

    private Integer valueAddedTaxFormulaId;

    private Integer additionalTaxFormulaId;

    private Integer waterTaxFormulaId;

    private Integer stampTaxFormulaId;

    private Integer incomeTaxFormulaId;

    private BigDecimal valueAddedTaxRate;

    private Integer isIncludeTax;

    private BigDecimal includeTaxRate;
    private Long createTime;
    private Long updateTime;

    public Integer getId() {
        return id;
    }

    public ParkProviderDetailBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ParkProviderDetailBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public ParkProviderDetailBO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ParkProviderDetailBO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public ParkProviderDetailBO setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public String getAccountOpenBank() {
        return accountOpenBank;
    }

    public ParkProviderDetailBO setAccountOpenBank(String accountOpenBank) {
        this.accountOpenBank = accountOpenBank;
        return this;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public ParkProviderDetailBO setAccountBank(String accountBank) {
        this.accountBank = accountBank;
        return this;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public ParkProviderDetailBO setAccountNo(String accountNo) {
        this.accountNo = accountNo;
        return this;
    }

    public BigDecimal getServiceFeeRate() {
        return serviceFeeRate;
    }

    public ParkProviderDetailBO setServiceFeeRate(BigDecimal serviceFeeRate) {
        this.serviceFeeRate = serviceFeeRate;
        return this;
    }

    public Integer getValueAddedTaxType() {
        return valueAddedTaxType;
    }

    public ParkProviderDetailBO setValueAddedTaxType(Integer valueAddedTaxType) {
        this.valueAddedTaxType = valueAddedTaxType;
        return this;
    }

    public BigDecimal getAdditionalTaxRate() {
        return additionalTaxRate;
    }

    public ParkProviderDetailBO setAdditionalTaxRate(BigDecimal additionalTaxRate) {
        this.additionalTaxRate = additionalTaxRate;
        return this;
    }

    public BigDecimal getWaterTaxRate() {
        return waterTaxRate;
    }

    public ParkProviderDetailBO setWaterTaxRate(BigDecimal waterTaxRate) {
        this.waterTaxRate = waterTaxRate;
        return this;
    }

    public BigDecimal getStampTaxRate() {
        return stampTaxRate;
    }

    public ParkProviderDetailBO setStampTaxRate(BigDecimal stampTaxRate) {
        this.stampTaxRate = stampTaxRate;
        return this;
    }

    public BigDecimal getIncomeTaxRate() {
        return incomeTaxRate;
    }

    public ParkProviderDetailBO setIncomeTaxRate(BigDecimal incomeTaxRate) {
        this.incomeTaxRate = incomeTaxRate;
        return this;
    }

    public Integer getIncomeTaxType() {
        return incomeTaxType;
    }

    public ParkProviderDetailBO setIncomeTaxType(Integer incomeTaxType) {
        this.incomeTaxType = incomeTaxType;
        return this;
    }

    public BigDecimal getRegistrationFee() {
        return registrationFee;
    }

    public ParkProviderDetailBO setRegistrationFee(BigDecimal registrationFee) {
        this.registrationFee = registrationFee;
        return this;
    }

    public BigDecimal getParkProviderRegistrationFee() {
        return parkProviderRegistrationFee;
    }

    public ParkProviderDetailBO setParkProviderRegistrationFee(BigDecimal parkProviderRegistrationFee) {
        this.parkProviderRegistrationFee = parkProviderRegistrationFee;
        return this;
    }

    public Boolean getMiniAppShow() {
        return isMiniAppShow;
    }

    public ParkProviderDetailBO setMiniAppShow(Boolean miniAppShow) {
        isMiniAppShow = miniAppShow;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public ParkProviderDetailBO setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public ParkProviderDetailBO setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public BigDecimal getValueAddedTaxRate() {
        return valueAddedTaxRate;
    }

    public ParkProviderDetailBO setValueAddedTaxRate(BigDecimal valueAddedTaxRate) {
        this.valueAddedTaxRate = valueAddedTaxRate;
        return this;
    }

    public Integer getValueAddedTaxFormulaId() {
        return valueAddedTaxFormulaId;
    }

    public ParkProviderDetailBO setValueAddedTaxFormulaId(Integer valueAddedTaxFormulaId) {
        this.valueAddedTaxFormulaId = valueAddedTaxFormulaId;
        return this;
    }

    public Integer getAdditionalTaxFormulaId() {
        return additionalTaxFormulaId;
    }

    public ParkProviderDetailBO setAdditionalTaxFormulaId(Integer additionalTaxFormulaId) {
        this.additionalTaxFormulaId = additionalTaxFormulaId;
        return this;
    }

    public Integer getWaterTaxFormulaId() {
        return waterTaxFormulaId;
    }

    public ParkProviderDetailBO setWaterTaxFormulaId(Integer waterTaxFormulaId) {
        this.waterTaxFormulaId = waterTaxFormulaId;
        return this;
    }

    public Integer getStampTaxFormulaId() {
        return stampTaxFormulaId;
    }

    public ParkProviderDetailBO setStampTaxFormulaId(Integer stampTaxFormulaId) {
        this.stampTaxFormulaId = stampTaxFormulaId;
        return this;
    }

    public Integer getIncomeTaxFormulaId() {
        return incomeTaxFormulaId;
    }

    public ParkProviderDetailBO setIncomeTaxFormulaId(Integer incomeTaxFormulaId) {
        this.incomeTaxFormulaId = incomeTaxFormulaId;
        return this;
    }

    public Integer getIsIncludeTax() {
        return isIncludeTax;
    }

    public ParkProviderDetailBO setIsIncludeTax(Integer isIncludeTax) {
        this.isIncludeTax = isIncludeTax;
        return this;
    }

    public BigDecimal getIncludeTaxRate() {
        return includeTaxRate;
    }

    public ParkProviderDetailBO setIncludeTaxRate(BigDecimal includeTaxRate) {
        this.includeTaxRate = includeTaxRate;
        return this;
    }
}
