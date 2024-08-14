/*
 * Copyright 2021 Victory Fintech Co. Ltd.
 */
package com.luoge.bos.uc.core;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.luoge.ns.core.AppException;
import com.luoge.ns.core.Code;
import com.luoge.ns.core.R;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.StringJoiner;

@Component
public class WebHandlerExceptionResolver implements HandlerExceptionResolver, Ordered {

    private static final Logger LOG = LoggerFactory.getLogger(WebHandlerExceptionResolver.class);

    @Resource
    private MessageConverter messageConverter;

    private static final ModelAndView EMPTY = new ModelAndView();

    @Override
    public ModelAndView resolveException(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response, Object handler, @Nonnull Exception ex) {
        if (ex instanceof AppException e) {
            String message = messageConverter.getMessageWithDefault(String.valueOf(e.getCode()));
            R<Void> r = R.fail(R.fail(e.getCode(), message));
            writeError(response, HttpStatus.OK.value(), MediaType.APPLICATION_JSON_VALUE, response(null, JSON.toJSONString(r)));
            return EMPTY;
        }
        if (ex instanceof MissingServletRequestParameterException) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("miss parameter, message:{}", ex.getMessage());
            }
            writeError(response, HttpStatus.OK.value(), MediaType.APPLICATION_JSON_VALUE, response(Code.ILLEGAL_PARAMETER + "", ""));
            return EMPTY;
        }

        if (ex instanceof ConstraintViolationException) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("not valid parameter, message:{}", ex.getMessage());
            }
            writeError(response, HttpStatus.OK.value(), MediaType.APPLICATION_JSON_VALUE, response(Code.ILLEGAL_PARAMETER + "", ""));
            return EMPTY;
        }

        if (ex instanceof MethodArgumentTypeMismatchException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("not valid parameter, message:{}", ex.getMessage());
            }
            writeError(response, HttpStatus.OK.value(), MediaType.APPLICATION_JSON_VALUE, response(Code.ILLEGAL_PARAMETER + "", ""));
            return EMPTY;
        }

        if (ex instanceof BindException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("not valid parameter, message:{}", ex.getMessage());
            }
            handleBindException(e, response);
            return EMPTY;
        }

        if (ex instanceof HttpRequestMethodNotSupportedException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("request method is error! message:{}", e.getMessage());
            }
            writeError(response, HttpStatus.OK.value(), MediaType.APPLICATION_JSON_VALUE, response(Code.NOT_FOUNT + "", ""));
            return EMPTY;
        }
        if (ex instanceof HttpMessageNotReadableException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("request parameter is error! message:{}", e.getMessage());
            }
            if (e.getCause() instanceof InvalidFormatException invalidFormatException) {
                String errorMessage = "format error: " + invalidFormatException.getValue();
                writeError(response, HttpStatus.OK.value(), MediaType.APPLICATION_JSON_VALUE, JSON.toJSONString(R.fail(Code.ILLEGAL_PARAMETER, errorMessage)));
                return EMPTY;
            }
            writeError(response, HttpStatus.OK.value(), MediaType.APPLICATION_JSON_VALUE, response(Code.ILLEGAL_PARAMETER + "", ""));
            return EMPTY;
        }

        if (ex instanceof MultipartException || ex instanceof MaxUploadSizeExceededException) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Exceeded the maximum upload file size, message: {}", ex.getMessage());
            }
            String message = messageConverter.getMessage(String.valueOf(Code.MAX_UPLOAD_SIZE_EXCEEDED));
            writeError(response, HttpStatus.OK.value(), MediaType.APPLICATION_JSON_VALUE, JSON.toJSONString(R.fail(Code.MAX_UPLOAD_SIZE_EXCEEDED, message)));
            return EMPTY;
        }

        LOG.error("system error", ex);
        writeError(response, HttpStatus.INTERNAL_SERVER_ERROR.value(), MediaType.APPLICATION_JSON_VALUE, response(Code.SYSTEM_ERROR + "", ""));
        return EMPTY;
    }

    private void handleBindException(BindException e, HttpServletResponse response) {
        BindingResult bindingResult = e.getBindingResult();
        StringJoiner messages = new StringJoiner("|");
        R result = R.fail(Code.ILLEGAL_PARAMETER);

        for (ObjectError error : bindingResult.getAllErrors()) {
            String extMessage = "";
            if (error.contains(ConstraintViolation.class)) {
                ConstraintViolation<?> constraintViolation = error.unwrap(ConstraintViolation.class);
                extMessage = String.format("%s: %s",
                        constraintViolation.getPropertyPath(),
                        constraintViolation.getMessage());
            } else if (error.contains(TypeMismatchException.class)) {
                TypeMismatchException typeMismatchException = error.unwrap(TypeMismatchException.class);
                extMessage = String.format("%s required type: %s",
                        typeMismatchException.getPropertyName(),
                        Objects.nonNull(typeMismatchException.getRequiredType()) ? typeMismatchException.getRequiredType().getSimpleName() : StringUtils.EMPTY);
            }
            messages.add(extMessage);
        }
        result.setMessage(messages.toString());
        writeError(response, HttpStatus.BAD_REQUEST.value(), MediaType.APPLICATION_JSON_VALUE, JSON.toJSONString(result));

    }

    private String response(String code, String defaultMessage) {
        try {
            if (StringUtils.isNotBlank(code)) {
                return JSON.toJSONString(R.fail(Integer.parseInt(code), messageConverter.getMessage(code)));
            }
        } catch (Exception e) {
            LOG.error("convert message fail! code:{}, message:{}", code, e.getMessage());
        }
        return defaultMessage;
    }

    /**
     * write body to response
     *
     * @param response    http response
     * @param httpCode    http response
     * @param contentType response content type
     * @param body        body
     */
    private void writeError(HttpServletResponse response, int httpCode, String contentType, String body) {
        response.setContentType(contentType);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setStatus(httpCode);
        try (Writer writer = response.getWriter()) {
            writer.write(body);
        } catch (IOException e) {
            LOG.warn("write response io exception", e);
        }
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
