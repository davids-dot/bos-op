package com.luoge.bos.invoice.model.report;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

public class DistributorMonthReportDetailBO {
    /**
     * 企业id
     */
    @ExcelIgnore
    private Integer enterpriseId;
    /**
     * 企业名称
     */
    @ExcelProperty("企业名称")
    private String enterpriseName;
    /**
     * 累计开票额
     */
    @ExcelProperty("累计开票额")
    private String totalAmount;
    /**
     * 应付佣金
     */
    @ExcelProperty("应付佣金")
    private String totalFee;

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public DistributorMonthReportDetailBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public DistributorMonthReportDetailBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public DistributorMonthReportDetailBO setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public DistributorMonthReportDetailBO setTotalFee(String totalFee) {
        this.totalFee = totalFee;
        return this;
    }
}
