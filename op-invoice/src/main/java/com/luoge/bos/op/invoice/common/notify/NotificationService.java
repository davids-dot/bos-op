package com.luoge.bos.op.invoice.common.notify;

import com.luoge.bos.op.invoice.configuration.wx.WxConfig;
import com.luoge.bos.op.invoice.util.InvokeUtil;
import com.luoge.ns.core.R;
import com.luoge.ns.uc.model.msg.WxPushMsgTemplate;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private com.luoge.ns.uc.dubbo.NotificationService notificationService;

    @Resource
    private WxConfig wxConfig;


    /**
     * 发送微信推送消息通知
     *
     * @param userId   用户id
     * @param template 消息模板
     * @param params   模板内的参数
     */
    public R<Void> sendWxTemplateMessage(int userId, WxPushMsgTemplate template, Map<String, String> params) {
        logger.debug("send message, userId:{}, template:{}, param:{}", userId, template, params);
        return InvokeUtil.invoke(
                () -> notificationService.sendWxTemplateMessage(userId, wxConfig.getMiniApp().getInvoice().getAppId(), template, params)
        ).getData();
    }
}
