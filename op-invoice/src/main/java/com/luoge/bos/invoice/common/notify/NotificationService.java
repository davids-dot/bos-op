package com.luoge.bos.invoice.common.notify;

import com.luoge.bos.data.configuration.wx.WxConfig;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private com.luoge.ns.uc.dubbo.NotificationService notificationService;

    @Resource
    private WxConfig wxConfig;


}
