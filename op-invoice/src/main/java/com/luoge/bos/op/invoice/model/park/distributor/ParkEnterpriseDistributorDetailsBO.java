package com.luoge.bos.op.invoice.model.park.distributor;

import java.math.BigDecimal;

public class ParkEnterpriseDistributorDetailsBO {
    private Integer id;
    private String name;
    private String remark;
    private Integer status;
    private String accountName;
    private String accountOpenBank;
    private String accountBank;
    private String accountNo;
    private BigDecimal feeRate;
    private Long createTime;
    private Long updateTime;

    public Integer getId() {
        return id;
    }

    public ParkEnterpriseDistributorDetailsBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ParkEnterpriseDistributorDetailsBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public ParkEnterpriseDistributorDetailsBO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ParkEnterpriseDistributorDetailsBO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public ParkEnterpriseDistributorDetailsBO setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public String getAccountOpenBank() {
        return accountOpenBank;
    }

    public ParkEnterpriseDistributorDetailsBO setAccountOpenBank(String accountOpenBank) {
        this.accountOpenBank = accountOpenBank;
        return this;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public ParkEnterpriseDistributorDetailsBO setAccountBank(String accountBank) {
        this.accountBank = accountBank;
        return this;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public ParkEnterpriseDistributorDetailsBO setAccountNo(String accountNo) {
        this.accountNo = accountNo;
        return this;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public ParkEnterpriseDistributorDetailsBO setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public ParkEnterpriseDistributorDetailsBO setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public ParkEnterpriseDistributorDetailsBO setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
