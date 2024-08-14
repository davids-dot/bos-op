package com.luoge.bos.invoice.model.park.enterprise;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.luoge.bos.core.serialize.BigDecimalSerializer;
import com.luoge.bos.core.serialize.LocalDateTimeSerializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkEnterpriseBO {
    /**
     * 企业id
     */
    private Integer id;
    /**
     * 企业名称
     */
    private String name;
    /**
     * 企业税号
     */
    private String taxNo;
    /**
     * 所属机构
     */
    private String orgName;
    /**
     * 服务费费率
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal feeRate;
    /**
     * 所属园区服务商
     */
    private String parkProviderName;
    /**
     * 所属渠道商
     */
    private String distributorName;
    /**
     * 添加时间
     */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;


    public Integer getId() {
        return id;
    }

    public ParkEnterpriseBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ParkEnterpriseBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public ParkEnterpriseBO setTaxNo(String taxNo) {
        this.taxNo = taxNo;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public ParkEnterpriseBO setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public ParkEnterpriseBO setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public ParkEnterpriseBO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public ParkEnterpriseBO setDistributorName(String distributorName) {
        this.distributorName = distributorName;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ParkEnterpriseBO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
}
