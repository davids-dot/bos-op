package com.luoge.bos.invoice.org.enterprise;

import com.luoge.bos.invoice.model.org.*;
import com.luoge.bos.invoice.util.ParamValidator;
import com.luoge.bos.core.BosAppCode;
import com.luoge.bos.core.model.PageQuery;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * 机构管理/企业注册
 */
@RequestMapping("/bos-op/enterprise/registration")
@RestController
public class EnterpriseRegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(EnterpriseRegistrationController.class);

    @Resource
    private EnterpriseRegistrationService enterpriseRegistrationService;


    /**
     * 查看工商注册申请列表
     */
    @GetMapping
    public R<Page<EnterpriseRegistrationBO>> listEnterpriseRegistration(ListEnterpriseRegistrationBO listEnterpriseRegistrationBO,
                                                                        PageQuery pageQuery) {
        pageQuery.check();
        return R.success(enterpriseRegistrationService.listEnterpriseRegistration(listEnterpriseRegistrationBO, pageQuery));
    }

    /**
     * 保存工商注册信息
     */
    @PutMapping
    public R<Void> saveEnterpriseRegistration(@Valid @RequestBody SaveEnterpriseRegistrationBO enterpriseRegistration) {
        enterpriseRegistrationService.saveEnterpriseRegistration(enterpriseRegistration);
        return R.SUCCESS;
    }

    /**
     * 审核通过或作废工商注册单
     */
    @PutMapping("/status")
    public R<Void> saveEnterpriseRegistrationStatus(@RequestBody EnterpriseRegistrationStatusBO registrationStatusBO) {
        return enterpriseRegistrationService.saveEnterpriseRegistrationStatus(registrationStatusBO);
    }

    /**
     * 查看工商注册单详情
     */
    @GetMapping("/detail")
    public R<EnterpriseRegistrationDetailBO> getEnterpriseRegistrationDetail(@RequestParam(name = "id") Long id) {
        EnterpriseRegistrationDetailBO enterpriseRegistrationDetail = enterpriseRegistrationService.getEnterpriseRegistrationDetail(id);
        return R.success(enterpriseRegistrationDetail);
    }

    /**
     * 导出工商注册单资料
     */
    @GetMapping("/detail/export")
    public R<Void> exportEnterpriseRegistrationDetail(@RequestParam(name = "id") long id, HttpServletResponse response) {
        try {
            enterpriseRegistrationService.exportEnterpriseRegistrationDetail(id, response);
        } catch (Exception e) {
            logger.error("invoice get file error", e);
            return R.fail(BosAppCode.FILE_DOWNLOAD_ERROR);
        }
        return null;
    }

    /**
     * 填写工商注册结果信息
     */
    @PutMapping("/result")
    public R<Void> saveEnterpriseRegistrationResult(@Valid @RequestBody EnterpriseRegistrationResultBO enterpriseRegistrationResultBO) {
        if (!ParamValidator.validateTaxNo(enterpriseRegistrationResultBO.getEnterpriseTaxNo())) {
            return R.fail(BosAppCode.INVALID_TAX_NO);
        }
        return enterpriseRegistrationService.saveEnterpriseRegistrationResult(enterpriseRegistrationResultBO);
    }
}
