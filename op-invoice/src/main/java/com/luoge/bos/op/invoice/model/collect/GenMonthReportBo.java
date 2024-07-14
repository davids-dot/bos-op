package com.luoge.bos.op.invoice.model.collect;

import com.luoge.bos.op.invoice.entity.ParkEnterpriseCustomerDO;
import com.luoge.bos.op.invoice.entity.ParkEnterpriseDO;
import com.luoge.bos.op.invoice.entity.ParkEnterpriseDistributorDO;
import com.luoge.bos.op.invoice.entity.ParkProviderDO;

import java.time.LocalDateTime;

/**
 * 生成月报BO
 */
public class GenMonthReportBo {
    ParkEnterpriseDO parkEnterprise;
    ParkProviderDO parkProvider;
    ParkEnterpriseDistributorDO parkDistributor;
    ParkEnterpriseCustomerDO parkCustomer;
    LocalDateTime lastMonthBegin;
    LocalDateTime lastMonthEnd;

    public ParkEnterpriseDO getParkEnterprise() {
        return parkEnterprise;
    }

    public GenMonthReportBo setParkEnterprise(ParkEnterpriseDO parkEnterprise) {
        this.parkEnterprise = parkEnterprise;
        return this;
    }

    public ParkProviderDO getParkProvider() {
        return parkProvider;
    }

    public GenMonthReportBo setParkProvider(ParkProviderDO parkProvider) {
        this.parkProvider = parkProvider;
        return this;
    }

    public ParkEnterpriseDistributorDO getParkDistributor() {
        return parkDistributor;
    }

    public GenMonthReportBo setParkDistributor(ParkEnterpriseDistributorDO parkDistributor) {
        this.parkDistributor = parkDistributor;
        return this;
    }

    public ParkEnterpriseCustomerDO getParkCustomer() {
        return parkCustomer;
    }

    public GenMonthReportBo setParkCustomer(ParkEnterpriseCustomerDO parkCustomer) {
        this.parkCustomer = parkCustomer;
        return this;
    }

    public LocalDateTime getLastMonthBegin() {
        return lastMonthBegin;
    }

    public GenMonthReportBo setLastMonthBegin(LocalDateTime lastMonthBegin) {
        this.lastMonthBegin = lastMonthBegin;
        return this;
    }

    public LocalDateTime getLastMonthEnd() {
        return lastMonthEnd;
    }

    public GenMonthReportBo setLastMonthEnd(LocalDateTime lastMonthEnd) {
        this.lastMonthEnd = lastMonthEnd;
        return this;
    }
}
