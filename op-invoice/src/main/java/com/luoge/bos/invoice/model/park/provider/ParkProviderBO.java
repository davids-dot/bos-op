package com.luoge.bos.invoice.model.park.provider;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.luoge.bos.core.serialize.BigDecimalSerializer;

import java.math.BigDecimal;

public class ParkProviderBO {
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String remark;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 服务费费率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal serviceFeeRate;
    /**
     * 附加税税率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal additionalTaxRate;
    /**
     * 水利基金税率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal waterTaxRate;
    /**
     * 印花税税率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal stampTaxRate;
    /**
     * 个人所得税税率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal incomeTaxRate;
    /**
     * 个人所得税类型
     */
    private Integer incomeTaxType;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 移动端是否可见
     */
    private Boolean isMiniAppShow;
    /**
     * 增值税是否免征  1 免征 2 不免征
     */
    private Integer valueAddedTaxType;
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
     * 个税计算公式
     */
    private Integer incomeTaxFormulaId;
    /**
     * 增值税税率
     */
    private BigDecimal valueAddedTaxRate;
    /**
     * 是否包税
     */
    private Integer isIncludeTax;
    /**
     * 包税税率
     */
    private BigDecimal includeTaxRate;

    public Integer getId() {
        return id;
    }

    public ParkProviderBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ParkProviderBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public ParkProviderBO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ParkProviderBO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public ParkProviderBO setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public BigDecimal getServiceFeeRate() {
        return serviceFeeRate;
    }

    public ParkProviderBO setServiceFeeRate(BigDecimal serviceFeeRate) {
        this.serviceFeeRate = serviceFeeRate;
        return this;
    }

    public BigDecimal getAdditionalTaxRate() {
        return additionalTaxRate;
    }

    public ParkProviderBO setAdditionalTaxRate(BigDecimal additionalTaxRate) {
        this.additionalTaxRate = additionalTaxRate;
        return this;
    }

    public BigDecimal getWaterTaxRate() {
        return waterTaxRate;
    }

    public ParkProviderBO setWaterTaxRate(BigDecimal waterTaxRate) {
        this.waterTaxRate = waterTaxRate;
        return this;
    }

    public BigDecimal getStampTaxRate() {
        return stampTaxRate;
    }

    public ParkProviderBO setStampTaxRate(BigDecimal stampTaxRate) {
        this.stampTaxRate = stampTaxRate;
        return this;
    }

    public BigDecimal getIncomeTaxRate() {
        return incomeTaxRate;
    }

    public ParkProviderBO setIncomeTaxRate(BigDecimal incomeTaxRate) {
        this.incomeTaxRate = incomeTaxRate;
        return this;
    }

    public Integer getIncomeTaxType() {
        return incomeTaxType;
    }

    public ParkProviderBO setIncomeTaxType(Integer incomeTaxType) {
        this.incomeTaxType = incomeTaxType;
        return this;
    }

    public Boolean getIsMiniAppShow() {
        return isMiniAppShow;
    }

    public ParkProviderBO setIsMiniAppShow(Boolean isMiniAppShow) {
        this.isMiniAppShow = isMiniAppShow;
        return this;
    }

    public Boolean getMiniAppShow() {
        return isMiniAppShow;
    }

    public ParkProviderBO setMiniAppShow(Boolean miniAppShow) {
        isMiniAppShow = miniAppShow;
        return this;
    }

    public Integer getValueAddedTaxType() {
        return valueAddedTaxType;
    }

    public ParkProviderBO setValueAddedTaxType(Integer valueAddedTaxType) {
        this.valueAddedTaxType = valueAddedTaxType;
        return this;
    }

    public Integer getValueAddedTaxFormulaId() {
        return valueAddedTaxFormulaId;
    }

    public ParkProviderBO setValueAddedTaxFormulaId(Integer valueAddedTaxFormulaId) {
        this.valueAddedTaxFormulaId = valueAddedTaxFormulaId;
        return this;
    }

    public Integer getAdditionalTaxFormulaId() {
        return additionalTaxFormulaId;
    }

    public ParkProviderBO setAdditionalTaxFormulaId(Integer additionalTaxFormulaId) {
        this.additionalTaxFormulaId = additionalTaxFormulaId;
        return this;
    }

    public Integer getWaterTaxFormulaId() {
        return waterTaxFormulaId;
    }

    public ParkProviderBO setWaterTaxFormulaId(Integer waterTaxFormulaId) {
        this.waterTaxFormulaId = waterTaxFormulaId;
        return this;
    }

    public Integer getStampTaxFormulaId() {
        return stampTaxFormulaId;
    }

    public ParkProviderBO setStampTaxFormulaId(Integer stampTaxFormulaId) {
        this.stampTaxFormulaId = stampTaxFormulaId;
        return this;
    }

    public Integer getIncomeTaxFormulaId() {
        return incomeTaxFormulaId;
    }

    public ParkProviderBO setIncomeTaxFormulaId(Integer incomeTaxFormulaId) {
        this.incomeTaxFormulaId = incomeTaxFormulaId;
        return this;
    }

    public BigDecimal getValueAddedTaxRate() {
        return valueAddedTaxRate;
    }

    public ParkProviderBO setValueAddedTaxRate(BigDecimal valueAddedTaxRate) {
        this.valueAddedTaxRate = valueAddedTaxRate;
        return this;
    }

    public Integer getIsIncludeTax() {
        return isIncludeTax;
    }

    public ParkProviderBO setIsIncludeTax(Integer isIncludeTax) {
        this.isIncludeTax = isIncludeTax;
        return this;
    }

    public BigDecimal getIncludeTaxRate() {
        return includeTaxRate;
    }

    public ParkProviderBO setIncludeTaxRate(BigDecimal includeTaxRate) {
        this.includeTaxRate = includeTaxRate;
        return this;
    }
}
