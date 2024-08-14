package com.luoge.bos.invoice.model.report;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

public class ParkProviderMonthReportBO {
    /**
     * 园区服务商id
     */
    @ExcelIgnore
    private Integer parkProviderId;
    /**
     * 园区服务商名称
     */
    @ExcelProperty("园区服务商")
    private String parkProviderName;
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
    @ExcelProperty("应付服务费")
    private String parkProviderFee;
    /**
     * 合计
     */
    @ExcelProperty("合计")
    private String total;

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public ParkProviderMonthReportBO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public ParkProviderMonthReportBO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public ParkProviderMonthReportBO setMonth(String month) {
        this.month = month;
        return this;
    }

    public String getParkProviderValueAddedTax() {
        return parkProviderValueAddedTax;
    }

    public ParkProviderMonthReportBO setParkProviderValueAddedTax(String parkProviderValueAddedTax) {
        this.parkProviderValueAddedTax = parkProviderValueAddedTax;
        return this;
    }

    public String getParkProviderAdditionalTax() {
        return parkProviderAdditionalTax;
    }

    public ParkProviderMonthReportBO setParkProviderAdditionalTax(String parkProviderAdditionalTax) {
        this.parkProviderAdditionalTax = parkProviderAdditionalTax;
        return this;
    }

    public String getParkProviderWaterTax() {
        return parkProviderWaterTax;
    }

    public ParkProviderMonthReportBO setParkProviderWaterTax(String parkProviderWaterTax) {
        this.parkProviderWaterTax = parkProviderWaterTax;
        return this;
    }

    public String getParkProviderStampTax() {
        return parkProviderStampTax;
    }

    public ParkProviderMonthReportBO setParkProviderStampTax(String parkProviderStampTax) {
        this.parkProviderStampTax = parkProviderStampTax;
        return this;
    }

    public String getParkProviderIncomeTax() {
        return parkProviderIncomeTax;
    }

    public ParkProviderMonthReportBO setParkProviderIncomeTax(String parkProviderIncomeTax) {
        this.parkProviderIncomeTax = parkProviderIncomeTax;
        return this;
    }

    public String getParkProviderFee() {
        return parkProviderFee;
    }

    public ParkProviderMonthReportBO setParkProviderFee(String parkProviderFee) {
        this.parkProviderFee = parkProviderFee;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public ParkProviderMonthReportBO setTotal(String total) {
        this.total = total;
        return this;
    }

    public String getParkProviderTotalTax() {
        return parkProviderTotalTax;
    }

    public ParkProviderMonthReportBO setParkProviderTotalTax(String parkProviderTotalTax) {
        this.parkProviderTotalTax = parkProviderTotalTax;
        return this;
    }
}
