package com.luoge.bos.invoice.model;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public class SaveEnterpriseRegistrationBO {
    /**
     * 注册单的id
     */
    private Long id;
    /**
     * 所选园区id
     */
    @NotNull
    private Integer parkProviderId;
    /**
     * 行业id
     */
    private Integer industryId;
    /**
     * 身份证正面文件id
     */
    private Integer idCardFrontFileId;
    /**
     * 身份证正面文件id
     */
    private Integer idCardBackFileId;
    /**
     * 半身照文件id
     */
    private Integer photoFileId;
    /**
     * 法人名称
     */
    private String corporateName;
    /**
     * 法人身份证号
     */
    private String corporateIdNo;
    /**
     * 法人电话号码
     */
    private String corporatePhone;
    /**
     * 以工商局核定为准
     */
    private Integer isBureau;
    /**
     * 候选企业列表
     */
    private List<String> candidateEnterpriseNames;
    /**
     * 付款凭证图片id
     */
    private String paymentProofFileId;
    /**
     * 付款金额
     */
    private BigDecimal paymentAmount;
    /**
     * 收款公司名
     */
    private String parkProviderAccountName;
    /**
     * 收款银行
     */
    private String parkProviderAccountBank;
    /**
     * 收款账号
     */
    private String parkProviderAccountNo;
    /**
     * 园区服务商名称
     */
    private String parkProviderName;
    /**
     * 真实企业名称
     */
    private String enterpriseName;
    /**
     * 真实企业税号
     */
    private String enterpriseTaxNo;
    /**
     * 企业类型
     */
    private Integer enterpriseType;
    /**
     * 企业营业执照文件id
     */
    private Integer enterpriseLicenseFileId;


    private Integer hasOtherEnterprise;

    public Long getId() {
        return id;
    }

    public SaveEnterpriseRegistrationBO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public SaveEnterpriseRegistrationBO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }

    public Integer getIndustryId() {
        return industryId;
    }

    public SaveEnterpriseRegistrationBO setIndustryId(Integer industryId) {
        this.industryId = industryId;
        return this;
    }

    public Integer getIdCardFrontFileId() {
        return idCardFrontFileId;
    }

    public SaveEnterpriseRegistrationBO setIdCardFrontFileId(Integer idCardFrontFileId) {
        this.idCardFrontFileId = idCardFrontFileId;
        return this;
    }

    public Integer getIdCardBackFileId() {
        return idCardBackFileId;
    }

    public SaveEnterpriseRegistrationBO setIdCardBackFileId(Integer idCardBackFileId) {
        this.idCardBackFileId = idCardBackFileId;
        return this;
    }

    public Integer getPhotoFileId() {
        return photoFileId;
    }

    public SaveEnterpriseRegistrationBO setPhotoFileId(Integer photoFileId) {
        this.photoFileId = photoFileId;
        return this;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public SaveEnterpriseRegistrationBO setCorporateName(String corporateName) {
        this.corporateName = corporateName;
        return this;
    }

    public String getCorporateIdNo() {
        return corporateIdNo;
    }

    public SaveEnterpriseRegistrationBO setCorporateIdNo(String corporateIdNo) {
        this.corporateIdNo = corporateIdNo;
        return this;
    }

    public String getCorporatePhone() {
        return corporatePhone;
    }

    public SaveEnterpriseRegistrationBO setCorporatePhone(String corporatePhone) {
        this.corporatePhone = corporatePhone;
        return this;
    }

    public Integer getIsBureau() {
        return isBureau;
    }

    public SaveEnterpriseRegistrationBO setIsBureau(Integer isBureau) {
        this.isBureau = isBureau;
        return this;
    }

    public List<String> getCandidateEnterpriseNames() {
        return candidateEnterpriseNames;
    }

    public SaveEnterpriseRegistrationBO setCandidateEnterpriseNames(List<String> candidateEnterpriseNames) {
        this.candidateEnterpriseNames = candidateEnterpriseNames;
        return this;
    }

    public String getPaymentProofFileId() {
        return paymentProofFileId;
    }

    public SaveEnterpriseRegistrationBO setPaymentProofFileId(String paymentProofFileId) {
        this.paymentProofFileId = paymentProofFileId;
        return this;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public SaveEnterpriseRegistrationBO setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    public String getParkProviderAccountName() {
        return parkProviderAccountName;
    }

    public SaveEnterpriseRegistrationBO setParkProviderAccountName(String parkProviderAccountName) {
        this.parkProviderAccountName = parkProviderAccountName;
        return this;
    }

    public String getParkProviderAccountBank() {
        return parkProviderAccountBank;
    }

    public SaveEnterpriseRegistrationBO setParkProviderAccountBank(String parkProviderAccountBank) {
        this.parkProviderAccountBank = parkProviderAccountBank;
        return this;
    }

    public String getParkProviderAccountNo() {
        return parkProviderAccountNo;
    }

    public SaveEnterpriseRegistrationBO setParkProviderAccountNo(String parkProviderAccountNo) {
        this.parkProviderAccountNo = parkProviderAccountNo;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public SaveEnterpriseRegistrationBO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public SaveEnterpriseRegistrationBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getEnterpriseTaxNo() {
        return enterpriseTaxNo;
    }

    public SaveEnterpriseRegistrationBO setEnterpriseTaxNo(String enterpriseTaxNo) {
        this.enterpriseTaxNo = enterpriseTaxNo;
        return this;
    }

    public Integer getEnterpriseType() {
        return enterpriseType;
    }

    public SaveEnterpriseRegistrationBO setEnterpriseType(Integer enterpriseType) {
        this.enterpriseType = enterpriseType;
        return this;
    }

    public Integer getEnterpriseLicenseFileId() {
        return enterpriseLicenseFileId;
    }

    public SaveEnterpriseRegistrationBO setEnterpriseLicenseFileId(Integer enterpriseLicenseFileId) {
        this.enterpriseLicenseFileId = enterpriseLicenseFileId;
        return this;
    }

    public Integer getHasOtherEnterprise() {
        return hasOtherEnterprise;
    }

    public SaveEnterpriseRegistrationBO setHasOtherEnterprise(Integer hasOtherEnterprise) {
        this.hasOtherEnterprise = hasOtherEnterprise;
        return this;
    }
}
