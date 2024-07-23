package com.luoge.bos.op.uc.core;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class UCValidator {
    /**
     * password
     */
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("(?=.*[A-Za-z])(?=.*\\d)\\w{8,26}");

    public static boolean validatePassword(String password) {
        return StringUtils.isNotBlank(password) && password.length() == 64;
    }

}

