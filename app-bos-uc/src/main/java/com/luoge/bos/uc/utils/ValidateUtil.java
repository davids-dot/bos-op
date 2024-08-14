package com.luoge.bos.uc.utils;

import cn.hutool.core.util.PhoneUtil;

public class ValidateUtil {
    /**
     * 判断是否是手机号
     */
    public static boolean isMobile(String phoneNumber) {
        return PhoneUtil.isMobile(phoneNumber);
    }
}
