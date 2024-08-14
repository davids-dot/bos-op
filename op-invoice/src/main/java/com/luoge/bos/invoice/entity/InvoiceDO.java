package com.luoge.bos.invoice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceDO {
    private Long id;

    private Integer orgId;

    private Integer enterpriseId;

    private Integer type;

    private Integer category;

    private String invoiceNo;

    private String invoiceCode;

    private String buyerName;

    private LocalDateTime issueTime;

    private BigDecimal totalAmount;

    private BigDecimal totalTax;

    private BigDecimal total;

    private BigDecimal serviceFeeRate;

    private BigDecimal serviceFee;

    private Integer sourceType;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private BigDecimal income;
    private Integer parkProviderId;
    private String parkProviderName;
    private BigDecimal parkProviderAmount;
    private BigDecimal parkProviderFee;
    private BigDecimal parkProviderTotalTax;
    private BigDecimal parkProviderValueAddedTax;
    private BigDecimal parkProviderAdditionalTax;
    private BigDecimal parkProviderWaterTax;
    private BigDecimal parkProviderStampTax;
    private BigDecimal parkProviderIncomeTax;
    private Integer parkEnterpriseDistributorId;
    private String parkEnterpriseDistributorName;
    private BigDecimal parkEnterpriseDistributorFee;

    private Integer parkEnterpriseId;
    private String parkEnterpriseName;
    private BigDecimal invoiceTaxRate;
    private String businessId;
    public Long getId() {
        return id;
    }

    public InvoiceDO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public InvoiceDO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public InvoiceDO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public InvoiceDO setType(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getCategory() {
        return category;
    }

    public InvoiceDO setCategory(Integer category) {
        this.category = category;
        return this;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public InvoiceDO setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
        return this;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public InvoiceDO setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
        return this;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public InvoiceDO setBuyerName(String buyerName) {
        this.buyerName = buyerName;
        return this;
    }

    public LocalDateTime getIssueTime() {
        return issueTime;
    }

    public InvoiceDO setIssueTime(LocalDateTime issueTime) {
        this.issueTime = issueTime;
        return this;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public InvoiceDO setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public InvoiceDO setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public InvoiceDO setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public BigDecimal getServiceFeeRate() {
        return serviceFeeRate;
    }

    public InvoiceDO setServiceFeeRate(BigDecimal serviceFeeRate) {
        this.serviceFeeRate = serviceFeeRate;
        return this;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public InvoiceDO setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public InvoiceDO setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public InvoiceDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public InvoiceDO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public InvoiceDO setIncome(BigDecimal income) {
        this.income = income;
        return this;
    }

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public InvoiceDO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public InvoiceDO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public BigDecimal getParkProviderAmount() {
        return parkProviderAmount;
    }

    public InvoiceDO setParkProviderAmount(BigDecimal parkProviderAmount) {
        this.parkProviderAmount = parkProviderAmount;
        return this;
    }

    public BigDecimal getParkProviderFee() {
        return parkProviderFee;
    }

    public InvoiceDO setParkProviderFee(BigDecimal parkProviderFee) {
        this.parkProviderFee = parkProviderFee;
        return this;
    }

    public BigDecimal getParkProviderTotalTax() {
        return parkProviderTotalTax;
    }

    public InvoiceDO setParkProviderTotalTax(BigDecimal parkProviderTotalTax) {
        this.parkProviderTotalTax = parkProviderTotalTax;
        return this;
    }

    public BigDecimal getParkProviderValueAddedTax() {
        return parkProviderValueAddedTax;
    }

    public InvoiceDO setParkProviderValueAddedTax(BigDecimal parkProviderValueAddedTax) {
        this.parkProviderValueAddedTax = parkProviderValueAddedTax;
        return this;
    }

    public BigDecimal getParkProviderAdditionalTax() {
        return parkProviderAdditionalTax;
    }

    public InvoiceDO setParkProviderAdditionalTax(BigDecimal parkProviderAdditionalTax) {
        this.parkProviderAdditionalTax = parkProviderAdditionalTax;
        return this;
    }

    public BigDecimal getParkProviderWaterTax() {
        return parkProviderWaterTax;
    }

    public InvoiceDO setParkProviderWaterTax(BigDecimal parkProviderWaterTax) {
        this.parkProviderWaterTax = parkProviderWaterTax;
        return this;
    }

    public BigDecimal getParkProviderStampTax() {
        return parkProviderStampTax;
    }

    public InvoiceDO setParkProviderStampTax(BigDecimal parkProviderStampTax) {
        this.parkProviderStampTax = parkProviderStampTax;
        return this;
    }

    public BigDecimal getParkProviderIncomeTax() {
        return parkProviderIncomeTax;
    }

    public InvoiceDO setParkProviderIncomeTax(BigDecimal parkProviderIncomeTax) {
        this.parkProviderIncomeTax = parkProviderIncomeTax;
        return this;
    }

    public Integer getParkEnterpriseDistributorId() {
        return parkEnterpriseDistributorId;
    }

    public InvoiceDO setParkEnterpriseDistributorId(Integer parkEnterpriseDistributorId) {
        this.parkEnterpriseDistributorId = parkEnterpriseDistributorId;
        return this;
    }

    public String getParkEnterpriseDistributorName() {
        return parkEnterpriseDistributorName;
    }

    public InvoiceDO setParkEnterpriseDistributorName(String parkEnterpriseDistributorName) {
        this.parkEnterpriseDistributorName = parkEnterpriseDistributorName;
        return this;
    }

    public BigDecimal getParkEnterpriseDistributorFee() {
        return parkEnterpriseDistributorFee;
    }

    public InvoiceDO setParkEnterpriseDistributorFee(BigDecimal parkEnterpriseDistributorFee) {
        this.parkEnterpriseDistributorFee = parkEnterpriseDistributorFee;
        return this;
    }

    public Integer getParkEnterpriseId() {
        return parkEnterpriseId;
    }

    public InvoiceDO setParkEnterpriseId(Integer parkEnterpriseId) {
        this.parkEnterpriseId = parkEnterpriseId;
        return this;
    }

    public String getParkEnterpriseName() {
        return parkEnterpriseName;
    }

    public InvoiceDO setParkEnterpriseName(String parkEnterpriseName) {
        this.parkEnterpriseName = parkEnterpriseName;
        return this;
    }

    public BigDecimal getInvoiceTaxRate() {
        return invoiceTaxRate;
    }

    public InvoiceDO setInvoiceTaxRate(BigDecimal invoiceTaxRate) {
        this.invoiceTaxRate = invoiceTaxRate;
        return this;
    }

    public String getBusinessId() {
        return businessId;
    }

    public InvoiceDO setBusinessId(String businessId) {
        this.businessId = businessId;
        return this;
    }
}