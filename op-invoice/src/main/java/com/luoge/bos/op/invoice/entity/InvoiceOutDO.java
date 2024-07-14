package com.luoge.bos.op.invoice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceOutDO {
    private Long id;

    private Integer orgId;

    private Integer enterpriseId;

    private String period;

    private String invoiceCode;

    private String invoiceNo;

    private Integer invoiceType;

    private LocalDateTime issueTime;

    private Integer category;

    private Integer taxType;

    private Integer method;

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

    private String taxBureau;

    private String receiver;

    private String issuer;

    private String reviewer;

    private String notifyEmail;

    private Integer pdfFileId;

    private Object ext;

    private Integer status;

    private Integer redReason;

    private String redApplyCode;

    private String redConfirmCode;

    private String redRelateNo;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer ofdFileId;

    private Integer xmlFileId;

    private String failReason;

    private BigDecimal offsetAmount;

    private Boolean includeTaxFlag;

    private String businessId;

    private Integer previewImgId;

    private Integer mobileUserId;


    public Long getId() {
        return id;
    }

    public InvoiceOutDO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public InvoiceOutDO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getPeriod() {
        return period;
    }

    public InvoiceOutDO setPeriod(String period) {
        this.period = period;
        return this;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public InvoiceOutDO setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
        return this;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public InvoiceOutDO setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
        return this;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public InvoiceOutDO setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
        return this;
    }

    public LocalDateTime getIssueTime() {
        return issueTime;
    }

    public InvoiceOutDO setIssueTime(LocalDateTime issueTime) {
        this.issueTime = issueTime;
        return this;
    }

    public Integer getCategory() {
        return category;
    }

    public InvoiceOutDO setCategory(Integer category) {
        this.category = category;
        return this;
    }

    public Integer getTaxType() {
        return taxType;
    }

    public InvoiceOutDO setTaxType(Integer taxType) {
        this.taxType = taxType;
        return this;
    }

    public Integer getMethod() {
        return method;
    }

    public InvoiceOutDO setMethod(Integer method) {
        this.method = method;
        return this;
    }

    public Boolean getBuyerPersonalFlag() {
        return buyerPersonalFlag;
    }

    public InvoiceOutDO setBuyerPersonalFlag(Boolean buyerPersonalFlag) {
        this.buyerPersonalFlag = buyerPersonalFlag;
        return this;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public InvoiceOutDO setBuyerName(String buyerName) {
        this.buyerName = buyerName;
        return this;
    }

    public String getBuyerTaxNo() {
        return buyerTaxNo;
    }

    public InvoiceOutDO setBuyerTaxNo(String buyerTaxNo) {
        this.buyerTaxNo = buyerTaxNo;
        return this;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public InvoiceOutDO setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
        return this;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public InvoiceOutDO setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
        return this;
    }

    public String getBuyerBankName() {
        return buyerBankName;
    }

    public InvoiceOutDO setBuyerBankName(String buyerBankName) {
        this.buyerBankName = buyerBankName;
        return this;
    }

    public String getBuyerBankAccount() {
        return buyerBankAccount;
    }

    public InvoiceOutDO setBuyerBankAccount(String buyerBankAccount) {
        this.buyerBankAccount = buyerBankAccount;
        return this;
    }

    public String getSellerName() {
        return sellerName;
    }

    public InvoiceOutDO setSellerName(String sellerName) {
        this.sellerName = sellerName;
        return this;
    }

    public String getSellerTaxNo() {
        return sellerTaxNo;
    }

    public InvoiceOutDO setSellerTaxNo(String sellerTaxNo) {
        this.sellerTaxNo = sellerTaxNo;
        return this;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public InvoiceOutDO setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
        return this;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public InvoiceOutDO setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
        return this;
    }

    public String getSellerBankName() {
        return sellerBankName;
    }

    public InvoiceOutDO setSellerBankName(String sellerBankName) {
        this.sellerBankName = sellerBankName;
        return this;
    }

    public String getSellerBankAccount() {
        return sellerBankAccount;
    }

    public InvoiceOutDO setSellerBankAccount(String sellerBankAccount) {
        this.sellerBankAccount = sellerBankAccount;
        return this;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public InvoiceOutDO setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public InvoiceOutDO setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public InvoiceOutDO setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public InvoiceOutDO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getTaxBureau() {
        return taxBureau;
    }

    public InvoiceOutDO setTaxBureau(String taxBureau) {
        this.taxBureau = taxBureau;
        return this;
    }

    public String getReceiver() {
        return receiver;
    }

    public InvoiceOutDO setReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public String getIssuer() {
        return issuer;
    }

    public InvoiceOutDO setIssuer(String issuer) {
        this.issuer = issuer;
        return this;
    }

    public String getReviewer() {
        return reviewer;
    }

    public InvoiceOutDO setReviewer(String reviewer) {
        this.reviewer = reviewer;
        return this;
    }

    public String getNotifyEmail() {
        return notifyEmail;
    }

    public InvoiceOutDO setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
        return this;
    }

    public Integer getPdfFileId() {
        return pdfFileId;
    }

    public InvoiceOutDO setPdfFileId(Integer pdfFileId) {
        this.pdfFileId = pdfFileId;
        return this;
    }

    public Object getExt() {
        return ext;
    }

    public InvoiceOutDO setExt(Object ext) {
        this.ext = ext;
        return this;
    }


    public Integer getStatus() {
        return status;
    }

    public InvoiceOutDO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getRedReason() {
        return redReason;
    }

    public InvoiceOutDO setRedReason(Integer redReason) {
        this.redReason = redReason;
        return this;
    }

    public String getRedApplyCode() {
        return redApplyCode;
    }

    public InvoiceOutDO setRedApplyCode(String redApplyCode) {
        this.redApplyCode = redApplyCode;
        return this;
    }

    public String getRedConfirmCode() {
        return redConfirmCode;
    }

    public InvoiceOutDO setRedConfirmCode(String redConfirmCode) {
        this.redConfirmCode = redConfirmCode;
        return this;
    }

    public String getRedRelateNo() {
        return redRelateNo;
    }

    public InvoiceOutDO setRedRelateNo(String redRelateNo) {
        this.redRelateNo = redRelateNo;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public InvoiceOutDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public InvoiceOutDO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Integer getOfdFileId() {
        return ofdFileId;
    }

    public InvoiceOutDO setOfdFileId(Integer ofdFileId) {
        this.ofdFileId = ofdFileId;
        return this;
    }

    public Integer getXmlFileId() {
        return xmlFileId;
    }

    public InvoiceOutDO setXmlFileId(Integer xmlFileId) {
        this.xmlFileId = xmlFileId;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public InvoiceOutDO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public String getFailReason() {
        return failReason;
    }

    public InvoiceOutDO setFailReason(String failReason) {
        this.failReason = failReason;
        return this;
    }

    public BigDecimal getOffsetAmount() {
        return offsetAmount;
    }

    public InvoiceOutDO setOffsetAmount(BigDecimal offsetAmount) {
        this.offsetAmount = offsetAmount;
        return this;
    }

    public Boolean getIncludeTaxFlag() {
        return includeTaxFlag;
    }

    public InvoiceOutDO setIncludeTaxFlag(Boolean includeTaxFlag) {
        this.includeTaxFlag = includeTaxFlag;
        return this;
    }

    public String getBusinessId() {
        return businessId;
    }

    public InvoiceOutDO setBusinessId(String businessId) {
        this.businessId = businessId;
        return this;
    }

    public Integer getPreviewImgId() {
        return previewImgId;
    }

    public InvoiceOutDO setPreviewImgId(Integer previewImgId) {
        this.previewImgId = previewImgId;
        return this;
    }

    public Integer getMobileUserId() {
        return mobileUserId;
    }

    public InvoiceOutDO setMobileUserId(Integer mobileUserId) {
        this.mobileUserId = mobileUserId;
        return this;
    }

}