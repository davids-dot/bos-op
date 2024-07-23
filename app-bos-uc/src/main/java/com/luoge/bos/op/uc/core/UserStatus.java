package com.luoge.bos.op.uc.core;

import java.util.Objects;

public enum UserStatus {

    NORMAL(1),
    LOCK(2),
    DISABLE(3);
    public final int value;

    UserStatus(int value) {
        this.value = value;
    }

    public static boolean isNormal(Integer status) {
        return Objects.equals(NORMAL.value, status);
    }

    public static boolean isLock(Integer status) {
        return Objects.equals(LOCK.value, status);
    }

    public static boolean isDisable(Integer status) {
        return Objects.equals(DISABLE.value, status);
    }
}
