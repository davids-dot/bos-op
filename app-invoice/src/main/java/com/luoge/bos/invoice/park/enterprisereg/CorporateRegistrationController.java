package com.luoge.bos.invoice.park.enterprisereg;


import com.luoge.bos.invoice.model.*;
import com.luoge.bos.core.model.PageQuery;
import com.luoge.bos.uc.ctx.Context;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 园区/(移动端)工商注册
 */
@RequestMapping("/mobile/invoice/park/enterprise/registration")
@RestController
public class CorporateRegistrationController {

    @Resource
    private CorporateRegistrationService corporateRegistrationService;
    /**
     * 保存工商注册信息
     */
    @PostMapping
    public R<IdBO> saveEnterpriseRegistration(@Valid @RequestBody SaveEnterpriseRegistrationBO enterpriseRegistration, Context ctx) {
        return corporateRegistrationService.saveEnterpriseRegistration(enterpriseRegistration, ctx.getOrgId(), ctx.getUserId());
    }

    /**
     * 提交工商注册付款信息
     */
    @PostMapping("/payment")
    public R<Void> submitEnterpriseRegistrationPayment(@Valid @RequestBody PaymentEnterpriseRegistrationBO paymentEnterpriseRegistrationBO, Context ctx) {
        return corporateRegistrationService.submitEnterpriseRegistrationPayment(paymentEnterpriseRegistrationBO);
    }

    /**
     * 查看工商注册单详情
     *
     * @param id 工商注册单id
     */
    @GetMapping("/detail")
    public R<EnterpriseRegistrationDetailVO> getEnterpriseRegistrationDetail(Long id) {
        return R.success(corporateRegistrationService.getEnterpriseRegistrationDetail(id));
    }

    /**
     * 查看工商注册申请列表
     *
     * @param status 状态
     */
    @GetMapping
    public R<Page<EnterpriseRegistrationVO>> listEnterpriseRegistration(Integer status, PageQuery pageQuery, Context ctx) {
        pageQuery.check();
        return R.success(corporateRegistrationService.listEnterpriseRegistration(status, ctx.getOrgId(), pageQuery.getPageNo(), pageQuery.getPageSize()));
    }

    /**
     * 删除工商注册申请
     */
    @DeleteMapping
    public R<Void> deleteEnterpriseRegistration(@Valid @RequestBody IdBO idBO, Context ctx) {
        corporateRegistrationService.deleteEnterpriseRegistration(ctx.getOrgId(), idBO.getId());
        return R.SUCCESS;
    }

}
