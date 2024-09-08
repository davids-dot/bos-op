package com.luoge.app.uc.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.mail.Mail;
import cn.hutool.extra.mail.MailAccount;
import com.alibaba.fastjson2.JSON;
import com.luoge.app.uc.model.SmsPurpose;
import com.luoge.bos.data.model.SendSmsBO;
import com.luoge.ns.core.AppException;
import com.luoge.ns.core.Code;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.activation.DataSource;
import java.io.InputStream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service()
public class NotificationCenterService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationCenterService.class);
//    @Resource
//    private EmailTemplateDao emailTemplateDao;
    @Resource
    private SmsService smsService;
//    @Resource
//    private WxMessageService wxMessageService;
//    @Resource
//    private EnterpriseService enterpriseService;
//    @Resource
//    private QwService qwService;
//    @Resource
//    private UserService userService;
//    @Resource
//    private NotifyMsgBuilder notifyMsgBuilder;
//    @Resource
//    private MessageRuleService messageRuleService;
//    @Resource
//    private MsgPushRecordDao msgPushRecordDao;


    /**
     * 发送邮件
     *
     */
//    public void sendEmail(SendEmailBO sendEmailBO, MailPurpose mailPurpose) {
//        MailPurposeTemplate mailTemplate = MailPurposeTemplate.of(mailPurpose.purpose);
//        if (Objects.isNull(mailTemplate)) {
//            throw new AppException(UCCode.MAIL_TEMPLATE_NOT_EXIST);
//        }
//        EmailTemplateDO emailTemplateDO = emailTemplateDao.get(mailTemplate.templateId);
//        if (Objects.isNull(emailTemplateDO)) {
//            throw new AppException(UCCode.MAIL_TEMPLATE_NOT_EXIST);
//        }
//        sendEmailBO.setSubject(emailTemplateDO.getTitle());
//        sendEmailBO.setContent(emailTemplateDO.getContent());
//        replaceVariable(sendEmailBO);
//        sendEmail(sendEmailBO);
//    }

    public R<Void> sendSmsMessage(SendSmsBO sendSmsBO, SmsPurpose smsPurpose) {
        return smsService.sendSms(smsPurpose, sendSmsBO.getReceiver(),
                sendSmsBO.getParams().values().stream().toList());
    }

//    private void replaceVariable(SendEmailBO sendEmailBO) {
//        Map<String, String> params = sendEmailBO.getParams();
//        if (MapUtils.isEmpty(params)) {
//            return;
//        }
//        String subject = notifyMsgBuilder.replaceVariable(sendEmailBO.getSubject(), params);
//        String content = notifyMsgBuilder.replaceVariable(sendEmailBO.getContent(), params);
//        sendEmailBO.setSubject(subject);
//        sendEmailBO.setContent(content);
//    }
//
//    public static void sendEmail(SendEmailBO sendEmailBO) {
//        // 发送邮件
//        sendEmail(sendEmailBO.getTos(), sendEmailBO.getCcs(), sendEmailBO.getBccs(),
//                sendEmailBO.getSubject(), sendEmailBO.getContent(), sendEmailBO.getImageMap(), sendEmailBO.isHtml(), sendEmailBO.getAttachments());
//    }
//
//    public static String sendEmail(Collection<String> tos, Collection<String> ccs,
//                                   Collection<String> bccs, String subject, String content,
//                                   Map<String, InputStream> imageMap, boolean isHtml, List<DataSource> attachments) {
//
//        MailAccount mailAccount = MailAccountConfig.INSTANCE.getAccount();
//        final Mail mail = Mail.create(mailAccount).setUseGlobalSession(false);
//
//        // 可选抄送人
//        if (CollUtil.isNotEmpty(ccs)) {
//            mail.setCcs(ccs.toArray(new String[0]));
//        }
//        // 可选密送人
//        if (CollUtil.isNotEmpty(bccs)) {
//            mail.setBccs(bccs.toArray(new String[0]));
//        }
//
//        mail.setTos(tos.toArray(new String[0]));
//        mail.setTitle(subject);
//        mail.setContent(content);
//        mail.setHtml(isHtml);
//        if (CollectionUtils.isNotEmpty(attachments)) {
//            mail.setAttachments(attachments.toArray(new DataSource[0]));
//        }
//
//        // 图片
//        if (MapUtil.isNotEmpty(imageMap)) {
//            for (Map.Entry<String, InputStream> entry : imageMap.entrySet()) {
//                mail.addImage(entry.getKey(), entry.getValue());
//                // 关闭流
//                IoUtil.close(entry.getValue());
//            }
//        }
//
//        return mail.send();
//    }
//
//    /**
//     * 发送模板消息
//     */
//    public R<Void> sendWxTemplateMessage(Integer orgId,
//                                         Integer enterpriseId,
//                                         int userId,
//                                         String appId,
//                                         WxPushMsgTemplate template,
//                                         Map<String, String> templateParams) {
//        orgId = Objects.requireNonNullElse(orgId, 0);
//        enterpriseId = Objects.requireNonNullElse(enterpriseId, 0);
//        R<R<Void>> sendRR = messageRuleService.runAfterRuleCheck(orgId, enterpriseId, StringUtils.EMPTY, userId, NotifyChannelEnum.WX.getType(), template.name(),
//                () -> wxMessageService.pushTemplateMessage(userId, appId, template, templateParams));
//
//        if (sendRR.failed()) {
//            return R.fail(sendRR);
//        }
//        R<Void> sendR = sendRR.getData();
//        if (sendR.ok()) {
//            MsgPushRecordDO msgPushRecord = new MsgPushRecordDO()
//                    .setOrgId(orgId)
//                    .setEnterpriseId(enterpriseId)
//                    .setOpenId(StringUtils.EMPTY)
//                    .setUserId(userId)
//                    .setChannel(NotifyChannelEnum.WX.getType())
//                    .setBizMsgType(template.name())
//                    .setContent(StrUtil.safeSubString(JSON.toJSONString(templateParams), 200))
//                    .setCreateTime(DateUtil.nowTime());
//            msgPushRecordDao.insert(msgPushRecord);
//        }
//        return sendR;
//    }
//
//    public R<Void> sendWxTemplateMessageByEnterprise(int orgId, int enterpriseId, String appId,
//                                                     WxPushMsgTemplate template, Map<String, String> templateParams) {
//        //  查询企业的第一个用户
//        List<UserDO> enterpriseUsers = enterpriseService.listEnterpriseUsers(orgId, enterpriseId, null);
//        if (CollectionUtils.isEmpty(enterpriseUsers)) {
//            logger.warn("当前企业无可推送用户");
//            return R.fail(UCCode.NO_USER_IN_ENTERPRISE);
//        }
//        int userId = enterpriseUsers.getFirst().getId();
//        // 发送微信消息
//        return sendWxTemplateMessage(orgId, enterpriseId, userId, appId, template, templateParams);
//    }
//
//    public R<Void> sendWxTemplateMessage(List<String> openIds,
//                                         WxPushMsgTemplate template, Map<String, String> templateParams) {
//        if (CollectionUtil.isEmpty(openIds)) {
//            return R.fail(Code.ILLEGAL_PARAMETER);
//        }
//        WxMpTemplateMessage wxMpTemplateMessage = notifyMsgBuilder.buildWxTemplateMsg(template, templateParams);
//        try {
//            for (String openId : openIds) {
//                wxMpTemplateMessage.setToUser(openId);
//                wxMessageService.sendTemplateMsg(wxMpTemplateMessage);
//            }
//            return R.SUCCESS;
//        } catch (Exception e) {
//            logger.error("push wx template msg error", e);
//        }
//        return R.fail(UCCode.WX_PUSH_TEMPLATE_MSG_FAILED);
//    }
//
//
//    public <T extends BaseMsgBO> R<Void> sendByChannel(int orgId, int enterpriseId, Integer channel,
//                                                       List<NotifyConfigBO> configs, BusinessMsgType type, T data) {
//        NotifyChannelEnum notifyChannel = NotifyChannelEnum.of(channel);
//        if (ObjectUtil.equals(notifyChannel, NotifyChannelEnum.UNKNOWN)) {
//            return R.fail(UCCode.NOTIFY_CHANNEL_UNKNOWN);
//        }
//        // 筛选重复用户
//        List<NotifyConfigBO> notifyConfigBOS = new ArrayList<>(configs
//                .stream()
//                .filter(item -> StringUtils.isNotBlank(item.getTargetName()) && Objects.equals(channel, item.getChannel()))
//                .collect(Collectors.toMap(NotifyConfigBO::getTargetName, Function.identity(), (key1, key2) -> key1))
//                .values());
//
//        if (CollectionUtil.isEmpty(notifyConfigBOS)) {
//            return R.fail(UCCode.NOT_EXIST_NOTIFY_CONFIG);
//        }
//        return switch (notifyChannel) {
//            case QW ->
//                    sendQwCardMsg(orgId, enterpriseId, type, notifyConfigBOS, notifyMsgBuilder.buildQwCardMsgData(type, data));
//            case WX ->
//                    sendWxNotifyMsg(orgId, enterpriseId, type, notifyConfigBOS, notifyMsgBuilder.buildWxTemplateMsg(type, data));
//            default -> R.fail(UCCode.NOTIFY_CHANNEL_UNKNOWN);
//        };
//    }
//
//
//    /**
//     * 发送企微通知
//     */
//    public R<Void> sendQwTextMsg(int orgId, Integer enterpriseId, List<NotifyConfigBO> notifyConfigBOS, String message) {
//        if (StringUtils.isBlank(message)) {
//            return R.fail(UCCode.NOTIFY_MSG_CAN_NOT_EMPTY);
//        }
//
//        List<NotifyConfigBO.QWContent> qwContents = notifyConfigBOS.stream()
//                .map(item -> (NotifyConfigBO.QWContent) item.getTargetContent())
//                .filter(Objects::nonNull)
//                .toList();
//
//        String toUser = qwContents.stream()
//                .map(NotifyConfigBO.QWContent::getQwUserId)
//                .distinct()
//                .collect(Collectors.joining(QWConstants.CONCAT_STR));
//
//        return qwService.sendTextMessage(orgId, new SendQwMessageBO()
//                .setOrgId(orgId)
//                .setToUser(toUser)
//                .setContent(message));
//    }
//
//    /**
//     * 发送企微通知
//     */
//    public R<Void> sendQwCardMsg(int orgId, int enterpriseId, BusinessMsgType type, List<NotifyConfigBO> notifyConfigBOS, QwCardMessageBO qwCardMessageBO) {
//        if (Objects.isNull(qwCardMessageBO) || StringUtils.isBlank(qwCardMessageBO.getDescription())) {
//            return R.fail(UCCode.NOTIFY_MSG_CAN_NOT_EMPTY);
//        }
//        List<NotifyConfigBO.QWContent> qwContents = notifyConfigBOS.stream()
//                .map(item -> (NotifyConfigBO.QWContent) item.getTargetContent())
//                .filter(Objects::nonNull)
//                .toList();
//
//        String toUser = qwContents.stream()
//                .map(NotifyConfigBO.QWContent::getQwUserId)
//                .distinct()
//                .collect(Collectors.joining(QWConstants.CONCAT_STR));
//
//        SendQwCardMessageBO sendQwCardMessageBO = new SendQwCardMessageBO()
//                .setOrgId(orgId)
//                .setToUser(toUser)
//                .setTitle(qwCardMessageBO.getTitle())
//                .setDescription(qwCardMessageBO.getDescription())
//                .setUrl(qwCardMessageBO.getUrl());
//
//        return sendQwCardMsgWithRule(orgId, enterpriseId, type, sendQwCardMessageBO);
//    }
//
//
//    private R<Void> sendQwCardMsgWithRule(int orgId, int enterpriseId, BusinessMsgType type, SendQwCardMessageBO sendQwCardMessageBO) {
//        logger.info("before send qw card message, orgId:{},enterpriseId:{}, type:{}", orgId, enterpriseId, type);
//        R<R<Void>> sendRR = messageRuleService.runAfterRuleCheck(orgId, enterpriseId, sendQwCardMessageBO.getToUser(), 0, NotifyChannelEnum.QW.getType(), type.name(),
//                () -> qwService.sendCardMessage(orgId, sendQwCardMessageBO));
//        if (sendRR.failed()) {
//            return R.fail(sendRR);
//        }
//        R<Void> sendR = sendRR.getData();
//        if (sendR.ok()) {
//            MsgPushRecordDO msgPushRecord = new MsgPushRecordDO()
//                    .setOrgId(orgId)
//                    .setEnterpriseId(enterpriseId)
//                    .setUserId(0)
//                    .setOpenId(sendQwCardMessageBO.getToUser())
//                    .setChannel(NotifyChannelEnum.QW.getType())
//                    .setBizMsgType(type.name())
//                    .setContent(StrUtil.safeSubString(JSON.toJSONString(sendQwCardMessageBO), 200))
//                    .setCreateTime(DateUtil.nowTime());
//            msgPushRecordDao.insert(msgPushRecord);
//        }
//        return sendR;
//    }
//
//
//    private <T> R<Void> sendWxNotifyMsg(int orgId, int enterpriseId, BusinessMsgType type, List<NotifyConfigBO> notifyConfigBOS,
//                                        WxMpTemplateMessage templateMessage) {
//        if (Objects.isNull(templateMessage)) {
//            logger.error("微信模板消息为空");
//            return R.fail(UCCode.NOTIFY_MSG_CAN_NOT_EMPTY);
//        }
//        List<String> openIds = notifyConfigBOS.stream().
//                map(item -> (NotifyConfigBO.WXContent) item.getTargetContent())
//                .map(NotifyConfigBO.WXContent::getWxMpOpenId)
//                .filter(ObjectUtil::isNotNull)
//                .toList();
//
//        for (String openId : openIds) {
//            templateMessage.setToUser(openId);
//            sendTemplateMsgWithRule(orgId, enterpriseId, openId, type.name(), templateMessage);
//        }
//        return R.SUCCESS;
//    }
//
//    private R<Void> sendTemplateMsgWithRule(int orgId, int enterpriseId, String openId, String bizMsgType, WxMpTemplateMessage mpTemplateMessage) {
//        R<R<Void>> sendRR = messageRuleService.runAfterRuleCheck(orgId, enterpriseId, openId, 0, NotifyChannelEnum.WX.getType(), bizMsgType,
//                () -> wxMessageService.sendTemplateMsg(mpTemplateMessage));
//        if (sendRR.failed()) {
//            return R.fail(sendRR);
//        }
//        R<Void> sendR = sendRR.getData();
//        if (sendR.ok()) {
//            MsgPushRecordDO msgPushRecord = new MsgPushRecordDO()
//                    .setOrgId(orgId)
//                    .setEnterpriseId(enterpriseId)
//                    .setUserId(0)
//                    .setOpenId(openId)
//                    .setChannel(NotifyChannelEnum.WX.getType())
//                    .setBizMsgType(bizMsgType)
//                    .setContent(StrUtil.safeSubString(JSON.toJSONString(mpTemplateMessage), 200))
//                    .setCreateTime(DateUtil.nowTime());
//            msgPushRecordDao.insert(msgPushRecord);
//        }
//        return sendR;
//    }
//
//
//    public R<Void> sendWxTestNotifyMsg(int userId, List<NotifyConfigBO> notifyConfigBOS, String message) {
//        Map<String, String> templateParams = new HashMap<>();
//        templateParams.put("textContent", message);
//        templateParams.put("founderName", userService.get(userId).getName());
//        List<String> openIds = notifyConfigBOS.stream().map(item -> (NotifyConfigBO.WXContent) item.getTargetContent())
//                .map(NotifyConfigBO.WXContent::getWxMpOpenId)
//                .filter(ObjectUtil::isNotNull)
//                .collect(Collectors.toList());
//
//        return sendWxTemplateMessage(openIds, WxPushMsgTemplate.TEST_NOTIFY_MESSAGE, templateParams);
//    }
}
