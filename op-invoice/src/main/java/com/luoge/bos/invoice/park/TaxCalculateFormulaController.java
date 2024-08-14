package com.luoge.bos.invoice.park;

import com.luoge.bos.invoice.model.TaxCalculateFormulaBO;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 算税公式管理
 */
@RequestMapping("/bos-op/tax/calculate/formula")
@RestController
public class TaxCalculateFormulaController {

    @Resource
    private TaxCalculateFormulaService taxCalculateFormulaService;

    /**
     * 查询算税公式的下拉列表
     */
    @GetMapping
    public R<List<TaxCalculateFormulaBO>> listTaxCalculateFormula(@RequestParam(name = "taxType",required = false) Integer taxType) {
        return R.success(taxCalculateFormulaService.listTaxCalculateFormula(taxType));
    }
}
