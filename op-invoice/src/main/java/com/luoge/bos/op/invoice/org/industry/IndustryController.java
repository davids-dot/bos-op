package com.luoge.bos.op.invoice.org.industry;


import com.luoge.bos.op.invoice.model.industry.IndustryVO;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 行业选择
 */
@RequestMapping("/bos-op/industry")
@RestController
public class IndustryController {
    @Resource
    private IndustryService industryService;

    /**
     * 行业选择列表
     */
    @GetMapping("/select")
    public R<List<IndustryVO>> listIndustries() {
        return R.success(industryService.listIndustries());
    }

}
