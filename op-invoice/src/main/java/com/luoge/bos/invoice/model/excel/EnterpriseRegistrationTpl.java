package com.luoge.bos.invoice.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 工商注册导出 excel 模板
 */
public class EnterpriseRegistrationTpl {
    /**
     * 法人
     */
    @ExcelProperty("法人")
    private String corporateName;
    /**
     * 身份证号
     */
    @ExcelProperty("身份证号")
    private String corporateIdNo;
    /**
     * 联系电话
     */
    @ExcelProperty("联系电话")
    private String corporatePhone;
    /**
     * 所属行业
     */
    @ExcelProperty("所属行业")
    private String industryName;
    /**
     * 所属园区
     */
    @ExcelProperty("所属园区")
    private String providerName;
    /**
     * 候选企业名称
     */
    @ExcelProperty("候选企业名称")
    private String candidateNames;
    /**
     * 应付金额
     */
    @ExcelProperty("应付金额")
    private String paymentAmount;


    public String getCorporateName() {
        return corporateName;
    }

    public EnterpriseRegistrationTpl setCorporateName(String corporateName) {
        this.corporateName = corporateName;
        return this;
    }

    public String getCorporateIdNo() {
        return corporateIdNo;
    }

    public EnterpriseRegistrationTpl setCorporateIdNo(String corporateIdNo) {
        this.corporateIdNo = corporateIdNo;
        return this;
    }

    public String getCorporatePhone() {
        return corporatePhone;
    }

    public EnterpriseRegistrationTpl setCorporatePhone(String corporatePhone) {
        this.corporatePhone = corporatePhone;
        return this;
    }

    public String getIndustryName() {
        return industryName;
    }

    public EnterpriseRegistrationTpl setIndustryName(String industryName) {
        this.industryName = industryName;
        return this;
    }

    public String getProviderName() {
        return providerName;
    }

    public EnterpriseRegistrationTpl setProviderName(String providerName) {
        this.providerName = providerName;
        return this;
    }

    public String getCandidateNames() {
        return candidateNames;
    }

    public EnterpriseRegistrationTpl setCandidateNames(String candidateNames) {
        this.candidateNames = candidateNames;
        return this;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public EnterpriseRegistrationTpl setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }
}
