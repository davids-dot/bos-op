package com.luoge.bos.invoice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DistributorReportDO {
    private Integer id;

    private Integer parkEnterpriseDistributorId;

    private String parkEnterpriseDistributorName;

    private String month;

    private BigDecimal totalAmount;

    private BigDecimal totalFee;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public DistributorReportDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getParkEnterpriseDistributorId() {
        return parkEnterpriseDistributorId;
    }

    public DistributorReportDO setParkEnterpriseDistributorId(Integer parkEnterpriseDistributorId) {
        this.parkEnterpriseDistributorId = parkEnterpriseDistributorId;
        return this;
    }

    public String getParkEnterpriseDistributorName() {
        return parkEnterpriseDistributorName;
    }

    public DistributorReportDO setParkEnterpriseDistributorName(String parkEnterpriseDistributorName) {
        this.parkEnterpriseDistributorName = parkEnterpriseDistributorName;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public DistributorReportDO setMonth(String month) {
        this.month = month;
        return this;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public DistributorReportDO setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public DistributorReportDO setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public DistributorReportDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public DistributorReportDO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}