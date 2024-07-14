package com.luoge.bos.op.invoice.collect.manual;

import com.luoge.bos.op.core.model.PageQuery;
import com.luoge.bos.op.invoice.model.DeleteLongBO;
import com.luoge.bos.op.invoice.model.collect.AddInvoiceBO;
import com.luoge.bos.op.invoice.model.collect.InvoiceBO;
import com.luoge.bos.op.invoice.model.collect.InvoiceDetailBO;
import com.luoge.bos.op.invoice.model.collect.ListInvoiceBO;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 发票管理
 */
@RequestMapping("/bos-op/invoice/collect")
@RestController
public class InvoiceController {
    @Resource
    private InvoiceService invoiceService;

    /**
     * 查询发票列表
     */
    @GetMapping
    public R<Page<InvoiceBO>> listInvoice(ListInvoiceBO listInvoiceBO, PageQuery pageQuery) {
        pageQuery.check();
        Page<InvoiceBO> invoiceBOPage = invoiceService.listInvoice(listInvoiceBO, pageQuery);
        return R.success(invoiceBOPage);
    }

    /**
     * 获取发票详情
     */
    @GetMapping("/detail")
    public R<InvoiceDetailBO> getInvoiceDetail(@RequestParam(name = "id") long id) {
        InvoiceDetailBO invoiceDetailBO = invoiceService.getInvoiceDetail(id);
        return R.success(invoiceDetailBO);
    }

    /**
     * 补录发票
     */
    @PostMapping
    public R<Void> addInvoice(@Valid @RequestBody AddInvoiceBO addInvoiceBO) {
        invoiceService.addInvoice(addInvoiceBO);
        return R.SUCCESS;
    }

    /**
     * 删除发票
     */
    @DeleteMapping
    public R<Void> deleteInvoice(@Valid @RequestBody DeleteLongBO deleteBO) {
        invoiceService.deleteInvoice(deleteBO);
        return R.SUCCESS;
    }

}
