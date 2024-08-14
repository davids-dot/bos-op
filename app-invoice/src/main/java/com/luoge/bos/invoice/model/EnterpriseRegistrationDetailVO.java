package com.luoge.bos.invoice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.luoge.bos.core.serialize.BigDecimalSerializer;

import java.math.BigDecimal;
import java.util.List;

public class EnterpriseRegistrationDetailVO {
    /**
     * 注册单id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 机构id
     */
    private Integer orgId;
    /**
     * 微信用户openID
     */
    private Integer userId;
    /**
     * 状态
     * 1-待付款 2-待审核 3-办理中 4-已完成 5-已作废
     */
    private Integer status;

    /**
     * 开票行业id
     */
    private Integer industryId;

    /**
     * 开票行业id
     */
    private String industryName;

    /**
     * 身份证正面图片id
     */
    private Integer idCardFrontFileId;
    /**
     * 身份证反面图片id
     */
    private Integer idCardBackFileId;
    /**
     * 法人半身照片文件id
     */
    private Integer photoFileId;
    /**
     * 法人姓名
     */
    private String corporateName;
    /**
     * 法人身份证号
     */
    private String corporateIdNo;
    /**
     * 法人手机号
     */
    private String corporatePhone;
    /**
     * 企业名称是否以工商局核定为准
     */
    private Boolean isBureau;
    /**
     * 候选企业名称
     */
    private List<String> candidateEnterpriseNames;
    /**
     * 付款凭证图片id
     */
    private String paymentProofFileId;
    /**
     * 付款金额
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal paymentAmount;

    /**
     * 收款公司名
     */
    private String parkProviderAccountName;
    /**
     * 首款公司银行
     */
    private String parkProviderAccountBank;
    /**
     * 收款账号
     */
    private String parkProviderAccountNo;
    /**
     * 园区id
     */
    private Integer parkProviderId;
    /**
     * 园区名称
     */
    private String parkProviderName;
    /**
     * 审批后的企业名称
     */
    private String enterpriseName;
    /**
     * 企业税号
     */
    private String enterpriseTaxNo;
    /**
     * 企业类型
     */
    private Integer enterpriseType;
    /**
     * 营业执照文件id
     */
    private Integer enterpriseLicenseFileId;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 修改时间
     */
    private Long updateTime;

    private Boolean hasOtherEnterprise;

    public Long getId() {
        return id;
    }

    public EnterpriseRegistrationDetailVO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public EnterpriseRegistrationDetailVO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public EnterpriseRegistrationDetailVO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public EnterpriseRegistrationDetailVO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getIndustryId() {
        return industryId;
    }

    public EnterpriseRegistrationDetailVO setIndustryId(Integer industryId) {
        this.industryId = industryId;
        return this;
    }

    public Integer getIdCardFrontFileId() {
        return idCardFrontFileId;
    }

    public EnterpriseRegistrationDetailVO setIdCardFrontFileId(Integer idCardFrontFileId) {
        this.idCardFrontFileId = idCardFrontFileId;
        return this;
    }

    public Integer getIdCardBackFileId() {
        return idCardBackFileId;
    }

    public EnterpriseRegistrationDetailVO setIdCardBackFileId(Integer idCardBackFileId) {
        this.idCardBackFileId = idCardBackFileId;
        return this;
    }

    public Integer getPhotoFileId() {
        return photoFileId;
    }

    public EnterpriseRegistrationDetailVO setPhotoFileId(Integer photoFileId) {
        this.photoFileId = photoFileId;
        return this;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public EnterpriseRegistrationDetailVO setCorporateName(String corporateName) {
        this.corporateName = corporateName;
        return this;
    }

    public String getCorporateIdNo() {
        return corporateIdNo;
    }

    public EnterpriseRegistrationDetailVO setCorporateIdNo(String corporateIdNo) {
        this.corporateIdNo = corporateIdNo;
        return this;
    }

    public String getCorporatePhone() {
        return corporatePhone;
    }

    public EnterpriseRegistrationDetailVO setCorporatePhone(String corporatePhone) {
        this.corporatePhone = corporatePhone;
        return this;
    }

    public Boolean getBureau() {
        return isBureau;
    }

    public EnterpriseRegistrationDetailVO setBureau(Boolean bureau) {
        isBureau = bureau;
        return this;
    }

    public List<String> getCandidateEnterpriseNames() {
        return candidateEnterpriseNames;
    }

    public EnterpriseRegistrationDetailVO setCandidateEnterpriseNames(List<String> candidateEnterpriseNames) {
        this.candidateEnterpriseNames = candidateEnterpriseNames;
        return this;
    }

    public String getPaymentProofFileId() {
        return paymentProofFileId;
    }

    public EnterpriseRegistrationDetailVO setPaymentProofFileId(String paymentProofFileId) {
        this.paymentProofFileId = paymentProofFileId;
        return this;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public EnterpriseRegistrationDetailVO setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    public String getParkProviderAccountName() {
        return parkProviderAccountName;
    }

    public EnterpriseRegistrationDetailVO setParkProviderAccountName(String parkProviderAccountName) {
        this.parkProviderAccountName = parkProviderAccountName;
        return this;
    }

    public String getParkProviderAccountBank() {
        return parkProviderAccountBank;
    }

    public EnterpriseRegistrationDetailVO setParkProviderAccountBank(String parkProviderAccountBank) {
        this.parkProviderAccountBank = parkProviderAccountBank;
        return this;
    }

    public String getParkProviderAccountNo() {
        return parkProviderAccountNo;
    }

    public EnterpriseRegistrationDetailVO setParkProviderAccountNo(String parkProviderAccountNo) {
        this.parkProviderAccountNo = parkProviderAccountNo;
        return this;
    }

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public EnterpriseRegistrationDetailVO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public EnterpriseRegistrationDetailVO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public EnterpriseRegistrationDetailVO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getEnterpriseTaxNo() {
        return enterpriseTaxNo;
    }

    public EnterpriseRegistrationDetailVO setEnterpriseTaxNo(String enterpriseTaxNo) {
        this.enterpriseTaxNo = enterpriseTaxNo;
        return this;
    }

    public Integer getEnterpriseType() {
        return enterpriseType;
    }

    public EnterpriseRegistrationDetailVO setEnterpriseType(Integer enterpriseType) {
        this.enterpriseType = enterpriseType;
        return this;
    }

    public Integer getEnterpriseLicenseFileId() {
        return enterpriseLicenseFileId;
    }

    public EnterpriseRegistrationDetailVO setEnterpriseLicenseFileId(Integer enterpriseLicenseFileId) {
        this.enterpriseLicenseFileId = enterpriseLicenseFileId;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public EnterpriseRegistrationDetailVO setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public EnterpriseRegistrationDetailVO setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getIndustryName() {
        return industryName;
    }

    public EnterpriseRegistrationDetailVO setIndustryName(String industryName) {
        this.industryName = industryName;
        return this;
    }

    public Boolean getHasOtherEnterprise() {
        return hasOtherEnterprise;
    }

    public EnterpriseRegistrationDetailVO setHasOtherEnterprise(Boolean hasOtherEnterprise) {
        this.hasOtherEnterprise = hasOtherEnterprise;
        return this;
    }
}
