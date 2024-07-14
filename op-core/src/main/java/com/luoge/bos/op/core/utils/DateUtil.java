package com.luoge.bos.op.core.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
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
        if (StringUtils.isBlank(txt)) {
            return Duration.ofSeconds(0);
        }

        Character last = txt.charAt(txt.length() - 1);
        Function<String, Duration> parser = durationParsers.get(last);
        return parser.apply(txt.substring(0, txt.length() - 1));
    }

    public static DateTime parseToBegin(String txt) {
        if (StringUtils.isBlank(txt)) {
            return beginOfSecond(new Date());
        }

        Character last = txt.charAt(txt.length() - 1);
        Function<String, DateTime> parser = beginParsers.get(last);
        return parser.apply(txt);
    }

    /**
     * 获取某天0点0分0秒的时间点
     */
    public static LocalDateTime atBeginOfDay(LocalDateTime time) {
        return time.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    /**
     * 获取上月的此时
     */
    public static LocalDateTime lastMonthTime() {
        return LocalDateTime.now().minusMonths(1);
    }

    /**
     * 获取某月1号0点0分0秒的时间点
     */
    public static LocalDateTime atBeginOfMonth(LocalDateTime month) {
        return month.withDayOfMonth(1)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    public static LocalDateTime yesterdayTime() {
        return LocalDateTime.now().minusDays(1);
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

    /**
     * 转为不带中划线的日期格式
     */
    public static String toDateStingWithoutDash(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return "";
        }
        return format(localDateTime, "yyyyMMdd");
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
     * 获取一个time 的月份
     *
     * @param time 要处理的时间
     * @return 年月字符串 yyyyMM 格式
     */
    public static String getNormalMonth(LocalDateTime time) {
        return format(time, "yyyy-MM");
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

    /**
     * 判断某个月是否是 季度开始， 其中 1, 4, 7, 10 是季度开始月
     *
     * @param month 月份
     */
    public static boolean isSeasonStartMonth(int month) {
        return month % 3 == 1;
    }

    /**
     * 找出某月的季度开始月
     *
     * @param month 月份
     */
    public static int seasonStartOfMonth(int month) {
        if (month == 1) {
            return 1;
        }
        return switch ((month - 1) / 3) {
            case 1 -> 4;
            case 2 -> 7;
            case 3 -> 10;
            default -> 1;
        };
    }

    /**
     * 构造以月为间隔的时间列表
     */
    public static List<LocalDateTime> monthList(LocalDateTime seasonStartTime, int count) {
        List<LocalDateTime> monthList = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            monthList.add(seasonStartTime.plusMonths(i));
        }
        return monthList;
    }


    /**
     * 构造以月为间隔的时间列表
     *
     * @param startTime 开始时间,包含
     * @param endTime   结束时间，不包含
     */
    public static List<LocalDateTime> monthList(LocalDateTime startTime, LocalDateTime endTime) {
        List<LocalDateTime> monthList = new ArrayList<>();
        int i = 0;
        LocalDateTime itMonth = startTime.plusMonths(i++);
        while (itMonth.isBefore(endTime)) {
            monthList.add(itMonth);
            itMonth = startTime.plusMonths(i++);
        }

        return monthList;
    }

    /**
     * 获取 当年 的开始时间, 1月1日凌晨
     */
    public static LocalDateTime atBeginOfYear(LocalDateTime time) {
        return time.withMonth(1)
                .withDayOfMonth(1)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    /**
     * 获取两个时间戳之间的月份
     */
    public static List<LocalDateTime> monthList(Long startMonth, Long endMonth) {
        List<LocalDateTime> resultList = new ArrayList<>();

        LocalDateTime startTime = DateUtil.toLocalDateTime(startMonth);
        LocalDateTime endTime = DateUtil.toLocalDateTime(endMonth);
        if (Objects.isNull(startTime) || Objects.isNull(endTime)) {
            return resultList;
        }
        int i = 0;
        LocalDateTime currTime = startTime.plusMonths(i++);
        do {
            resultList.add(currTime);
            currTime = startTime.plusMonths(i++);
        } while (currTime.isBefore(endTime));

        return resultList;
    }

    /**
     * 把月份格式 yyyyMM 的字符串 转为LocalDateTime
     */
    public static LocalDateTime toLocalDateTimeFromMonthStr(String monthStr) {
        LocalDate date = LocalDate.parse(monthStr + "-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalTime time = LocalTime.MIDNIGHT;
        return LocalDateTime.of(date, time);
    }

    public static LocalDateTime atBeginOfSeason(LocalDateTime startTime) {
        // 先找出 startTime 对应月份 month 的1号的时间 monthStartTime
        LocalDateTime monthStartTime = DateUtil.atBeginOfMonth(startTime);
        int month = startTime.getMonth().getValue();

        // 如果 m 是首月, 则返回 a
        if (DateUtil.isSeasonStartMonth(month)) {
            return monthStartTime;
        }

        // 如果 m 不是首月, 则返回 a 减去到首月的间隔月份
        int seasonStartMonth = DateUtil.seasonStartOfMonth(month);
        return monthStartTime.minusMonths(month - seasonStartMonth);
    }
}
