package com.luoge.bos.op.invoice.collect.schedule;

import com.luoge.bos.op.core.BosAppCode;
import com.luoge.bos.op.core.types.InvoiceSourceType;
import com.luoge.bos.op.core.utils.DateUtil;
import com.luoge.bos.op.core.utils.Numbers;
import com.luoge.bos.op.invoice.apply.NsInvoiceOutItemDao;
import com.luoge.bos.op.invoice.collect.manual.InvoiceDao;
import com.luoge.bos.op.invoice.entity.InvSyncRecordDO;
import com.luoge.bos.op.invoice.entity.InvoiceDO;
import com.luoge.bos.op.invoice.entity.InvoiceOutDO;
import com.luoge.bos.op.invoice.entity.ParkEnterpriseDO;
import com.luoge.bos.op.invoice.entity.invoice.InvoiceOutItemDO;
import com.luoge.bos.op.invoice.model.collect.SeasonSummaryDailyBO;
import com.luoge.bos.op.invoice.model.collect.YearSummaryDailyBO;
import com.luoge.bos.op.invoice.model.collect.sync.EnterpriseDailyInvoiceBaseData;
import com.luoge.bos.op.invoice.model.park.enterprise.ParkEnterpriseFeeBO;
import com.luoge.bos.op.invoice.park.enterprise.ParkEnterpriseService;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 同步发票信息到bos
 */
@Service
public class SyncInvoiceTask {
    private static final Logger logger = LoggerFactory.getLogger(SyncInvoiceTask.class);

    @Resource
    private ParkEnterpriseService parkEnterpriseService;
    @Resource
    private NsInvoiceOutDao nsInvoiceOutDao;
    @Resource
    private NsInvoiceOutItemDao nsInvoiceOutItemDao;
    @Resource
    private InvoiceDao invoiceDao;
    @Resource
    private InvSyncRecordDao invSyncRecordDao;
    @Resource
    private ComputeTaxService computeTaxService;


    /**
     * 单次数据库最多操作1000 条数据
     */
    private static final int BATCH_SIZE = 1000;

    @Scheduled(cron = "0 0 2 * * *") // 每天2点
    public void syncInvoiceDaily() {
        logger.info("sync daily invoice start");
        // 上月时间
        InvSyncRecordDO syncRecord = invSyncRecordDao.getSyncRecord();
        LocalDateTime startTime = syncRecord.getLastSyncTime();
        LocalDateTime endTime = DateUtil.atBeginOfDay(DateUtil.nowTime());
        syncInvoiceByTimeRange(startTime, endTime);
        computeInvoiceByTimeRange(startTime, endTime);
        invSyncRecordDao.updateSyncTime(endTime, DateUtil.nowTime());
    }

    /**
     * 同步企业 指定时间范围内开具 的发票
     *
     * @param parkEnterprise 企业
     * @param startTime      开始时间
     * @param endTime        结束时间
     */
    private void doSyncInvoice(ParkEnterpriseDO parkEnterprise, LocalDateTime startTime, LocalDateTime endTime) {
        Integer orgId = parkEnterprise.getOrgId();
        Integer enterpriseId = parkEnterprise.getEnterpriseId();
        // 查询总数
        int invoiceCount = nsInvoiceOutDao.countInvoice(orgId,
                enterpriseId, startTime, endTime);

        // 分页处理数据
        int offset = 0;
        while (offset < invoiceCount) {
            syncPageData(orgId, enterpriseId, parkEnterprise.getServiceFeeRate(), parkEnterprise.getEnterpriseName(),
                    startTime, endTime, offset);
            offset += BATCH_SIZE;
        }
    }

    /**
     * 重算补录发票的归属收入
     */
    private void recomputeTodayInvoice(Integer orgId,
                                       Integer enterpriseId,
                                       LocalDateTime startTime,
                                       LocalDateTime endTime,
                                       EnterpriseDailyInvoiceBaseData enterpriseBaseData,
                                       int offset) {
        List<InvoiceDO> toComputeInvoices = invoiceDao.listTodayInvoices(orgId, enterpriseId, startTime, endTime, offset, BATCH_SIZE);
        if (CollectionUtils.isEmpty(toComputeInvoices)) {
            return;
        }
        LocalDateTime now = DateUtil.nowTime();
        for (InvoiceDO invoice : toComputeInvoices) {
            computeTaxService.computeInvoiceIncome(invoice, enterpriseBaseData.getParkEnterpriseFeeRate(),
                    enterpriseBaseData.getSeasonSummaryDailyBO(),
                    enterpriseBaseData.getYearSummaryDailyBO());
            invoice.setUpdateTime(now);
        }
        invoiceDao.batchUpdate(toComputeInvoices);
    }

    /**
     * @param orgId        机构id
     * @param enterpriseId 企业id
     * @param startTime    本日 开始时间
     */
    private EnterpriseDailyInvoiceBaseData computeEnterpriseBaseData(Integer orgId,
                                                                     Integer enterpriseId,
                                                                     LocalDateTime startTime) {
        ParkEnterpriseFeeBO parkEnterpriseFeeRate = parkEnterpriseService.getParkEnterpriseFeeRate(enterpriseId);
        // 获取季度首日
        LocalDateTime seasonStartTime = DateUtil.atBeginOfSeason(startTime);
        // 统计季度 税 信息
        SeasonSummaryDailyBO seasonSummary = invoiceDao.summarySeasonDaily(orgId, enterpriseId, seasonStartTime, startTime);
        if (Objects.isNull(seasonSummary)) {
            seasonSummary = SeasonSummaryDailyBO.emptySummary().setEnterpriseId(enterpriseId);
        }

        // 获取年度首日
        LocalDateTime yearStartTime = DateUtil.atBeginOfYear(startTime);
        // 统计 年度 缴纳个税额度
        YearSummaryDailyBO yearSummary = invoiceDao.summaryYearDaily(orgId, enterpriseId, yearStartTime, startTime);
        if (Objects.isNull(yearSummary)) {
            yearSummary = new YearSummaryDailyBO()
                    .setEnterpriseId(enterpriseId)
                    .setIssueAmount(BigDecimal.ZERO)
                    .setIncomeTax(BigDecimal.ZERO);
        }

        return new EnterpriseDailyInvoiceBaseData()
                .setParkEnterpriseFeeRate(parkEnterpriseFeeRate)
                .setSeasonSummaryDailyBO(seasonSummary)
                .setYearSummaryDailyBO(yearSummary);
    }

    private void syncPageData(Integer orgId, Integer enterpriseId, BigDecimal serviceFeeRate,
                              String enterpriseName, LocalDateTime startTime, LocalDateTime endTime, int offset) {
        List<InvoiceOutDO> nsInvoices = nsInvoiceOutDao.listByPage(orgId, enterpriseId, startTime, endTime, offset, BATCH_SIZE);
        if (CollectionUtils.isEmpty(nsInvoices)) {
            return;
        }
        Map<Long, BigDecimal> invoiceTaxRateMap = getInvoiceTaxRateMap(orgId, nsInvoices);
        LocalDateTime now = DateUtil.nowTime();
        List<InvoiceDO> invoices = nsInvoices.stream()
                .map(x -> toInvoiceDO(x, enterpriseName, serviceFeeRate, now, invoiceTaxRateMap))
                .toList();
        invoiceDao.batchInsertOrIgnore(invoices);
    }

    /**
     * 查询发票税率
     * @desc PRD->V1.5.8_B表业务统计优化
     */
    private Map<Long, BigDecimal> getInvoiceTaxRateMap(Integer orgId, List<InvoiceOutDO> nsInvoices) {
        List<Long> invoiceIds = nsInvoices.stream().map(InvoiceOutDO::getId).distinct().collect(Collectors.toList());
        List<InvoiceOutItemDO> invoiceOutItems = nsInvoiceOutItemDao.selectByInvoiceIds(orgId, invoiceIds);
        return invoiceOutItems.
                stream().
                collect(Collectors.groupingBy(InvoiceOutItemDO::getInvoiceId, Collectors.collectingAndThen(Collectors.toList(), value -> value.getFirst().getTaxRate())));
    }

    private InvoiceDO toInvoiceDO(InvoiceOutDO invoiceOutDO,
                                  String enterpriseName,
                                  BigDecimal serviceFeeRate,
                                  LocalDateTime now,
                                  Map<Long, BigDecimal> invoiceTaxRateMap) {
        return new InvoiceDO()
                .setId(invoiceOutDO.getId())
                .setOrgId(invoiceOutDO.getOrgId())
                .setEnterpriseId(invoiceOutDO.getEnterpriseId())
                .setType(invoiceOutDO.getInvoiceType())
                .setCategory(invoiceOutDO.getCategory())
                .setInvoiceNo(invoiceOutDO.getInvoiceNo())
                .setInvoiceCode(invoiceOutDO.getInvoiceCode())
                .setBuyerName(invoiceOutDO.getBuyerName())
                .setIssueTime(invoiceOutDO.getIssueTime())
                .setTotalAmount(invoiceOutDO.getTotalAmount())
                .setTotalTax(invoiceOutDO.getTotalTax())
                .setTotal(invoiceOutDO.getTotal())
                // 服务费
                .setServiceFeeRate(serviceFeeRate)
                .setServiceFee(Numbers.mul(invoiceOutDO.getTotal(), serviceFeeRate))

                .setSourceType(InvoiceSourceType.SYNC.type)
                .setParkEnterpriseId(invoiceOutDO.getEnterpriseId())
                .setParkEnterpriseName(enterpriseName)
                .setInvoiceTaxRate(invoiceTaxRateMap.getOrDefault(invoiceOutDO.getId(), null))
                .setBusinessId(invoiceOutDO.getBusinessId())
                .setCreateTime(now)
                .setUpdateTime(now);
    }


    public void syncInvoiceByTimeRange(LocalDateTime startTime, LocalDateTime endTime) {
        // 查询企业列表，按企业分别同步数据
        List<ParkEnterpriseDO> parkEnterprises = parkEnterpriseService.listParkEnterprises();
        if (CollectionUtils.isEmpty(parkEnterprises)) {
            logger.info("park enterprise is empty");
            return;
        }
        for (ParkEnterpriseDO parkEnterprise : parkEnterprises) {
            doSyncInvoice(parkEnterprise, startTime, endTime);
        }
    }

    public void computeInvoiceByTimeRange(LocalDateTime startTime, LocalDateTime endTime) {
        // 查询企业列表，按企业分别同步数据
        List<ParkEnterpriseDO> parkEnterprises = parkEnterpriseService.listParkEnterprises();
        if (CollectionUtils.isEmpty(parkEnterprises)) {
            logger.info("park enterprise is empty");
            return;
        }
        for (ParkEnterpriseDO parkEnterprise : parkEnterprises) {
            doComputeInvoice(parkEnterprise, startTime, endTime);
        }
    }

    private void syncAndComputeInvoice(ParkEnterpriseDO parkEnterprise, LocalDateTime startTime, LocalDateTime endTime) {
        doSyncInvoice(parkEnterprise, startTime, endTime);
        doComputeInvoice(parkEnterprise, startTime, endTime);
    }

    private void doComputeInvoice(ParkEnterpriseDO parkEnterprise, LocalDateTime startTime, LocalDateTime endTime) {
        Integer orgId = parkEnterprise.getOrgId();
        Integer enterpriseId = parkEnterprise.getEnterpriseId();

        EnterpriseDailyInvoiceBaseData enterpriseBaseData = computeEnterpriseBaseData(orgId, enterpriseId, startTime);
        // 查询总数
        int invoiceCount = invoiceDao.countToComputeInvoice(orgId,
                enterpriseId, startTime, endTime);

        // 分页处理数据
        int offset = 0;
        while (offset < invoiceCount) {
            recomputeTodayInvoice(orgId, enterpriseId, startTime, endTime, enterpriseBaseData, offset);
            offset += BATCH_SIZE;
        }
    }

    public R<Void> syncInvoiceByTimeRange(LocalDateTime startTime, LocalDateTime endTime, Integer enterpriseId) {
        if (Objects.isNull(enterpriseId)) {
            syncInvoiceByTimeRange(startTime, endTime);
            computeInvoiceByTimeRange(startTime, endTime);
        } else {
            ParkEnterpriseDO parkEnterprise = parkEnterpriseService.getParkEnterprise(enterpriseId);
            if (Objects.isNull(parkEnterprise)) {
                return R.fail(BosAppCode.PARK_ENTERPRISE_NOT_EXIST);
            }
            syncAndComputeInvoice(parkEnterprise, startTime, endTime);
        }
        return R.SUCCESS;
    }

    public void clearInvoicesIncome(Integer enterpriseId, LocalDateTime startTime, LocalDateTime endTime) {
        invoiceDao.clearInvoicesIncome(enterpriseId, startTime, endTime, DateUtil.nowTime());
    }
}
