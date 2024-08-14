package com.luoge.bos.invoice.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreateProductDataBO {
    private Integer id;
    @NotNull
    private Integer appId;
    /**
     * 商品名称
     */
    @NotEmpty
    private String name;
    /**
     * 商品标签
     */
    private String tags;
    /**
     * 商品单位
     *
     * @see com.luoge.ns.account.core.ProductUnit
     */
    @NotNull
    private Integer unit;
    /**
     * 商品原价
     */
    @NotNull
    private String originPrice;
    /**
     * 折扣价
     */
    private String discountPrice;
    /**
     * 商品描述
     */
    private String description;
    /**
     * 效期单位
     *
     * @see com.luoge.ns.account.core.ValidityUnit
     */
    @NotNull
    private Integer validityUnit;
    /**
     * 效期值
     */
    @NotNull
    private Integer validityValue;
    /**
     * 数据明细
     */
    private List<ProductDataListBO> dataList;
    /**
     * 权限明细
     */
    private List<ProductPermissionsBO> permissions;
    /**
     * 备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public CreateProductDataBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getAppId() {
        return appId;
    }

    public CreateProductDataBO setAppId(Integer appId) {
        this.appId = appId;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateProductDataBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getTags() {
        return tags;
    }

    public CreateProductDataBO setTags(String tags) {
        this.tags = tags;
        return this;
    }

    public Integer getUnit() {
        return unit;
    }

    public CreateProductDataBO setUnit(Integer unit) {
        this.unit = unit;
        return this;
    }

    public String getOriginPrice() {
        return originPrice;
    }

    public CreateProductDataBO setOriginPrice(String originPrice) {
        this.originPrice = originPrice;
        return this;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public CreateProductDataBO setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateProductDataBO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getValidityUnit() {
        return validityUnit;
    }

    public CreateProductDataBO setValidityUnit(Integer validityUnit) {
        this.validityUnit = validityUnit;
        return this;
    }

    public Integer getValidityValue() {
        return validityValue;
    }

    public CreateProductDataBO setValidityValue(Integer validityValue) {
        this.validityValue = validityValue;
        return this;
    }

    public List<ProductDataListBO> getDataList() {
        return dataList;
    }

    public CreateProductDataBO setDataList(List<ProductDataListBO> dataList) {
        this.dataList = dataList;
        return this;
    }

    public List<ProductPermissionsBO> getPermissions() {
        return permissions;
    }

    public CreateProductDataBO setPermissions(List<ProductPermissionsBO> permissions) {
        this.permissions = permissions;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public CreateProductDataBO setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
