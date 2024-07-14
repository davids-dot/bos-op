/*
 * Copyright 2021 Victory Fintech Co. Ltd.
 */
package com.luoge.bos.op.configuration;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.core.JsonParseException;
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
import org.springframework.web.HttpMediaTypeNotSupportedException;
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
import java.util.Set;
import java.util.StringJoiner;

@Component
public class WebHandlerExceptionResolver implements HandlerExceptionResolver, Ordered {

    private static final Logger LOG = LoggerFactory.getLogger(WebHandlerExceptionResolver.class);

    @Resource
    private MessageConverter messageConverter;

    private static final ModelAndView EMPTY = new ModelAndView();
    private static final String DEFAULT_ERROR_BODY = "{\"code\": 500, \"message\": \"服务异常\"}";

    @SuppressWarnings("unchecked")
    @Override
    public ModelAndView resolveException(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response, Object handler, @Nonnull Exception ex) {
        Throwable causedException = ExceptionUtil.getCausedBy(ex, AppException.class);
        if (causedException != null) {
            ex = (Exception) causedException;
        }
        switch (ex) {
            case MissingServletRequestParameterException e -> handleMissParamException(response, e);
            case ConstraintViolationException e -> handleConstraintViolationException(response, e);
            case MethodArgumentTypeMismatchException e -> handleTypeMismatchException(response, e);
            case BindException e -> handleBindException(response, e);
            case HttpRequestMethodNotSupportedException e -> handleMethodNotSupportException(response, e);
            case HttpMessageNotReadableException e -> handleHttpMessageNotReadableException(response, e);
            case MaxUploadSizeExceededException e -> handleMaxUploadSizeExceededException(response, e);
            case MultipartException ignored ->
                    writeError(response, HttpStatus.OK.value(), JSON.toJSONString(R.fail(Code.ILLEGAL_PARAMETER, "上传内容错误")));
            case HttpMediaTypeNotSupportedException e -> writeError(response, HttpStatus.OK.value(),
                    JSON.toJSONString(R.fail(Code.ILLEGAL_PARAMETER, "不支持ContentType:" + e.getContentType() + " 传参")));
            default -> handleSystemError(response, ex);
        }
        return EMPTY;
    }

    private void handleSystemError(HttpServletResponse response, Exception e) {
        LOG.error("system error", e);
        writeError(response, HttpStatus.INTERNAL_SERVER_ERROR.value(), response(Code.SYSTEM_ERROR + ""));
    }

    private void handleMaxUploadSizeExceededException(HttpServletResponse response, MaxUploadSizeExceededException e) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Exceeded the maximum upload file size, message: {}", e.getMessage());
        }
        String message = messageConverter.getMessage(String.valueOf(Code.MAX_UPLOAD_SIZE_EXCEEDED));
        writeError(response, HttpStatus.OK.value(), JSON.toJSONString(R.fail(Code.MAX_UPLOAD_SIZE_EXCEEDED, message)));
    }

    private void handleHttpMessageNotReadableException(HttpServletResponse response, HttpMessageNotReadableException e) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("request parameter is error! message:{}", e.getMessage());
        }
        if (e.getCause() instanceof JsonParseException) {
            writeError(response, HttpStatus.OK.value(), response(R.fail(Code.ILLEGAL_PARAMETER, "json格式有误")));
            return;
        }
        if (e.getCause() instanceof InvalidFormatException invalidFormatException) {
            String errorMessage = "json路径" + invalidFormatException.getPathReference() + ", 预期类型:" + invalidFormatException.getTargetType().getSimpleName() + ",格式错误: " + invalidFormatException.getValue();
            writeError(response, HttpStatus.OK.value(), JSON.toJSONString(R.fail(Code.ILLEGAL_PARAMETER, errorMessage)));
            return;
        }
        writeError(response, HttpStatus.OK.value(), response(R.fail(Code.ILLEGAL_PARAMETER, e.getMessage())));
    }

    private void handleMethodNotSupportException(HttpServletResponse response, HttpRequestMethodNotSupportedException e) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("request method is error! message:{}", e.getMessage());
        }
        writeError(response, HttpStatus.OK.value(), response(Code.NOT_FOUNT + ""));
    }

    private void handleTypeMismatchException(HttpServletResponse response, MethodArgumentTypeMismatchException e) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("not valid parameter, message:{}", e.getMessage());
        }
        writeError(response, HttpStatus.OK.value(),
                response(R.fail(Code.ILLEGAL_PARAMETER, getTypeMismatchExceptionString(e))));
    }

    private void handleConstraintViolationException(HttpServletResponse response, ConstraintViolationException e) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("not valid parameter, message:{}", e.getMessage());
        }
        writeError(response, HttpStatus.OK.value(),
                response(R.fail(Code.ILLEGAL_PARAMETER, parseConstraintViolationString(e.getConstraintViolations()))));
    }

    private void handleMissParamException(HttpServletResponse response, MissingServletRequestParameterException e) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("miss parameter, message:{}", e.getMessage());
        }
        String errorMsg = String.format("缺少类型为 %s 的参数 %s", e.getParameterType(), e.getParameterName());
        writeError(response, HttpStatus.OK.value(), response(R.fail(Code.ILLEGAL_PARAMETER, errorMsg)));
    }

    private String parseConstraintViolationString(Set<ConstraintViolation<?>> constraintViolations) {
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            sb.append(" ").append(parseConstraintViolationString(constraintViolation));
        }
        return sb.toString();
    }

    private String parseConstraintViolationString(ConstraintViolation<?> constraintViolation) {
        return String.format("%s: %s",
                constraintViolation.getPropertyPath(),
                constraintViolation.getMessage());
    }

    private String getTypeMismatchExceptionString(TypeMismatchException e) {
        return String.format("参数类型不匹配，参数：%s 需要类型为:%s", e.getPropertyName(), Objects.nonNull(e.getRequiredType()) ? e.getRequiredType().getSimpleName() : "");
    }


    private void handleBindException(HttpServletResponse response, BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringJoiner messages = new StringJoiner("|");
        R<?> result = R.fail(Code.ILLEGAL_PARAMETER);

        for (ObjectError error : bindingResult.getAllErrors()) {
            String extMessage = "";
            if (error.contains(ConstraintViolation.class)) {
                ConstraintViolation<?> constraintViolation = error.unwrap(ConstraintViolation.class);
                extMessage = parseConstraintViolationString(constraintViolation);
            } else if (error.contains(TypeMismatchException.class)) {
                TypeMismatchException typeMismatchException = error.unwrap(TypeMismatchException.class);
                extMessage = getTypeMismatchExceptionString(typeMismatchException);
            }
            messages.add(extMessage);
        }
        result.setMessage(messages.toString());
        writeError(response, HttpStatus.OK.value(), JSON.toJSONString(result));

    }

    private String response(String code) {
        try {
            if (StringUtils.isNotBlank(code)) {
                return JSON.toJSONString(R.fail(Integer.parseInt(code), messageConverter.getMessage(code)));
            }
        } catch (Exception e) {
            LOG.error("convert message fail! code:{}, message:{}", code, e.getMessage());
        }
        return "";
    }

    private String response(R<?> r) {
        try {
            return JSON.toJSONString(r);
        } catch (Exception e) {
            LOG.error("convert json fail! data:{}", r, e);
        }
        return DEFAULT_ERROR_BODY;
    }

    /**
     * write body to response
     *
     * @param response http response
     * @param httpCode http response
     * @param body     body
     */
    private void writeError(HttpServletResponse response, int httpCode, String body) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
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
