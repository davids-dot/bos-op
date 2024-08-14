package com.luoge.bos.invoice.report.provider;

import com.luoge.bos.core.model.PageQuery;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.core.utils.Numbers;
import com.luoge.bos.invoice.report.enterprise.ParkEnterpriseReportDao;
import com.luoge.bos.invoice.entity.ParkEnterpriseReportDO;
import com.luoge.bos.invoice.entity.ParkProviderReportDO;
import com.luoge.bos.invoice.model.report.ListParkProviderMonthReportBO;
import com.luoge.bos.invoice.model.report.ParkProviderMonthReportBO;
import com.luoge.bos.invoice.model.report.ParkProviderMonthReportDetailBO;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkProviderReportService {

    @Resource
    private ParkProviderReportDao parkProviderReportDao;
    @Resource
    private ParkEnterpriseReportDao parkEnterpriseReportDao;

    public R<Page<ParkProviderMonthReportBO>> listParkProviderMonthReport(ListParkProviderMonthReportBO listReportBO,
                                                                          PageQuery pageQuery) {
        List<String> months = DateUtil.monthList(listReportBO.getStartMonth(), listReportBO.getEndMonth())
                .stream()
                .map(DateUtil::getNormalMonth)
                .toList();

        var providerReports = parkProviderReportDao.listByName(listReportBO.getProviderId(), months,
                pageQuery.getPageNo(), pageQuery.getPageSize());

        List<ParkProviderMonthReportBO> reportList = providerReports.stream()
                .map(this::toParkProviderMonthReportBO)
                .toList();

        return R.success(new Page<>(providerReports.getTotal(), reportList));
    }

    public List<ParkProviderMonthReportBO> listParkProviderMonthReport(ListParkProviderMonthReportBO listReportBO) {

        List<String> months = DateUtil.monthList(listReportBO.getStartMonth(), listReportBO.getEndMonth())
                .stream()
                .map(DateUtil::getNormalMonth)
                .toList();

        List<ParkProviderReportDO> parkProviderReports = parkProviderReportDao.list(listReportBO.getProviderId(), months);
        return parkProviderReports.stream()
                .map(this::toParkProviderMonthReportBO)
                .toList();
    }

    public R<Page<ParkProviderMonthReportDetailBO>> listReportDetail(int providerId, String month, PageQuery pageQuery) {
        var parkEnterpriseReports = parkEnterpriseReportDao.listProviderMonthReportDetailByPage(providerId, month,
                pageQuery.getPageNo(), pageQuery.getPageSize());

        List<ParkProviderMonthReportDetailBO> detailList = parkEnterpriseReports.stream()
                .map(this::toParkProviderMonthReportDetailBO)
                .toList();

        return R.success(new Page<>(parkEnterpriseReports.getTotal(), detailList));
    }

    public List<ParkProviderMonthReportDetailBO> listReportDetail(int providerId, String month) {
        var parkEnterpriseReports = parkEnterpriseReportDao.listProviderMonthReportDetail(providerId, month);
        return parkEnterpriseReports.stream()
                .map(this::toParkProviderMonthReportDetailBO)
                .toList();
    }

    private ParkProviderMonthReportBO toParkProviderMonthReportBO(ParkProviderReportDO r) {
        return new ParkProviderMonthReportBO()
                .setParkProviderId(r.getParkProviderId())
                .setParkProviderName(r.getParkProviderName())
                .setMonth(r.getMonth())

                .setParkProviderValueAddedTax(Numbers.toString(r.getParkProviderValueAddedTax()))
                .setParkProviderAdditionalTax(Numbers.toString(r.getParkProviderAdditionalTax()))
                .setParkProviderWaterTax(Numbers.toString(r.getParkProviderWaterTax()))
                .setParkProviderStampTax(Numbers.toString(r.getParkProviderStampTax()))
                .setParkProviderIncomeTax(Numbers.toString(r.getParkProviderIncomeTax()))
                .setParkProviderTotalTax(Numbers.toString(r.getParkProviderTotalTax()))

                .setParkProviderFee(Numbers.toString(r.getParkProviderFee()))
                .setTotal(Numbers.toString(
                        Numbers.add(
                                r.getParkProviderFee(),
                                r.getParkProviderTotalTax()
                        )
                ));
    }


    private ParkProviderMonthReportDetailBO toParkProviderMonthReportDetailBO(ParkEnterpriseReportDO r) {
        return new ParkProviderMonthReportDetailBO()

                .setEnterpriseId(r.getEnterpriseId())
                .setEnterpriseName(r.getEnterpriseName())
                .setMonth(r.getMonth())

                .setParkProviderValueAddedTax(Numbers.toString(r.getParkProviderValueAddedTax()))
                .setParkProviderAdditionalTax(Numbers.toString(r.getParkProviderAdditionalTax()))
                .setParkProviderWaterTax(Numbers.toString(r.getParkProviderWaterTax()))
                .setParkProviderStampTax(Numbers.toString(r.getParkProviderStampTax()))
                .setParkProviderIncomeTax(Numbers.toString(r.getParkProviderIncomeTax()))
                .setParkProviderTotalTax(Numbers.toString(r.getParkProviderTotalTax()))
                .setParkProviderFee(Numbers.toString(r.getParkProviderFee()))
                .setTotal(
                        Numbers.toString(
                                Numbers.add(
                                        r.getParkProviderFee(),
                                        r.getParkProviderTotalTax()
                                )
                        )
                );

    }

    public void saveReports(List<ParkProviderReportDO> parkProviderReports) {
        parkProviderReportDao.batchInsertOnConflictUpdate(parkProviderReports);
    }
}
