package com.luoge.bos.invoice.apply;


import com.luoge.bos.core.model.PageQuery;
import com.luoge.bos.invoice.model.apply.InvoiceApplyBO;
import com.luoge.bos.invoice.model.apply.InvoiceApplyDetailBO;
import com.luoge.bos.invoice.model.apply.ListInvoiceApplyBO;
import com.luoge.bos.invoice.model.apply.UpdateInvoiceApplyStatusBO;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * 开票申请
 */
@RequestMapping("/bos-op/invoice/apply")
@RestController
public class InvoiceApplyController {

    @Resource
    private InvoiceApplyService invoiceApplyService;

    /**
     * 查询开票申请列表
     */
    @GetMapping
    public R<Page<InvoiceApplyBO>> listInvoiceApply(ListInvoiceApplyBO listInvoiceApplyBO,
                                                    PageQuery pageQuery) {
        pageQuery.check();
        return R.success(invoiceApplyService.listInvoiceApply(listInvoiceApplyBO, pageQuery));
    }

    /**
     * 查看开票申请单详情
     */
    @GetMapping("/detail")
    public R<InvoiceApplyDetailBO> getInvoiceApplyDetail(@RequestParam(name = "id") Long id) {
        return R.success(invoiceApplyService.getInvoiceApplyDetail(id));
    }

    /**
     * 审核通过或驳回或作废开票申请单
     */
    @PutMapping("/status")
    public R<Void> updateInvoiceApplyStatus(@RequestBody UpdateInvoiceApplyStatusBO invoiceApplyStatusBO) {
        return invoiceApplyService.updateInvoiceApplyStatus(invoiceApplyStatusBO);
    }

}
