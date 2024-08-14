package com.luoge.bos.invoice.park.enterprise;

import com.luoge.bos.invoice.model.DeleteBO;
import com.luoge.bos.invoice.model.park.enterprise.*;
import com.luoge.bos.core.model.PageQuery;
import com.luoge.bos.invoice.entity.ParkEnterpriseDO;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 园区企业管理
 */
@RequestMapping("/bos-op/park/enterprise")
@RestController
public class ParkEnterpriseController {

    @Resource
    private ParkEnterpriseService parkEnterpriseService;

    /**
     * 查询园区企业列表
     */
    @GetMapping
    public R<Page<ParkEnterpriseBO>> listParkEnterprise(ListParkEnterpriseBO listParkEnterpriseBO,
                                                        PageQuery pageQuery) {
        return R.success(parkEnterpriseService.listParkEnterprisesByPage(listParkEnterpriseBO, pageQuery));
    }

    /**
     * 园区企业下拉列表
     */
    @GetMapping("/select")
    public R<List<ParkEnterpriseBO>> listParkEnterprise() {
        List<ParkEnterpriseDO> parkEnterprises = parkEnterpriseService.listParkEnterprises();
        List<ParkEnterpriseBO> results = parkEnterprises.stream()
                .map(x -> new ParkEnterpriseBO()
                        .setId(x.getEnterpriseId())
                        .setName(x.getEnterpriseName()))
                .collect(Collectors.toList());

        return R.success(results);
    }

    /**
     * 添加园区企业
     */
    @PostMapping
    public R<Void> addParkEnterprise(@Valid @RequestBody AddParkEnterpriseBO addParkEnterpriseBO) {
        parkEnterpriseService.addParkEnterprise(addParkEnterpriseBO.getEnterpriseIds());
        return R.SUCCESS;
    }

    /**
     * 获取园区企业详情
     */
    @GetMapping("/detail")
    public R<ParkEnterpriseDetailBO> getParkEnterpriseDetail(@RequestParam(name = "id") int id) {
        return R.success(parkEnterpriseService.getParkEnterpriseDetail(id));
    }

    /**
     * 更改园区企业设置
     */
    @PutMapping("/setting")
    public R<Void> updateFeeSetting(@Valid @RequestBody ParkEnterpriseFeeBO parkEnterprise) {
        parkEnterpriseService.updateFeeSetting(parkEnterprise);
        return R.SUCCESS;
    }

    /**
     * 删除园区企业
     */
    @DeleteMapping
    public R<Void> deleteParkEnterprise(@RequestBody DeleteBO deleteBO) {
        parkEnterpriseService.deleteParkEnterprise(deleteBO.getId());
        return R.SUCCESS;
    }

}
