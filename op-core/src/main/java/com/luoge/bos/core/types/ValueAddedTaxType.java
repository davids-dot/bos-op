package com.luoge.bos.core.types;

import java.util.Objects;
import java.util.stream.Stream;

public enum ValueAddedTaxType {
    /**
     * 30万下免税
     */
    TAX_FREE_BELOW_300000(1),
    /**
     * 累计票上增值税
     */
    TAX_BY_INVOICE(2);


    public final int type;

    ValueAddedTaxType(int type) {
        this.type = type;
    }

    public static ValueAddedTaxType of(Integer valueAddedTaxType) {
        return Stream.of(values()).filter(x -> Objects.equals(x.type, valueAddedTaxType)).findAny().orElse(null);
    }

}