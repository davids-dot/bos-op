package com.luoge.bos.invoice.org.enterprise;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.excel.util.StringUtils;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.luoge.bos.core.BosAppCode;
import com.luoge.bos.core.model.FileBO;
import com.luoge.bos.core.model.PageQuery;
import com.luoge.bos.core.types.EnterpriseRegistration;
import com.luoge.bos.core.types.EnterpriseType;
import com.luoge.bos.core.types.OperationRecord;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.core.utils.Numbers;
import com.luoge.bos.core.utils.StrUtil;
import com.luoge.bos.data.EnterpriseDao;
import com.luoge.bos.data.OrgDao;
import com.luoge.bos.invoice.common.FileService;
import com.luoge.bos.invoice.common.IndustryDao;
import com.luoge.bos.invoice.common.OperationRecordService;
import com.luoge.bos.invoice.common.notify.NotificationService;
import com.luoge.bos.invoice.configuration.AppConfig;
import com.luoge.bos.invoice.entity.invoice.EnterpriseRegistrationDO;
import com.luoge.bos.invoice.entity.invoice.IndustryDO;
import com.luoge.bos.invoice.entity.invoice.OperationRecordDO;
import com.luoge.bos.data.entity.EnterpriseDO;
import com.luoge.bos.invoice.model.excel.EnterpriseRegistrationTpl;
import com.luoge.bos.invoice.model.org.*;
import com.luoge.bos.invoice.util.ExcelUtils;
import com.luoge.bos.invoice.util.InvokeUtil;
import com.luoge.bos.invoice.util.ZipUtil;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import com.luoge.ns.uc.model.msg.WxPushMsgTemplate;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipOutputStream;

@Service
public class EnterpriseRegistrationService {

    private static final Logger logger = LoggerFactory.getLogger(EnterpriseRegistrationService.class);

    @Resource
    private EnterpriseRegistrationDao enterpriseRegistrationDao;
    @Resource
    private FileService fileService;
    @Resource
    private AppConfig appConfig;
    @Resource
    private IndustryDao industryDao;
    @Resource
    private EnterpriseDao enterpriseDao;
    @Resource
    private OperationRecordService operationRecordService;
    @Resource
    private NotificationService notificationService;
    @Resource
    private OrgDao orgDao;

    public Page<EnterpriseRegistrationBO> listEnterpriseRegistration(ListEnterpriseRegistrationBO listEnterpriseRegistrationBO, PageQuery pageQuery) {
        LocalDateTime startTime = DateUtil.toLocalDateTime(listEnterpriseRegistrationBO.getStartTime());
        LocalDateTime endTime = DateUtil.toLocalDateTime(listEnterpriseRegistrationBO.getEndTime());

        var enterpriseRegistration = enterpriseRegistrationDao.list(listEnterpriseRegistrationBO.getCorporateName(),
                listEnterpriseRegistrationBO.getParkProviderId(),
                listEnterpriseRegistrationBO.getStatus(),
                startTime,
                endTime,
                pageQuery.getPageNo(),
                pageQuery.getPageSize());

        List<EnterpriseRegistrationBO> result = enterpriseRegistration.stream()
                .map(this::toEnterpriseRegistrationBO)
                .toList();

        return new Page<>(enterpriseRegistration.getTotal(), result);
    }

    private EnterpriseRegistrationBO toEnterpriseRegistrationBO(EnterpriseRegistrationDO e) {
        EnterpriseRegistrationBO bo = new EnterpriseRegistrationBO()
                .setId(e.getId())
                .setParkProviderName(e.getParkProviderName())
                .setCorporateName(e.getCorporateName())
                .setCorporatePhone(e.getCorporatePhone())
                .setPaymentAmount(e.getPaymentAmount())
                .setStatus(e.getStatus())
                .setCreateTime(DateUtil.toTimeMills(e.getCreateTime()));

        if (ObjectUtil.equals(e.getStatus(), EnterpriseRegistration.Status.DONE.status)) {
            bo.setEnterpriseName(e.getEnterpriseName());
        } else {
            bo.setEnterpriseName(StrUtil.isNotBlank(e.getCandidateEnterpriseName()) ? e.getCandidateEnterpriseName().split(",")[0] : null);
        }
        return bo;
    }

    public EnterpriseRegistrationDetailBO getEnterpriseRegistrationDetail(Long id) {
        EnterpriseRegistrationDO enterpriseRegistrationDO = enterpriseRegistrationDao.get(id);
        IndustryDO industryDO = industryDao.getById(enterpriseRegistrationDO.getIndustryId());
        EnterpriseRegistrationDetailBO enterpriseRegistrationDetailBO = toEnterpriseRegistrationDetailBO(enterpriseRegistrationDO, industryDO);
        setLogTime(enterpriseRegistrationDetailBO);
        return enterpriseRegistrationDetailBO;
    }

    private void setLogTime(EnterpriseRegistrationDetailBO enterpriseRegistrationDetailBO) {
        List<OperationRecordDO> operationRecords = operationRecordService.listByBusinessId(enterpriseRegistrationDetailBO.getId());

        OperationRecordDO approveRecord = operationRecords.stream()
                .filter(x -> Objects.equals(x.getOperationType(), OperationRecord.OperationType.APPROVE.type))
                .findAny().orElse(null);
        if (Objects.nonNull(approveRecord)) {
            enterpriseRegistrationDetailBO.setApproveTime(DateUtil.toTimeMills(approveRecord.getCreateTime()));
        }
        OperationRecordDO finishRecord = operationRecords.stream()
                .filter(x -> Objects.equals(x.getOperationType(), OperationRecord.OperationType.DONE.type))
                .findAny().orElse(null);
        if (Objects.nonNull(finishRecord)) {
            enterpriseRegistrationDetailBO.setFinishedTime(DateUtil.toTimeMills(finishRecord.getCreateTime()));
        }
        OperationRecordDO deprecatedRecord = operationRecords.stream()
                .filter(x -> Objects.equals(x.getOperationType(), OperationRecord.OperationType.DEPRECATED.type))
                .findAny().orElse(null);
        if (Objects.nonNull(deprecatedRecord)) {
            enterpriseRegistrationDetailBO.setDeprecatedTime(DateUtil.toTimeMills(deprecatedRecord.getCreateTime()));
        }
    }

    public EnterpriseRegistrationDetailBO toEnterpriseRegistrationDetailBO(EnterpriseRegistrationDO registrationDO, IndustryDO industryDO) {


        return new EnterpriseRegistrationDetailBO()
                .setId(registrationDO.getId())
                .setCorporateName(registrationDO.getCorporateName())
                .setCorporateIdNo(registrationDO.getCorporateIdNo())
                .setCorporatePhone(registrationDO.getCorporatePhone())
                .setIdCardFrontFileId(registrationDO.getIdCardFrontFileId())
                .setIdCardBackFileId(registrationDO.getIdCardBackFileId())
                .setPhotoFileId(registrationDO.getPhotoFileId())
                .setIndustryId(industryDO.getId())
                .setIndustryName(industryDO.getName())
                .setParkProviderId(registrationDO.getParkProviderId())
                .setParkProviderName(registrationDO.getParkProviderName())
                .setCandidateEnterpriseName(StrUtil.isNotBlank(registrationDO.getCandidateEnterpriseName()) ?
                        Arrays.asList(registrationDO.getCandidateEnterpriseName().split(",")) : null)
                .setPaymentAmount(registrationDO.getPaymentAmount())
                .setCreateTime(DateUtil.toTimeMills(registrationDO.getCreateTime()))
                .setPaymentProofFileId(
                        StringUtils.isBlank(registrationDO.getPaymentProofFileId()) ? null :
                                Stream.of(registrationDO.getPaymentProofFileId().split(","))
                                        .map(Numbers::toInt).collect(Collectors.toList())
                )
                .setRealCorporateName(registrationDO.getRealCorporateName())
                .setEnterpriseName(registrationDO.getEnterpriseName())
                .setEnterpriseType(registrationDO.getEnterpriseType())
                .setEnterpriseTaxNo(registrationDO.getEnterpriseTaxNo())
                .setEnterpriseLicenseFileId(registrationDO.getEnterpriseLicenseFileId())
                .setIsBureau(registrationDO.getIsBureau())
                .setStatus(registrationDO.getStatus());
    }

    public void saveEnterpriseRegistration(SaveEnterpriseRegistrationBO enterpriseRegistration) {
        EnterpriseRegistrationDO registrationDO = toEnterpriseRegistrationDO(enterpriseRegistration);
        enterpriseRegistrationDao.update(registrationDO);
    }

    public EnterpriseRegistrationDO toEnterpriseRegistrationDO(SaveEnterpriseRegistrationBO bo) {
        LocalDateTime now = DateUtil.nowTime();
        return new EnterpriseRegistrationDO()
                .setId(bo.getId())
                .setParkProviderId(bo.getParkProviderId())
                .setIndustryId(bo.getIndustryId())
                .setIdCardFrontFileId(bo.getIdCardFrontFileId())
                .setIdCardBackFileId(bo.getIdCardBackFileId())
                .setPhotoFileId(bo.getPhotoFileId())
                .setCorporateName(bo.getCorporateName())
                .setCorporateIdNo(bo.getCorporateIdNo())
                .setCorporatePhone(bo.getCorporatePhone())
                .setIsBureau(bo.getIsBureau())
                .setParkProviderName(bo.getParkProviderName())
                .setCandidateEnterpriseName(CollUtil.isEmpty(bo.getCandidateEnterpriseName()) ? null : String.join(",", bo.getCandidateEnterpriseName()))
                .setUpdateTime(now);
    }

    public R<Void> saveEnterpriseRegistrationStatus(EnterpriseRegistrationStatusBO registrationStatusBO) {
        Long registrationId = registrationStatusBO.getId();
        EnterpriseRegistrationDO enterpriseRegistration = enterpriseRegistrationDao.getById(registrationId);
        if (ObjectUtil.isNull(enterpriseRegistration)) {
            return R.fail(BosAppCode.ENTERPRISE_REG_NOT_EXIST);
        }
        //校验状态
        if (ObjectUtil.equals(EnterpriseRegistration.Status.DONE.status, enterpriseRegistration.getStatus())) {
            return R.fail(BosAppCode.ENTERPRISE_REG_AUDITED);
        }
        EnterpriseRegistration.Action action = Objects.equals(registrationStatusBO.getOperation(), 1) ? EnterpriseRegistration.Action.APPROVE : EnterpriseRegistration.Action.MARK_DEPRECATED;

        EnterpriseRegistration.Status currentStatus = EnterpriseRegistration.Status.of(enterpriseRegistration.getStatus());
        R<EnterpriseRegistration.Status> nextStatus = currentStatus.onAction(action);
        if (nextStatus.failed()) {
            return R.fail(nextStatus.getCode());
        }
        LocalDateTime updateTime = DateUtil.nowTime();
        enterpriseRegistrationDao.updateStatus(registrationId, nextStatus.getData().status, updateTime);

        InvokeUtil.runAsync(() -> {
            // 写入操作日志
            saveOperationLog(registrationId, action == EnterpriseRegistration.Action.APPROVE ? OperationRecord.OperationType.APPROVE.type :
                    OperationRecord.OperationType.DEPRECATED.type);
            // 发送模板消息
            sendWxTemplateMessage(enterpriseRegistration, action, updateTime);
        });
        return R.SUCCESS;
    }

    private void sendWxTemplateMessage(EnterpriseRegistrationDO enterpriseRegistration, EnterpriseRegistration.Action action,
                                       LocalDateTime updateTime) {
        Map<String, String> messageParams = new HashMap<>();
        messageParams.put("id", String.valueOf(enterpriseRegistration.getId()));
        messageParams.put("corporateName", enterpriseRegistration.getCorporateName());
        WxPushMsgTemplate template = null;
        if (action == EnterpriseRegistration.Action.APPROVE) {
            template = WxPushMsgTemplate.ENTERPRISE_REGISTRATION_APPROVED;
            messageParams.put("candidateEnterpriseName",
                    StringUtils.isBlank(enterpriseRegistration.getCandidateEnterpriseName()) ?
                            "" : enterpriseRegistration.getCandidateEnterpriseName().split(",")[0]
            );
            messageParams.put("approveTime", DateUtil.toDateTimeString(updateTime));
        } else if (action == EnterpriseRegistration.Action.MARK_DEPRECATED) {
            template = WxPushMsgTemplate.ENTERPRISE_REGISTRATION_DEPRECATED;
            messageParams.put("deprecateTime", DateUtil.toDateTimeString(updateTime));
        }

    }

    private void saveOperationLog(Long registrationId, String action) {
        OperationRecordDO operationRecordDO = new OperationRecordDO()
                .setBusinessId(registrationId)
                .setBusinessType(OperationRecord.BusinessType.ENTERPRISE_REGISTRATION.type)
                .setOperationType(action)
                .setCreateTime(DateUtil.nowTime());
        operationRecordService.saveOperationRecord(operationRecordDO);
    }

    @DSTransactional
    public R<Void> saveEnterpriseRegistrationResult(EnterpriseRegistrationResultBO regResult) {
        Long registrationId = regResult.getId();
        EnterpriseRegistrationDO registrationDO = enterpriseRegistrationDao.getById(registrationId);
        if (ObjectUtil.isNull(registrationDO)) {
            return R.fail(BosAppCode.ENTERPRISE_REG_NOT_EXIST);
        }
        EnterpriseRegistration.Status currentStatus = EnterpriseRegistration.Status.of(registrationDO.getStatus());
        R<EnterpriseRegistration.Status> nextStatus = currentStatus.onAction(EnterpriseRegistration.Action.RECORD_RESULT);
        if (nextStatus.failed()) {
            return R.fail(nextStatus.getCode());
        }
        Integer orgId = registrationDO.getOrgId();
        if (enterpriseDao.existName(orgId, regResult.getEnterpriseName())) {
            return R.fail(BosAppCode.EXIST_ENTERPRISE_NAME);
        }
        EnterpriseDO existEnterprise = enterpriseDao.getByTaxNo(orgId, regResult.getEnterpriseTaxNo());
        if (Objects.nonNull(existEnterprise)) {
            return R.fail(BosAppCode.EXIST_TAX_NO);
        }
        // 保存工商注册结果信息
        EnterpriseRegistrationDO enterpriseRegistrationDO = toEnterpriseRegistrationDO(regResult, nextStatus.getData().status);
        enterpriseRegistrationDao.updateResult(enterpriseRegistrationDO);

        // 生成企业
        EnterpriseDO enterpriseDO = toEnterpriseDO(regResult, orgId);
        enterpriseDao.insert(enterpriseDO);
        // 添加企业用户关系
        enterpriseDao.insertEnterpriseUserRelation(orgId, enterpriseDO.getId(), registrationDO.getUserId(), DateUtil.nowTime());

        // 如果是机构下的第一家企业， 回写 法人 名称到 机构名称
        if (Objects.equals(1, orgDao.countEnterprise(orgId))) {
            orgDao.updateName(regResult.getRealCorporateName(), orgId, DateUtil.nowTime());
        }

        // 记录操作日志
        saveOperationLog(registrationId, OperationRecord.OperationType.DONE.type);
        // 发送微信模板消息
        sendRegistrationFinishMessage(regResult, enterpriseRegistrationDO, registrationDO.getUserId());

        return R.SUCCESS;
    }

    private void sendRegistrationFinishMessage(EnterpriseRegistrationResultBO regResult,
                                               EnterpriseRegistrationDO enterpriseRegistrationDO, Integer userId) {
        Map<String, String> messageParams = new HashMap<>();
        messageParams.put("id", String.valueOf(enterpriseRegistrationDO.getId()));
        messageParams.put("enterpriseName", regResult.getEnterpriseName());
        messageParams.put("enterpriseTaxNo", regResult.getEnterpriseTaxNo());
        messageParams.put("finishTime", DateUtil.toDateTimeString(enterpriseRegistrationDO.getUpdateTime()));

//        notificationService.sendWxTemplateMessage(userId,
//                WxPushMsgTemplate.ENTERPRISE_REGISTRATION_DONE, messageParams);
    }

    public EnterpriseDO toEnterpriseDO(EnterpriseRegistrationResultBO registrationResultBO, Integer orgId) {
        LocalDateTime now = DateUtil.nowTime();
        return new EnterpriseDO()
                .setOrgId(orgId)
                .setName(registrationResultBO.getEnterpriseName())
                .setTaxNo(registrationResultBO.getEnterpriseTaxNo())
                .setCreateTime(now)
                .setType(EnterpriseType.SMALL_TAXPAYER.getType())
                .setStatus(1)
                .setUpdateTime(now);
    }

    public EnterpriseRegistrationDO toEnterpriseRegistrationDO(EnterpriseRegistrationResultBO registrationResultBO, Integer status) {
        LocalDateTime now = DateUtil.nowTime();
        return new EnterpriseRegistrationDO()
                .setId(registrationResultBO.getId())
                .setEnterpriseName(registrationResultBO.getEnterpriseName())
                .setEnterpriseTaxNo(registrationResultBO.getEnterpriseTaxNo())
                .setEnterpriseType(registrationResultBO.getEnterpriseType())
                .setRealCorporateName(registrationResultBO.getRealCorporateName())
                .setEnterpriseLicenseFileId(registrationResultBO.getEnterpriseLicenseFileId())
                .setStatus(status)
                .setUpdateTime(now);
    }


    public void exportEnterpriseRegistrationDetail(long id, HttpServletResponse response) throws Exception {


        // 工商注册单
        EnterpriseRegistrationDO enterpriseRegistration = enterpriseRegistrationDao.get(id);
        // 设置响应头信息 write前设置否则不生效
        response.setContentType("application/octet-stream");
        // 使用URLEncoder.encode 防止中文乱码
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(enterpriseRegistration.getCorporateName() + "_工商注册申请资料.zip", "UTF-8"));

        // 组装成excel
        EnterpriseRegistrationTpl registrationTpl = toEnterpriseRegistrationTpl(enterpriseRegistration);
        String fileName = "工商注册_" + id;

        String excelFileName = appConfig.getTemporaryPath() + File.separatorChar + fileName + ".xlsx";
        // 生成excel
        FileOutputStream outputStream = new FileOutputStream(excelFileName);
        ExcelUtils.exportExcel(outputStream, fileName, List.of(registrationTpl), EnterpriseRegistrationTpl.class);
        // 下载图片文件
        List<Integer> fileIds = CollUtil.newArrayList(enterpriseRegistration.getIdCardFrontFileId(), enterpriseRegistration.getIdCardBackFileId(),
                enterpriseRegistration.getPhotoFileId(), enterpriseRegistration.getEnterpriseLicenseFileId());
        fileIds.addAll(CollUtil.newArrayList(enterpriseRegistration.getPaymentProofFileId().split(StrPool.COMMA)).stream().map(Integer::valueOf).collect(Collectors.toList()));
        List<FileBO> pictures = fileIds.stream()
                .filter(Objects::nonNull)
                .map(x -> fileService.downloadFile(x))
                .filter(R::ok).map(R::getData).toList();

        // 生成zip 文件
        // 创建ZIP输出流
        try (ZipOutputStream zos = new ZipOutputStream(response.getOutputStream())) {
            ZipUtil.addFileToZip(excelFileName, fileName + ".xlsx", zos);

            for (FileBO picture : pictures) {
                ZipUtil.addFileToZip(picture.getContent(), System.nanoTime() + picture.getOriginalName(), zos);
            }

            // 完成ZIP文件的创建
            zos.finish();

        } finally {
            outputStream.close();
            File tempExcelFile = new File(excelFileName);
            if (tempExcelFile.exists()) {
                tempExcelFile.delete();
            }
        }
    }

    private EnterpriseRegistrationTpl toEnterpriseRegistrationTpl(EnterpriseRegistrationDO e) {
        return new EnterpriseRegistrationTpl()
                .setCorporateName(e.getCorporateName())
                .setCorporateIdNo(e.getCorporateIdNo())
                .setCorporatePhone(e.getCorporatePhone())
                .setIndustryName(industryDao.getById(e.getIndustryId()).getName())
                .setProviderName(e.getParkProviderName())
                .setCandidateNames(e.getCandidateEnterpriseName())
                .setPaymentAmount(Numbers.toString(e.getPaymentAmount()));
    }

}
