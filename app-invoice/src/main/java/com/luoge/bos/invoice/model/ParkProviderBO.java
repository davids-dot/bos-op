package com.luoge.bos.invoice.model;

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
     * 工商注册服务费
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal registrationFee;
    /**
     * 创建时间
     */
    private Long createTime;

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

    public BigDecimal getRegistrationFee() {
        return registrationFee;
    }

    public ParkProviderBO setRegistrationFee(BigDecimal registrationFee) {
        this.registrationFee = registrationFee;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public ParkProviderBO setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }
}
