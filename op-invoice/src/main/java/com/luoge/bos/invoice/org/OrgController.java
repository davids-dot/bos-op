package com.luoge.bos.invoice.org;

import com.luoge.bos.invoice.model.org.OrgAdminPasswdBO;
import com.luoge.bos.invoice.model.org.OrgBO;
import com.luoge.bos.invoice.model.org.OrgDetailBO;
import com.luoge.bos.core.model.PageQuery;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 机构管理
 */
@RestController
@RequestMapping("/bos-op/org")
public class OrgController {

    @Resource
    private OrgService orgService;

    /**
     * 查询机构列表
     */
    @GetMapping
    public R<Page<OrgBO>> listOrg(@RequestParam(name = "name", required = false) String name,
                                  PageQuery pageQuery) {
        pageQuery.check();
        Page<OrgBO> orgBOPage = orgService.listOrg(name, pageQuery);
        return R.success(orgBOPage);
    }

    /**
     * 机构下拉选择列表
     */
    @GetMapping("/select")
    public R<List<OrgBO>> listOrg() {
        return R.success(orgService.listOrg());
    }

    /**
     * 获取机构详情
     */
    @GetMapping("/detail")
    public R<OrgDetailBO> getOrgDetail(@RequestParam(name = "id") Integer id) {
        OrgDetailBO orgDetailBO = orgService.getOrgDetail(id);
        return R.success(orgDetailBO);
    }

    /**
     * 新增或编辑机构
     */
    @PostMapping
    public R<Void> saveOrg(@Valid @RequestBody OrgDetailBO orgBO) {
        if (orgBO.getId() == null) {
            return orgService.insertOrg(orgBO);
        } else {
            return orgService.updateOrg(orgBO);
        }
    }

    /**
     * 重置密码
     */
    @PutMapping("/password")
    public R<Void> resetPasswd(@RequestBody @Valid OrgAdminPasswdBO reset) {
        orgService.resetAdminPasswd(reset.getId(), reset.getAdminPassword());
        return R.SUCCESS;
    }

}
