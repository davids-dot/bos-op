package com.luoge.bos.core.utils;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.NumberUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Numbers extends NumberUtil {
    private static final Logger log = LoggerFactory.getLogger(Numbers.class);

    private static final BigDecimal HUNDRED = new BigDecimal("100");

    private Numbers() {
    }

    public static String toString(BigDecimal value) {
        if (value == null) {
            return "0";
        }
        return value.stripTrailingZeros()
                .toPlainString();
    }

    /**
     * 保留原格式，不去掉末尾的0
     */
    public static String toOriginalString(BigDecimal value) {
        if (value == null) {
            return "0";
        }
        return value.toString();
    }

    public static BigDecimal bigDecimal(String s) {
        if (StringUtils.isBlank(s)) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(s);
        } catch (Exception e) {
            log.error("parse number error, str:{}", s, e);
            return BigDecimal.ZERO;
        }
    }

    public static int toInt(Boolean flag) {
        return (flag == null) ? 0 : flag ? 1 : 0;
    }


    /**
     * 字符转int, 不会报错，格式错误默认返回0
     */
    public static int toInt(String str) {
        return NumberUtils.toInt(str, 0);
    }

    /**
     * Verify that x == y
     *
     * @param x first decimal
     * @param y second decimal
     * @return true: x == y
     */
    public static boolean eq(BigDecimal x, BigDecimal y) {
        if (x == null || y == null) {
            return false;
        }

        return x.compareTo(y) == 0;
    }

    /**
     * Verify that x != y
     *
     * @param x first decimal
     * @param y second decimal
     * @return true: x != y
     */
    public static boolean ne(BigDecimal x, BigDecimal y) {
        return x.compareTo(y) != 0;
    }

    /**
     * Verify that x <= y
     *
     * @param x first decimal
     * @param y second decimal
     * @return true: x <= y
     */
    public static boolean le(BigDecimal x, BigDecimal y) {
        return x.compareTo(y) <= 0;
    }

    /**
     * Verify that x < y
     *
     * @param x first decimal
     * @param y second decimal
     * @return true: x < y
     */
    public static boolean lt(BigDecimal x, BigDecimal y) {
        return x.compareTo(y) < 0;
    }

    /**
     * Verify that x >= y
     *
     * @param x first decimal
     * @param y second decimal
     * @return true: x >= y
     */
    public static boolean ge(BigDecimal x, BigDecimal y) {
        return x.compareTo(y) >= 0;
    }

    /**
     * Verify that x > y
     *
     * @param x first decimal
     * @param y second decimal
     * @return true: x > y
     */
    public static boolean gt(BigDecimal x, BigDecimal y) {
        return x.compareTo(y) > 0;
    }

    /**
     * 百分数格式的字符 转为bigDecimal
     *
     * @param percentageStr 百分数格式的字符
     */
    public static BigDecimal percentageStrToBigDecimal(String percentageStr) {
        if (StringUtils.isBlank(percentageStr)) {
            return BigDecimal.ZERO;
        }
        if (percentageStr.contains("%")) {
            try {
                BigDecimal bigDecimal = new BigDecimal(percentageStr.replace("%", ""));
                return bigDecimal.divide(HUNDRED, 2, RoundingMode.HALF_UP);
            } catch (Exception e) {
                log.error("parse number error", e);
                return BigDecimal.ZERO;
            }
        } else {
            return bigDecimal(percentageStr);
        }
    }

    /**
     * @param bigDecimal 数字
     */
    public static String bigDecimalToPercentageStr(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return "0%";
        }

        double value = bigDecimal.doubleValue() * 100;

        // 构建百分比字符串并返回
        return String.format("%.2f%%", value);
    }


    /**
     * 字符转long, 不会报错，格式错误默认返回0
     */
    public static Long toLong(String id) {
        return NumberUtils.toLong(id, 0L);
    }

    /**
     * 除法， 被除数 除数 任一个为空则返回0，   除数为0 时返回0
     *
     * @param je 被除数
     * @param se 除数
     */
    public static BigDecimal divide(BigDecimal je, BigDecimal se) {
        if (Objects.isNull(je) || Objects.isNull(se) || BigDecimal.ZERO.compareTo(se) == 0) {
            return BigDecimal.ZERO;
        }
        return Numbers.div(je, se);

    }

    public static boolean canDivide(BigDecimal leftQuantity) {
        return Objects.nonNull(leftQuantity) && leftQuantity.compareTo(BigDecimal.ZERO) != 0;
    }


    public static BigDecimal addWithScale(int scale, BigDecimal... values) {
        if (ArrayUtil.isEmpty(values)) {
            return BigDecimal.ZERO;
        }
        List<BigDecimal> newValues = Arrays.stream(values).map(
                x -> {
                    if (Objects.isNull(x)) {
                        return BigDecimal.ZERO;
                    }
                    return x.setScale(scale, RoundingMode.HALF_UP);
                }
        ).toList();
        return Numbers.add(newValues.toArray(new BigDecimal[0]));
    }

}
