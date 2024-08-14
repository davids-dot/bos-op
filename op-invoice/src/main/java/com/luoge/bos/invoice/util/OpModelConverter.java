package com.luoge.bos.invoice.util;

import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.core.types.InvoiceSourceType;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.core.utils.Numbers;
import com.luoge.bos.invoice.entity.InvoiceDO;
import com.luoge.bos.invoice.model.collect.InvoiceBO;
import com.luoge.bos.invoice.model.excel.InvoiceTpl;

import java.util.Objects;

public class OpModelConverter {
    private OpModelConverter() {
    }


    public static InvoiceBO toInvoiceBO(InvoiceDO invoice) {
        return new InvoiceBO()
                .setId(String.valueOf(invoice.getId()))
                .setOrgId(invoice.getOrgId())
                .setEnterpriseId(invoice.getEnterpriseId())
                .setType(invoice.getType())
                .setInvoiceNo(invoice.getInvoiceNo())
                .setInvoiceCode(invoice.getInvoiceCode())
                .setBuyerName(invoice.getBuyerName())
                .setIssueTime(invoice.getIssueTime())
                .setTotalAmount(invoice.getTotalAmount())
                .setTotalTax(invoice.getTotalTax())
                .setTotal(invoice.getTotal())
                .setServiceFeeRate(Numbers.mul(invoice.getServiceFeeRate(), BOSConsts.BIG_DECIMAL_100))
                .setServiceFee(invoice.getServiceFee())
                .setParkProviderAmount(invoice.getParkProviderAmount())
                .setDistributorFee(invoice.getParkEnterpriseDistributorFee())
                .setIncome(invoice.getIncome())
                .setSourceType(invoice.getSourceType())
                .setCreateTime(invoice.getCreateTime());
    }


    public static InvoiceTpl toInvoiceTpl(InvoiceBO invoice) {
        InvoiceSourceType invoiceSourceType = InvoiceSourceType.of(invoice.getSourceType());
        return new InvoiceTpl()
                .setId(invoice.getId())
                .setInvoiceNo(invoice.getInvoiceNo())
                .setBuyerName(invoice.getBuyerName())
                .setTotal(Numbers.toString(invoice.getTotal()))
                .setServiceFeeRate(Numbers.toString(invoice.getServiceFeeRate()))
                .setServiceFee(Numbers.toString(invoice.getServiceFee()))
                .setParkProviderAmount(Numbers.toString(invoice.getParkProviderAmount()))
                .setDistributorFee(Numbers.toString(invoice.getDistributorFee()))
                .setIncome(Numbers.toString(invoice.getIncome()))
                .setSourceType(Objects.isNull(invoiceSourceType) ? "" : invoiceSourceType.remark)
                .setIssueTime(DateUtil.toDateSting(invoice.getIssueTime()));
    }
}
