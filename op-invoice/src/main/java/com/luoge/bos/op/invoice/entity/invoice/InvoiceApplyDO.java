package com.luoge.bos.op.invoice.entity.invoice;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 发票
 */
public class InvoiceApplyDO {
    private Long id;

    private Integer orgId;

    private Integer enterpriseId;

    private Integer userId;

    private Integer invoiceType;

    private Boolean buyerPersonalFlag;

    private String buyerName;

    private String buyerTaxNo;

    private String buyerAddress;

    private String buyerPhone;

    private String buyerBankName;

    private String buyerBankAccount;

    private String sellerName;

    private String sellerTaxNo;

    private String sellerAddress;

    private String sellerPhone;

    private String sellerBankName;

    private String sellerBankAccount;

    private BigDecimal totalAmount;

    private BigDecimal totalTax;

    private BigDecimal total;

    private String remark;

    private String notifyEmail;

    private Integer status;

    private Boolean includeTaxFlag;

    private String businessProofFileIds;

    private String fundProofFileIds;

    private BigDecimal serviceFee;

    private String paymentProofFileId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
    private BigDecimal serviceFeeRate;

    public Long getId() {
        return id;
    }

    public InvoiceApplyDO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public InvoiceApplyDO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public InvoiceApplyDO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public InvoiceApplyDO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public InvoiceApplyDO setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
        return this;
    }

    public Boolean getBuyerPersonalFlag() {
        return buyerPersonalFlag;
    }

    public InvoiceApplyDO setBuyerPersonalFlag(Boolean buyerPersonalFlag) {
        this.buyerPersonalFlag = buyerPersonalFlag;
        return this;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public InvoiceApplyDO setBuyerName(String buyerName) {
        this.buyerName = buyerName;
        return this;
    }

    public String getBuyerTaxNo() {
        return buyerTaxNo;
    }

    public InvoiceApplyDO setBuyerTaxNo(String buyerTaxNo) {
        this.buyerTaxNo = buyerTaxNo;
        return this;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public InvoiceApplyDO setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
        return this;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public InvoiceApplyDO setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
        return this;
    }

    public String getBuyerBankName() {
        return buyerBankName;
    }

    public InvoiceApplyDO setBuyerBankName(String buyerBankName) {
        this.buyerBankName = buyerBankName;
        return this;
    }

    public String getBuyerBankAccount() {
        return buyerBankAccount;
    }

    public InvoiceApplyDO setBuyerBankAccount(String buyerBankAccount) {
        this.buyerBankAccount = buyerBankAccount;
        return this;
    }

    public String getSellerName() {
        return sellerName;
    }

    public InvoiceApplyDO setSellerName(String sellerName) {
        this.sellerName = sellerName;
        return this;
    }

    public String getSellerTaxNo() {
        return sellerTaxNo;
    }

    public InvoiceApplyDO setSellerTaxNo(String sellerTaxNo) {
        this.sellerTaxNo = sellerTaxNo;
        return this;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public InvoiceApplyDO setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
        return this;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public InvoiceApplyDO setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
        return this;
    }

    public String getSellerBankName() {
        return sellerBankName;
    }

    public InvoiceApplyDO setSellerBankName(String sellerBankName) {
        this.sellerBankName = sellerBankName;
        return this;
    }

    public String getSellerBankAccount() {
        return sellerBankAccount;
    }

    public InvoiceApplyDO setSellerBankAccount(String sellerBankAccount) {
        this.sellerBankAccount = sellerBankAccount;
        return this;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public InvoiceApplyDO setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public InvoiceApplyDO setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public InvoiceApplyDO setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public InvoiceApplyDO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getNotifyEmail() {
        return notifyEmail;
    }

    public InvoiceApplyDO setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public InvoiceApplyDO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Boolean getIncludeTaxFlag() {
        return includeTaxFlag;
    }

    public InvoiceApplyDO setIncludeTaxFlag(Boolean includeTaxFlag) {
        this.includeTaxFlag = includeTaxFlag;
        return this;
    }

    public String getBusinessProofFileIds() {
        return businessProofFileIds;
    }

    public InvoiceApplyDO setBusinessProofFileIds(String businessProofFileIds) {
        this.businessProofFileIds = businessProofFileIds;
        return this;
    }

    public String getFundProofFileIds() {
        return fundProofFileIds;
    }

    public InvoiceApplyDO setFundProofFileIds(String fundProofFileIds) {
        this.fundProofFileIds = fundProofFileIds;
        return this;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public InvoiceApplyDO setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public String getPaymentProofFileId() {
        return paymentProofFileId;
    }

    public InvoiceApplyDO setPaymentProofFileId(String paymentProofFileId) {
        this.paymentProofFileId = paymentProofFileId;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public InvoiceApplyDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public InvoiceApplyDO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public BigDecimal getServiceFeeRate() {
        return serviceFeeRate;
    }

    public InvoiceApplyDO setServiceFeeRate(BigDecimal serviceFeeRate) {
        this.serviceFeeRate = serviceFeeRate;
        return this;
    }
}