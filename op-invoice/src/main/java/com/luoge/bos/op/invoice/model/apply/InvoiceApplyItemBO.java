package com.luoge.bos.op.invoice.model.apply;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.luoge.bos.op.core.serialize.BigDecimalSerializer;

import java.math.BigDecimal;

public class InvoiceApplyItemBO{
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     *项目名称
     */
    private String name;
    /**
     *规格型号
     */
    private String spec;
    /**
     *单位
     */
    private String unit;
    /**
     *数量
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal quantity;
    /**
     *单价
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal price;
    /**
     *金额
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal amount;
    /**
     *税率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal taxRate;
    /**
     *税额
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal tax;
    /**
     * 优惠政策及简易计税类型
     */
    private String specialType;

    public Long getId() {
        return id;
    }

    public InvoiceApplyItemBO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public InvoiceApplyItemBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSpec() {
        return spec;
    }

    public InvoiceApplyItemBO setSpec(String spec) {
        this.spec = spec;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public InvoiceApplyItemBO setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public InvoiceApplyItemBO setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public InvoiceApplyItemBO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public InvoiceApplyItemBO setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public InvoiceApplyItemBO setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
        return this;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public InvoiceApplyItemBO setTax(BigDecimal tax) {
        this.tax = tax;
        return this;
    }

    public String getSpecialType() {
        return specialType;
    }

    public InvoiceApplyItemBO setSpecialType(String specialType) {
        this.specialType = specialType;
        return this;
    }
}