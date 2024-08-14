package com.luoge.bos.invoice.model.collect;


import java.math.BigDecimal;

public class AddInvoiceBO {
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
    private String totalAmount;
    /**
     * 税额合计
     */
    private String totalTax;
    /**
     * 价税合计
     */
    private String total;
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
    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public AddInvoiceBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public Long getIssueTime() {
        return issueTime;
    }

    public AddInvoiceBO setIssueTime(Long issueTime) {
        this.issueTime = issueTime;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public AddInvoiceBO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public AddInvoiceBO setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public AddInvoiceBO setTotalTax(String totalTax) {
        this.totalTax = totalTax;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public AddInvoiceBO setTotal(String total) {
        this.total = total;
        return this;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public AddInvoiceBO setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
        return this;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public AddInvoiceBO setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
        return this;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public AddInvoiceBO setBuyerName(String buyerName) {
        this.buyerName = buyerName;
        return this;
    }

    public BigDecimal getInvoiceTaxRate() {
        return invoiceTaxRate;
    }

    public AddInvoiceBO setInvoiceTaxRate(BigDecimal invoiceTaxRate) {
        this.invoiceTaxRate = invoiceTaxRate;
        return this;
    }
    public String getBusinessId() {
        return businessId;
    }

    public AddInvoiceBO setBusinessId(String businessId) {
        this.businessId = businessId;
        return this;
    }
}
