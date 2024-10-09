package com.luoge.app.uc.configuration;


import com.luoge.app.uc.wxctx.resolver.WxContextResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WxWebConverterConfiguration implements WebMvcConfigurer {

    /**
     * 微信小程序、公众号 配置消息转换器
     *
     * @param resolvers 转换器
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new WxContextResolver());
    }
}
