package com.luoge.bos.invoice.model.collect;

import java.math.BigDecimal;

public class MonthIncomeTaxBO {
    private BigDecimal incomeTax;

    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    public MonthIncomeTaxBO setIncomeTax(BigDecimal incomeTax) {
        this.incomeTax = incomeTax;
        return this;
    }
}
