package com.luoge.bos.invoice.park.enterprisereg;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.excel.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.luoge.bos.common.IDUtil;
import com.luoge.bos.invoice.entity.EnterpriseRegistrationDO;
import com.luoge.bos.invoice.entity.ParkProviderDO;
import com.luoge.bos.invoice.model.*;
import com.luoge.bos.invoice.park.industry.IndustryService;
import com.luoge.bos.invoice.park.provider.AppParkProviderDao;
import com.luoge.bos.core.BosAppCode;
import com.luoge.bos.core.types.EnterpriseRegistration;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.core.utils.Numbers;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CorporateRegistrationService {

    @Resource
    private CorporateRegistrationDao corporateRegistrationDao;

    @Resource
    private IndustryService industryService;
    @Resource
    private AppParkProviderDao appParkProviderDao;

    public R<IdBO> saveEnterpriseRegistration(SaveEnterpriseRegistrationBO enterpriseRegistration, int orgId, int userId) {
        EnterpriseRegistrationDO enterpriseRegistrationDO = toEnterpriseRegistrationDO(enterpriseRegistration, orgId, userId);
        enterpriseRegistrationDO.setId(IDUtil.getSnowflakeNextId());
        buildParkProviderAccountInfo(enterpriseRegistrationDO);
        corporateRegistrationDao.insert(enterpriseRegistrationDO);
        return R.success(new IdBO(enterpriseRegistrationDO.getId()));
    }

    /**
     * 组装园区服务商信息
     */
    private void buildParkProviderAccountInfo(EnterpriseRegistrationDO enterpriseRegistrationDO) {
        if (ObjectUtil.isNotEmpty(enterpriseRegistrationDO.getParkProviderId())) {
            ParkProviderDO parkProviderDO = appParkProviderDao.get(enterpriseRegistrationDO.getParkProviderId());
            enterpriseRegistrationDO
                    .setPaymentAmount(parkProviderDO.getRegistrationFee())
                    .setParkProviderName(parkProviderDO.getName())
                    .setParkProviderAccountName(parkProviderDO.getAccountName())
                    .setParkProviderAccountBank(parkProviderDO.getAccountBank())
                    .setParkProviderAccountNo(parkProviderDO.getAccountNo());
        }
    }

    /**
     * 提交工商注册付款凭证
     */
    public R<Void> submitEnterpriseRegistrationPayment(PaymentEnterpriseRegistrationBO paymentEnterpriseRegistrationBO) {
        EnterpriseRegistrationDO enterpriseRegistrationDO = corporateRegistrationDao.getById(paymentEnterpriseRegistrationBO.getId());
        if (ObjectUtil.isNull(enterpriseRegistrationDO)) {
            return R.fail(BosAppCode.ENTERPRISE_REG_NOT_EXIST);
        }
        EnterpriseRegistration.Status currentStatus = EnterpriseRegistration.Status.of(enterpriseRegistrationDO.getStatus());
        R<EnterpriseRegistration.Status> nextStausR = currentStatus.onAction(EnterpriseRegistration.Action.SUBMIT_PAYMENT);
        if (nextStausR.failed()) {
            return R.fail(nextStausR.getCode());
        }
        paymentEnterpriseRegistrationBO.setStatus(nextStausR.getData().status);
        String paymentProofFileId =
                paymentEnterpriseRegistrationBO.getPaymentProofFileId()
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(","));
        corporateRegistrationDao.updateEnterprisePayment(
                paymentEnterpriseRegistrationBO.getId(),
                paymentProofFileId,
                paymentEnterpriseRegistrationBO.getStatus());
        return R.SUCCESS;
    }

    private EnterpriseRegistrationDO toEnterpriseRegistrationDO(SaveEnterpriseRegistrationBO enterpriseRegistration, int orgId, int userId) {
        LocalDateTime nowTime = DateUtil.nowTime();
        return new EnterpriseRegistrationDO()
                .setId(enterpriseRegistration.getId())
                .setOrgId(orgId)
                .setUserId(userId)
                .setStatus(EnterpriseRegistration.Status.TO_PAY.status)
                .setParkProviderId(enterpriseRegistration.getParkProviderId())
                .setIndustryId(enterpriseRegistration.getIndustryId())
                .setIdCardFrontFileId(enterpriseRegistration.getIdCardFrontFileId())
                .setIdCardBackFileId(enterpriseRegistration.getIdCardBackFileId())
                .setPhotoFileId(enterpriseRegistration.getPhotoFileId())
                .setCorporateName(enterpriseRegistration.getCorporateName())
                .setCorporateIdNo(enterpriseRegistration.getCorporateIdNo())
                .setCorporatePhone(enterpriseRegistration.getCorporatePhone())
                .setIsBureau(Objects.equals(enterpriseRegistration.getIsBureau(), 1))
                .setCandidateEnterpriseName(Strings.join(enterpriseRegistration.getCandidateEnterpriseNames(), ','))
                .setPaymentProofFileId(enterpriseRegistration.getPaymentProofFileId())
                .setPaymentAmount(enterpriseRegistration.getPaymentAmount())
                .setParkProviderAccountName(enterpriseRegistration.getParkProviderAccountName())
                .setParkProviderAccountBank(enterpriseRegistration.getParkProviderAccountBank())
                .setParkProviderAccountNo(enterpriseRegistration.getParkProviderAccountNo())
                .setParkProviderId(enterpriseRegistration.getParkProviderId())
                .setParkProviderName(enterpriseRegistration.getParkProviderName())
                .setEnterpriseName(enterpriseRegistration.getEnterpriseName())
                .setEnterpriseType(enterpriseRegistration.getEnterpriseType())
                .setEnterpriseTaxNo(enterpriseRegistration.getEnterpriseTaxNo())
                .setEnterpriseLicenseFileId(enterpriseRegistration.getEnterpriseLicenseFileId())
                .setUpdateTime(nowTime)
                .setCreateTime(nowTime)
                .setHasOtherEnterprise(ObjectUtil.equals(enterpriseRegistration.getHasOtherEnterprise(), 1));
    }

    /**
     * 工商注册列表
     */
    public Page<EnterpriseRegistrationVO> listEnterpriseRegistration(Integer status, int orgId, int pageNo, int pageSize) {
        com.github.pagehelper.Page<EnterpriseRegistrationDO> enterpriseRegistrations = PageHelper.startPage(pageNo, pageSize)
                .doSelectPage(() -> corporateRegistrationDao.listByStatus(status, orgId));
        List<EnterpriseRegistrationVO> res = enterpriseRegistrations.getResult()
                .stream()
                .map(this::toEnterpriseRegistrationVO)
                .collect(Collectors.toList());
        return new Page<>(enterpriseRegistrations.getTotal(), res);
    }

    private EnterpriseRegistrationVO toEnterpriseRegistrationVO(EnterpriseRegistrationDO enterpriseRegistrationDO) {
        IndustryVO industryVO = industryService.getById(enterpriseRegistrationDO.getIndustryId());
        return new EnterpriseRegistrationVO()
                .setId(enterpriseRegistrationDO.getId())
                .setIndustryId(enterpriseRegistrationDO.getIndustryId())
                .setIndustryName(ObjectUtil.isNull(industryVO) ? "--" : industryVO.getName())
                .setStatus(enterpriseRegistrationDO.getStatus())
                .setPaymentAmount(enterpriseRegistrationDO.getPaymentAmount())
                .setParkProviderName(enterpriseRegistrationDO.getParkProviderName())
                .setCreateTime(enterpriseRegistrationDO.getCreateTime().toInstant(ZoneOffset.of("+8")).toEpochMilli())
                //如果企业名称为空(未审核)并且候选企业名称非空返回第一个候选企业名称
                .setEnterpriseName(
                        (StringUtils.isBlank(enterpriseRegistrationDO.getEnterpriseName()) && StringUtils.isNotBlank(enterpriseRegistrationDO.getCandidateEnterpriseName()))
                                ? enterpriseRegistrationDO.getCandidateEnterpriseName().split(",")[0]
                                : enterpriseRegistrationDO.getEnterpriseName());
    }

    /**
     * 获取工商注册详情
     */
    public EnterpriseRegistrationDetailVO getEnterpriseRegistrationDetail(Long id) {
        EnterpriseRegistrationDO enterpriseRegistrationDO = corporateRegistrationDao.getById(id);
        if (ObjectUtil.isNull(enterpriseRegistrationDO)) {
            return null;
        }
        return toEnterpriseRegistrationDetailVO(enterpriseRegistrationDO);
    }

    private EnterpriseRegistrationDetailVO toEnterpriseRegistrationDetailVO(EnterpriseRegistrationDO enterpriseReg) {
        return new EnterpriseRegistrationDetailVO()
                .setId(enterpriseReg.getId())
                .setOrgId(enterpriseReg.getOrgId())
                .setUserId(enterpriseReg.getUserId())
                .setStatus(enterpriseReg.getStatus())
                .setIndustryId(enterpriseReg.getIndustryId())
                .setIndustryName(industryService.getById(enterpriseReg.getIndustryId()).getName())
                .setIdCardFrontFileId(enterpriseReg.getIdCardFrontFileId())
                .setIdCardBackFileId(enterpriseReg.getIdCardBackFileId())
                .setPhotoFileId(enterpriseReg.getPhotoFileId())
                // 法人名称
                .setCorporateName(StringUtils.isNotBlank(enterpriseReg.getRealCorporateName()) ? enterpriseReg.getRealCorporateName()
                        : enterpriseReg.getCorporateName())
                .setCorporateIdNo(enterpriseReg.getCorporateIdNo())
                .setCorporatePhone(enterpriseReg.getCorporatePhone())
                .setBureau(enterpriseReg.getIsBureau())
                .setCandidateEnterpriseNames(cn.hutool.core.util.StrUtil.isBlank(enterpriseReg.getCandidateEnterpriseName()) ? Collections.emptyList() : Arrays.asList(enterpriseReg.getCandidateEnterpriseName().split(",")))
                .setPaymentProofFileId(enterpriseReg.getPaymentProofFileId())
                .setPaymentAmount(enterpriseReg.getPaymentAmount())
                .setParkProviderAccountName(enterpriseReg.getParkProviderAccountName())
                .setParkProviderAccountBank(enterpriseReg.getParkProviderAccountBank())
                .setParkProviderAccountNo(enterpriseReg.getParkProviderAccountNo())
                .setParkProviderId(enterpriseReg.getParkProviderId())
                .setParkProviderName(enterpriseReg.getParkProviderName())
                // 真实企业名称
                .setEnterpriseName(enterpriseReg.getEnterpriseName())
                .setEnterpriseType(enterpriseReg.getEnterpriseType())
                .setEnterpriseTaxNo(enterpriseReg.getEnterpriseTaxNo())
                .setEnterpriseLicenseFileId(enterpriseReg.getEnterpriseLicenseFileId())
                .setHasOtherEnterprise(enterpriseReg.getHasOtherEnterprise())
                .setCreateTime(DateUtil.toTimeMills(enterpriseReg.getCreateTime()))
                .setUpdateTime(DateUtil.toTimeMills(enterpriseReg.getUpdateTime()));
    }

    public void deleteEnterpriseRegistration(int orgId, String id) {
        corporateRegistrationDao.delete(orgId, Numbers.toLong(id));
    }
}
