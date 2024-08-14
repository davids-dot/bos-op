package com.luoge.bos.invoice.park.distributor;

import com.luoge.bos.invoice.model.park.distributor.ParkEnterpriseDistributorBO;
import com.luoge.bos.invoice.model.park.distributor.ParkEnterpriseDistributorDetailsBO;
import com.luoge.bos.invoice.model.park.distributor.ParkEnterpriseDistributorStatusBO;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 渠道商管理
 */
@RestController
@RequestMapping("/bos-op/enterprise/distributor")
public class ParkEnterpriseDistributorController {

    @Resource
    private ParkEnterpriseDistributorService parkEnterpriseDistributorService;

    /**
     * 查询渠道商
     */
    @GetMapping
    public R<Page<ParkEnterpriseDistributorBO>> listParkEnterpriseDistributor(@RequestParam(defaultValue = "1") Integer pageNo,
                                                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                                                              String name) {
        Page<ParkEnterpriseDistributorBO> page = parkEnterpriseDistributorService.listParkEnterpriseDistributor(pageNo, pageSize, name);
        return R.success(page);
    }

    /**
     * 渠道商下拉列表
     *
     * @param status 筛选状态
     */
    @GetMapping("/select")
    public R<List<ParkEnterpriseDistributorBO>> listParkEnterpriseDistributor(@RequestParam(name = "status", required = false) Integer status) {
        return R.success(parkEnterpriseDistributorService.listParkEnterpriseDistributor(status));
    }

    /**
     * 获取详情页
     */
    @GetMapping("/detail")
    public R<ParkEnterpriseDistributorDetailsBO> getParkEnterpriseDistributorDetails(Integer id) {
        ParkEnterpriseDistributorDetailsBO parkEnterpriseDistributorDetailsBO = parkEnterpriseDistributorService.getParkEnterpriseDistributorDetails(id);
        return R.success(parkEnterpriseDistributorDetailsBO);
    }

    /**
     * 添加/更新渠道商
     */
    @PostMapping
    public R<Void> parkEnterpriseDistributor(@RequestBody ParkEnterpriseDistributorDetailsBO parkEnterpriseDistributorDetailsBO) {
        if (parkEnterpriseDistributorDetailsBO.getId() == null) {
            return parkEnterpriseDistributorService.insertParkEnterpriseDistributor(parkEnterpriseDistributorDetailsBO);
        } else {
            return parkEnterpriseDistributorService.updateParkEnterpriseDistributor(parkEnterpriseDistributorDetailsBO);
        }
    }

    /**
     * 更新状态
     */
    @PutMapping("/status")
    public R<Void> updateParkEnterpriseDistributorStatus(@Valid @RequestBody ParkEnterpriseDistributorStatusBO parkEnterpriseDistributorStatusBO) {
        parkEnterpriseDistributorService.updateParkEnterpriseDistributorStatus(parkEnterpriseDistributorStatusBO);
        return R.SUCCESS;
    }

}
