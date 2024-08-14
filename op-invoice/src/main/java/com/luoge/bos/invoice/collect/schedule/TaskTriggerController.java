package com.luoge.bos.invoice.collect.schedule;

import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.invoice.model.collect.TriggerTaskBO;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * 任务触发
 */
@RequestMapping("/bos-op/collect/task")
@RestController
public class TaskTriggerController {

    @Resource
    private SyncInvoiceTask syncInvoiceTask;
    @Resource
    private MonthReportTask monthReportTask;

    /**
     * 手动触发发票同步任务
     */
    @PostMapping("/trigger/syncInvoice")
    public R<Void> triggerSyncInvoiceTask(@RequestBody TriggerTaskBO triggerTaskBO) {
        return syncInvoiceTask.syncInvoiceByTimeRange(
                DateUtil.toLocalDateTime(triggerTaskBO.getStartTime()),
                DateUtil.toLocalDateTime(triggerTaskBO.getEndTime()),
                triggerTaskBO.getEnterpriseId());
    }

    /**
     * 手动触发报表生成任务
     */
    @PostMapping("/trigger/generateReport")
    public R<Void> triggerGenerateReportTask(@RequestBody TriggerTaskBO triggerTaskBO) {
        LocalDateTime startTime = DateUtil.toLocalDateTime(triggerTaskBO.getStartTime());
        LocalDateTime endTime = DateUtil.toLocalDateTime(triggerTaskBO.getEndTime());
        monthReportTask.generateMonthReport(startTime, endTime);
        return R.SUCCESS;
    }

    /**
     * 清理发票上已计算的归属收入,重新跑数时使用
     */
    @PutMapping("/invoices/income")
    public R<Void> clearInvoicesIncome(@RequestBody TriggerTaskBO triggerTaskBO) {
        LocalDateTime startTime = DateUtil.toLocalDateTime(triggerTaskBO.getStartTime());
        LocalDateTime endTime = DateUtil.toLocalDateTime(triggerTaskBO.getEndTime());
        syncInvoiceTask.clearInvoicesIncome(triggerTaskBO.getEnterpriseId(), startTime, endTime);
        return R.SUCCESS;
    }
}
