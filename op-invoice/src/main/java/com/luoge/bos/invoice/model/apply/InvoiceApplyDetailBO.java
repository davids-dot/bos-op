package com.luoge.bos.invoice.model.apply;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.List;

public class InvoiceApplyDetailBO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 购方名称
     */
    private String buyerName;
    /**
     * 购方税号
     */
    private String buyerTaxNo;
    /**
     * 销方名称
     */
    private String sellerName;
    /**
     * 销方税号
     */
    private String sellerTaxNo;
    /**
     * 商品项
     */
    private List<InvoiceApplyItemBO> items;
    /**
     * 合计金额
     */
    private BigDecimal totalAmount;
    /**
     * 合计税额
     */
    private BigDecimal totalTax;
    /**
     * 价税合计
     */
    private BigDecimal total;
    /**
     * 备注
     */
    private String remark;
    /**
     * 业务凭证
     */
    private List<Integer> businessProofFileIds;
    /**
     * 流水凭证
     */
    private List<Integer> fundProofFileIds;
    /**
     * 应付金额
     */
    private BigDecimal serviceFee;
    /**
     * 付款凭证
     */
    private List<Integer> paymentProofFileId;
    /**
     * 开票申请时间
     */
    private Long createTime;
    /**
     * 审核时间
     */
    private Long approveTime;
    /**
     * 作废时间
     */
    private Long deprecatedTime;
    /**
     * 驳回时间
     */
    private Long rejectedTime;
    /**
     * 驳回原因
     */
    private String rejectedReason;
    /**
     * 状态
     */
    private Integer status;
    /**
     *
     * 票种类型
     */
    private Integer type;

    public Long getId() {
        return id;
    }

    public InvoiceApplyDetailBO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public InvoiceApplyDetailBO setBuyerName(String buyerName) {
        this.buyerName = buyerName;
        return this;
    }

    public String getBuyerTaxNo() {
        return buyerTaxNo;
    }

    public InvoiceApplyDetailBO setBuyerTaxNo(String buyerTaxNo) {
        this.buyerTaxNo = buyerTaxNo;
        return this;
    }

    public String getSellerName() {
        return sellerName;
    }

    public InvoiceApplyDetailBO setSellerName(String sellerName) {
        this.sellerName = sellerName;
        return this;
    }

    public String getSellerTaxNo() {
        return sellerTaxNo;
    }

    public InvoiceApplyDetailBO setSellerTaxNo(String sellerTaxNo) {
        this.sellerTaxNo = sellerTaxNo;
        return this;
    }

    public List<InvoiceApplyItemBO> getItems() {
        return items;
    }

    public InvoiceApplyDetailBO setItems(List<InvoiceApplyItemBO> items) {
        this.items = items;
        return this;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public InvoiceApplyDetailBO setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public InvoiceApplyDetailBO setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public InvoiceApplyDetailBO setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public InvoiceApplyDetailBO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public List<Integer> getBusinessProofFileIds() {
        return businessProofFileIds;
    }

    public InvoiceApplyDetailBO setBusinessProofFileIds(List<Integer> businessProofFileIds) {
        this.businessProofFileIds = businessProofFileIds;
        return this;
    }

    public List<Integer> getFundProofFileIds() {
        return fundProofFileIds;
    }

    public InvoiceApplyDetailBO setFundProofFileIds(List<Integer> fundProofFileIds) {
        this.fundProofFileIds = fundProofFileIds;
        return this;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public InvoiceApplyDetailBO setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public List<Integer> getPaymentProofFileId() {
        return paymentProofFileId;
    }

    public InvoiceApplyDetailBO setPaymentProofFileId(List<Integer> paymentProofFileId) {
        this.paymentProofFileId = paymentProofFileId;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public InvoiceApplyDetailBO setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public InvoiceApplyDetailBO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Long getApproveTime() {
        return approveTime;
    }

    public InvoiceApplyDetailBO setApproveTime(Long approveTime) {
        this.approveTime = approveTime;
        return this;
    }

    public Long getDeprecatedTime() {
        return deprecatedTime;
    }

    public InvoiceApplyDetailBO setDeprecatedTime(Long deprecatedTime) {
        this.deprecatedTime = deprecatedTime;
        return this;
    }

    public Long getRejectedTime() {
        return rejectedTime;
    }

    public InvoiceApplyDetailBO setRejectedTime(Long rejectedTime) {
        this.rejectedTime = rejectedTime;
        return this;
    }

    public String getRejectedReason() {
        return rejectedReason;
    }

    public InvoiceApplyDetailBO setRejectedReason(String rejectedReason) {
        this.rejectedReason = rejectedReason;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public InvoiceApplyDetailBO setType(Integer type) {
        this.type = type;
        return this;
    }
}
