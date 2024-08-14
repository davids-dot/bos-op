package com.luoge.bos.invoice.query;

import com.luoge.bos.core.model.PageQuery;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.invoice.collect.manual.InvoiceDao;
import com.luoge.bos.invoice.entity.InvoiceDO;
import com.luoge.bos.invoice.park.enterprise.ParkEnterpriseDao;
import com.luoge.bos.invoice.util.OpModelConverter;
import com.luoge.bos.invoice.model.collect.InvoiceBO;
import com.luoge.bos.invoice.model.query.EnterpriseFeeBO;
import com.luoge.bos.invoice.model.query.EnterpriseInvoiceSummaryBO;
import com.luoge.bos.invoice.model.query.ListEnterpriseFeeBO;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class EnterpriseFeeService {
    @Resource
    private InvoiceDao invoiceDao;
    @Resource
    private ParkEnterpriseDao parkEnterpriseDao;

    public R<Page<EnterpriseFeeBO>> listEnterpriseFee(ListEnterpriseFeeBO listEnterpriseFeeBO, PageQuery pageQuery) {
        LocalDateTime startTime = DateUtil.toLocalDateTime(listEnterpriseFeeBO.getStartTime());
        LocalDateTime endTime = DateUtil.toLocalDateTime(listEnterpriseFeeBO.getEndTime());

        var enterprises = parkEnterpriseDao.listEnterpriseForFee(listEnterpriseFeeBO.getName(),
                listEnterpriseFeeBO.getProviderId(), listEnterpriseFeeBO.getDistributorId(),
                pageQuery.getPageNo(), pageQuery.getPageSize());

        List<Integer> enterpriseIds = enterprises.stream()
                .map(EnterpriseFeeBO::getEnterpriseId)
                .toList();

        List<EnterpriseFeeBO> enterpriseFees = invoiceDao.sumEnterpriseFee(startTime, endTime, enterpriseIds);
        Map<Integer, EnterpriseFeeBO> enterpriseMap = enterpriseFees.stream()
                .collect(Collectors.toMap(EnterpriseFeeBO::getEnterpriseId, Function.identity()));

        enterprises.forEach(x -> {
            setAmount(x, enterpriseMap);
            x.setStartTime(listEnterpriseFeeBO.getStartTime());
            x.setEndTime(listEnterpriseFeeBO.getEndTime());
        });

        return R.success(new Page<>(enterprises.getTotal(), enterprises));
    }

    public List<EnterpriseFeeBO> listEnterpriseFee(ListEnterpriseFeeBO listEnterpriseFeeBO) {
        LocalDateTime startTime = DateUtil.toLocalDateTime(listEnterpriseFeeBO.getStartTime());
        LocalDateTime endTime = DateUtil.toLocalDateTime(listEnterpriseFeeBO.getEndTime());

        var enterprises = parkEnterpriseDao.listEnterpriseForFeeWithoutPage(listEnterpriseFeeBO.getName(),
                listEnterpriseFeeBO.getProviderId(), listEnterpriseFeeBO.getDistributorId());

        List<Integer> enterpriseIds = enterprises.stream()
                .map(EnterpriseFeeBO::getEnterpriseId)
                .toList();

        List<EnterpriseFeeBO> enterpriseFees = invoiceDao.sumEnterpriseFee(startTime, endTime, enterpriseIds);
        Map<Integer, EnterpriseFeeBO> enterpriseMap = enterpriseFees.stream()
                .collect(Collectors.toMap(EnterpriseFeeBO::getEnterpriseId, Function.identity()));

        enterprises.forEach(x -> {
            setAmount(x, enterpriseMap);
        });

        return enterprises;
    }

    private static void setAmount(EnterpriseFeeBO x, Map<Integer, EnterpriseFeeBO> enterpriseMap) {
        EnterpriseFeeBO enterprise = enterpriseMap.get(x.getEnterpriseId());
        if (Objects.nonNull(enterprise)) {
            x.setTotalAmount(enterprise.getTotalAmount())
                    .setTotalFee(enterprise.getTotalFee())
                    .setParkProviderAmount(enterprise.getParkProviderAmount())
                    .setDistributorFee(enterprise.getDistributorFee())
                    .setIncome(enterprise.getIncome());
        } else {
            x.setTotalAmount("0")
                    .setTotalFee("0")
                    .setParkProviderAmount("0")
                    .setDistributorFee("0")
                    .setIncome("0");
        }
    }

    public EnterpriseInvoiceSummaryBO summaryEnterpriseFee(ListEnterpriseFeeBO listEnterpriseFeeBO) {
        LocalDateTime startTime = DateUtil.toLocalDateTime(listEnterpriseFeeBO.getStartTime());
        LocalDateTime endTime = DateUtil.toLocalDateTime(listEnterpriseFeeBO.getEndTime());

        var enterprises = parkEnterpriseDao.listEnterpriseForFeeWithoutPage(listEnterpriseFeeBO.getName(),
                listEnterpriseFeeBO.getProviderId(), listEnterpriseFeeBO.getDistributorId());

        List<Integer> enterpriseIds = enterprises.stream()
                .map(EnterpriseFeeBO::getEnterpriseId)
                .toList();
        if (CollectionUtils.isEmpty(enterpriseIds)) {
            return EnterpriseInvoiceSummaryBO.emptySummary();
        }

        return invoiceDao.summaryEnterpriseFee(startTime, endTime, enterpriseIds);
    }

    public R<Page<InvoiceBO>> listReportDetail(int enterpriseId, long startTime, long endTime, PageQuery pageQuery) {
        LocalDateTime start = DateUtil.toLocalDateTime(startTime);
        LocalDateTime end = DateUtil.toLocalDateTime(endTime);

        var invoices = invoiceDao.listEnterpriseInvoicesByPage(enterpriseId, start, end, pageQuery.getPageNo(), pageQuery.getPageSize());

        List<InvoiceBO> invoiceBOS = invoices.stream()
                .map(OpModelConverter::toInvoiceBO)
                .collect(Collectors.toList());

        return R.success(new Page<>(invoices.getTotal(), invoiceBOS));
    }

    public List<InvoiceBO> listReportDetail(int enterpriseId, long startTime, long endTime) {
        LocalDateTime start = DateUtil.toLocalDateTime(startTime);
        LocalDateTime end = DateUtil.toLocalDateTime(endTime);

        List<InvoiceDO> invoices = invoiceDao.listEnterpriseInvoices(enterpriseId, start, end);
        return invoices.stream()
                .map(OpModelConverter::toInvoiceBO)
                .collect(Collectors.toList());
    }


}
