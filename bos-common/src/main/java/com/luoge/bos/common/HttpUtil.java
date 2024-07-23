package com.luoge.bos.common;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static void writeRes(HttpServletResponse response, int httpCode, String body) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setStatus(httpCode);
        try (Writer writer = response.getWriter()) {
            writer.write(body);
        } catch (IOException e) {
            logger.warn("write response io exception", e);
        }
    }
}
