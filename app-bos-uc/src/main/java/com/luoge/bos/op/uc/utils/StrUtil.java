package com.luoge.bos.op.uc.utils;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StrUtil extends cn.hutool.core.util.StrUtil {
    public static String encodeUrl(String urlStr) {
       return encodeUrl(urlStr, StandardCharsets.UTF_8);
    }


    public static String encodeUrl(String urlStr, Charset charset) {
        if (com.alibaba.nacos.common.utils.StringUtils.isBlank(urlStr)) {
            return com.alibaba.nacos.common.utils.StringUtils.EMPTY;
        }
        try {
            String s = URLEncoder.encode(urlStr, charset);
            return s.replaceAll("\\+", "%20");
        } catch (Exception e) {
            return com.alibaba.nacos.common.utils.StringUtils.EMPTY;
        }
    }
}
