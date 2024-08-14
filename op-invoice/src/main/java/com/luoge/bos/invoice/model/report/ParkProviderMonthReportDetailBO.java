package com.luoge.bos.invoice.model.report;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

public class ParkProviderMonthReportDetailBO {
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
     * 月份
     */
    @ExcelProperty("月份")
    private String month;
    /**
     * 应付增值税
     */
    @ExcelProperty("应付增值税")
    private String parkProviderValueAddedTax;
    /**
     * 应付附加税
     */
    @ExcelProperty("应付附加税")
    private String parkProviderAdditionalTax;
    /**
     * 应付水利基金
     */
    @ExcelProperty("应付水利基金")
    private String parkProviderWaterTax;
    /**
     * 应付印花税
     */
    @ExcelProperty("应付印花税")
    private String parkProviderStampTax;
    /**
     * 应付个人所得税
     */
    @ExcelProperty("应付个人所得税")
    private String parkProviderIncomeTax;
    /**
     * 应付税额合计
     */
    @ExcelProperty("应付税额合计")
    private String parkProviderTotalTax;
    /**
     * 应付服务费
     */
    @ExcelProperty("应付费用")
    private String parkProviderFee;
    /**
     * 合计
     */
    @ExcelProperty("合计")
    private String total;

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public ParkProviderMonthReportDetailBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public ParkProviderMonthReportDetailBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public ParkProviderMonthReportDetailBO setMonth(String month) {
        this.month = month;
        return this;
    }

    public String getParkProviderValueAddedTax() {
        return parkProviderValueAddedTax;
    }

    public ParkProviderMonthReportDetailBO setParkProviderValueAddedTax(String parkProviderValueAddedTax) {
        this.parkProviderValueAddedTax = parkProviderValueAddedTax;
        return this;
    }

    public String getParkProviderAdditionalTax() {
        return parkProviderAdditionalTax;
    }

    public ParkProviderMonthReportDetailBO setParkProviderAdditionalTax(String parkProviderAdditionalTax) {
        this.parkProviderAdditionalTax = parkProviderAdditionalTax;
        return this;
    }

    public String getParkProviderWaterTax() {
        return parkProviderWaterTax;
    }

    public ParkProviderMonthReportDetailBO setParkProviderWaterTax(String parkProviderWaterTax) {
        this.parkProviderWaterTax = parkProviderWaterTax;
        return this;
    }

    public String getParkProviderStampTax() {
        return parkProviderStampTax;
    }

    public ParkProviderMonthReportDetailBO setParkProviderStampTax(String parkProviderStampTax) {
        this.parkProviderStampTax = parkProviderStampTax;
        return this;
    }

    public String getParkProviderIncomeTax() {
        return parkProviderIncomeTax;
    }

    public ParkProviderMonthReportDetailBO setParkProviderIncomeTax(String parkProviderIncomeTax) {
        this.parkProviderIncomeTax = parkProviderIncomeTax;
        return this;
    }

    public String getParkProviderFee() {
        return parkProviderFee;
    }

    public ParkProviderMonthReportDetailBO setParkProviderFee(String parkProviderFee) {
        this.parkProviderFee = parkProviderFee;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public ParkProviderMonthReportDetailBO setTotal(String total) {
        this.total = total;
        return this;
    }

    public String getParkProviderTotalTax() {
        return parkProviderTotalTax;
    }

    public ParkProviderMonthReportDetailBO setParkProviderTotalTax(String parkProviderTotalTax) {
        this.parkProviderTotalTax = parkProviderTotalTax;
        return this;
    }
}
