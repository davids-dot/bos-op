package com.luoge.bos.op.invoice.model;

public class TaxCalculateFormulaBO {
    /**
     * id
     */
    private Integer id;
    /**
     * 税种类型
     */
    private Integer taxType;
    /**
     * 税种名称
     */
    private String taxTypeName;
    /**
     * 公式名称
     */
    private String formulaName;
    /**
     * 公式表达式
     */
    private String formulaExpression;

    public Integer getId() {
        return id;
    }

    public TaxCalculateFormulaBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getTaxType() {
        return taxType;
    }

    public TaxCalculateFormulaBO setTaxType(Integer taxType) {
        this.taxType = taxType;
        return this;
    }

    public String getTaxTypeName() {
        return taxTypeName;
    }

    public TaxCalculateFormulaBO setTaxTypeName(String taxTypeName) {
        this.taxTypeName = taxTypeName;
        return this;
    }

    public String getFormulaName() {
        return formulaName;
    }

    public TaxCalculateFormulaBO setFormulaName(String formulaName) {
        this.formulaName = formulaName;
        return this;
    }

    public String getFormulaExpression() {
        return formulaExpression;
    }

    public TaxCalculateFormulaBO setFormulaExpression(String formulaExpression) {
        this.formulaExpression = formulaExpression;
        return this;
    }
}
