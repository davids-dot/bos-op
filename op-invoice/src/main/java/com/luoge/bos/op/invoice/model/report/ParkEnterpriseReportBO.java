package com.luoge.bos.op.invoice.model.report;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkEnterpriseReportBO {
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
    /**
     * 总 专票税额
     */
    private BigDecimal invoiceSpecialTax;
    /**
     * 总 普票税额
     */
    private BigDecimal invoiceNormalTax;

    private BigDecimal invoiceTotal;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 配置公式-累计税额
     */
    private BigDecimal virtualInvoiceTotalTax;
    /**
     * 配置公式-累计专票税额
     */
    private BigDecimal virtualInvoiceSpecialTax;
    /**
     * 配置公式-累计普票税额
     */
    private BigDecimal virtualInvoiceNormalTax;

    public Long getId() {
        return id;
    }

    public ParkEnterpriseReportBO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public ParkEnterpriseReportBO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public ParkEnterpriseReportBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public ParkEnterpriseReportBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public ParkEnterpriseReportBO setMonth(String month) {
        this.month = month;
        return this;
    }

    public BigDecimal getInvoiceTotalAmount() {
        return invoiceTotalAmount;
    }

    public ParkEnterpriseReportBO setInvoiceTotalAmount(BigDecimal invoiceTotalAmount) {
        this.invoiceTotalAmount = invoiceTotalAmount;
        return this;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public ParkEnterpriseReportBO setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public ParkEnterpriseReportBO setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getCustomerManager() {
        return customerManager;
    }

    public ParkEnterpriseReportBO setCustomerManager(String customerManager) {
        this.customerManager = customerManager;
        return this;
    }

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public ParkEnterpriseReportBO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public ParkEnterpriseReportBO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public BigDecimal getParkProviderAmount() {
        return parkProviderAmount;
    }

    public ParkEnterpriseReportBO setParkProviderAmount(BigDecimal parkProviderAmount) {
        this.parkProviderAmount = parkProviderAmount;
        return this;
    }

    public BigDecimal getParkProviderFee() {
        return parkProviderFee;
    }

    public ParkEnterpriseReportBO setParkProviderFee(BigDecimal parkProviderFee) {
        this.parkProviderFee = parkProviderFee;
        return this;
    }

    public BigDecimal getParkProviderTotalTax() {
        return parkProviderTotalTax;
    }

    public ParkEnterpriseReportBO setParkProviderTotalTax(BigDecimal parkProviderTotalTax) {
        this.parkProviderTotalTax = parkProviderTotalTax;
        return this;
    }

    public Integer getParkEnterpriseDistributorId() {
        return parkEnterpriseDistributorId;
    }

    public ParkEnterpriseReportBO setParkEnterpriseDistributorId(Integer parkEnterpriseDistributorId) {
        this.parkEnterpriseDistributorId = parkEnterpriseDistributorId;
        return this;
    }

    public String getParkEnterpriseDistributorName() {
        return parkEnterpriseDistributorName;
    }

    public ParkEnterpriseReportBO setParkEnterpriseDistributorName(String parkEnterpriseDistributorName) {
        this.parkEnterpriseDistributorName = parkEnterpriseDistributorName;
        return this;
    }

    public BigDecimal getParkEnterpriseDistributorFee() {
        return parkEnterpriseDistributorFee;
    }

    public ParkEnterpriseReportBO setParkEnterpriseDistributorFee(BigDecimal parkEnterpriseDistributorFee) {
        this.parkEnterpriseDistributorFee = parkEnterpriseDistributorFee;
        return this;
    }

    public BigDecimal getParkProviderValueAddedTax() {
        return parkProviderValueAddedTax;
    }

    public ParkEnterpriseReportBO setParkProviderValueAddedTax(BigDecimal parkProviderValueAddedTax) {
        this.parkProviderValueAddedTax = parkProviderValueAddedTax;
        return this;
    }

    public BigDecimal getParkProviderAdditionalTax() {
        return parkProviderAdditionalTax;
    }

    public ParkEnterpriseReportBO setParkProviderAdditionalTax(BigDecimal parkProviderAdditionalTax) {
        this.parkProviderAdditionalTax = parkProviderAdditionalTax;
        return this;
    }

    public BigDecimal getParkProviderWaterTax() {
        return parkProviderWaterTax;
    }

    public ParkEnterpriseReportBO setParkProviderWaterTax(BigDecimal parkProviderWaterTax) {
        this.parkProviderWaterTax = parkProviderWaterTax;
        return this;
    }

    public BigDecimal getParkProviderStampTax() {
        return parkProviderStampTax;
    }

    public ParkEnterpriseReportBO setParkProviderStampTax(BigDecimal parkProviderStampTax) {
        this.parkProviderStampTax = parkProviderStampTax;
        return this;
    }

    public BigDecimal getParkProviderIncomeTax() {
        return parkProviderIncomeTax;
    }

    public ParkEnterpriseReportBO setParkProviderIncomeTax(BigDecimal parkProviderIncomeTax) {
        this.parkProviderIncomeTax = parkProviderIncomeTax;
        return this;
    }

    public BigDecimal getInvoiceTotalTax() {
        return invoiceTotalTax;
    }

    public ParkEnterpriseReportBO setInvoiceTotalTax(BigDecimal invoiceTotalTax) {
        this.invoiceTotalTax = invoiceTotalTax;
        return this;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public ParkEnterpriseReportBO setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ParkEnterpriseReportBO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public ParkEnterpriseReportBO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public BigDecimal getInvoiceSpecialTax() {
        return invoiceSpecialTax;
    }

    public ParkEnterpriseReportBO setInvoiceSpecialTax(BigDecimal invoiceSpecialTax) {
        this.invoiceSpecialTax = invoiceSpecialTax;
        return this;
    }

    public BigDecimal getInvoiceNormalTax() {
        return invoiceNormalTax;
    }

    public ParkEnterpriseReportBO setInvoiceNormalTax(BigDecimal invoiceNormalTax) {
        this.invoiceNormalTax = invoiceNormalTax;
        return this;
    }

    public BigDecimal getVirtualInvoiceTotalTax() {
        return virtualInvoiceTotalTax;
    }

    public ParkEnterpriseReportBO setVirtualInvoiceTotalTax(BigDecimal virtualInvoiceTotalTax) {
        this.virtualInvoiceTotalTax = virtualInvoiceTotalTax;
        return this;
    }

    public BigDecimal getVirtualInvoiceSpecialTax() {
        return virtualInvoiceSpecialTax;
    }

    public ParkEnterpriseReportBO setVirtualInvoiceSpecialTax(BigDecimal virtualInvoiceSpecialTax) {
        this.virtualInvoiceSpecialTax = virtualInvoiceSpecialTax;
        return this;
    }

    public BigDecimal getVirtualInvoiceNormalTax() {
        return virtualInvoiceNormalTax;
    }

    public ParkEnterpriseReportBO setVirtualInvoiceNormalTax(BigDecimal virtualInvoiceNormalTax) {
        this.virtualInvoiceNormalTax = virtualInvoiceNormalTax;
        return this;
    }
}
