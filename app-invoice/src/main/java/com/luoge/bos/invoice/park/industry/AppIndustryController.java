package com.luoge.bos.invoice.park.industry;


import com.luoge.bos.invoice.model.IndustryVO;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 园区/行业
 */
@RequestMapping("/mobile/invoice/park/industry")
@RestController
public class AppIndustryController {
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
