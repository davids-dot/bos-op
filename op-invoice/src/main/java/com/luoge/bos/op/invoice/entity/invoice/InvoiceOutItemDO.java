package com.luoge.bos.op.invoice.entity.invoice;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceOutItemDO {
    private Long id;
    private Integer orgId;
    private Integer enterpriseId;
    private Long invoiceId;
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

    public InvoiceOutItemDO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public InvoiceOutItemDO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public InvoiceOutItemDO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public InvoiceOutItemDO setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
        return this;
    }

    public Integer getRowNo() {
        return rowNo;
    }

    public InvoiceOutItemDO setRowNo(Integer rowNo) {
        this.rowNo = rowNo;
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public InvoiceOutItemDO setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getName() {
        return name;
    }

    public InvoiceOutItemDO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSpec() {
        return spec;
    }

    public InvoiceOutItemDO setSpec(String spec) {
        this.spec = spec;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public InvoiceOutItemDO setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public InvoiceOutItemDO setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public InvoiceOutItemDO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public InvoiceOutItemDO setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public InvoiceOutItemDO setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
        return this;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public InvoiceOutItemDO setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public InvoiceOutItemDO setTaxCode(String taxCode) {
        this.taxCode = taxCode;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public InvoiceOutItemDO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getSpecialType() {
        return specialType;
    }

    public InvoiceOutItemDO setSpecialType(String specialType) {
        this.specialType = specialType;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public InvoiceOutItemDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public BigDecimal getIncludeTaxAmount() {
        return includeTaxAmount;
    }

    public InvoiceOutItemDO setIncludeTaxAmount(BigDecimal includeTaxAmount) {
        this.includeTaxAmount = includeTaxAmount;
        return this;
    }

    public BigDecimal getIncludeTaxPrice() {
        return includeTaxPrice;
    }

    public InvoiceOutItemDO setIncludeTaxPrice(BigDecimal includeTaxPrice) {
        this.includeTaxPrice = includeTaxPrice;
        return this;
    }
}