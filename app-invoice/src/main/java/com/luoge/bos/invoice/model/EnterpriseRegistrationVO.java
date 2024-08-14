package com.luoge.bos.invoice.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;

public class EnterpriseRegistrationVO {
    /**
     * 注册单的id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 真实企业名称
     */
    private String enterpriseName;
    /**
     * 付款金额
     */
    private BigDecimal paymentAmount;

    /**
     * 园区服务商名称
     */
    private String parkProviderName;

    /**
     * 行业id
     */
    private Integer industryId;
    /**
     * 行业名称
     */
    private String industryName;

    /**
     * 注册单状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Long createTime;

    public Long getId() {
        return id;
    }

    public EnterpriseRegistrationVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public EnterpriseRegistrationVO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public EnterpriseRegistrationVO setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public EnterpriseRegistrationVO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public Integer getIndustryId() {
        return industryId;
    }

    public EnterpriseRegistrationVO setIndustryId(Integer industryId) {
        this.industryId = industryId;
        return this;
    }

    public String getIndustryName() {
        return industryName;
    }

    public EnterpriseRegistrationVO setIndustryName(String industryName) {
        this.industryName = industryName;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public EnterpriseRegistrationVO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public EnterpriseRegistrationVO setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }
}
