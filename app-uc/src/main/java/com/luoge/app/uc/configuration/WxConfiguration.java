package com.luoge.app.uc.configuration;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.luoge.bos.data.configuration.wx.WxApp;
import com.luoge.bos.data.configuration.wx.WxConfig;
import jakarta.annotation.Resource;
import me.chanjar.weixin.common.error.WxRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class WxConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(WxConfiguration.class);

    @Value("${wx.mini-app.invoice.app-id}")
    private String appId;

    @Resource
    private WxConfig wxConfig;

    public String getAppId() {
        return appId;
    }

    public WxConfiguration setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    /**
     * 微信小程序服务
     */
    @Bean
    public WxMaService wxMaService() {
        List<WxApp> wxApps = Collections.singletonList(wxConfig.getMiniApp().getInvoice());
        if (wxApps == null) {
            logger.warn("缺少配置");
            throw new WxRuntimeException("缺少配置");
        }
        WxMaService maService = new WxMaServiceImpl();
        maService.setMultiConfigs(
                wxApps.stream()
                        .map(a -> {
                            WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
                            config.setAppid(a.getAppId());
                            config.setSecret(a.getSecret());
                            return config;
                        }).collect(Collectors.toMap(WxMaDefaultConfigImpl::getAppid, a -> a, (o, n) -> o)));
        return maService;
    }

    /**
     * 微信公众号服务
     */
//    @Bean
//    public WxMpService wxMpService() {
//        List<WxApp> configs = wxConfig.getMp();
//        if (CollectionUtils.isEmpty(configs)) {
//            logger.warn("公众号配置信息有误");
//            throw new WxRuntimeException("公众号配置信息有误");
//        }
//        WxApp wxApp = configs.get(0);
//        WxMpService wxMpService = new WxMpServiceImpl();
//        WxMpConfigStorage wxMpConfigStorage = new WxMpDefaultConfigImpl() {
//            {
//                appId = wxApp.getAppid();
//                secret = wxApp.getSecret();
//            }
//        };
//        wxMpService.setWxMpConfigStorage(wxMpConfigStorage);
//        return wxMpService;
//    }
}
