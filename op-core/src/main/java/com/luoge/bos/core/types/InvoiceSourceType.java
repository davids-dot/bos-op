package com.luoge.bos.core.types;

import java.util.Objects;
import java.util.stream.Stream;

public enum InvoiceSourceType {
    /**
     * 程序同步
     */
    SYNC(1, "北海云票"),
    /**
     * 人工补录
     */
    MANUAL(2, "补录发票");

    public final int type;
    public final String remark;

    InvoiceSourceType(int type, String remark) {
        this.type = type;
        this.remark = remark;
    }

    public static InvoiceSourceType of(Integer type) {
        return Stream.of(values()).filter(x -> Objects.equals(type,x.type)).findAny().orElse(null);
    }

}
