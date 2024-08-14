package com.luoge.bos.invoice.park.provider;


import com.luoge.bos.invoice.model.ParkProviderBO;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 园区/园区服务商
 */
@RequestMapping("/mobile/invoice/park/provider")
@RestController
public class AppParkProviderController {


    @Resource
    private AppParkProviderService appParkProviderService;

    /**
     * 查询园区服务商的下拉列表
     */
    @GetMapping("/select")
    public R<List<ParkProviderBO>> listParkProviders(@RequestParam(name = "status", required = false) Integer status) {
        return R.success(appParkProviderService.listParkProvider(status));
    }

}
