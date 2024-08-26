package com.luoge.bos.core.utils;

import cn.hutool.core.util.PhoneUtil;

import java.util.Set;
import java.util.stream.Collectors;

public class ValidateUtil {
    /**
     * 判断是否是手机号
     */
    public static boolean isMobile(String phoneNumber) {
        return PhoneUtil.isMobile(phoneNumber);
    }
}
