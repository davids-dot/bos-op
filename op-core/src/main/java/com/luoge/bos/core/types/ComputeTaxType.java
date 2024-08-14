package com.luoge.bos.core.types;


import java.util.stream.Stream;

public class ComputeTaxType {

    /**
     * 增值税
     */
    public enum AddedTaxCalculateFormula {
        TOTAL_MUL_TAX_RATE(1, "发票价税合计×发票票面税率"),
        REAL_TAX_AMOUNT(2, "发票价税合计÷(1+发票票面税率)×发票票面税率");

        private final Integer calculateFormula;
        private final String calculateFormulaExpression;

        AddedTaxCalculateFormula(Integer calculateFormula, String calculateFormulaExpression) {
            this.calculateFormula = calculateFormula;
            this.calculateFormulaExpression = calculateFormulaExpression;
        }

        public Integer getCalculateFormula() {
            return calculateFormula;
        }

        public String getCalculateFormulaExpression() {
            return calculateFormulaExpression;
        }

        public static AddedTaxCalculateFormula of(Integer calculateFormula) {
            return Stream.of(AddedTaxCalculateFormula.values())
                    .filter(item -> item.getCalculateFormula().equals(calculateFormula))
                    .findFirst()
                    .orElse(null);
        }
    }

    /**
     * 附加税
     */
    public enum AdditionalTaxCalculateFormula {
        TOTAL_MUL_TAX_RATE(3, "发票价税合计×附加税税率"),
        VAT_MUL_TAX_RATE(4, "增值税税额×附加税税率");

        private final Integer calculateFormula;
        private final String calculateFormulaExpression;

        AdditionalTaxCalculateFormula(Integer calculateFormula, String calculateFormulaExpression) {
            this.calculateFormula = calculateFormula;
            this.calculateFormulaExpression = calculateFormulaExpression;
        }

        public Integer getCalculateFormula() {
            return calculateFormula;
        }

        public String getCalculateFormulaExpression() {
            return calculateFormulaExpression;
        }

        public static AdditionalTaxCalculateFormula of(Integer calculateFormula) {
            return Stream.of(AdditionalTaxCalculateFormula.values())
                    .filter(item -> item.getCalculateFormula().equals(calculateFormula))
                    .findFirst()
                    .orElse(null);
        }
    }


    /**
     * 水利基金
     */
    public enum WaterTaxCalculateFormula {
        TOTAL_AMOUNT_MUL_TAX_RATE(5, "发票不含税金额 × 水利基金税率");

        private final Integer calculateFormula;
        private final String calculateFormulaExpression;

        WaterTaxCalculateFormula(Integer calculateFormula, String calculateFormulaExpression) {
            this.calculateFormula = calculateFormula;
            this.calculateFormulaExpression = calculateFormulaExpression;
        }

        public Integer getCalculateFormula() {
            return calculateFormula;
        }

        public String getCalculateFormulaExpression() {
            return calculateFormulaExpression;
        }

        public static WaterTaxCalculateFormula of(Integer calculateFormula) {
            return Stream.of(WaterTaxCalculateFormula.values())
                    .filter(item -> item.getCalculateFormula().equals(calculateFormula))
                    .findFirst()
                    .orElse(null);
        }
    }

    /**
     * 印花税
     */
    public enum StampTaxCalculateFormula {
        TOTAL_MUL_TAX_RATE(6, "发票价税合计 × 印花税税率");

        private final Integer calculateFormula;
        private final String calculateFormulaExpression;

        StampTaxCalculateFormula(Integer calculateFormula, String calculateFormulaExpression) {
            this.calculateFormula = calculateFormula;
            this.calculateFormulaExpression = calculateFormulaExpression;
        }

        public Integer getCalculateFormula() {
            return calculateFormula;
        }

        public String getCalculateFormulaExpression() {
            return calculateFormulaExpression;
        }

        public static StampTaxCalculateFormula of(Integer calculateFormula) {
            return Stream.of(StampTaxCalculateFormula.values())
                    .filter(item -> item.getCalculateFormula().equals(calculateFormula))
                    .findFirst()
                    .orElse(null);
        }
    }

    /**
     * 个人所得税
     */
    public enum IncomeTaxCalculateFormula {
        FIXED_RATE(7, "发票价税合计×个税税率"),
        TOTAL_AMOUNT_MUL_RATE(8, "发票不含税金额×个税税率"),
        FIVE_LEVEL_TOTAL_HALF(9, "不含税价×核定率×税率-速算扣除数×50%");


        private final Integer calculateFormula;
        private final String calculateFormulaExpression;

        IncomeTaxCalculateFormula(Integer calculateFormula, String calculateFormulaExpression) {
            this.calculateFormula = calculateFormula;
            this.calculateFormulaExpression = calculateFormulaExpression;
        }

        public Integer getCalculateFormula() {
            return calculateFormula;
        }

        public String getCalculateFormulaExpression() {
            return calculateFormulaExpression;
        }

        public static IncomeTaxCalculateFormula of(Integer calculateFormula) {
            return Stream.of(IncomeTaxCalculateFormula.values())
                    .filter(item -> item.getCalculateFormula().equals(calculateFormula))
                    .findFirst()
                    .orElse(null);
        }

    }


}
