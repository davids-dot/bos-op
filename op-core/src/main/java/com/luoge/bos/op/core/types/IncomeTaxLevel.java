package com.luoge.bos.op.core.types;

import com.luoge.bos.op.core.utils.Numbers;

import java.math.BigDecimal;

public enum IncomeTaxLevel {

    FIVE_PERCENT_LEVEL(1, new BigDecimal("30000"), new BigDecimal("0.05"), new BigDecimal("0")),
    TEN_PERCENT_LEVEL(2, new BigDecimal("90000"), new BigDecimal("0.10"), new BigDecimal("1500")),
    TWENTY_PERCENT_LEVEL(3, new BigDecimal("300000"), new BigDecimal("0.20"), new BigDecimal("10500")),
    THIRTY_PERCENT_LEVEL(4, new BigDecimal("500000"), new BigDecimal("0.30"), new BigDecimal("40500")),
    THIRTY_FIVE_PERCENT_LEVEL(5, null, new BigDecimal("0.35"), new BigDecimal("65500"));

    /**
     * 税率等级
     */
    private final int level;
    /**
     * 收入阈值
     */
    private final BigDecimal incomeThreshold;
    /**
     * 本级税率
     */
    private final BigDecimal levelTaxRate;
    /**
     * 速算扣除
     */
    private final BigDecimal quickDeduction;

    IncomeTaxLevel(int level, BigDecimal incomeThreshold, BigDecimal levelTaxRate, BigDecimal quickDeduction) {
        this.level = level;
        this.incomeThreshold = incomeThreshold;
        this.levelTaxRate = levelTaxRate;
        this.quickDeduction = quickDeduction;
    }

    /**
     * 根据应纳税所得额 计算所在等级
     */
    public static IncomeTaxLevel of(BigDecimal taxableIncome) {
        IncomeTaxLevel[] levels = values();
        for (int i = 0; i < levels.length - 1; ++i) {
            if (Numbers.le(taxableIncome, levels[i].incomeThreshold)) {
                return levels[i];
            }
        }
        return levels[levels.length - 1];
    }


    /**
     * 根据 全年累计应纳税所得额 算出 全年应缴纳税款
     *
     * @param taxableIncome 应纳税所得额
     */
    public static BigDecimal computeFiveLevelTotalHalfTax(BigDecimal taxableIncome) {
        IncomeTaxLevel level = of(taxableIncome);
        return Numbers.mul(taxableIncome, level.levelTaxRate)   // 纳税额*税率
                .subtract(level.quickDeduction)        // 减去 速算扣除
                .multiply(new BigDecimal("0.5"));      // 减半
    }

    public static void main(String[] args) {
        BigDecimal[] taxableIncomes = new BigDecimal[]{
                new BigDecimal("5000"),
                new BigDecimal("40000"),
                new BigDecimal("110000")
        };
        for (var taxableIncome : taxableIncomes) {
            System.out.println(computeFiveLevelTotalHalfTax(taxableIncome));
        }
    }
}
