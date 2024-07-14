package com.luoge.bos.op.core.types;

/**
 * 企业类型
 * 1-一般纳税人, 2-小规模纳税人
 */
public enum EnterpriseType {
    UNKNOWN(0),
    GENERAL_TAXPAYER(1),
    SMALL_TAXPAYER(2);

    private final int type;

    EnterpriseType(int type) {
        this.type = type;
    }

    public static EnterpriseType of(int type) {
        if (GENERAL_TAXPAYER.type == type) {
            return GENERAL_TAXPAYER;
        }
        if (SMALL_TAXPAYER.type == type) {
            return SMALL_TAXPAYER;
        }
        return UNKNOWN;
    }

    public int getType() {
        return type;
    }

}
