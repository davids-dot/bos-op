package com.luoge.bos.invoice.model.park.distributor;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.luoge.bos.core.serialize.BigDecimalSerializer;

import java.math.BigDecimal;

public class ParkEnterpriseDistributorBO {
    private Integer id;
    private String name;
    private String remark;
    private Integer status;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal distributorFeeRate;
    private Long createTime;

    public Integer getId() {
        return id;
    }

    public ParkEnterpriseDistributorBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ParkEnterpriseDistributorBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public ParkEnterpriseDistributorBO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ParkEnterpriseDistributorBO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public BigDecimal getDistributorFeeRate() {
        return distributorFeeRate;
    }

    public ParkEnterpriseDistributorBO setDistributorFeeRate(BigDecimal distributorFeeRate) {
        this.distributorFeeRate = distributorFeeRate;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public ParkEnterpriseDistributorBO setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }
}
