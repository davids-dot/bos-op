package com.luoge.bos.op.configuration;

import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageConverter {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Resource
    private MessageSource messageSource;

    public String getMessage(String code) {
        return getMessageWithDefault(code);
    }

    public String getMessage(String code, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, args, locale);
    }

    public String getMessageWithDefault(int code) {
        return getMessageWithDefault(String.valueOf(code));
    }

    public String getMessageWithDefault(String code) {
        return getMessageWithDefault(code, StringUtils.EMPTY);
    }

    public String getMessageWithDefault(String code, String defaultMessage) {
        Locale locale = LocaleContextHolder.getLocale();
        try {
            return messageSource.getMessage(code, null, locale);
        } catch (Exception e) {
            LOG.warn("no message for code:{}", code, e);
            return defaultMessage;
        }
    }
}
