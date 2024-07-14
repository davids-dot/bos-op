package com.luoge.bos.op.invoice.model.collect;

import java.math.BigDecimal;

public class InvoiceDetailBO {
    /**
     * 发票id
     */
    private String id;
    /**
     * 企业id
     */
    private Integer enterpriseId;
    /**
     * 开票时间
     */
    private Long issueTime;
    /**
     * 开票类型
     */
    private Integer type;
    /**
     * 金额合计
     */
    private BigDecimal totalAmount;
    /**
     * 税额合计
     */
    private BigDecimal totalTax;
    /**
     * 价税合计
     */
    private BigDecimal total;
    /**
     * 发票号码
     */
    private String invoiceNo;
    /**
     * 发票代码
     */
    private String invoiceCode;
    /**
     * 购方名称
     */
    private String buyerName;
    /**
     * 发票税率
     */
    private BigDecimal invoiceTaxRate;
    /**
     * 业务id
     */
    private String businessId;

    public String getId() {
        return id;
    }

    public InvoiceDetailBO setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public InvoiceDetailBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public Long getIssueTime() {
        return issueTime;
    }

    public InvoiceDetailBO setIssueTime(Long issueTime) {
        this.issueTime = issueTime;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public InvoiceDetailBO setType(Integer type) {
        this.type = type;
        return this;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public InvoiceDetailBO setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public InvoiceDetailBO setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public InvoiceDetailBO setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public InvoiceDetailBO setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
        return this;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public InvoiceDetailBO setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
        return this;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public InvoiceDetailBO setBuyerName(String buyerName) {
        this.buyerName = buyerName;
        return this;
    }

    public BigDecimal getInvoiceTaxRate() {
        return invoiceTaxRate;
    }

    public InvoiceDetailBO setInvoiceTaxRate(BigDecimal invoiceTaxRate) {
        this.invoiceTaxRate = invoiceTaxRate;
        return this;
    }

    public String getBusinessId() {
        return businessId;
    }

    public InvoiceDetailBO setBusinessId(String businessId) {
        this.businessId = businessId;
        return this;
    }
}
