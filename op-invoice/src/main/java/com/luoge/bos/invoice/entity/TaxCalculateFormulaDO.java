package com.luoge.bos.invoice.entity;

public class TaxCalculateFormulaDO {
    private Integer id;
    private Integer taxType;
    private String taxTypeName;
    private String formulaName;
    private String formulaExpression;

    public Integer getId() {
        return id;
    }

    public TaxCalculateFormulaDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getTaxType() {
        return taxType;
    }

    public TaxCalculateFormulaDO setTaxType(Integer taxType) {
        this.taxType = taxType;
        return this;
    }

    public String getTaxTypeName() {
        return taxTypeName;
    }

    public TaxCalculateFormulaDO setTaxTypeName(String taxTypeName) {
        this.taxTypeName = taxTypeName;
        return this;
    }

    public String getFormulaName() {
        return formulaName;
    }

    public TaxCalculateFormulaDO setFormulaName(String formulaName) {
        this.formulaName = formulaName;
        return this;
    }

    public String getFormulaExpression() {
        return formulaExpression;
    }

    public TaxCalculateFormulaDO setFormulaExpression(String formulaExpression) {
        this.formulaExpression = formulaExpression;
        return this;
    }
}
