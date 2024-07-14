package com.luoge.bos.op.invoice.collect.manual;

import cn.hutool.core.util.IdUtil;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.core.model.PageQuery;
import com.luoge.bos.op.core.types.InvoiceCategory;
import com.luoge.bos.op.core.types.InvoiceSourceType;
import com.luoge.bos.op.core.utils.DateUtil;
import com.luoge.bos.op.core.utils.Numbers;
import com.luoge.bos.op.invoice.entity.InvoiceDO;
import com.luoge.bos.op.invoice.entity.ParkEnterpriseDO;
import com.luoge.bos.op.invoice.model.DeleteLongBO;
import com.luoge.bos.op.invoice.model.collect.AddInvoiceBO;
import com.luoge.bos.op.invoice.model.collect.InvoiceBO;
import com.luoge.bos.op.invoice.model.collect.InvoiceDetailBO;
import com.luoge.bos.op.invoice.model.collect.ListInvoiceBO;
import com.luoge.bos.op.invoice.park.enterprise.ParkEnterpriseDao;
import com.luoge.ns.core.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class InvoiceService {
    @Resource
    private InvoiceDao invoiceDao;

    @Resource
    private ParkEnterpriseDao parkEnterpriseDao;

    public Page<InvoiceBO> listInvoice(ListInvoiceBO listInvoiceBO, PageQuery pageQuery) {

        LocalDateTime startTime = DateUtil.toLocalDateTime(listInvoiceBO.getStartTime());
        LocalDateTime endTime = DateUtil.toLocalDateTime(listInvoiceBO.getEndTime());

        var invoiceBO = invoiceDao.listManualInvoice(listInvoiceBO.getParkProviderId(),
                listInvoiceBO.getEnterpriseName(),
                startTime,
                endTime,
                pageQuery.getPageNo(),
                pageQuery.getPageSize());

        invoiceBO.forEach(x -> x.setServiceFeeRate(Numbers.mul(x.getServiceFeeRate(), BOSConsts.BIG_DECIMAL_100)));

        return new Page<>(invoiceBO.getTotal(), invoiceBO.getResult());
    }

    public InvoiceDetailBO getInvoiceDetail(long id) {
        InvoiceDO invoiceDO = invoiceDao.getDetail(id);
        return toInvoiceDetailBO(invoiceDO);
    }

    public InvoiceDetailBO toInvoiceDetailBO(InvoiceDO invoiceDO) {
        return new InvoiceDetailBO()
                .setId(String.valueOf(invoiceDO.getId()))
                .setEnterpriseId(invoiceDO.getEnterpriseId())
                .setIssueTime(DateUtil.toTimeMills(invoiceDO.getIssueTime()))
                .setType(invoiceDO.getType())
                .setTotalAmount(invoiceDO.getTotalAmount())
                .setTotalTax(invoiceDO.getTotalTax())
                .setTotal(invoiceDO.getTotal())
                .setInvoiceNo(invoiceDO.getInvoiceNo())
                .setBuyerName(invoiceDO.getBuyerName())
                .setBusinessId(invoiceDO.getBusinessId())
                .setInvoiceTaxRate(Numbers.mul(invoiceDO.getInvoiceTaxRate(), BOSConsts.BIG_DECIMAL_100));
    }

    public void addInvoice(AddInvoiceBO addInvoiceBO) {
        ParkEnterpriseDO parkEnterpriseDO = parkEnterpriseDao.getOrg(addInvoiceBO.getEnterpriseId());

        InvoiceDO invoiceDO = toInvoiceDO(addInvoiceBO, parkEnterpriseDO.getOrgId(),
                parkEnterpriseDO.getServiceFeeRate(), parkEnterpriseDO.getEnterpriseName());
        invoiceDao.add(invoiceDO);
    }

    public InvoiceDO toInvoiceDO(AddInvoiceBO addInvoiceBO, Integer orgId,
                                 BigDecimal serviceFeeRate, String parkEnterpriseName) {
        LocalDateTime now = DateUtil.nowTime();

        InvoiceDO invoiceDO = new InvoiceDO()
                .setId(IdUtil.getSnowflakeNextId())
                .setOrgId(orgId)
                .setEnterpriseId(addInvoiceBO.getEnterpriseId())
                .setParkEnterpriseId(addInvoiceBO.getEnterpriseId())
                .setParkEnterpriseName(parkEnterpriseName)
                .setIssueTime(DateUtil.toLocalDateTime(addInvoiceBO.getIssueTime()))
                .setType(addInvoiceBO.getType())
                .setTotalAmount(Numbers.toBigDecimal(addInvoiceBO.getTotalAmount()))
                .setTotalTax(Numbers.toBigDecimal(addInvoiceBO.getTotalTax()))
                .setTotal(Numbers.toBigDecimal(addInvoiceBO.getTotal()))
                .setServiceFeeRate(serviceFeeRate)
                .setInvoiceNo(addInvoiceBO.getInvoiceNo())
                .setBuyerName(addInvoiceBO.getBuyerName())
                .setSourceType(InvoiceSourceType.MANUAL.type)
                .setInvoiceTaxRate(Numbers.divide(addInvoiceBO.getInvoiceTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setBusinessId(addInvoiceBO.getBusinessId())
                .setCreateTime(now)
                .setUpdateTime(now);
        invoiceDO.setServiceFee(Numbers.mul(serviceFeeRate, invoiceDO.getTotal()));

        if (invoiceDO.getTotal().compareTo(BigDecimal.ZERO) < 0) {
            invoiceDO.setCategory(InvoiceCategory.RED.category);
        } else {
            invoiceDO.setCategory(InvoiceCategory.BLUE.category);
        }
        return invoiceDO;
    }

    public void deleteInvoice(DeleteLongBO deleteBO) {
        invoiceDao.delete(deleteBO.getId());
    }

}
