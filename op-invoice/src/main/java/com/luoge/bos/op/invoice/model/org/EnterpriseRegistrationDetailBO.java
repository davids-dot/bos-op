package com.luoge.bos.op.invoice.model.org;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.List;

public class EnterpriseRegistrationDetailBO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 法人姓名
     */
    private String corporateName;
    /**
     * 法人身份证号
     */
    private String corporateIdNo;
    /**
     * 法人电话
     */
    private String corporatePhone;
    /**
     * 法人身份证正面
     */
    private Integer idCardFrontFileId;
    /**
     * 法人身份证反面
     */
    private Integer idCardBackFileId;
    /**
     * 法人半身照片
     */
    private Integer photoFileId;
    /**
     * 所属行业id
     */
    private Integer industryId;
    /**
     * 所属行业
     */
    private String industryName;
    /**
     * 所属园区id
     */
    private Integer parkProviderId;
    /**
     * 所属园区
     */
    private String parkProviderName;
    /**
     * 候选企业名称
     */
    private List<String> candidateEnterpriseName;
    /**
     * 付款凭证
     */
    private List<Integer> paymentProofFileId;
    /**
     * 付款金额
     */
    private BigDecimal paymentAmount;
    /**
     * 申请提交时间
     */
    private Long createTime;
    /**
     * 审核时间
     */
    private Long approveTime;
    /**
     * 作废时间
     */
    private Long deprecatedTime;
    /**
     * 完成时间
     */
    private Long finishedTime;
    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 纳税人识别号
     */
    private String enterpriseTaxNo;
    /**
     * 企业类型
     */
    private Integer enterpriseType;
    /**
     * 企业法人
     */
    private String realCorporateName;
    /**
     * 营业执照图片id
     */
    private Integer enterpriseLicenseFileId;
    /**
     * 当前状态
     */
    private Integer status;

    /**
     * 以工商局注册为准
     */
    private Boolean isBureau;

    public Long getId() {
        return id;
    }

    public EnterpriseRegistrationDetailBO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public EnterpriseRegistrationDetailBO setCorporateName(String corporateName) {
        this.corporateName = corporateName;
        return this;
    }

    public String getCorporateIdNo() {
        return corporateIdNo;
    }

    public EnterpriseRegistrationDetailBO setCorporateIdNo(String corporateIdNo) {
        this.corporateIdNo = corporateIdNo;
        return this;
    }

    public String getCorporatePhone() {
        return corporatePhone;
    }

    public EnterpriseRegistrationDetailBO setCorporatePhone(String corporatePhone) {
        this.corporatePhone = corporatePhone;
        return this;
    }

    public Integer getIdCardFrontFileId() {
        return idCardFrontFileId;
    }

    public EnterpriseRegistrationDetailBO setIdCardFrontFileId(Integer idCardFrontFileId) {
        this.idCardFrontFileId = idCardFrontFileId;
        return this;
    }

    public Integer getIdCardBackFileId() {
        return idCardBackFileId;
    }

    public EnterpriseRegistrationDetailBO setIdCardBackFileId(Integer idCardBackFileId) {
        this.idCardBackFileId = idCardBackFileId;
        return this;
    }

    public Integer getPhotoFileId() {
        return photoFileId;
    }

    public EnterpriseRegistrationDetailBO setPhotoFileId(Integer photoFileId) {
        this.photoFileId = photoFileId;
        return this;
    }

    public String getIndustryName() {
        return industryName;
    }

    public EnterpriseRegistrationDetailBO setIndustryName(String industryName) {
        this.industryName = industryName;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public EnterpriseRegistrationDetailBO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public List<String> getCandidateEnterpriseName() {
        return candidateEnterpriseName;
    }

    public EnterpriseRegistrationDetailBO setCandidateEnterpriseName(List<String> candidateEnterpriseName) {
        this.candidateEnterpriseName = candidateEnterpriseName;
        return this;
    }

    public List<Integer> getPaymentProofFileId() {
        return paymentProofFileId;
    }

    public EnterpriseRegistrationDetailBO setPaymentProofFileId(List<Integer> paymentProofFileId) {
        this.paymentProofFileId = paymentProofFileId;
        return this;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public EnterpriseRegistrationDetailBO setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public EnterpriseRegistrationDetailBO setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getApproveTime() {
        return approveTime;
    }

    public EnterpriseRegistrationDetailBO setApproveTime(Long approveTime) {
        this.approveTime = approveTime;
        return this;
    }

    public Long getDeprecatedTime() {
        return deprecatedTime;
    }

    public EnterpriseRegistrationDetailBO setDeprecatedTime(Long deprecatedTime) {
        this.deprecatedTime = deprecatedTime;
        return this;
    }

    public Long getFinishedTime() {
        return finishedTime;
    }

    public EnterpriseRegistrationDetailBO setFinishedTime(Long finishedTime) {
        this.finishedTime = finishedTime;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public EnterpriseRegistrationDetailBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getEnterpriseTaxNo() {
        return enterpriseTaxNo;
    }

    public EnterpriseRegistrationDetailBO setEnterpriseTaxNo(String enterpriseTaxNo) {
        this.enterpriseTaxNo = enterpriseTaxNo;
        return this;
    }

    public Integer getEnterpriseType() {
        return enterpriseType;
    }

    public EnterpriseRegistrationDetailBO setEnterpriseType(Integer enterpriseType) {
        this.enterpriseType = enterpriseType;
        return this;
    }

    public String getRealCorporateName() {
        return realCorporateName;
    }

    public EnterpriseRegistrationDetailBO setRealCorporateName(String realCorporateName) {
        this.realCorporateName = realCorporateName;
        return this;
    }

    public Integer getEnterpriseLicenseFileId() {
        return enterpriseLicenseFileId;
    }

    public EnterpriseRegistrationDetailBO setEnterpriseLicenseFileId(Integer enterpriseLicenseFileId) {
        this.enterpriseLicenseFileId = enterpriseLicenseFileId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public EnterpriseRegistrationDetailBO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Boolean getIsBureau() {
        return isBureau;
    }

    public EnterpriseRegistrationDetailBO setIsBureau(Boolean bureau) {
        isBureau = bureau;
        return this;
    }

    public Integer getIndustryId() {
        return industryId;
    }

    public EnterpriseRegistrationDetailBO setIndustryId(Integer industryId) {
        this.industryId = industryId;
        return this;
    }

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public EnterpriseRegistrationDetailBO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }
}
