package com.luoge.app.uc.common;

import com.luoge.app.uc.entity.RegionDO;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * uc/公共接口
 */
@Validated
@RestController
@RequestMapping("uc/common")
public class UcCommonController {

    @Resource
    private UcCommonService ucCommonService;
//    @Resource
//    private EnterpriseService enterpriseService;

    /**
     * 获取行政区划列表
     *
     * @return 行政区划列表
     */
    @GetMapping("/regions")
    public R<List<RegionDO>> listRegions() {
        return R.success(ucCommonService.listRegions());
    }

    /**
     * 获取行业代码列表
     *
     * @return 业代码列表
     */
//    @GetMapping("/industries")
//    public R<List<IndustryBO>> listIndustries() {
//        return R.success(commonService.listIndustries());
//    }
//
//    /**
//     * 企业查询
//     *
//     * @param ctx   上下文
//     * @param name  企业名称
//     * @param scope 范围 1-当前用户可选企业, 2=当前用户可选+三方搜索, 3-仅搜索
//     * @return 业代码列表
//     */
//    @GetMapping("/enterprises")
//    public R<List<EnterpriseBO>> listEnterprises(Context ctx, String name, Integer scope) {
//        return R.success(enterpriseService.listEnterpriseByKeywordAndScope(ctx.getOrgId(), ctx.getUserId(), name, scope));
//    }
}
