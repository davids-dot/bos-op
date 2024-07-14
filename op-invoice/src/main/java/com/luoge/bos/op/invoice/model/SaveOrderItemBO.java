package com.luoge.bos.op.invoice.model;


import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class SaveOrderItemBO {
    private int appId;
    @NotNull
    private int productId;
    private String productName;
    private int productUnit;
    @NotNull
    private Integer quantity;
    @NotNull
    private String originPrice;
    @NotNull
    private String finalPrice;
    private String tags;
    @NotNull
    private Integer validityUnit;
    @NotNull
    private Integer validityValue;

    public int getAppId() {
        return appId;
    }

    public SaveOrderItemBO setAppId(int appId) {
        this.appId = appId;
        return this;
    }

    public int getProductId() {
        return productId;
    }

    public SaveOrderItemBO setProductId(int productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public SaveOrderItemBO setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public int getProductUnit() {
        return productUnit;
    }

    public SaveOrderItemBO setProductUnit(int productUnit) {
        this.productUnit = productUnit;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public SaveOrderItemBO setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getOriginPrice() {
        return originPrice;
    }

    public SaveOrderItemBO setOriginPrice(String originPrice) {
        this.originPrice = originPrice;
        return this;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public SaveOrderItemBO setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
        return this;
    }

    public String getTags() {
        return tags;
    }

    public SaveOrderItemBO setTags(String tags) {
        this.tags = tags;
        return this;
    }

    public Integer getValidityUnit() {
        return validityUnit;
    }

    public SaveOrderItemBO setValidityUnit(Integer validityUnit) {
        this.validityUnit = validityUnit;
        return this;
    }

    public Integer getValidityValue() {
        return validityValue;
    }

    public SaveOrderItemBO setValidityValue(Integer validityValue) {
        this.validityValue = validityValue;
        return this;
    }
}
