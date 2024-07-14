package com.luoge.bos.op.invoice.report.distributor;

import com.luoge.bos.op.core.model.PageQuery;
import com.luoge.bos.op.core.utils.DateUtil;
import com.luoge.bos.op.core.utils.Numbers;
import com.luoge.bos.op.invoice.entity.DistributorReportDO;
import com.luoge.bos.op.invoice.entity.ParkEnterpriseReportDO;
import com.luoge.bos.op.invoice.model.report.DistributorMonthReportBO;
import com.luoge.bos.op.invoice.model.report.DistributorMonthReportDetailBO;
import com.luoge.bos.op.invoice.model.report.ListDistributorMonthReportBO;
import com.luoge.bos.op.invoice.report.enterprise.ParkEnterpriseReportDao;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributorReportService {

    @Resource
    private DistributorReportDao distributorReportDao;
    @Resource
    private ParkEnterpriseReportDao parkEnterpriseReportDao;

    public R<Page<DistributorMonthReportBO>> listDistributorMonthReport(ListDistributorMonthReportBO listReportBO, PageQuery pageQuery) {
        List<String> months = DateUtil.monthList(listReportBO.getStartMonth(), listReportBO.getEndMonth())
                .stream()
                .map(DateUtil::getNormalMonth)
                .toList();

        var distributorReports = distributorReportDao.listByPage(listReportBO.getDistributorId(), months,
                pageQuery.getPageNo(), pageQuery.getPageSize());

        List<DistributorMonthReportBO> reportList = distributorReports.stream()
                .map(this::toDistributorMonthReportBO)
                .toList();

        return R.success(new Page<>(distributorReports.getTotal(), reportList));
    }


    public List<DistributorMonthReportBO> listDistributorMonthReport(ListDistributorMonthReportBO listReportBO) {
        List<String> months = DateUtil.monthList(listReportBO.getStartMonth(), listReportBO.getEndMonth())
                .stream()
                .map(DateUtil::getNormalMonth)
                .toList();

        List<DistributorReportDO> distributorReports = distributorReportDao.list(listReportBO.getDistributorId(), months);
        return distributorReports.stream()
                .map(this::toDistributorMonthReportBO)
                .toList();
    }

    public R<Page<DistributorMonthReportDetailBO>> listReportDetail(int distributorId, String month, PageQuery pageQuery) {
        var parkEnterpriseReports = parkEnterpriseReportDao.listDistributorMonthReportDetailByPage(distributorId, month,
                pageQuery.getPageNo(), pageQuery.getPageSize());

        List<DistributorMonthReportDetailBO> detailList = parkEnterpriseReports.stream()
                .map(this::toDistributorMonthReportDetailBO)
                .toList();

        return R.success(new Page<>(parkEnterpriseReports.getTotal(), detailList));
    }

    public List<DistributorMonthReportDetailBO> listReportDetail(int distributorId, String month) {
        var parkEnterpriseReports = parkEnterpriseReportDao.listDistributorMonthReportDetail(distributorId, month);

        return parkEnterpriseReports.stream()
                .map(this::toDistributorMonthReportDetailBO)
                .toList();
    }

    private DistributorMonthReportBO toDistributorMonthReportBO(DistributorReportDO r) {
        return new DistributorMonthReportBO()
                .setDistributorId(r.getParkEnterpriseDistributorId())
                .setDistributorName(r.getParkEnterpriseDistributorName())
                .setMonth(r.getMonth())
                .setTotalAmount(Numbers.toString(r.getTotalAmount()))
                .setTotalFee(Numbers.toString(r.getTotalFee()));
    }

    private DistributorMonthReportDetailBO toDistributorMonthReportDetailBO(ParkEnterpriseReportDO r) {
        return new DistributorMonthReportDetailBO()
                .setEnterpriseId(r.getEnterpriseId())
                .setEnterpriseName(r.getEnterpriseName())
                .setTotalAmount(Numbers.toString(r.getInvoiceTotal()))
                .setTotalFee(Numbers.toString(r.getParkEnterpriseDistributorFee()));
    }

    public void saveReports(List<DistributorReportDO> parkProviderReports) {
        distributorReportDao.batchInsertOnConflictUpdate(parkProviderReports);
    }


}
