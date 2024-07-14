package com.luoge.bos.op.invoice.org.enterprise;

import com.luoge.bos.op.core.model.PageQuery;
import com.luoge.bos.op.invoice.model.org.EnterpriseBO;
import com.luoge.bos.op.invoice.model.org.EnterpriseDetailBO;
import com.luoge.bos.op.invoice.model.org.IndustryBO;
import com.luoge.bos.op.invoice.model.org.UpdateEnterpriseStatusBO;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 机构管理/企业管理
 */
@RequestMapping("/bos-op/enterprise")
@RestController
public class EnterpriseController {
    @Resource
    private EnterpriseService enterpriseService;

    /**
     * 查询企业列表
     */
    @GetMapping
    public R<Page<EnterpriseBO>> listEnterprise(@RequestParam(name = "name", required = false) String name,
                                                @RequestParam(name = "orgId") Integer orgId,
                                                PageQuery pageQuery) {
        pageQuery.check();
        Page<EnterpriseBO> enterpriseBOPage = enterpriseService.listEnterprise(name, orgId, pageQuery);
        return R.success(enterpriseBOPage);
    }

    /**
     * 企业列表下拉选择
     */
    @GetMapping("/select")
    public R<List<EnterpriseBO>> listEnterprise() {
        return R.success(enterpriseService.listEnterprise());
    }

    /**
     * 查询企业详情
     */
    @GetMapping("/detail")
    public R<EnterpriseDetailBO> getEnterprise(@RequestParam(name = "id") Integer id) {
        EnterpriseDetailBO enterpriseBO = enterpriseService.getEnterprise(id);
        return R.success(enterpriseBO);
    }

    /**
     * 创建或修改企业
     */
    @PostMapping
    public R<Void> saveEnterprise(@Valid @RequestBody EnterpriseDetailBO enterpriseDetailBO) {
        if (enterpriseDetailBO.getId() == null) {
            return enterpriseService.insertEnterprise(enterpriseDetailBO);
        } else {
            return enterpriseService.updateEnterprise(enterpriseDetailBO);
        }
    }

    /**
     * 查询行业
     */
    @GetMapping("/industries")
    public R<List<IndustryBO>> listIndustries() {
        return R.success(enterpriseService.listIndustries());
    }

    /**
     * 更改企业状态
     */
    @PutMapping
    public R<Void> updateEnterpriseStatus(@Valid @RequestBody UpdateEnterpriseStatusBO updateEnterpriseStatusBO) {
        enterpriseService.updateEnterpriseStatus(updateEnterpriseStatusBO);
        return R.SUCCESS;
    }

    /**
     * 查询供添加园区企业的企业源
     *
     * @param orgId 机构id
     * @param name  企业名称
     */
    @GetMapping("/park")
    public R<Page<EnterpriseBO>> listParkEnterpriseSource(@RequestParam(name = "orgId", required = false) Integer orgId,
                                                          @RequestParam(name = "name", required = false) String name,
                                                          PageQuery pageQuery) {
        pageQuery.check();
        return R.success(enterpriseService.listParkEnterpriseSource(orgId, name, pageQuery));
    }


}
