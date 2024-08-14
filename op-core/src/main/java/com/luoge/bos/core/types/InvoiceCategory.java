package com.luoge.bos.core.types;

public enum InvoiceCategory {
    /**
     * 蓝票
     */
    BLUE(1),
    /**
     * 红票
     */
    RED(2);

    public final int category;

    InvoiceCategory(int category) {
        this.category = category;
    }
}
