package com.luoge.bos.invoice.query;

import com.luoge.bos.core.model.PageQuery;
import com.luoge.bos.invoice.util.ExcelUtils;
import com.luoge.bos.invoice.util.OpModelConverter;
import com.luoge.bos.invoice.model.collect.InvoiceBO;
import com.luoge.bos.invoice.model.excel.InvoiceTpl;
import com.luoge.bos.invoice.model.query.EnterpriseFeeBO;
import com.luoge.bos.invoice.model.query.EnterpriseInvoiceSummaryBO;
import com.luoge.bos.invoice.model.query.ListEnterpriseFeeBO;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * 企业服务费
 */
@RequestMapping("/bos-op/enterprise/fee")
@RestController
public class EnterpriseFeeController {

    @Resource
    private EnterpriseFeeService enterpriseFeeService;

    /**
     * 查看企业服务费
     */
    @GetMapping
    public R<Page<EnterpriseFeeBO>> listEnterpriseFee(ListEnterpriseFeeBO listEnterpriseFeeBO, PageQuery pageQuery) {
        pageQuery.check();
        return enterpriseFeeService.listEnterpriseFee(listEnterpriseFeeBO, pageQuery);
    }


    /**
     * 导出企业服务费excel 文件
     */
    @GetMapping("/export")
    public void exportEnterpriseFee(ListEnterpriseFeeBO listEnterpriseFeeBO, HttpServletResponse response) throws IOException {
        List<EnterpriseFeeBO> enterpriseFees = enterpriseFeeService.listEnterpriseFee(listEnterpriseFeeBO);
        ExcelUtils.exportExcel(response, "应收服务费", enterpriseFees, EnterpriseFeeBO.class);
    }

    /**
     * 查看企业服务费汇总信息
     */
    @GetMapping("/summary")
    public R<EnterpriseInvoiceSummaryBO> getEnterpriseFeeSummary(ListEnterpriseFeeBO listEnterpriseFeeBO) {
        return R.success(enterpriseFeeService.summaryEnterpriseFee(listEnterpriseFeeBO));
    }

    /**
     * 查询企业服务费对应明细
     */
    @GetMapping("/detail")
    public R<Page<InvoiceBO>> listReportDetail(@RequestParam(name = "enterpriseId") int enterpriseId,
                                               @RequestParam(name = "startTime") long startTime,
                                               @RequestParam(name = "endTime") long endTime,
                                               PageQuery pageQuery) {
        pageQuery.check();
        return enterpriseFeeService.listReportDetail(enterpriseId, startTime, endTime,pageQuery);
    }

    /**
     * 企业服务费明细导出
     */
    @GetMapping("/detail/export")
    public void exportReportDetail(@RequestParam(name = "enterpriseId") int enterpriseId,
                                   @RequestParam(name = "startTime") long startTime,
                                   @RequestParam(name = "endTime") long endTime,
                                   HttpServletResponse response) throws IOException {
        List<InvoiceBO> invoices = enterpriseFeeService.listReportDetail(enterpriseId, startTime, endTime);
        List<InvoiceTpl> invoiceTpls = invoices.stream()
                .map(OpModelConverter::toInvoiceTpl)
                .toList();

        ExcelUtils.exportExcel(response, "企业服务费明细", invoiceTpls, InvoiceTpl.class);
    }



}
