package com.luoge.bos.invoice.report.enterprise;

import com.luoge.bos.core.model.PageQuery;
import com.luoge.bos.invoice.util.ExcelUtils;
import com.luoge.bos.invoice.util.OpModelConverter;
import com.luoge.bos.invoice.model.collect.InvoiceBO;
import com.luoge.bos.invoice.model.excel.InvoiceTpl;
import com.luoge.bos.invoice.model.report.EnterpriseMonthReportBO;
import com.luoge.bos.invoice.model.report.ListEnterpriseMonthReportBO;
import com.luoge.bos.invoice.model.report.SummaryEnterpriseReportBO;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 园区企业报表
 */
@Validated
@RequestMapping("/bos-op/report/enterprise")
@RestController
public class ParkEnterpriseReportController {

    @Resource
    private ParkEnterpriseReportService parkEnterpriseReportService;


    /**
     * 园区企业开票服务费月报
     */
    @GetMapping
    public R<Page<EnterpriseMonthReportBO>> listEnterpriseReport(ListEnterpriseMonthReportBO listEnterpriseMonthReportBO,
                                                                 PageQuery pageQuery) {
        pageQuery.check();
        return parkEnterpriseReportService.listEnterpriseReport(listEnterpriseMonthReportBO, pageQuery);
    }

    /**
     * 导出 园区企业开票服务费月报
     */
    @GetMapping("/export")
    public void exportEnterpriseReport(ListEnterpriseMonthReportBO listEnterpriseMonthReportBO, HttpServletResponse response) throws Exception {
        List<EnterpriseMonthReportBO> enterpriseReports = parkEnterpriseReportService.listEnterpriseReport(listEnterpriseMonthReportBO);
        ExcelUtils.exportExcel(response, "企业开票服务费月报", enterpriseReports, EnterpriseMonthReportBO.class);
    }

    /**
     * 企业开票服务费 汇总信息
     */
    @GetMapping("/summary")
    public R<SummaryEnterpriseReportBO> summaryEnterpriseReport(ListEnterpriseMonthReportBO listEnterpriseMonthReportBO) {
        return R.success(parkEnterpriseReportService.summaryEnterpriseReport(listEnterpriseMonthReportBO));
    }


    /**
     * 查询企业月服务费对应发票
     *
     * @param enterpriseId 企业id
     * @param month        月份
     */
    @GetMapping("/detail")
    public R<Page<InvoiceBO>> listReportDetail(@RequestParam(name = "enterpriseId") int enterpriseId,
                                               @Valid @NotBlank(message = "月份不能为空") @RequestParam(name = "month") String month,
                                               PageQuery pageQuery) {
        return parkEnterpriseReportService.listEnterpriseReportDetail(enterpriseId, month, pageQuery);
    }

    /**
     * 导出企业服务费对应发票
     *
     * @param enterpriseId 企业id
     * @param month        月份
     */
    @GetMapping("/detail/export")
    public void exportReportDetail(@RequestParam(name = "enterpriseId") int enterpriseId,
                                   @Valid @NotBlank(message = "月份不能为空") @RequestParam(name = "month") String month,
                                   HttpServletResponse response) throws Exception {
        List<InvoiceBO> invoices = parkEnterpriseReportService.listEnterpriseReportDetail(enterpriseId, month);
        List<InvoiceTpl> invoiceTpls = invoices.stream()
                .map(OpModelConverter::toInvoiceTpl)
                .toList();

        ExcelUtils.exportExcel(response, "企业开票服务费月报明细", invoiceTpls, InvoiceTpl.class);
    }
}
