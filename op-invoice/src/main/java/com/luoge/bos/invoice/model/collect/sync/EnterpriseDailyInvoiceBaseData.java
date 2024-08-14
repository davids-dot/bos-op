package com.luoge.bos.invoice.model.collect.sync;

import com.luoge.bos.invoice.model.collect.YearSummaryDailyBO;
import com.luoge.bos.invoice.model.collect.SeasonSummaryDailyBO;
import com.luoge.bos.invoice.model.park.enterprise.ParkEnterpriseFeeBO;

/**
 * 企业每日发票数据 计算的 基础数据类
 */
public class EnterpriseDailyInvoiceBaseData {
    /**
     * 企业上的园区费率、渠道商费率等
     */
    private ParkEnterpriseFeeBO parkEnterpriseFeeRate;
    /**
     * 季度累计税 信息
     */
    private SeasonSummaryDailyBO seasonSummaryDailyBO;
    /**
     * 年段累计税 信息
     */
    private YearSummaryDailyBO yearSummaryDailyBO;

    public ParkEnterpriseFeeBO getParkEnterpriseFeeRate() {
        return parkEnterpriseFeeRate;
    }

    public EnterpriseDailyInvoiceBaseData setParkEnterpriseFeeRate(ParkEnterpriseFeeBO parkEnterpriseFeeRate) {
        this.parkEnterpriseFeeRate = parkEnterpriseFeeRate;
        return this;
    }

    public SeasonSummaryDailyBO getSeasonSummaryDailyBO() {
        return seasonSummaryDailyBO;
    }

    public EnterpriseDailyInvoiceBaseData setSeasonSummaryDailyBO(SeasonSummaryDailyBO seasonSummaryDailyBO) {
        this.seasonSummaryDailyBO = seasonSummaryDailyBO;
        return this;
    }

    public YearSummaryDailyBO getYearSummaryDailyBO() {
        return yearSummaryDailyBO;
    }

    public EnterpriseDailyInvoiceBaseData setYearSummaryDailyBO(YearSummaryDailyBO yearSummaryDailyBO) {
        this.yearSummaryDailyBO = yearSummaryDailyBO;
        return this;
    }
}
