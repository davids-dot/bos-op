package com.luoge.bos.invoice.model.apply;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceApplyBO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 服务费率
     */
    private BigDecimal serviceFeeRate;
    /**
     * 园区服务商id
     */
    private Integer parkProviderId;
    /**
     * 园区服务商名称
     */
    private String parkProviderName;
    /**
     * 开票金额
     */
    private BigDecimal total;
    /**
     * 应收服务费
     */
    private BigDecimal serviceFee;
    /**
     * 审核状态
     */
    private Integer status;
    /**
     * 提交时间
     */
    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public InvoiceApplyBO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public InvoiceApplyBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public InvoiceApplyBO setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public InvoiceApplyBO setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public InvoiceApplyBO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public InvoiceApplyBO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public BigDecimal getServiceFeeRate() {
        return serviceFeeRate;
    }

    public InvoiceApplyBO setServiceFeeRate(BigDecimal serviceFeeRate) {
        this.serviceFeeRate = serviceFeeRate;
        return this;
    }

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public InvoiceApplyBO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public InvoiceApplyBO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }
}