package com.luoge.bos.op.core.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StrUtil extends cn.hutool.core.util.StrUtil {
    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");

    /**
     * 获取字符串数组指定下标数据，不存在时返回默认值
     *
     * @param array      字符串数组
     * @param index      目标数据下标
     * @param defaultStr 默认值
     * @return 数据
     */
    public static String get(String[] array, int index, String defaultStr) {
        if (array == null || array.length < (index + 1)) {
            return defaultStr;
        }
        return array[index];
    }

    public static String get(String str1, String str2) {
        return isBlank(str1) ? trimToEmpty(str2) : trimToEmpty(str1);
    }

    public static String getWithExclude(String target, String... excludeStr) {
        if (isBlank(target)) {
            return EMPTY;
        }
        if (excludeStr != null && Arrays.asList(excludeStr).contains(target)) {
            return EMPTY;
        }
        return target;
    }

    public static BigDecimal to(String value) {
        return isBlank(value) ? null : new BigDecimal(value);
    }

    public static BigDecimal to(String value, String defaultValue) {
        return isBlank(value) ? new BigDecimal(defaultValue) : new BigDecimal(value);
    }

    public static BigDecimal toNonNull(String value) {
        return isBlank(value) ? BigDecimal.ZERO : new BigDecimal(value);
    }

    public static BigDecimal toRate(String value) {
        if (isBlank(value)) {
            return BigDecimal.ZERO;
        }

        return value.endsWith("%") ?
                new BigDecimal(value.substring(0, value.length() - 1)).divide(ONE_HUNDRED, 2, RoundingMode.HALF_DOWN) : new BigDecimal(value);
    }


    /**
     * 取字符串的num 位后缀
     *
     * @param checkCode 原始字符串
     * @param num       后缀位数
     */
    public static String getPostFix(String checkCode, int num) {
        if (StringUtils.isBlank(checkCode)) {
            return checkCode;
        }
        if (checkCode.length() >= num) {
            return checkCode.substring(checkCode.length() - num);
        }
        return checkCode;
    }


    public static String join(List<String> strList) {
        if (CollectionUtils.isEmpty(strList)) {
            return StringUtils.EMPTY;
        }
        return String.join(",", strList);
    }

    public static String encodeUrl(String urlStr) {
        if (StringUtils.isBlank(urlStr)) {
            return StringUtils.EMPTY;
        }
        try {
            String s = URLEncoder.encode(urlStr, StandardCharsets.UTF_8);
            return s.replaceAll("\\+", "%20");
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }
}
