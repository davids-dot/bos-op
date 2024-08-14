package com.luoge.bos.common;

import cn.hutool.core.util.IdUtil;

public class IDUtil extends IdUtil {

    public static long getID() {
        return getSnowflakeNextId();
    }
}
