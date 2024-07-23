package com.luoge.bos.op.uc.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 脱敏工具类
 */
public class DesensitizedUtil extends cn.hutool.core.util.DesensitizedUtil {

    private DesensitizedUtil() {
    }

    public static String email(String email) {
        if (StringUtils.isBlank(email)) {
            return email;
        }
        String[] split = email.split("@");
        String userName = split[0];
        String mailPostFix = "";
        if (split.length > 1) {
            mailPostFix = split[1];
        }
        userName = desensitizedEmail(userName);
        return userName + "@" + mailPostFix;
    }

    private static String desensitizedEmail(String userName) {
        if (StringUtils.isBlank(userName)) {
            return userName;
        }
        int len = userName.length();
        if (len < 3) {
            return StringUtils.EMPTY + userName.charAt(0) + maskRepeat(len - 1);
        }
        if (len <= 6) {
            return StringUtils.EMPTY + userName.charAt(0) + maskRepeat(len - 2) + userName.charAt(len - 1);
        } else {
            return StringUtils.EMPTY + userName.charAt(0) + userName.charAt(1) + maskRepeat(len - 4) + userName.charAt(len - 2) + userName.charAt(len - 1);
        }
    }

    private static String maskRepeat(int n) {
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append('*');
        }
        return sb.toString();
    }
}
