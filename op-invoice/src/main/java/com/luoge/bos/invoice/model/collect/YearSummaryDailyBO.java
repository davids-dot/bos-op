package com.luoge.bos.invoice.model.collect;

import java.math.BigDecimal;

public class YearSummaryDailyBO {
    /**
     * 企业id
     */
    private Integer enterpriseId;
    /**
     * 年度累计开票金额
     * 专票 - 不含税金额
     * 普票 - 价税合计
     */
    private BigDecimal issueAmount;
    /**
     * 年度累计已缴纳个税
     */
    private BigDecimal incomeTax;


    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public YearSummaryDailyBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    public YearSummaryDailyBO setIncomeTax(BigDecimal incomeTax) {
        this.incomeTax = incomeTax;
        return this;
    }

    public BigDecimal getIssueAmount() {
        return issueAmount;
    }

    public YearSummaryDailyBO setIssueAmount(BigDecimal issueAmount) {
        this.issueAmount = issueAmount;
        return this;
    }
}
