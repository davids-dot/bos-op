package com.luoge.bos.invoice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkEnterpriseDistributorDO {
    private Integer id;
    private String name;
    private String remark;
    private Integer status;
    private String accountName;
    private String accountOpenBank;
    private String accountBank;
    private String accountNo;
    private BigDecimal feeRate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public ParkEnterpriseDistributorDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ParkEnterpriseDistributorDO setName(String name) {
        this.name = name;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public ParkEnterpriseDistributorDO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ParkEnterpriseDistributorDO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public ParkEnterpriseDistributorDO setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public String getAccountOpenBank() {
        return accountOpenBank;
    }

    public ParkEnterpriseDistributorDO setAccountOpenBank(String accountOpenBank) {
        this.accountOpenBank = accountOpenBank;
        return this;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public ParkEnterpriseDistributorDO setAccountBank(String accountBank) {
        this.accountBank = accountBank;
        return this;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public ParkEnterpriseDistributorDO setAccountNo(String accountNo) {
        this.accountNo = accountNo;
        return this;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public ParkEnterpriseDistributorDO setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ParkEnterpriseDistributorDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public ParkEnterpriseDistributorDO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
