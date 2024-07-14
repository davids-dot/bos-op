package com.luoge.bos.op.invoice.collect.schedule;

import com.alibaba.excel.util.StringUtils;
import com.luoge.bos.op.core.utils.DateUtil;
import com.luoge.bos.op.invoice.collect.manual.InvoiceDao;
import com.luoge.bos.op.invoice.common.ParkEnterpriseCustomerDao;
import com.luoge.bos.op.invoice.entity.*;
import com.luoge.bos.op.invoice.model.collect.GenMonthReportBo;
import com.luoge.bos.op.invoice.model.report.ParkEnterpriseReportBO;
import com.luoge.bos.op.invoice.park.distributor.ParkEnterpriseDistributorService;
import com.luoge.bos.op.invoice.park.enterprise.ParkEnterpriseService;
import com.luoge.bos.op.invoice.park.provider.ParkProviderService;
import com.luoge.bos.op.invoice.report.distributor.DistributorReportService;
import com.luoge.bos.op.invoice.report.enterprise.ParkEnterpriseReportService;
import com.luoge.bos.op.invoice.report.provider.ParkProviderReportService;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 月度报表生成任务
 */
@Service
public class MonthReportTask {
    private static final Logger logger = LoggerFactory.getLogger(MonthReportTask.class);

    @Resource
    private ParkEnterpriseService parkEnterpriseService;
    @Resource
    private ParkProviderService parkProviderService;
    @Resource
    private ComputeTaxService computeTaxService;
    @Resource
    private ParkEnterpriseDistributorService parkEnterpriseDistributorService;
    @Resource
    private ParkEnterpriseReportService parkEnterpriseReportService;
    @Resource
    private ParkProviderReportService parkProviderReportService;
    @Resource
    private DistributorReportService distributorReportService;
    @Resource
    private InvoiceDao invoiceDao;
    @Resource
    private ParkEnterpriseCustomerDao parkEnterpriseCustomerDao;


    /**
     * 每月1日2点整 生成上月报表
     */
    @Scheduled(cron = "0 30 2 1 * *")
    public void generateEnterpriseMonthReport() {
        logger.info("generate month report start");
        LocalDateTime lastMonthBegin = DateUtil.atBeginOfMonth(DateUtil.nowTime().minusMonths(1));
        LocalDateTime lastMonthEnd = lastMonthBegin.plusMonths(1);
        generateMonthReport(lastMonthBegin, lastMonthEnd);
    }

    public void generateMonthReport(LocalDateTime monthBegin, LocalDateTime monthEnd) {
        logger.info("generate report at time:{} to {}", monthBegin, monthEnd);
        // 查询企业列表，按企业分别同步数据
        List<ParkEnterpriseDO> parkEnterprises = parkEnterpriseService.listParkEnterprises();
        if (CollectionUtils.isEmpty(parkEnterprises)) {
            logger.info("park enterprise is empty");
            return;
        }
        List<ParkProviderDO> parkProviders = parkProviderService.listParkProviders();
        Map<Integer, ParkProviderDO> providerMap = parkProviders.stream()
                .collect(Collectors.toMap(ParkProviderDO::getId, Function.identity()));

        List<ParkEnterpriseDistributorDO> distributors = parkEnterpriseDistributorService.listDistributors();
        Map<Integer, ParkEnterpriseDistributorDO> distributorMap = distributors.stream()
                .collect(Collectors.toMap(ParkEnterpriseDistributorDO::getId, Function.identity()));

        List<ParkEnterpriseCustomerDO> parkEnterpriseCustomers = parkEnterpriseCustomerDao.list();
        Map<Integer, ParkEnterpriseCustomerDO> enterpriseCustomerMap = parkEnterpriseCustomers.stream()
                .collect(Collectors.toMap(ParkEnterpriseCustomerDO::getId, Function.identity()));

        for (ParkEnterpriseDO parkEnterprise : parkEnterprises) {
            try {
                doGenerateEnterpriseMonthReport(
                        buildGenMonthReportBo(
                                providerMap.get(parkEnterprise.getParkProviderId()),
                                parkEnterprise,
                                distributorMap.get(parkEnterprise.getDistributorId()),
                                enterpriseCustomerMap.get(parkEnterprise.getCustomerId()),
                                monthBegin, monthEnd
                        )
                );
            } catch (Exception e) {
                logger.error("生成月报出错, enterpriseId:{} errorMsg:{}", parkEnterprise.getEnterpriseId(), e.getMessage(), e);
            }
        }
        generateParkProviderMonthReport(parkProviders, monthBegin);
        generateDistributorMonthReport(distributors, monthBegin);
    }

    private GenMonthReportBo buildGenMonthReportBo(ParkProviderDO parkProvider, ParkEnterpriseDO parkEnterprise,
                                                   ParkEnterpriseDistributorDO parkDistributor, ParkEnterpriseCustomerDO parkCustomer,
                                                   LocalDateTime lastMonthBegin, LocalDateTime lastMonthEnd){
        return new GenMonthReportBo()
                .setParkProvider(parkProvider)
                .setParkEnterprise(parkEnterprise)
                .setParkDistributor(parkDistributor)
                .setParkCustomer(parkCustomer)
                .setLastMonthBegin(lastMonthBegin)
                .setLastMonthEnd(lastMonthEnd);
    }

    /**
     * 生成渠道商月报
     */
    private void generateDistributorMonthReport(List<ParkEnterpriseDistributorDO> distributors,
                                                LocalDateTime monthAt) {
        if (CollectionUtils.isEmpty(distributors)) {
            return;
        }

        List<Integer> distributorIds = distributors.stream()
                .map(ParkEnterpriseDistributorDO::getId)
                .toList();

        String month = DateUtil.getNormalMonth(monthAt);
        List<DistributorReportDO> parkProviderReports = parkEnterpriseReportService.listDistributorsReports(month,
                distributorIds);
        if (CollectionUtils.isEmpty(parkProviderReports)) {
            return;
        }
        LocalDateTime now = DateUtil.nowTime();
        parkProviderReports.forEach(x -> {
            x.setCreateTime(now);
            x.setUpdateTime(now);
        });
        distributorReportService.saveReports(parkProviderReports);
    }


    /**
     * 生成园区服务商月报
     */
    private void generateParkProviderMonthReport(List<ParkProviderDO> parkProviders,
                                                 LocalDateTime monthAt) {
        if (CollectionUtils.isEmpty(parkProviders)) {
            return;
        }
        List<Integer> providerIds = parkProviders.stream()
                .map(ParkProviderDO::getId)
                .toList();

        String month = DateUtil.getNormalMonth(monthAt);
        List<ParkProviderReportDO> parkProviderReports = parkEnterpriseReportService.listParkProvidersReports(month,
                providerIds);
        if (CollectionUtils.isEmpty(parkProviderReports)) {
            return;
        }
        LocalDateTime now = DateUtil.nowTime();
        parkProviderReports.forEach(x -> {
            x.setCreateTime(now);
            x.setUpdateTime(now);
        });
        parkProviderReportService.saveReports(parkProviderReports);
    }


    /**
     * @param genMonthReportBo  生成月报入参
     */
    private void doGenerateEnterpriseMonthReport(GenMonthReportBo genMonthReportBo) {
        // 聚合上月开票额, 按月分组
        List<ParkEnterpriseReportBO> parkEnterpriseReports = invoiceDao.summaryMonthFee(
                genMonthReportBo.getParkEnterprise().getOrgId(),
                genMonthReportBo.getParkEnterprise().getEnterpriseId(),
                genMonthReportBo.getLastMonthBegin(), genMonthReportBo.getLastMonthEnd());
        // 每个企业的上月报表 组装参数
        buildEnterpriseMonthReports(genMonthReportBo, parkEnterpriseReports);
        for (var enterpriseMonthReport : parkEnterpriseReports) {
            // 计算园区税、费
            computeTaxService.computeParkProviderTaxFee(genMonthReportBo, enterpriseMonthReport);
        }
        // 保存报告
        batchInsertReport(parkEnterpriseReports);
    }

    private void batchInsertReport(List<ParkEnterpriseReportBO> parkEnterpriseReports) {
        List<ParkEnterpriseReportDO> reportDOS = parkEnterpriseReports.stream()
                .map(this::toReportDO)
                .collect(Collectors.toList());
        parkEnterpriseReportService.batchInsert(reportDOS);
    }

    private void buildEnterpriseMonthReports(GenMonthReportBo genMonthReportBo, List<ParkEnterpriseReportBO> parkEnterpriseReports) {
        // 如果当前企业发票为空，构造一条 为 0 的月报
        if (CollectionUtils.isEmpty(parkEnterpriseReports)) {
            parkEnterpriseReports.add(new ParkEnterpriseReportBO()
                    .setEnterpriseId(genMonthReportBo.getParkEnterprise().getEnterpriseId())
                    .setMonth(DateUtil.toDateSting(genMonthReportBo.getLastMonthBegin()))
                    .setInvoiceTotal(BigDecimal.ZERO)
                    .setInvoiceTotalAmount(BigDecimal.ZERO)
                    .setServiceFee(BigDecimal.ZERO)
                    .setInvoiceTotalTax(BigDecimal.ZERO));
        }
        // 补充月报上的基本信息
        parkEnterpriseReports.forEach(x -> {
            x.setOrgId(genMonthReportBo.getParkEnterprise().getOrgId());
            x.setEnterpriseName(genMonthReportBo.getParkEnterprise().getEnterpriseName());
            x.setMonth(x.getMonth().substring(0, 7));
            x.setCustomer(Objects.isNull(genMonthReportBo.getParkCustomer()) ? StringUtils.EMPTY : genMonthReportBo.getParkCustomer().getName());
            x.setCustomerManager(genMonthReportBo.getParkEnterprise().getCustomerManager());
            x.setParkProviderId(Objects.isNull(genMonthReportBo.getParkProvider()) ? null : genMonthReportBo.getParkProvider().getId());
            x.setParkProviderName(Objects.isNull(genMonthReportBo.getParkProvider()) ? null : genMonthReportBo.getParkProvider().getName());
        });
    }

    private ParkEnterpriseReportDO toReportDO(ParkEnterpriseReportBO r) {
        LocalDateTime now = DateUtil.nowTime();
        return new ParkEnterpriseReportDO()
                .setOrgId(r.getOrgId())
                .setEnterpriseId(r.getEnterpriseId())
                .setEnterpriseName(r.getEnterpriseName())
                .setMonth(r.getMonth())
                .setInvoiceTotal(r.getInvoiceTotal())
                .setInvoiceTotalAmount(r.getInvoiceTotalAmount())
                .setInvoiceTotalTax(r.getInvoiceTotalTax())
                .setServiceFee(r.getServiceFee())
                .setCustomer(r.getCustomer())
                .setCustomerManager(r.getCustomerManager())
                .setParkProviderId(r.getParkProviderId())
                .setParkProviderName(r.getParkProviderName())
                .setParkProviderAmount(r.getParkProviderAmount())
                .setParkProviderFee(r.getParkProviderFee())
                .setParkProviderTotalTax(r.getParkProviderTotalTax())
                .setParkEnterpriseDistributorId(r.getParkEnterpriseDistributorId())
                .setParkEnterpriseDistributorName(r.getParkEnterpriseDistributorName())
                .setParkEnterpriseDistributorFee(r.getParkEnterpriseDistributorFee())
                .setParkProviderValueAddedTax(r.getParkProviderValueAddedTax())
                .setParkProviderAdditionalTax(r.getParkProviderAdditionalTax())
                .setParkProviderWaterTax(r.getParkProviderWaterTax())
                .setParkProviderStampTax(r.getParkProviderStampTax())
                .setParkProviderIncomeTax(r.getParkProviderIncomeTax())
                .setCreateTime(now)
                .setUpdateTime(now);
    }

}
