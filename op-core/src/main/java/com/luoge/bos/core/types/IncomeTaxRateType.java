package com.luoge.bos.core.types;

import java.util.Objects;
import java.util.stream.Stream;

public enum IncomeTaxRateType {
    /**
     * 固定税率
     */
    FIXED_RATE(1),
    /**
     * 五级累计减半
     */
    FIVE_LEVEL_TOTAL_HALF(2),
    /**
     * 发票不含税金额 × 个税税率
     */
    TOTAL_AMOUNT_MUL_RATE(3);

    public final int type;

    IncomeTaxRateType(int type) {
        this.type = type;
    }

    public static IncomeTaxRateType of(Integer incomeTaxType) {
        return Stream.of(values()).filter(x -> Objects.equals(x.type, incomeTaxType)).findAny().orElse(null);
    }
}
