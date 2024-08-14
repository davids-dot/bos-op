package com.luoge.bos.invoice.report.enterprise;

import com.luoge.bos.core.model.PageQuery;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.core.utils.Numbers;
import com.luoge.bos.invoice.collect.manual.InvoiceDao;
import com.luoge.bos.invoice.util.OpModelConverter;
import com.luoge.bos.invoice.entity.DistributorReportDO;
import com.luoge.bos.invoice.entity.ParkEnterpriseReportDO;
import com.luoge.bos.invoice.entity.ParkProviderReportDO;
import com.luoge.bos.invoice.model.collect.InvoiceBO;
import com.luoge.bos.invoice.model.report.EnterpriseMonthReportBO;
import com.luoge.bos.invoice.model.report.ListEnterpriseMonthReportBO;
import com.luoge.bos.invoice.model.report.SummaryEnterpriseReportBO;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ParkEnterpriseReportService {
    @Resource
    private ParkEnterpriseReportDao parkEnterpriseReportDao;
    @Resource
    private InvoiceDao invoiceDao;


    public void batchInsert(List<ParkEnterpriseReportDO> parkEnterpriseReports) {
        parkEnterpriseReportDao.batchInsertOnConflictUpdate(parkEnterpriseReports);
    }

    public R<Page<EnterpriseMonthReportBO>> listEnterpriseReport(ListEnterpriseMonthReportBO listReportBO, PageQuery pageQuery) {
        List<String> months = DateUtil.monthList(listReportBO.getStartMonth(), listReportBO.getEndMonth())
                .stream()
                .map(DateUtil::getNormalMonth)
                .toList();

        var reports = parkEnterpriseReportDao.listEnterpriseReportByPage(listReportBO.getProviderId(), listReportBO.getEnterpriseName(),
                listReportBO.getCustomerManager(), listReportBO.getCustomer(),
                listReportBO.getDistributorName(), months, pageQuery.getPageNo(), pageQuery.getPageSize());

        List<EnterpriseMonthReportBO> results = reports.stream()
                .map(this::toEnterpriseMonthReportBO)
                .toList();

        return R.success(new Page<>(reports.getTotal(), results));
    }

    public List<EnterpriseMonthReportBO> listEnterpriseReport(ListEnterpriseMonthReportBO listReportBO) {
        List<String> months = DateUtil.monthList(listReportBO.getStartMonth(), listReportBO.getEndMonth())
                .stream()
                .map(DateUtil::getNormalMonth)
                .toList();

        var reports = parkEnterpriseReportDao.listEnterpriseReport(listReportBO.getProviderId(), listReportBO.getEnterpriseName(),
                listReportBO.getCustomerManager(), listReportBO.getCustomer(),
                listReportBO.getDistributorName(), months);

        return reports.stream()
                .map(this::toEnterpriseMonthReportBO)
                .toList();
    }

    public SummaryEnterpriseReportBO summaryEnterpriseReport(ListEnterpriseMonthReportBO listReportBO) {
        List<String> months = DateUtil.monthList(listReportBO.getStartMonth(), listReportBO.getEndMonth())
                .stream()
                .map(DateUtil::getNormalMonth)
                .toList();

        SummaryEnterpriseReportBO summary = parkEnterpriseReportDao.summaryEnterpriseReport(listReportBO.getProviderId(), listReportBO.getEnterpriseName(),
                listReportBO.getCustomerManager(), listReportBO.getCustomer(),
                listReportBO.getDistributorName(), months);

        if (Objects.isNull(summary)) {
            return SummaryEnterpriseReportBO.EMPTY_SUMMARY;
        }

        summary.setIncome(
                Numbers.add(summary.getServiceFee(), summary.getProviderAmount().negate(), summary.getDistributorAmount().negate())
        );
        return summary;
    }

    private EnterpriseMonthReportBO toEnterpriseMonthReportBO(ParkEnterpriseReportDO r) {
        BigDecimal serviceFee = Objects.isNull(r.getServiceFee()) ? BigDecimal.ZERO : r.getServiceFee();
        return new EnterpriseMonthReportBO()
                .setEnterpriseId(r.getEnterpriseId())
                .setEnterpriseName(r.getEnterpriseName())
                .setMonth(r.getMonth())
                .setInvoiceTotalAmount(Numbers.toString(r.getInvoiceTotal()))
                .setServiceFee(Numbers.toString(serviceFee))
                .setCustomer(r.getCustomer())
                .setCustomerManager(r.getCustomerManager())
                .setParkProviderId(r.getParkProviderId())
                .setParkProviderName(r.getParkProviderName())
                .setParkProviderAmount(Numbers.toString(r.getParkProviderAmount()))
                .setDistributorId(r.getParkEnterpriseDistributorId())
                .setDistributorName(r.getParkEnterpriseDistributorName())
                .setDistributorFee(Numbers.toString(r.getParkEnterpriseDistributorFee()))
                .setIncome(
                        Numbers.toString(
                        serviceFee.subtract(r.getParkProviderAmount()).subtract(r.getParkEnterpriseDistributorFee())
                ));
    }

    public R<Page<InvoiceBO>> listEnterpriseReportDetail(int enterpriseId,
                                                         String month,
                                                         PageQuery pageQuery) {
        LocalDateTime monthBegin = DateUtil.toLocalDateTimeFromMonthStr(month);
        LocalDateTime monthEnd = monthBegin.plusMonths(1);

        var invoices = invoiceDao.listEnterpriseInvoicesByPage(enterpriseId, monthBegin, monthEnd,
                pageQuery.getPageNo(), pageQuery.getPageSize());

        List<InvoiceBO> results = invoices.stream()
                .map(OpModelConverter::toInvoiceBO)
                .collect(Collectors.toList());

        return R.success(new Page<>(invoices.getTotal(), results));
    }

    public List<InvoiceBO> listEnterpriseReportDetail(int enterpriseId, String month) {
        LocalDateTime monthBegin = DateUtil.toLocalDateTimeFromMonthStr(month);
        LocalDateTime monthEnd = monthBegin.plusMonths(1);

        var invoices = invoiceDao.listEnterpriseInvoices(enterpriseId, monthBegin, monthEnd);
        return invoices.stream()
                .map(OpModelConverter::toInvoiceBO)
                .collect(Collectors.toList());
    }

    /**
     * 园区服务商报表
     */
    public List<ParkProviderReportDO> listParkProvidersReports(String month, List<Integer> providerIds) {
        return parkEnterpriseReportDao.listParkProvidersReports(month, providerIds);
    }

    /**
     * 渠道商报表
     */
    public List<DistributorReportDO> listDistributorsReports(String month, List<Integer> distributorIds) {
        return parkEnterpriseReportDao.listDistributorsReports(month, distributorIds);
    }


}
