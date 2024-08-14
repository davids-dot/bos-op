package com.luoge.bos.invoice.collect.schedule;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.nacos.common.utils.CollectionUtils;
import com.luoge.bos.core.types.ComputeTaxType;
import com.luoge.bos.core.types.IncomeTaxLevel;
import com.luoge.bos.core.types.InvoiceType;
import com.luoge.bos.core.types.ValueAddedTaxType;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.core.utils.Numbers;
import com.luoge.bos.invoice.collect.manual.InvoiceDao;
import com.luoge.bos.invoice.model.park.provider.EnterpriseParkProviderFeeRate;
import com.luoge.bos.invoice.model.collect.*;
import com.luoge.bos.invoice.entity.InvoiceDO;
import com.luoge.bos.invoice.entity.ParkEnterpriseDO;
import com.luoge.bos.invoice.entity.ParkEnterpriseDistributorDO;
import com.luoge.bos.invoice.entity.ParkProviderDO;
import com.luoge.bos.invoice.model.park.enterprise.ParkEnterpriseFeeBO;
import com.luoge.bos.invoice.model.report.ParkEnterpriseReportBO;
import com.luoge.bos.invoice.report.enterprise.ParkEnterpriseReportDao;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 月度报表计算服务,只查询和计算
 */
@Service
public class ComputeTaxService {

    private static final Logger logger = LoggerFactory.getLogger(ComputeTaxService.class);

    /**
     * 季度价税合计阈值
     */
    public static final BigDecimal SEASON_INVOICE_TOTAL_THRESHOLD = new BigDecimal("300000");
    public static final Integer TURE = 1;

    @Resource
    private ParkEnterpriseReportDao parkEnterpriseReportDao;
    @Resource
    private InvoiceDao invoiceDao;

    /**
     * 计算园区服务商的税费,写入企业月报表
     * @param genMonthReportBo    生成月报入参
     * @param monthReport    企业月报表
     */
    public void computeParkProviderTaxFee(GenMonthReportBo genMonthReportBo, ParkEnterpriseReportBO monthReport) {
        // 园区
        ParkProviderDO parkProvider = genMonthReportBo.getParkProvider();
        // 企业
        ParkEnterpriseDO parkEnterprise = genMonthReportBo.getParkEnterprise();
        // 渠道商
        ParkEnterpriseDistributorDO parkDistributor = genMonthReportBo.getParkDistributor();
        if (Objects.isNull(parkProvider)) {
            buildMonthReportDefaultData(monthReport, parkDistributor);
            return;
        }

        EnterpriseParkProviderFeeRate parkFeeRate = createEnterpriseParkProviderFeeRate(parkEnterprise, parkProvider);
        // 计算 应付服务商服务费
        // 园区服务费 = 开票金额 * 园区服务费费率
        BigDecimal parkProviderFee = Numbers.mul(monthReport.getInvoiceTotal(), parkFeeRate.getParkProviderServiceFeeRate());

        BigDecimal valuedAddedTax = BigDecimal.ZERO;                //增值税
        BigDecimal additionalTax = BigDecimal.ZERO;                 //附加税
        BigDecimal waterTax = BigDecimal.ZERO;                      //水利基金
        BigDecimal stampTax = BigDecimal.ZERO;                      //印花税
        MonthIncomeTaxBO incomeTaxBO = null;                        //个税
        BigDecimal parkProviderTotalTax;                            //园区服务商所有的税
        // 是否包税
        // 是: 发票价税合计 × 包税税率
        // 否: 五个税种单独计算 按配置公式各税种乘税率
        if (parkProvider.getIncludeTax()) {
            parkProviderTotalTax = monthReport.getInvoiceTotal().multiply(parkFeeRate.getIncludeTaxRate());
        } else {
            // 增值税
            valuedAddedTax = computeValueAddedTax(genMonthReportBo, monthReport, parkProvider.getValueAddedTaxFormulaId(), parkFeeRate.getValueAddedTaxType());
            // 附加税
            additionalTax = computeAdditionalTax(parkProvider.getAdditionalTaxFormulaId(), monthReport.getInvoiceTotal(), valuedAddedTax, parkFeeRate.getParkProviderAdditionalTaxRate());
            // 水利基金
            waterTax = computeWaterTax(parkProvider.getWaterTaxFormulaId(), monthReport.getInvoiceTotalAmount(), parkFeeRate.getParkProviderWaterTaxRate());
            // 印花税
            stampTax = computeStampTax(parkProvider.getStampTaxFormulaId(), monthReport.getInvoiceTotal(), parkFeeRate.getParkProviderStampTaxRate());
            // 个人所得税
            incomeTaxBO = computeIncomeTax(genMonthReportBo, monthReport, parkProvider.getIncomeTaxFormulaId(), parkFeeRate.getParkProviderIncomeTaxRate());
            // 计算园区服务商税合计
            parkProviderTotalTax = Numbers.addWithScale(2, valuedAddedTax, additionalTax, waterTax, stampTax, ObjectUtil.isEmpty(incomeTaxBO) ? BigDecimal.ZERO : incomeTaxBO.getIncomeTax());
        }

        LocalDateTime now = DateUtil.nowTime();
        monthReport.setParkProviderFee(parkProviderFee)
                .setParkProviderValueAddedTax(valuedAddedTax)
                .setParkProviderAdditionalTax(additionalTax)
                .setParkProviderWaterTax(waterTax)
                .setParkProviderStampTax(stampTax)
                .setParkProviderIncomeTax(Objects.nonNull(incomeTaxBO) ? incomeTaxBO.getIncomeTax() : BigDecimal.ZERO)
                .setParkProviderTotalTax(parkProviderTotalTax)
                .setParkProviderAmount(Numbers.addWithScale(2, parkProviderFee, monthReport.getParkProviderTotalTax()))
                .setParkEnterpriseDistributorId(Objects.nonNull(parkDistributor) ? parkDistributor.getId() : null)
                .setParkEnterpriseDistributorName(Objects.nonNull(parkDistributor) ? parkDistributor.getName() : StringUtils.EMPTY)
                .setParkEnterpriseDistributorFee(
                        Numbers.mul(monthReport.getInvoiceTotal(),
                                ObjectUtils.firstNonNull(
                                        parkEnterprise.getDistributorServiceFeeRate(),
                                        Objects.nonNull(parkDistributor) ? parkDistributor.getFeeRate() : BigDecimal.ZERO,
                                        BigDecimal.ZERO
                                )
                        )
                )
                .setCreateTime(now)
                .setUpdateTime(now);
    }

    /**
     * 构建月报默认值
     */
    private void buildMonthReportDefaultData(ParkEnterpriseReportBO monthReport, ParkEnterpriseDistributorDO parkDistributor) {
        LocalDateTime now = DateUtil.nowTime();
        monthReport.setParkProviderFee(BigDecimal.ZERO)
                .setParkProviderValueAddedTax(BigDecimal.ZERO)
                .setParkProviderAdditionalTax(BigDecimal.ZERO)
                .setParkProviderWaterTax(BigDecimal.ZERO)
                .setParkProviderStampTax(BigDecimal.ZERO)
                .setParkProviderIncomeTax(BigDecimal.ZERO)
                .setParkProviderTotalTax(BigDecimal.ZERO)
                .setParkProviderAmount(BigDecimal.ZERO)
                .setParkEnterpriseDistributorId(Objects.nonNull(parkDistributor) ? parkDistributor.getId() : null)
                .setParkEnterpriseDistributorName(Objects.nonNull(parkDistributor) ? parkDistributor.getName() : StringUtils.EMPTY)
                .setParkEnterpriseDistributorFee(Numbers.mul(monthReport.getInvoiceTotal(), Objects.nonNull(parkDistributor) ? parkDistributor.getFeeRate() : BigDecimal.ZERO))
                .setCreateTime(now)
                .setUpdateTime(now);
    }

    private EnterpriseParkProviderFeeRate createEnterpriseParkProviderFeeRate(ParkEnterpriseDO parkEnterprise, ParkProviderDO parkProvider) {
        return new EnterpriseParkProviderFeeRate()
                .setParkProviderServiceFeeRate(ObjectUtils.firstNonNull(
                        parkEnterprise.getParkProviderServiceFeeRate(), parkProvider.getServiceFeeRate(), BigDecimal.ZERO
                ))
                .setParkProviderAdditionalTaxRate(ObjectUtils.firstNonNull(
                        parkEnterprise.getParkProviderAdditionalTaxRate(), parkProvider.getAdditionalTaxRate(), BigDecimal.ZERO
                ))
                .setParkProviderWaterTaxRate(ObjectUtils.firstNonNull(
                        parkEnterprise.getParkProviderWaterTaxRate(), parkProvider.getWaterTaxRate(), BigDecimal.ZERO
                ))
                .setParkProviderStampTaxRate(ObjectUtils.firstNonNull(
                        parkEnterprise.getParkProviderStampTaxRate(), parkProvider.getStampTaxRate(), BigDecimal.ZERO
                ))
                .setParkProviderIncomeTaxRate(ObjectUtils.firstNonNull(
                        parkEnterprise.getParkProviderIncomeTaxRate(), parkProvider.getIncomeTaxRate(), BigDecimal.ZERO
                ))
                .setValueAddedTaxType(
                        ObjectUtils.firstNonNull(parkEnterprise.getValueAddedTaxType(), parkProvider.getValueAddedTaxType())
                )
                // 包税税率 优先企业税率 其次园区税率 都为空取0
                .setIncludeTaxRate(
                        ObjectUtils.firstNonNull(
                            ObjectUtils.firstNonNull(parkEnterprise.getIncludeTaxRate(), parkProvider.getIncludeTaxRate()),
                            BigDecimal.ZERO
                        )
                );
    }

    /**
     * 个人所得税
     */
    private MonthIncomeTaxBO computeIncomeTax(GenMonthReportBo genMonthReportBo, ParkEnterpriseReportBO monthReport,
                                              Integer formula, BigDecimal incomeTaxRate) {
        ComputeTaxType.IncomeTaxCalculateFormula incomeTaxCalculateFormula = ComputeTaxType.IncomeTaxCalculateFormula.of(formula);
        if (Objects.isNull(incomeTaxCalculateFormula)) {
            return null;
        }
        if (incomeTaxCalculateFormula.equals(ComputeTaxType.IncomeTaxCalculateFormula.FIXED_RATE)) {
            return computeFixedRateIncomeTax(incomeTaxRate, monthReport.getInvoiceTotal());
        } else if (incomeTaxCalculateFormula.equals(ComputeTaxType.IncomeTaxCalculateFormula.FIVE_LEVEL_TOTAL_HALF)) {
            return computeFiveLevelTotalHalfIncomeTax(genMonthReportBo, incomeTaxRate);
        } else {
            // 发票不含税金额×个税税率
            BigDecimal incomeTax = Numbers.mul(monthReport.getInvoiceTotalAmount(), incomeTaxRate);
            return new MonthIncomeTaxBO().setIncomeTax(incomeTax);
        }
    }

    /**
     * 计算 五级累进减半 本月应缴个税
     *
     * @param incomeTaxRate 核定应税所得率
     */
    private MonthIncomeTaxBO computeFiveLevelTotalHalfIncomeTax(GenMonthReportBo genMonthReportBo,
                                                                BigDecimal incomeTaxRate) {
        ParkEnterpriseDO parkEnterprise = genMonthReportBo.getParkEnterprise();
        // 算出 累计全年应纳税所得额
        BigDecimal totalYearTaxableIncome = computeTotalYearTaxableIncome(parkEnterprise, incomeTaxRate,
                genMonthReportBo.getLastMonthBegin(), genMonthReportBo.getLastMonthEnd());
        // 算出全年应纳税税额
        BigDecimal totalYearTax = IncomeTaxLevel.computeFiveLevelTotalHalfTax(totalYearTaxableIncome);
        // 减去以往月份纳税税额得出本月应纳税税额
        BigDecimal yearHistoryTax = computeYearHistoryTax(parkEnterprise, genMonthReportBo.getLastMonthBegin());

        BigDecimal incomeTax = Numbers.sub(totalYearTax, yearHistoryTax);
        return new MonthIncomeTaxBO().setIncomeTax(incomeTax);
    }

    /**
     * 本年累计已交个人所得税额
     */
    private BigDecimal computeYearHistoryTax(ParkEnterpriseDO parkEnterprise, LocalDateTime lastMonthBegin) {
        LocalDateTime yearBegin = DateUtil.atBeginOfYear(lastMonthBegin);
        List<String> months = DateUtil.monthList(yearBegin, lastMonthBegin)
                .stream()
                .map(DateUtil::getNormalMonth)
                .toList();
        if (CollectionUtils.isEmpty(months)) {
            return BigDecimal.ZERO;
        }
        return parkEnterpriseReportDao.sumYearHistoryTax(parkEnterprise.getOrgId(), parkEnterprise.getEnterpriseId(),
                months);
    }

    /**
     * 累计全年应纳税所得额
     */
    private BigDecimal computeTotalYearTaxableIncome(ParkEnterpriseDO parkEnterprise,
                                                     BigDecimal incomeTaxRate,
                                                     LocalDateTime lastMonthBegin,
                                                     LocalDateTime lastMonthEnd) {
        // 获取年度开始时间
        LocalDateTime yearBegin = DateUtil.atBeginOfYear(lastMonthBegin);
        // 年度累计票金额
        BigDecimal yearInvoiceAmount = invoiceDao.sumYearInvoiceAmount(parkEnterprise.getOrgId(), parkEnterprise.getEnterpriseId(),
                yearBegin, lastMonthEnd);
        // 年度累计应纳税所得额
        return yearInvoiceAmount.multiply(incomeTaxRate);
    }

    private MonthIncomeTaxBO computeFixedRateIncomeTax(BigDecimal incomeTaxRate, BigDecimal invoiceTotal) {
        BigDecimal incomeTax = Numbers.mul(invoiceTotal, incomeTaxRate);
        return new MonthIncomeTaxBO().setIncomeTax(incomeTax);
    }


    /**
     * 印花税金额
     *
     * @param invoiceTotal 价税合计
     * @param stampTaxRate 印花税税率
     */
    public BigDecimal computeStampTax(Integer formula, BigDecimal invoiceTotal, BigDecimal stampTaxRate) {
        ComputeTaxType.StampTaxCalculateFormula stampTaxCalculateFormula = ComputeTaxType.StampTaxCalculateFormula.of(formula);
        if (ObjectUtil.isEmpty(stampTaxCalculateFormula)) {
            return null;
        }
        return Numbers.mul(invoiceTotal, stampTaxRate);
    }


    /**
     * 应付附加税金额
     *
     * @param valuedAddedTax    增值税金额
     * @param total             价税合计
     * @param additionalTaxRate 附加税税率
     */
    public BigDecimal computeAdditionalTax(Integer formula, BigDecimal total, BigDecimal valuedAddedTax, BigDecimal additionalTaxRate) {
        ComputeTaxType.AdditionalTaxCalculateFormula additionalTaxCalculateFormula = ComputeTaxType.AdditionalTaxCalculateFormula.of(formula);
        if (ObjectUtil.isEmpty(additionalTaxCalculateFormula)){
            return null;
        }
        if (ComputeTaxType.AdditionalTaxCalculateFormula.TOTAL_MUL_TAX_RATE.equals(additionalTaxCalculateFormula)) {
            return Numbers.mul(total, additionalTaxRate);
        }
        return Numbers.mul(valuedAddedTax, additionalTaxRate);
    }


    /**
     * 水利基金税金额
     *
     * @param invoiceTotalAmount 不含税金额
     * @param waterTaxRate       水利基金税率
     */
    public BigDecimal computeWaterTax(Integer formula, BigDecimal invoiceTotalAmount, BigDecimal waterTaxRate) {
        ComputeTaxType.WaterTaxCalculateFormula waterTaxCalculateFormula = ComputeTaxType.WaterTaxCalculateFormula.of(formula);
        if (ObjectUtil.isEmpty(waterTaxCalculateFormula)) {
            return null;
        }
        return Numbers.mul(invoiceTotalAmount, waterTaxRate);
    }

    /**
     * 应付增值税金额
     */
    private BigDecimal computeValueAddedTax(GenMonthReportBo genMonthReportBo,
                                            ParkEnterpriseReportBO monthReport,
                                            Integer formula,
                                            Integer valueAddedTaxType) {
        ComputeTaxType.AddedTaxCalculateFormula addedTaxCalculateFormula = ComputeTaxType.AddedTaxCalculateFormula.of(formula);
        if (ObjectUtil.isEmpty(addedTaxCalculateFormula)){
            return null;
        }
        // 计算当前月增值税合计
        SeasonSummaryBO seasonSummary = computeSeasonSummary(addedTaxCalculateFormula, genMonthReportBo, monthReport);
        // 需缴增值税
        BigDecimal valueAddedTax = Numbers.ge(seasonSummary.getInvoiceTotalAmount(), SEASON_INVOICE_TOTAL_THRESHOLD) ?
                                   Numbers.sub(seasonSummary.getInvoiceTotalTax(), seasonSummary.getHistoryValueTax()) :
                                   Numbers.sub(seasonSummary.getInvoiceSpecialTax(), seasonSummary.getHistoryValueTax());
        // 判断计税方式
        if (ComputeTaxType.AddedTaxCalculateFormula.REAL_TAX_AMOUNT.equals(addedTaxCalculateFormula)){
            // 如果未开启30万免征政策
            if (Objects.equals(ValueAddedTaxType.TAX_BY_INVOICE.type, valueAddedTaxType)) {
                return monthReport.getInvoiceTotalTax();
            }
            return valueAddedTax;
        }
        // 如果未开启30万免征政策
        if (Objects.equals(ValueAddedTaxType.TAX_BY_INVOICE.type, valueAddedTaxType)) {
            return monthReport.getVirtualInvoiceTotalTax();
        }
        return valueAddedTax;
    }


    public BigDecimal computeValueAddedTax(Integer formula, InvoiceDO invoice, SeasonSummaryDailyBO seasonSummaryDailyBO, Integer valueAddedTaxType) {
        ComputeTaxType.AddedTaxCalculateFormula addedTaxCalculateFormula = ComputeTaxType.AddedTaxCalculateFormula.of(formula);
        if (ObjectUtil.isEmpty(addedTaxCalculateFormula)) {
            return null;
        }

        BigDecimal valueAddedTax;
        // 判断计算方式
        if (ComputeTaxType.AddedTaxCalculateFormula.REAL_TAX_AMOUNT.equals(addedTaxCalculateFormula)) {
            // 判断是否开启增值税免征政策
            if (Objects.equals(ValueAddedTaxType.TAX_BY_INVOICE.type, valueAddedTaxType)) {
                return invoice.getTotalTax();
            }
            // 发票和季度增值税额累加
            seasonSummaryDailyBO.addInvoice(invoice);
            // 判断季度内累计开票金额是否大于30万免税
            valueAddedTax = Numbers.ge(seasonSummaryDailyBO.getInvoiceTotalAmount(), SEASON_INVOICE_TOTAL_THRESHOLD) ?
                            Numbers.add(seasonSummaryDailyBO.getInvoiceTotalTax(), seasonSummaryDailyBO.getHistoryValueTax().negate()) :
                            Numbers.add(seasonSummaryDailyBO.getInvoiceSpecialTax(), seasonSummaryDailyBO.getHistoryValueTax().negate());
            // 当前发票增值税累加到历史所缴增值税中
            seasonSummaryDailyBO.addValueAddedTax(valueAddedTax);
            return valueAddedTax;
        }

        // 判断是否开启增值税免征政策
        if (Objects.equals(ValueAddedTaxType.TAX_BY_INVOICE.type, valueAddedTaxType)) {
            return invoice.getTotal().multiply(ObjectUtil.isEmpty(invoice.getInvoiceTaxRate()) ? new BigDecimal("0") : invoice.getInvoiceTaxRate());
        }
        // 当前发票和季度增值税额累加
        seasonSummaryDailyBO.addInvoice(invoice);
        valueAddedTax = !Numbers.ge(seasonSummaryDailyBO.getInvoiceTotalAmount(), SEASON_INVOICE_TOTAL_THRESHOLD) ?
                        Numbers.add(seasonSummaryDailyBO.getVirtualInvoiceSpecialTax(),seasonSummaryDailyBO.getHistoryValueTax().negate()) :
                        Numbers.add(seasonSummaryDailyBO.getVirtualInvoiceTotalTax(), seasonSummaryDailyBO.getHistoryValueTax().negate());
        // 当前发票增值税累加到历史所缴增值税中
        seasonSummaryDailyBO.addValueAddedTax(valueAddedTax);
        return valueAddedTax;
    }

    private SeasonSummaryBO computeSeasonSummary(ComputeTaxType.AddedTaxCalculateFormula addedTaxCalculateFormula,
                                                 GenMonthReportBo genMonthReportBo,
                                                 ParkEnterpriseReportBO monthReport) {
        ParkEnterpriseDO parkEnterprise = genMonthReportBo.getParkEnterprise();
        BigDecimal invoiceTotalTax = monthReport.getInvoiceTotalTax();
        BigDecimal invoiceSpecialTax = monthReport.getInvoiceSpecialTax();
        BigDecimal invoiceNormalTax = monthReport.getInvoiceNormalTax();
        // 判断计算方式
        if (ObjectUtil.equals(ComputeTaxType.AddedTaxCalculateFormula.TOTAL_MUL_TAX_RATE, addedTaxCalculateFormula)) {
            invoiceTotalTax = monthReport.getVirtualInvoiceTotalTax();
            invoiceSpecialTax = monthReport.getVirtualInvoiceSpecialTax();
            invoiceNormalTax = monthReport.getVirtualInvoiceNormalTax();
        }
        int month = genMonthReportBo.getLastMonthBegin().getMonth().getValue();

        // 是季度首月
        if (DateUtil.isSeasonStartMonth(month)) {
            return new SeasonSummaryBO()
                    .setInvoiceTotal(monthReport.getInvoiceTotal())
                    .setInvoiceTotalAmount(monthReport.getInvoiceTotalAmount())
                    .setInvoiceTotalTax(invoiceTotalTax)
                    .setInvoiceSpecialTax(invoiceSpecialTax)
                    .setInvoiceNormalTax(invoiceNormalTax)
                    .setHistoryValueTax(BigDecimal.ZERO);
        }

        // 找出季度首月
        int seasonStartMonth = DateUtil.seasonStartOfMonth(month);
        LocalDateTime seasonStartTime = genMonthReportBo.getLastMonthBegin().minusMonths(month - seasonStartMonth);
        List<String> seasonHistoryMonths = DateUtil.monthList(seasonStartTime, month - seasonStartMonth)
                .stream().map(DateUtil::getNormalMonth).toList();

        // 本季度历史已缴合计
        SummaryHistoryBO summaryHistory = parkEnterpriseReportDao.summaryHistory(parkEnterprise.getOrgId(),
                parkEnterprise.getEnterpriseId(),
                seasonHistoryMonths);
        if (Objects.isNull(summaryHistory)) {
            summaryHistory = new SummaryHistoryBO(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        }

        // 本季度历史专票,普票汇总
        SummaryHistoryTaxBO summaryHistoryTaxBO = invoiceDao.summaryHistoryTax(parkEnterprise.getOrgId(), parkEnterprise.getEnterpriseId(),
                                                                                seasonStartTime, genMonthReportBo.getLastMonthBegin());
        if (Objects.isNull(summaryHistoryTaxBO)) {
            summaryHistoryTaxBO = new SummaryHistoryTaxBO(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        }
        // 本季度专票普票合计
        if (ObjectUtil.equals(ComputeTaxType.AddedTaxCalculateFormula.TOTAL_MUL_TAX_RATE, addedTaxCalculateFormula)) {
            invoiceSpecialTax = Numbers.add(invoiceSpecialTax, summaryHistoryTaxBO.getVirtualSpecialTax());
            invoiceNormalTax = Numbers.add(invoiceNormalTax, summaryHistoryTaxBO.getVirtualNormalTax());
            // 专票普票合计
            BigDecimal historyInvoiceTotalTax = Numbers.add(summaryHistoryTaxBO.getVirtualSpecialTax(), summaryHistoryTaxBO.getVirtualNormalTax());
            invoiceTotalTax = Numbers.add(invoiceTotalTax, historyInvoiceTotalTax);
        }else {
            invoiceSpecialTax = Numbers.add(invoiceSpecialTax, summaryHistoryTaxBO.getSpecialTax());
            invoiceNormalTax = Numbers.add(invoiceNormalTax, summaryHistoryTaxBO.getNormalTax());
            invoiceTotalTax = Numbers.add(invoiceTotalTax, summaryHistory.getInvoiceTotalTax());
        }
        return new SeasonSummaryBO()
                .setInvoiceTotal(Numbers.add(monthReport.getInvoiceTotal(), summaryHistory.getInvoiceTotal()))
                .setInvoiceTotalAmount(Numbers.add(monthReport.getInvoiceTotalAmount(), summaryHistory.getInvoiceTotalAmount()))
                .setInvoiceTotalTax(invoiceTotalTax)
                .setInvoiceSpecialTax(invoiceSpecialTax)
                .setInvoiceNormalTax(invoiceNormalTax)
                .setHistoryValueTax(summaryHistory.getValueAddedTax());
    }

    public BigDecimal computeIncomeTax(Integer formula,
                                       BigDecimal incomeTaxRate,
                                       InvoiceDO invoice,
                                       YearSummaryDailyBO yearSummaryDailyBO) {
        ComputeTaxType.IncomeTaxCalculateFormula incomeTaxCalculateFormula = ComputeTaxType.IncomeTaxCalculateFormula.of(formula);
        if (Objects.isNull(incomeTaxCalculateFormula)) {
            return null;
        }
        BigDecimal incomeTax;
        if (incomeTaxCalculateFormula.equals(ComputeTaxType.IncomeTaxCalculateFormula.FIXED_RATE)) {
            incomeTax = Numbers.mul(invoice.getTotal(), incomeTaxRate);
        } else if (incomeTaxCalculateFormula.equals(ComputeTaxType.IncomeTaxCalculateFormula.FIVE_LEVEL_TOTAL_HALF)) {
            incomeTax = computeFiveLevelTotalHalfIncomeTax(incomeTaxRate,
                    yearSummaryDailyBO, invoice);
        } else {
            incomeTax = invoice.getTotalAmount().multiply(incomeTaxRate);
        }
        yearSummaryDailyBO.setIncomeTax(Numbers.add(yearSummaryDailyBO.getIncomeTax(), incomeTax));
        return incomeTax;
    }

    private BigDecimal computeFiveLevelTotalHalfIncomeTax(BigDecimal incomeTaxRate,
                                                          YearSummaryDailyBO yearSummaryDailyBO,
                                                          InvoiceDO invoice) {

        if (Objects.equals(InvoiceType.ELECTRONIC_FULL_SPECIAL.type, invoice.getType())) {
            yearSummaryDailyBO.setIssueAmount(
                    Numbers.add(yearSummaryDailyBO.getIssueAmount(), invoice.getTotalAmount())
            );
        } else if (Objects.equals(InvoiceType.ELECTRONIC_FULL_GENERAL.type, invoice.getType())) {
            yearSummaryDailyBO.setIssueAmount(
                    Numbers.add(yearSummaryDailyBO.getIssueAmount(), invoice.getTotal())
            );
        }
        // 算出 累计全年应纳税所得额
        BigDecimal totalYearTaxableIncome = Numbers.mul(yearSummaryDailyBO.getIssueAmount(), incomeTaxRate);
        // 算出全年应纳税税额
        BigDecimal totalYearTax = IncomeTaxLevel.computeFiveLevelTotalHalfTax(totalYearTaxableIncome);
        // 减去以往月份纳税税额得出本月应纳税税额
        return Numbers.sub(totalYearTax, yearSummaryDailyBO.getIncomeTax());
    }


    /**
     * 计算每张票的归属收入
     */
    public void computeInvoiceIncome(InvoiceDO invoice, ParkEnterpriseFeeBO feeRate,
                                      SeasonSummaryDailyBO seasonSummaryDailyBO, YearSummaryDailyBO yearSummaryDailyBO) {
        if (Objects.isNull(feeRate.getParkProviderId())) {
            buildInvoiceDefaultData(invoice, feeRate);
            return;
        }
        // 计算 应付服务商服务费
        // 园区服务费 = 开票金额 * 园区服务费费率
        BigDecimal parkProviderFee = Numbers.mul(invoice.getTotal(), feeRate.getParkProviderServiceFeeRate());

        BigDecimal valuedAddedTax = BigDecimal.ZERO;                //增值税
        BigDecimal additionalTax = BigDecimal.ZERO;                 //附加税
        BigDecimal waterTax = BigDecimal.ZERO;                      //水利基金
        BigDecimal stampTax = BigDecimal.ZERO;                      //印花税
        BigDecimal incomeTax = BigDecimal.ZERO;                     //个税
        BigDecimal parkProviderTotalTax;                            //园区服务商所有的税

        // 是否包税
        // 是: 发票价税合计 × 包税税率
        // 否: 五个税种单独计算 按配置公式各税种乘税率
        if (Objects.equals(feeRate.getIsIncludeTax(), TURE)) {
            parkProviderTotalTax = invoice.getTotal().multiply(feeRate.getIncludeTaxRate());
        } else {
            // 增值税额
            valuedAddedTax = computeValueAddedTax(feeRate.getValueAddedTaxFormulaId(), invoice, seasonSummaryDailyBO, feeRate.getValueAddedTaxType());
            // 附加税
            additionalTax = computeAdditionalTax(feeRate.getAdditionalTaxFormulaId(), invoice.getTotal(), valuedAddedTax, feeRate.getParkProviderAdditionalTaxRate());
            // 水利基金
            waterTax = computeWaterTax(feeRate.getWaterTaxFormulaId(), invoice.getTotalAmount(), feeRate.getParkProviderWaterTaxRate());
            // 印花税
            stampTax = computeStampTax(feeRate.getStampTaxFormulaId(), invoice.getTotal(), feeRate.getParkProviderStampTaxRate());
            // 个税
            incomeTax = computeIncomeTax(feeRate.getIncomeTaxFormulaId(), feeRate.getParkProviderIncomeTaxRate(), invoice, yearSummaryDailyBO);
            // 计算园区服务商税合计
            parkProviderTotalTax = Numbers.addWithScale(3, valuedAddedTax, additionalTax, waterTax, stampTax, incomeTax);
        }

        invoice.setParkProviderId(feeRate.getParkProviderId())
                .setParkProviderName(feeRate.getParkProviderName())
                .setParkProviderValueAddedTax(valuedAddedTax)
                .setParkProviderAdditionalTax(additionalTax)
                .setParkProviderWaterTax(waterTax)
                .setParkProviderStampTax(stampTax)
                .setParkProviderIncomeTax(incomeTax)
                // 园区服务商所有的税
                .setParkProviderTotalTax(parkProviderTotalTax)
                // 园区服务商所有的费
                .setParkProviderFee(parkProviderFee)
                // 园区服务商的 税 + 费
                .setParkProviderAmount(Numbers.addWithScale(3, invoice.getParkProviderTotalTax(),
                        invoice.getParkProviderFee()
                ))
                .setParkEnterpriseDistributorId(feeRate.getDistributorId())
                .setParkEnterpriseDistributorName(feeRate.getDistributorName())
                .setParkEnterpriseDistributorFee(
                        Numbers.mul(invoice.getTotal(), feeRate.getDistributorServiceFeeRate())
                )
                .setIncome(
                        Numbers.addWithScale(3, invoice.getServiceFee(),
                                invoice.getParkProviderAmount().negate(),
                                invoice.getParkEnterpriseDistributorFee().negate()
                        )
                );
    }

    private void buildInvoiceDefaultData(InvoiceDO invoice, ParkEnterpriseFeeBO feeRate) {
        LocalDateTime now = DateUtil.nowTime();
        invoice.setParkProviderFee(BigDecimal.ZERO)
                .setParkProviderValueAddedTax(BigDecimal.ZERO)
                .setParkProviderAdditionalTax(BigDecimal.ZERO)
                .setParkProviderWaterTax(BigDecimal.ZERO)
                .setParkProviderStampTax(BigDecimal.ZERO)
                .setParkProviderIncomeTax(BigDecimal.ZERO)
                .setParkProviderTotalTax(BigDecimal.ZERO)
                .setParkProviderAmount(BigDecimal.ZERO)
                .setParkEnterpriseDistributorId(feeRate.getDistributorId())
                .setParkEnterpriseDistributorName(
                        StringUtils.isNotBlank(feeRate.getDistributorName()) ? feeRate.getDistributorName() : StringUtils.EMPTY)
                .setParkEnterpriseDistributorFee(
                        Numbers.mul(invoice.getTotal(), Objects.nonNull(feeRate.getDistributorServiceFeeRate()) ? feeRate.getDistributorServiceFeeRate() : BigDecimal.ZERO))
                .setCreateTime(now)
                .setUpdateTime(now);
    }

}
