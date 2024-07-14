package com.luoge.bos.op.invoice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkProviderReportDO {
    private Integer id;

    private Integer parkProviderId;

    private String parkProviderName;

    private String month;

    private BigDecimal parkProviderValueAddedTax;

    private BigDecimal parkProviderAdditionalTax;

    private BigDecimal parkProviderWaterTax;

    private BigDecimal parkProviderStampTax;

    private BigDecimal parkProviderIncomeTax;
    private BigDecimal parkProviderTotalTax;

    private BigDecimal parkProviderFee;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public void setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public void setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName == null ? null : parkProviderName.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public BigDecimal getParkProviderValueAddedTax() {
        return parkProviderValueAddedTax;
    }

    public void setParkProviderValueAddedTax(BigDecimal parkProviderValueAddedTax) {
        this.parkProviderValueAddedTax = parkProviderValueAddedTax;
    }

    public BigDecimal getParkProviderAdditionalTax() {
        return parkProviderAdditionalTax;
    }

    public void setParkProviderAdditionalTax(BigDecimal parkProviderAdditionalTax) {
        this.parkProviderAdditionalTax = parkProviderAdditionalTax;
    }

    public BigDecimal getParkProviderWaterTax() {
        return parkProviderWaterTax;
    }

    public void setParkProviderWaterTax(BigDecimal parkProviderWaterTax) {
        this.parkProviderWaterTax = parkProviderWaterTax;
    }

    public BigDecimal getParkProviderStampTax() {
        return parkProviderStampTax;
    }

    public void setParkProviderStampTax(BigDecimal parkProviderStampTax) {
        this.parkProviderStampTax = parkProviderStampTax;
    }

    public BigDecimal getParkProviderIncomeTax() {
        return parkProviderIncomeTax;
    }

    public void setParkProviderIncomeTax(BigDecimal parkProviderIncomeTax) {
        this.parkProviderIncomeTax = parkProviderIncomeTax;
    }

    public BigDecimal getParkProviderFee() {
        return parkProviderFee;
    }

    public void setParkProviderFee(BigDecimal parkProviderFee) {
        this.parkProviderFee = parkProviderFee;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getParkProviderTotalTax() {
        return parkProviderTotalTax;
    }

    public ParkProviderReportDO setParkProviderTotalTax(BigDecimal parkProviderTotalTax) {
        this.parkProviderTotalTax = parkProviderTotalTax;
        return this;
    }
}