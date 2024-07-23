package com.luoge.bos.op.uc.core;

import java.util.Objects;

public enum AuthenticationType {

    BY_USER_NAME(1),
    BY_MOBILE(2);

    private int value;

    AuthenticationType(int value) {
        this.value = value;
    }

    public static boolean isUserName(Integer type) {
        return Objects.equals(BY_USER_NAME.value, type);
    }

    public static boolean isMobile(Integer type) {
        return Objects.equals(BY_MOBILE.value, type);
    }

    public static AuthenticationType of(int value) {
        for (var item : AuthenticationType.values()) {
            if (item.value == value) {
                return item;
            }
        }
        return BY_USER_NAME;
    }
}
