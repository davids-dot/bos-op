package com.luoge.bos.op.invoice.entity.invoice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 发票明细
 */
public class InvoiceApplyItemDO implements Serializable {
    private Long id;

    private Integer orgId;

    private Integer enterpriseId;

    private Long applyId;

    private Integer rowNo;

    private Integer productId;

    private String name;

    private String spec;

    private String unit;

    private BigDecimal quantity;

    private BigDecimal price;

    private BigDecimal amount;

    private BigDecimal taxRate;

    private BigDecimal taxAmount;

    private BigDecimal includeTaxAmount;

    private BigDecimal includeTaxPrice;

    private String taxCode;

    private Integer type;

    private String specialType;

    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public InvoiceApplyItemDO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public InvoiceApplyItemDO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public InvoiceApplyItemDO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public Long getApplyId() {
        return applyId;
    }

    public InvoiceApplyItemDO setApplyId(Long applyId) {
        this.applyId = applyId;
        return this;
    }

    public Integer getRowNo() {
        return rowNo;
    }

    public InvoiceApplyItemDO setRowNo(Integer rowNo) {
        this.rowNo = rowNo;
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public InvoiceApplyItemDO setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getName() {
        return name;
    }

    public InvoiceApplyItemDO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSpec() {
        return spec;
    }

    public InvoiceApplyItemDO setSpec(String spec) {
        this.spec = spec;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public InvoiceApplyItemDO setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public InvoiceApplyItemDO setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public InvoiceApplyItemDO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public InvoiceApplyItemDO setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public InvoiceApplyItemDO setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
        return this;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public InvoiceApplyItemDO setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    public BigDecimal getIncludeTaxAmount() {
        return includeTaxAmount;
    }

    public InvoiceApplyItemDO setIncludeTaxAmount(BigDecimal includeTaxAmount) {
        this.includeTaxAmount = includeTaxAmount;
        return this;
    }

    public BigDecimal getIncludeTaxPrice() {
        return includeTaxPrice;
    }

    public InvoiceApplyItemDO setIncludeTaxPrice(BigDecimal includeTaxPrice) {
        this.includeTaxPrice = includeTaxPrice;
        return this;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public InvoiceApplyItemDO setTaxCode(String taxCode) {
        this.taxCode = taxCode;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public InvoiceApplyItemDO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getSpecialType() {
        return specialType;
    }

    public InvoiceApplyItemDO setSpecialType(String specialType) {
        this.specialType = specialType;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public InvoiceApplyItemDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
}