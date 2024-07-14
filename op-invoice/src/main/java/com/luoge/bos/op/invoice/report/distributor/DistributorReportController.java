package com.luoge.bos.op.invoice.report.distributor;

import com.luoge.bos.op.core.model.PageQuery;
import com.luoge.bos.op.invoice.model.report.DistributorMonthReportBO;
import com.luoge.bos.op.invoice.model.report.DistributorMonthReportDetailBO;
import com.luoge.bos.op.invoice.model.report.ListDistributorMonthReportBO;
import com.luoge.bos.op.invoice.util.ExcelUtils;
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
 * 渠道商报表
 */
@Validated
@RequestMapping("/bos-op/report/distributor")
@RestController
public class DistributorReportController {

    @Resource
    private DistributorReportService distributorReportService;

    /**
     * 查询渠道商佣金月报
     */
    @GetMapping
    public R<Page<DistributorMonthReportBO>> listDistributorMonthReport(ListDistributorMonthReportBO listDistributorMonthReportBO,
                                                                        PageQuery pageQuery) {
        pageQuery.check();
        return distributorReportService.listDistributorMonthReport(listDistributorMonthReportBO, pageQuery);
    }

    /**
     * 渠道商佣金报表导出
     */
    @GetMapping("/export")
    public void exportDistributorMonthReport(ListDistributorMonthReportBO listDistributorMonthReportBO, HttpServletResponse response) throws IOException {
        List<DistributorMonthReportBO> reports = distributorReportService.listDistributorMonthReport(listDistributorMonthReportBO);
        ExcelUtils.exportExcel(response, "渠道商佣金", reports, DistributorMonthReportBO.class);
    }

    /**
     * 查询渠道商包含的企业明细报表
     *
     * @param distributorId 企业id
     * @param month         月份
     */
    @GetMapping("/detail")
    public R<Page<DistributorMonthReportDetailBO>> listReportDetail(@RequestParam(name = "distributorId") int distributorId,
                                                                    @Valid @NotBlank(message = "月份不能为空") @RequestParam(name = "month") String month,
                                                                    PageQuery pageQuery) {
        pageQuery.check();
        return distributorReportService.listReportDetail(distributorId, month, pageQuery);
    }

    /**
     * 导出渠道商佣金明细报表
     *
     * @param distributorId 企业id
     * @param month         月份
     */
    @GetMapping("/detail/export")
    public void exportReportDetail(@RequestParam(name = "distributorId") int distributorId,
                                   @Valid @NotBlank(message = "月份不能为空") @RequestParam(name = "month") String month,
                                   HttpServletResponse response) throws IOException {
        List<DistributorMonthReportDetailBO> distributorReportDetails = distributorReportService.listReportDetail(distributorId, month);
        ExcelUtils.exportExcel(response, "渠道商佣金明细", distributorReportDetails, DistributorMonthReportDetailBO.class);
    }

}
