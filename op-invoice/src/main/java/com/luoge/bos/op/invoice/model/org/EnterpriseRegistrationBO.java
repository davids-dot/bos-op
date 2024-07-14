package com.luoge.bos.op.invoice.model.org;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;

public class EnterpriseRegistrationBO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 园区服务商
     */
    private String parkProviderName;
    /**
     * 法人
     */
    private String corporateName;
    /**
     * 手机号
     */
    private String corporatePhone;
    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 应付金额
     */
    private BigDecimal paymentAmount;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 提交时间
     */
    private Long createTime;

    public Long getId() {
        return id;
    }

    public EnterpriseRegistrationBO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public EnterpriseRegistrationBO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public EnterpriseRegistrationBO setCorporateName(String corporateName) {
        this.corporateName = corporateName;
        return this;
    }

    public String getCorporatePhone() {
        return corporatePhone;
    }


    public EnterpriseRegistrationBO setCorporatePhone(String corporatePhone) {
        this.corporatePhone = corporatePhone;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public EnterpriseRegistrationBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public EnterpriseRegistrationBO setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public EnterpriseRegistrationBO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public EnterpriseRegistrationBO setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }
}
