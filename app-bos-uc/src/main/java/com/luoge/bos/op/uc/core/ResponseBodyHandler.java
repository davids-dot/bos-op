package com.luoge.bos.op.uc.core;

import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Component
@ControllerAdvice
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {

    @Resource
    private MessageConverter messageConverter;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(@Nullable Object o, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (o instanceof R r && r.failed()) {
            if (StringUtils.isBlank(r.getMessage())) {
                r.setMessage(messageConverter.getMessage(StringUtils.EMPTY + r.getCode()));
            }
        }
        return o;
    }
}
