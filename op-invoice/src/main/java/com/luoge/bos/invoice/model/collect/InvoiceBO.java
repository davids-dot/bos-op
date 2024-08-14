package com.luoge.bos.invoice.model.collect;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.luoge.bos.core.serialize.BigDecimalSerializer;
import com.luoge.bos.core.serialize.LocalDateTimeSerializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceBO {
    private String id;

    private Integer orgId;

    private Integer enterpriseId;

    private Integer type;

    private String invoiceNo;

    private String invoiceCode;

    private String buyerName;

    private String parkProviderName;

    private String enterpriseName;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal totalAmount;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal totalTax;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal total;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal serviceFeeRate;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal serviceFee;
    /**
     * 应付服务商金额
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal parkProviderAmount;
    /**
     * 应付渠道商金额
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal distributorFee;
    /**
     * 应归属收入
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal income;
    private Integer sourceType;

    @ExcelProperty("开票时间")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime issueTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    public String getId() {
        return id;
    }

    public InvoiceBO setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public InvoiceBO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public InvoiceBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public InvoiceBO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public InvoiceBO setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
        return this;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public InvoiceBO setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
        return this;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public InvoiceBO setBuyerName(String buyerName) {
        this.buyerName = buyerName;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public InvoiceBO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public InvoiceBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public LocalDateTime getIssueTime() {
        return issueTime;
    }

    public InvoiceBO setIssueTime(LocalDateTime issueTime) {
        this.issueTime = issueTime;
        return this;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public InvoiceBO setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public InvoiceBO setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public InvoiceBO setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public BigDecimal getServiceFeeRate() {
        return serviceFeeRate;
    }

    public InvoiceBO setServiceFeeRate(BigDecimal serviceFeeRate) {
        this.serviceFeeRate = serviceFeeRate;
        return this;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public InvoiceBO setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public BigDecimal getParkProviderAmount() {
        return parkProviderAmount;
    }

    public InvoiceBO setParkProviderAmount(BigDecimal parkProviderAmount) {
        this.parkProviderAmount = parkProviderAmount;
        return this;
    }

    public BigDecimal getDistributorFee() {
        return distributorFee;
    }

    public InvoiceBO setDistributorFee(BigDecimal distributorFee) {
        this.distributorFee = distributorFee;
        return this;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public InvoiceBO setIncome(BigDecimal income) {
        this.income = income;
        return this;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public InvoiceBO setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public InvoiceBO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
}
