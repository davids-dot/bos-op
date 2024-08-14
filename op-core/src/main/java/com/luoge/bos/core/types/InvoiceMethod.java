package com.luoge.bos.core.types;

import java.util.Arrays;

/**
 * 1-手工录入 2-扫码 3-导入 4-API'
 */
public enum InvoiceMethod {
    UNKNOWN(0),
    DIRECT(1),
    SCAN(2),
    IMPORT(3),
    API(4),
    SYNC(5),
    /**
     * 移动端提交开票
     */
    MOBILE_SUBMIT(6);

    public final int code;

    InvoiceMethod(int code) {
        this.code = code;
    }

    public static InvoiceMethod of(int code) {
        return Arrays.stream(InvoiceMethod.values()).filter(t -> t.code == code).findFirst().orElse(UNKNOWN);
    }

    public int getCode() {
        return code;
    }
}
