package com.luoge.bos.op.uc.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.LocalDateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;


public class DateUtil extends cn.hutool.core.date.DateUtil {
    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

    public static final ZoneOffset BEI_JING_TIME_ZONE = ZoneOffset.of("+08");
    public static final String NORMAL_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String NORMAL_DATE_FORMAT = "yyyy-MM-dd";
    public static final DateTimeFormatter NORMAL_DATETIME_FORMATTER = DateTimeFormatter.ofPattern(NORMAL_DATETIME_FORMAT);
    public static final DateTimeFormatter NORMAL_DATE_FORMATTER = DateTimeFormatter.ofPattern(NORMAL_DATE_FORMAT);


    private DateUtil() {
    }

    private static final Map<Character, Function<String, Duration>> durationParsers = new HashMap<>();

    static {
        durationParsers.put('s', txt -> Duration.ofSeconds(Integer.parseInt(txt)));
        durationParsers.put('m', txt -> Duration.ofMinutes(Integer.parseInt(txt)));
        durationParsers.put('h', txt -> Duration.ofHours(Integer.parseInt(txt)));
        durationParsers.put('D', txt -> Duration.ofDays(Integer.parseInt(txt)));
        durationParsers.put('W', txt -> Duration.ofDays(7L * Integer.parseInt(txt)));
        durationParsers.put('M', txt -> Duration.ofDays(30L * Integer.parseInt(txt)));
        durationParsers.put('Q', txt -> Duration.ofDays(90L * Integer.parseInt(txt)));
        durationParsers.put('Y', txt -> Duration.ofDays(365L * Integer.parseInt(txt)));
    }

    private static final Map<Character, Function<String, DateTime>> beginParsers = new HashMap<>();

    static {
        beginParsers.put('s', txt -> beginOfSecond(offsetSecond(new Date(), (int) parse(txt).toSeconds())));
        beginParsers.put('m', txt -> beginOfMinute(offsetMinute(new Date(), (int) parse("").toMinutes())));
        beginParsers.put('h', txt -> beginOfHour(offsetHour(new Date(), (int) parse(txt).toHours())));
        beginParsers.put('D', txt -> beginOfDay(offsetDay(new Date(), (int) parse(txt).toDays())));
        beginParsers.put('W', txt -> beginOfWeek(offsetDay(new Date(), (int) parse(txt).toDays())));
        beginParsers.put('M', txt -> beginOfMonth(offsetDay(new Date(), (int) parse(txt).toDays())));
        beginParsers.put('Q', txt -> beginOfQuarter(offsetDay(new Date(), (int) parse(txt).toDays())));
        beginParsers.put('Y', txt -> beginOfYear(offsetDay(new Date(), (int) parse(txt).toDays())));
    }

    public static Duration parse(String txt) {
        if (!StringUtils.hasText(txt)) {
            return Duration.ofSeconds(0);
        }

        Character last = txt.charAt(txt.length() - 1);
        Function<String, Duration> parser = durationParsers.get(last);
        return parser.apply(txt.substring(0, txt.length() - 1));
    }

    public static DateTime parseToBegin(String txt) {
        if (!StringUtils.hasText(txt)) {
            return beginOfSecond(new Date());
        }

        Character last = txt.charAt(txt.length() - 1);
        Function<String, DateTime> parser = beginParsers.get(last);
        return parser.apply(txt);
    }

    public static LocalDateTime toLocalDateTime(String dateTimeStr) {
        if (StrUtil.isBlank(dateTimeStr)) {
            return null;
        }
        return LocalDateTime.parse(dateTimeStr, NORMAL_DATETIME_FORMATTER);
    }

    public static LocalDateTime toLocalDateTime(String dateTimeStr, String pattern) {
        if (StrUtil.isBlank(dateTimeStr)) {
            return null;
        }
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime toLocalDateTime(Long timeMills) {
        if (Objects.isNull(timeMills) || timeMills <= 0) {
            return null;
        }
        long epochSecond = timeMills / 1000;
        int nanoOfSecond = (int) (timeMills % 1000) * 1000;
        return LocalDateTime.ofEpochSecond(epochSecond, nanoOfSecond, BEI_JING_TIME_ZONE);
    }

    public static long toTimeMills(String dateTimeStr) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, NORMAL_DATETIME_FORMATTER);
        return localDateTime.toInstant(BEI_JING_TIME_ZONE).toEpochMilli();
    }

    public static long toTimeMills(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return 0L;
        }
        return localDateTime.toInstant(BEI_JING_TIME_ZONE).toEpochMilli();
    }

    public static LocalDateTime nowTime() {
        return LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    public static String toDateSting(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return "";
        }
        return localDateTime.format(NORMAL_DATE_FORMATTER);
    }

    public static String toDateTimeString(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return "";
        }
        return localDateTime.format(NORMAL_DATETIME_FORMATTER);
    }

    /**
     * 获取当前月 yyyyMM
     *
     * @return 当前月
     */
    public static String getCurrentMonth() {
        return format(nowTime(), "yyyyMM");
    }


    /**
     * 获取当月最后一天日期
     *
     * @return 当月最后一天日期 yyyy-MM-dd
     */
    public static String getLastDateOfMonth() {
        return format(endOfMonth(new Date()), NORMAL_DATE_FORMAT);
    }

    public static String format(String sourceDateStr, String fromFormat, String toFormat) {
        if (isSameFormat(fromFormat, toFormat)) {
            return sourceDateStr;
        }

        return format(parse(sourceDateStr, fromFormat), toFormat);
    }

    public static boolean isSameFormat(String fromFormat, String toFormat) {
        if (StrUtil.isBlank(fromFormat)) {
            return false;
        }
        return fromFormat.equals(toFormat);
    }

    public static boolean isSameTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        return dateTime1.isEqual(dateTime2);
    }

    /**
     * 获取一个time 的月份
     *
     * @param time 要处理的时间
     * @return 年月字符串 yyyyMM 格式
     */
    public static String getMonth(LocalDateTime time) {
        return format(time, "yyyyMM");
    }

    /**
     * 获取当前日 格式:yyyyMMdd
     *
     * @return 当前日期
     */
    public static String getCurrentDate() {
        return format(nowTime(), "yyyyMMdd");
    }


    public static LocalDateTime tomorrowAsLocalDateTime() {
        return LocalDateTimeUtil.of(tomorrow());
    }

    public static LocalDateTime getFirstDayOfCurrentMonth() {
        return getFirstDayOfMonth(DateUtil.nowTime());
    }

    public static LocalDateTime getFirstDayOfNextMonth() {
        LocalDateTime now = LocalDateTime.now();
        return getFirstDayOfNextMonth(now);
    }

    public static LocalDateTime getFirstDayOfNextMonth(LocalDateTime time) {
        Month currentMonth = time.getMonth();
        int currentYear = time.getYear();

        Month nextMonth = currentMonth.plus(1);
        int nextYear = currentMonth == Month.DECEMBER ? currentYear + 1 : currentYear;
        return LocalDateTime.of(nextYear, nextMonth, 1, 0, 0, 0);
    }

    public static LocalDateTime getFirstDayOfMonth(LocalDateTime month) {
        return month.withDayOfMonth(1)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }


    public static LocalDateTime getOrElse(LocalDateTime time, LocalDateTime elseTime) {
        return time != null ? time : elseTime;
    }


    public static LocalDateTime toLocalDateTimeFromDayStr(String str, String pattern) {
        try {
            return LocalDate.parse(str, DateTimeFormatter.ofPattern(pattern)).atStartOfDay();
        } catch (Exception e) {
            log.error("parse exception, str:{}, format:{}", str, pattern, e);
            return null;
        }
    }

    public static long diffDays(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime == null || endTime == null) {
            return 0;
        }

        return Duration.between(startTime, endTime).toDays();
    }
}
