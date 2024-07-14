package com.luoge.bos.op.core;

import java.math.BigDecimal;

public interface BOSConsts {

    BigDecimal BIG_DECIMAL_100 = new BigDecimal("100");

    class DataSource {
        public static final String MASTER = "master";
        public static final String INVOICE = "invoice";
        public static final String UC = "uc";
    }
}
