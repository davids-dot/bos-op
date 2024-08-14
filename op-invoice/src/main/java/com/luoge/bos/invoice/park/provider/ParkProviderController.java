package com.luoge.bos.invoice.park.provider;


import com.luoge.bos.invoice.model.park.provider.ParkProviderBO;
import com.luoge.bos.invoice.model.park.provider.ParkProviderDetailBO;
import com.luoge.bos.invoice.model.park.provider.ParkProviderStatusBO;
import com.luoge.bos.core.model.PageQuery;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 园区服务商管理
 */
@RequestMapping("/bos-op/park/provider")
@RestController
public class ParkProviderController {

    @Resource
    private ParkProviderService parkProviderService;

    /**
     * 查询园区服务商列表
     */
    @GetMapping
    public R<Page<ParkProviderBO>> listParkProvider(@RequestParam(name = "name", required = false) String name,
                                                    PageQuery pageQuery) {
        pageQuery.check();
        Page<ParkProviderBO> page = parkProviderService.listParkProvider(name, pageQuery);
        return R.success(page);
    }

    /**
     * 查询园区服务商的下拉列表
     */
    @GetMapping("/select")
    public R<List<ParkProviderBO>> listParkProviders(@RequestParam(name = "status", required = false) Integer status) {
        return R.success(parkProviderService.listParkProvider(status));
    }

    /**
     * 获取园区服务商详情
     */
    @GetMapping("/detail")
    public R<ParkProviderDetailBO> getParkProviderDetail(@RequestParam(name = "id") Integer id) {
        ParkProviderDetailBO parkProviderDetailBO = parkProviderService.getParkProviderDetail(id);
        return R.success(parkProviderDetailBO);
    }

    /**
     * 新增/编辑 园区服务商
     */
    @PostMapping
    public R<Void> parkProvider(@Valid @RequestBody ParkProviderDetailBO parkProviderDetailBO) {
        if (parkProviderDetailBO.getId() == null) {
            return parkProviderService.insertParkProvider(parkProviderDetailBO);
        } else {
            return parkProviderService.updateParkProvider(parkProviderDetailBO);
        }
    }

    /**
     * 更新园区服务商状态
     */
    @PutMapping("/status")
    private R<Void> updateParkProviderStatus(@Valid @RequestBody ParkProviderStatusBO parkProviderStatusBO) {
        parkProviderService.updateParkProviderStatus(parkProviderStatusBO);
        return R.SUCCESS;
    }
}
