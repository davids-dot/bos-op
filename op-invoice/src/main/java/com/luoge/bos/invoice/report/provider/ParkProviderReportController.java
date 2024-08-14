package com.luoge.bos.invoice.report.provider;

import com.luoge.bos.core.model.PageQuery;
import com.luoge.bos.invoice.util.ExcelUtils;
import com.luoge.bos.invoice.model.report.ListParkProviderMonthReportBO;
import com.luoge.bos.invoice.model.report.ParkProviderMonthReportBO;
import com.luoge.bos.invoice.model.report.ParkProviderMonthReportDetailBO;
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

import java.io.IOException;
import java.util.List;

/**
 * 园区服务商报表
 */
@Validated
@RequestMapping("/bos-op/report/provider")
@RestController
public class ParkProviderReportController {

    @Resource
    private ParkProviderReportService parkProviderReportService;


    /**
     * 查看园区服务商税费月报
     */
    @GetMapping
    public R<Page<ParkProviderMonthReportBO>> listParkProviderMonthReport(ListParkProviderMonthReportBO listReportBO,
                                                                          PageQuery pageQuery) {
        pageQuery.check();
        return parkProviderReportService.listParkProviderMonthReport(listReportBO, pageQuery);
    }

    /**
     * 园区服务商税费报表导出
     */
    @GetMapping("/export")
    public void exportParkProviderMonthReport(ListParkProviderMonthReportBO listParkProviderMonthReportBO, HttpServletResponse response) throws IOException {
        List<ParkProviderMonthReportBO> reports = parkProviderReportService.listParkProviderMonthReport(listParkProviderMonthReportBO);
        ExcelUtils.exportExcel(response, "园区服务商税费", reports, ParkProviderMonthReportBO.class);
    }

    /**
     * 查询园区应付费包含的企业明细报表
     *
     * @param providerId 企业id
     * @param month      月份
     */
    @GetMapping("/detail")
    public R<Page<ParkProviderMonthReportDetailBO>> listReportDetail(@RequestParam(name = "providerId") int providerId,
                                                                     @RequestParam(name = "month") String month,
                                                                     PageQuery pageQuery) {
        pageQuery.check();
        return parkProviderReportService.listReportDetail(providerId, month, pageQuery);
    }

    /**
     * 导出园区服务商税费明细报表
     *
     * @param providerId 企业id
     * @param month      月份
     */
    @GetMapping("/detail/export")
    public void exportReportDetail(@RequestParam(name = "providerId") int providerId,
                                   @Valid @NotBlank(message = "月份不能为空") @RequestParam(name = "month") String month,
                                   HttpServletResponse response) throws IOException{
        List<ParkProviderMonthReportDetailBO> parkProviderMonthReportDetail = parkProviderReportService.listReportDetail(providerId,month);
        ExcelUtils.exportExcel(response, "园区服务商税费明细", parkProviderMonthReportDetail, ParkProviderMonthReportDetailBO.class);
    }
}
