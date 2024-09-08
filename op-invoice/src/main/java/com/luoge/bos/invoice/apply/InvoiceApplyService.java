package com.luoge.bos.invoice.apply;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.excel.util.StringUtils;
import com.alibaba.nacos.common.utils.CollectionUtils;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.luoge.bos.core.BosAppCode;
import com.luoge.bos.core.model.PageQuery;
import com.luoge.bos.core.types.*;
import com.luoge.bos.invoice.model.apply.*;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.core.utils.Numbers;
import com.luoge.bos.invoice.collect.schedule.NsInvoiceOutDao;
import com.luoge.bos.invoice.common.OperationRecordService;
import com.luoge.bos.invoice.common.notify.NotificationService;
import com.luoge.bos.invoice.entity.InvoiceOutDO;
import com.luoge.bos.invoice.entity.invoice.InvoiceApplyDO;
import com.luoge.bos.invoice.entity.invoice.InvoiceApplyItemDO;
import com.luoge.bos.invoice.entity.invoice.InvoiceOutItemDO;
import com.luoge.bos.invoice.entity.invoice.OperationRecordDO;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import com.luoge.ns.uc.model.msg.WxPushMsgTemplate;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class InvoiceApplyService {
    @Resource
    private InvoiceApplyDao invoiceApplyDao;

    @Resource
    private InvoiceApplyItemDao invoiceApplyItemDao;

    @Resource
    private OperationRecordService operationRecordService;

    @Resource
    private NsInvoiceOutDao nsInvoiceOutDao;

    @Resource
    private NsInvoiceOutItemDao nsInvoiceOutItemDao;

    @Resource
    private NotificationService notificationService;

    public Page<InvoiceApplyBO> listInvoiceApply(ListInvoiceApplyBO listInvoiceApplyBO, PageQuery pageQuery) {
        LocalDateTime startTime = DateUtil.toLocalDateTime(listInvoiceApplyBO.getStartTime());
        LocalDateTime endTime = DateUtil.toLocalDateTime(listInvoiceApplyBO.getEndTime());

        var invoiceApplyPage = invoiceApplyDao.list(listInvoiceApplyBO.getParkProviderId(),
                listInvoiceApplyBO.getEnterpriseName(),
                listInvoiceApplyBO.getStatus(),
                startTime,
                endTime,
                pageQuery.getPageNo(),
                pageQuery.getPageSize());

        return new Page<>(invoiceApplyPage.getTotal(), invoiceApplyPage);
    }


    public InvoiceApplyDetailBO getInvoiceApplyDetail(Long id) {
        InvoiceApplyDO invoiceApplyDO = invoiceApplyDao.getById(id);
        List<InvoiceApplyItemDO> invoiceApplyItemDO = invoiceApplyItemDao.listItemsByApplyId(id);
        InvoiceApplyDetailBO invoiceApplyDetailBO = toInvoiceApplyDetailBO(invoiceApplyDO, invoiceApplyItemDO, new InvoiceApplyDetailBO());
        setLogTime(invoiceApplyDetailBO);
        return invoiceApplyDetailBO;
    }

    private void setLogTime(InvoiceApplyDetailBO invoiceApplyDetailBO) {
        List<OperationRecordDO> operationRecords = operationRecordService.listByBusinessId(invoiceApplyDetailBO.getId());

        OperationRecordDO approveRecord = operationRecords.stream()
                .filter(x -> Objects.equals(x.getOperationType(), OperationRecord.OperationType.INVOICE_APPROVE.type))
                .findAny().orElse(null);
        if (Objects.nonNull(approveRecord)) {
            invoiceApplyDetailBO.setApproveTime(DateUtil.toTimeMills(approveRecord.getCreateTime()));
        }

        List<OperationRecordDO> rejectRecord = operationRecords.stream()
                .filter(x -> Objects.equals(x.getOperationType(), OperationRecord.OperationType.INVOICE_REJECTED.type))
                .sorted(Comparator.comparing(OperationRecordDO::getCreateTime))
                .toList();
        if (CollectionUtils.isNotEmpty(rejectRecord)) {
            OperationRecordDO last = rejectRecord.getLast();
            if (Objects.nonNull(last)) {
                invoiceApplyDetailBO.setRejectedTime(DateUtil.toTimeMills(last.getCreateTime()));
                invoiceApplyDetailBO.setRejectedReason(last.getOperationRemark());
            }
        }

        OperationRecordDO deprecatedRecord = operationRecords.stream()
                .filter(x -> Objects.equals(x.getOperationType(), OperationRecord.OperationType.INVOICE_DEPRECATED.type))
                .findAny().orElse(null);
        if (Objects.nonNull(deprecatedRecord)) {
            invoiceApplyDetailBO.setDeprecatedTime(DateUtil.toTimeMills(deprecatedRecord.getCreateTime()));
        }
    }

    private InvoiceApplyDetailBO toInvoiceApplyDetailBO(InvoiceApplyDO invoiceApplyDO, List<InvoiceApplyItemDO> invoiceApplyItemDO, InvoiceApplyDetailBO target) {
        target.setId(invoiceApplyDO.getId())
                .setBuyerName(invoiceApplyDO.getBuyerName())
                .setBuyerTaxNo(invoiceApplyDO.getBuyerTaxNo())
                .setSellerName(invoiceApplyDO.getSellerName())
                .setSellerTaxNo(invoiceApplyDO.getSellerTaxNo())
                .setTotalAmount(invoiceApplyDO.getTotalAmount())
                .setTotalTax(invoiceApplyDO.getTotalTax())
                .setTotal(invoiceApplyDO.getTotal())
                .setRemark(invoiceApplyDO.getRemark())
                .setStatus(invoiceApplyDO.getStatus())
                .setBusinessProofFileIds(
                        StringUtils.isBlank(invoiceApplyDO.getBusinessProofFileIds()) ? null :
                                Stream.of(invoiceApplyDO.getBusinessProofFileIds().split(","))
                                        .map(Numbers::toInt).collect(Collectors.toList())
                )
                .setFundProofFileIds(
                        StringUtils.isBlank(invoiceApplyDO.getFundProofFileIds()) ? null :
                                Stream.of(invoiceApplyDO.getFundProofFileIds().split(","))
                                        .map(Numbers::toInt).collect(Collectors.toList())
                )
                .setServiceFee(invoiceApplyDO.getServiceFee())
                .setPaymentProofFileId(
                        StringUtils.isBlank(invoiceApplyDO.getPaymentProofFileId()) ? null :
                                Stream.of(invoiceApplyDO.getPaymentProofFileId().split(","))
                                        .map(Numbers::toInt).collect(Collectors.toList())
                )
                .setCreateTime(DateUtil.toTimeMills(invoiceApplyDO.getCreateTime()))
                .setType(invoiceApplyDO.getInvoiceType());

        List<InvoiceApplyItemBO> collect = invoiceApplyItemDO.stream().map(item -> new InvoiceApplyItemBO()
                .setId(item.getId())
                .setName(item.getName())
                .setSpec(item.getSpec())
                .setUnit(item.getUnit())
                .setQuantity(item.getQuantity())
                .setPrice(item.getPrice())
                .setAmount(item.getAmount())
                .setTaxRate(item.getTaxRate())
                .setTax(item.getTaxAmount())
                .setSpecialType(item.getSpecialType())
        ).collect(Collectors.toList());

        target.setItems(collect);
        return target;
    }

    @DSTransactional
    public R<Void> updateInvoiceApplyStatus(UpdateInvoiceApplyStatusBO invoiceApplyStatusBO) {
        Long invoiceApplyId = invoiceApplyStatusBO.getId();
        InvoiceApplyDO invoiceApply = invoiceApplyDao.getById(invoiceApplyId);
        if (ObjectUtil.isNull(invoiceApply)) {
            return R.fail(BosAppCode.INVOICE_APPLY_NOT_EXIST);
        }
        if (ObjectUtil.equals(invoiceApply.getStatus(), InvoiceApply.Status.DONE.status)) {
            return R.fail(BosAppCode.INVOICE_APPLY_AUDITED);
        }

        InvoiceApply.Action action = null;
        if (invoiceApplyStatusBO.getOperation() == 1) {
            action = InvoiceApply.Action.APPROVE;
        } else if (invoiceApplyStatusBO.getOperation() == 2) {
            action = InvoiceApply.Action.MARK_DEPRECATED;
        } else {
            action = InvoiceApply.Action.REJECT;
        }

        InvoiceApply.Status currentStatus = InvoiceApply.Status.of(invoiceApply.getStatus());
        R<InvoiceApply.Status> nextStatus = currentStatus.onAction(action);
        if (nextStatus.failed()) {
            return R.fail(nextStatus.getCode());
        }
        LocalDateTime now = DateUtil.nowTime();
        invoiceApplyDao.updateStatus(invoiceApplyId, nextStatus.getData().status, now);

        // 保存操作日志
        saveOperationLog(invoiceApplyId, getLogActionByAction(action), invoiceApplyStatusBO);
        if (action == InvoiceApply.Action.APPROVE) {
            // 新增一条待开票状态的发票
            // 构造发票主体
            InvoiceOutDO invoice = toInvoiceOutDO(invoiceApply, now);
            nsInvoiceOutDao.insert(invoice);

            // 查询 开票申请的项目
            List<InvoiceApplyItemDO> invoiceApplyItemDOS = invoiceApplyItemDao.listItemsByApplyId(invoiceApplyId);
            if (CollectionUtils.isNotEmpty(invoiceApplyItemDOS)) {
                List<InvoiceOutItemDO> items = invoiceApplyItemDOS.stream()
                        .map(x -> toInvoiceItemDO(x, invoice.getId(), now))
                        .collect(Collectors.toList());
                nsInvoiceOutItemDao.batchSave(items);
            }
        }
        sendWxTemplateMessage(invoiceApply, action, now);
        return R.SUCCESS;
    }

    private InvoiceOutItemDO toInvoiceItemDO(InvoiceApplyItemDO a, Long invoiceId, LocalDateTime now) {
        return new InvoiceOutItemDO()
                .setOrgId(a.getOrgId())
                .setEnterpriseId(a.getEnterpriseId())
                .setInvoiceId(invoiceId)
                .setRowNo(a.getRowNo())
                .setProductId(a.getProductId())
                .setName(a.getName())
                .setSpec(a.getSpec())
                .setUnit(a.getUnit())
                .setQuantity(a.getQuantity())
                .setPrice(a.getPrice())
                .setAmount(a.getAmount())
                .setTaxRate(a.getTaxRate())
                .setTaxAmount(a.getTaxAmount())
                .setTaxCode(a.getTaxCode())
                .setType(a.getType())
                .setSpecialType(a.getSpecialType())
                .setIncludeTaxAmount(a.getIncludeTaxAmount())
                .setIncludeTaxPrice(a.getIncludeTaxPrice())
                .setCreateTime(now);
    }

    private InvoiceOutDO toInvoiceOutDO(InvoiceApplyDO a, LocalDateTime now) {
        return new InvoiceOutDO()
                .setId(IdUtil.getSnowflakeNextId())
                .setOrgId(a.getOrgId())
                .setEnterpriseId(a.getEnterpriseId())
                .setBusinessId(String.valueOf(a.getId()))
                .setInvoiceType(a.getInvoiceType())
                .setBuyerPersonalFlag(a.getBuyerPersonalFlag())
                .setBuyerName(a.getBuyerName())
                .setBuyerTaxNo(a.getBuyerTaxNo())
                .setBuyerAddress(a.getBuyerAddress())
                .setBuyerPhone(a.getBuyerPhone())
                .setBuyerBankName(a.getBuyerBankName())
                .setBuyerBankAccount(a.getBuyerBankAccount())
                .setSellerName(a.getSellerName())
                .setSellerTaxNo(a.getSellerTaxNo())
                .setSellerAddress(a.getSellerAddress())
                .setSellerPhone(a.getSellerPhone())
                .setSellerBankName(a.getSellerBankName())
                .setSellerBankAccount(a.getSellerBankAccount())
                .setTotalAmount(a.getTotalAmount())
                .setTotalTax(a.getTotalTax())
                .setTotal(a.getTotal())
                .setIssueTime(now)
                .setCategory(InvoiceCategory.BLUE.category)
                .setMethod(InvoiceMethod.MOBILE_SUBMIT.code)
                .setRemark(a.getRemark())
                .setNotifyEmail(a.getNotifyEmail())
                .setStatus(InvoiceStatus.MOBILE_APPLYING.status)
                .setIncludeTaxFlag(a.getIncludeTaxFlag())
                .setOffsetAmount(BigDecimal.ZERO)
                .setMobileUserId(a.getUserId())
                .setCreateTime(now)
                .setUpdateTime(now);
    }

    private String getLogActionByAction(InvoiceApply.Action action) {
        return switch (action) {
            case InvoiceApply.Action.REJECT -> OperationRecord.OperationType.INVOICE_REJECTED.type;
            case InvoiceApply.Action.APPROVE -> OperationRecord.OperationType.INVOICE_APPROVE.type;
            case InvoiceApply.Action.MARK_DEPRECATED -> OperationRecord.OperationType.INVOICE_DEPRECATED.type;
            default -> StringUtils.EMPTY;
        };
    }


    private void saveOperationLog(Long registrationId, String action, UpdateInvoiceApplyStatusBO invoiceApplyStatusBO) {
        OperationRecordDO operationRecordDO = new OperationRecordDO()
                .setBusinessId(registrationId)
                .setBusinessType(OperationRecord.BusinessType.INVOICE_APPLY.type)
                .setOperationType(action)
                .setOperationRemark(Objects.equals(action, OperationRecord.OperationType.INVOICE_REJECTED.type) ? invoiceApplyStatusBO.getOperationRemark() : null)
                .setCreateTime(DateUtil.nowTime());
        operationRecordService.saveOperationRecord(operationRecordDO);
    }

    private void sendWxTemplateMessage(InvoiceApplyDO invoiceApply, InvoiceApply.Action action, LocalDateTime now) {
        Map<String, String> messageParams = new HashMap<>();
        messageParams.put("id", String.valueOf(invoiceApply.getId()));
        messageParams.put("enterpriseId", String.valueOf(invoiceApply.getEnterpriseId()));
        messageParams.put("total", Numbers.toString(invoiceApply.getTotal()));
        WxPushMsgTemplate template = null;
        if (action == InvoiceApply.Action.APPROVE) {
            template = WxPushMsgTemplate.INVOICE_APPLY_APPROVED;
            messageParams.put("approveTime", DateUtil.toDateTimeString(now));
        } else if (action == InvoiceApply.Action.MARK_DEPRECATED) {
            template = WxPushMsgTemplate.INVOICE_APPLY_DEPRECATED;
            messageParams.put("deprecatedTime", DateUtil.toDateTimeString(now));
            messageParams.put("buyerName", invoiceApply.getBuyerName());
        } else if (action == InvoiceApply.Action.REJECT) {
            template = WxPushMsgTemplate.INVOICE_APPLY_REJECTED;
            messageParams.put("rejectedTime", DateUtil.toDateTimeString(now));
        }
    }

}
