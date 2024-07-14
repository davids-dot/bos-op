package com.luoge.bos.op.invoice.util;

import java.util.regex.Pattern;

public class ParamValidator {

    private static final Pattern TAX_NO_PATTERN = Pattern.compile("^[A-Z0-9]{15}$|^[A-Z0-9]{18}$|^[A-Z0-9]{20}$");
    private static final int EMAIL_MAX_LENGTH = 60;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w][\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");


    public static boolean validateTaxNo(String buyerTaxNo) {
        return TAX_NO_PATTERN.matcher(buyerTaxNo).matches();
    }


    public static boolean validateEmail(String email) {
        return email.length() < EMAIL_MAX_LENGTH
                && EMAIL_PATTERN.matcher(email).matches();
    }
}
