package com.luoge.bos.invoice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkEnterpriseReportDO {
    private Long id;

    private Integer orgId;

    private Integer enterpriseId;

    private String enterpriseName;

    private String month;

    private BigDecimal invoiceTotalAmount;

    private BigDecimal serviceFee;

    private String customer;

    private String customerManager;

    private Integer parkProviderId;

    private String parkProviderName;

    private BigDecimal parkProviderAmount;

    private BigDecimal parkProviderFee;

    private BigDecimal parkProviderTotalTax;

    private Integer parkEnterpriseDistributorId;

    private String parkEnterpriseDistributorName;

    private BigDecimal parkEnterpriseDistributorFee;

    private BigDecimal parkProviderValueAddedTax;

    private BigDecimal parkProviderAdditionalTax;

    private BigDecimal parkProviderWaterTax;

    private BigDecimal parkProviderStampTax;

    private BigDecimal parkProviderIncomeTax;

    private BigDecimal invoiceTotalTax;

    private BigDecimal invoiceTotal;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public ParkEnterpriseReportDO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public ParkEnterpriseReportDO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public ParkEnterpriseReportDO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public ParkEnterpriseReportDO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public ParkEnterpriseReportDO setMonth(String month) {
        this.month = month;
        return this;
    }

    public BigDecimal getInvoiceTotalAmount() {
        return invoiceTotalAmount;
    }

    public ParkEnterpriseReportDO setInvoiceTotalAmount(BigDecimal invoiceTotalAmount) {
        this.invoiceTotalAmount = invoiceTotalAmount;
        return this;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public ParkEnterpriseReportDO setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public ParkEnterpriseReportDO setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getCustomerManager() {
        return customerManager;
    }

    public ParkEnterpriseReportDO setCustomerManager(String customerManager) {
        this.customerManager = customerManager;
        return this;
    }

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public ParkEnterpriseReportDO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public ParkEnterpriseReportDO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public BigDecimal getParkProviderAmount() {
        return parkProviderAmount;
    }

    public ParkEnterpriseReportDO setParkProviderAmount(BigDecimal parkProviderAmount) {
        this.parkProviderAmount = parkProviderAmount;
        return this;
    }

    public BigDecimal getParkProviderFee() {
        return parkProviderFee;
    }

    public ParkEnterpriseReportDO setParkProviderFee(BigDecimal parkProviderFee) {
        this.parkProviderFee = parkProviderFee;
        return this;
    }

    public BigDecimal getParkProviderTotalTax() {
        return parkProviderTotalTax;
    }

    public ParkEnterpriseReportDO setParkProviderTotalTax(BigDecimal parkProviderTotalTax) {
        this.parkProviderTotalTax = parkProviderTotalTax;
        return this;
    }

    public Integer getParkEnterpriseDistributorId() {
        return parkEnterpriseDistributorId;
    }

    public ParkEnterpriseReportDO setParkEnterpriseDistributorId(Integer parkEnterpriseDistributorId) {
        this.parkEnterpriseDistributorId = parkEnterpriseDistributorId;
        return this;
    }

    public String getParkEnterpriseDistributorName() {
        return parkEnterpriseDistributorName;
    }

    public ParkEnterpriseReportDO setParkEnterpriseDistributorName(String parkEnterpriseDistributorName) {
        this.parkEnterpriseDistributorName = parkEnterpriseDistributorName;
        return this;
    }

    public BigDecimal getParkEnterpriseDistributorFee() {
        return parkEnterpriseDistributorFee;
    }

    public ParkEnterpriseReportDO setParkEnterpriseDistributorFee(BigDecimal parkEnterpriseDistributorFee) {
        this.parkEnterpriseDistributorFee = parkEnterpriseDistributorFee;
        return this;
    }

    public BigDecimal getParkProviderValueAddedTax() {
        return parkProviderValueAddedTax;
    }

    public ParkEnterpriseReportDO setParkProviderValueAddedTax(BigDecimal parkProviderValueAddedTax) {
        this.parkProviderValueAddedTax = parkProviderValueAddedTax;
        return this;
    }

    public BigDecimal getParkProviderAdditionalTax() {
        return parkProviderAdditionalTax;
    }

    public ParkEnterpriseReportDO setParkProviderAdditionalTax(BigDecimal parkProviderAdditionalTax) {
        this.parkProviderAdditionalTax = parkProviderAdditionalTax;
        return this;
    }

    public BigDecimal getParkProviderWaterTax() {
        return parkProviderWaterTax;
    }

    public ParkEnterpriseReportDO setParkProviderWaterTax(BigDecimal parkProviderWaterTax) {
        this.parkProviderWaterTax = parkProviderWaterTax;
        return this;
    }

    public BigDecimal getParkProviderStampTax() {
        return parkProviderStampTax;
    }

    public ParkEnterpriseReportDO setParkProviderStampTax(BigDecimal parkProviderStampTax) {
        this.parkProviderStampTax = parkProviderStampTax;
        return this;
    }

    public BigDecimal getParkProviderIncomeTax() {
        return parkProviderIncomeTax;
    }

    public ParkEnterpriseReportDO setParkProviderIncomeTax(BigDecimal parkProviderIncomeTax) {
        this.parkProviderIncomeTax = parkProviderIncomeTax;
        return this;
    }

    public BigDecimal getInvoiceTotalTax() {
        return invoiceTotalTax;
    }

    public ParkEnterpriseReportDO setInvoiceTotalTax(BigDecimal invoiceTotalTax) {
        this.invoiceTotalTax = invoiceTotalTax;
        return this;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public ParkEnterpriseReportDO setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ParkEnterpriseReportDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public ParkEnterpriseReportDO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}