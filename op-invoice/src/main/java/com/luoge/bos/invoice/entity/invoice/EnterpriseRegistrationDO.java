package com.luoge.bos.invoice.entity.invoice;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EnterpriseRegistrationDO {
    private Long id;

    private Integer orgId;

    private Integer userId;

    private Integer status;

    private Integer parkProviderId;

    private Integer industryId;

    private Integer idCardFrontFileId;

    private Integer idCardBackFileId;

    private Integer photoFileId;

    private String corporateName;

    private String corporateIdNo;

    private String corporatePhone;

    private Boolean isBureau;

    private String candidateEnterpriseName;

    private String paymentProofFileId;

    private BigDecimal paymentAmount;

    private String parkProviderAccountName;

    private String parkProviderAccountBank;

    private String parkProviderAccountNo;

    private String parkProviderName;

    private String enterpriseName;

    private String enterpriseTaxNo;

    private Integer enterpriseType;

    private Integer enterpriseLicenseFileId;
    private String realCorporateName;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public EnterpriseRegistrationDO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public EnterpriseRegistrationDO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public EnterpriseRegistrationDO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public EnterpriseRegistrationDO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public EnterpriseRegistrationDO setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
        return this;
    }

    public Integer getIndustryId() {
        return industryId;
    }

    public EnterpriseRegistrationDO setIndustryId(Integer industryId) {
        this.industryId = industryId;
        return this;
    }

    public Integer getIdCardFrontFileId() {
        return idCardFrontFileId;
    }

    public EnterpriseRegistrationDO setIdCardFrontFileId(Integer idCardFrontFileId) {
        this.idCardFrontFileId = idCardFrontFileId;
        return this;
    }

    public Integer getIdCardBackFileId() {
        return idCardBackFileId;
    }

    public EnterpriseRegistrationDO setIdCardBackFileId(Integer idCardBackFileId) {
        this.idCardBackFileId = idCardBackFileId;
        return this;
    }

    public Integer getPhotoFileId() {
        return photoFileId;
    }

    public EnterpriseRegistrationDO setPhotoFileId(Integer photoFileId) {
        this.photoFileId = photoFileId;
        return this;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public EnterpriseRegistrationDO setCorporateName(String corporateName) {
        this.corporateName = corporateName;
        return this;
    }

    public String getCorporateIdNo() {
        return corporateIdNo;
    }

    public EnterpriseRegistrationDO setCorporateIdNo(String corporateIdNo) {
        this.corporateIdNo = corporateIdNo;
        return this;
    }

    public String getCorporatePhone() {
        return corporatePhone;
    }

    public EnterpriseRegistrationDO setCorporatePhone(String corporatePhone) {
        this.corporatePhone = corporatePhone;
        return this;
    }

    public Boolean getIsBureau() {
        return isBureau;
    }

    public EnterpriseRegistrationDO setIsBureau(Boolean bureau) {
        isBureau = bureau;
        return this;
    }

    public String getCandidateEnterpriseName() {
        return candidateEnterpriseName;
    }

    public EnterpriseRegistrationDO setCandidateEnterpriseName(String candidateEnterpriseName) {
        this.candidateEnterpriseName = candidateEnterpriseName;
        return this;
    }

    public String getPaymentProofFileId() {
        return paymentProofFileId;
    }

    public EnterpriseRegistrationDO setPaymentProofFileId(String paymentProofFileId) {
        this.paymentProofFileId = paymentProofFileId;
        return this;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public EnterpriseRegistrationDO setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    public String getParkProviderAccountName() {
        return parkProviderAccountName;
    }

    public EnterpriseRegistrationDO setParkProviderAccountName(String parkProviderAccountName) {
        this.parkProviderAccountName = parkProviderAccountName;
        return this;
    }

    public String getParkProviderAccountBank() {
        return parkProviderAccountBank;
    }

    public EnterpriseRegistrationDO setParkProviderAccountBank(String parkProviderAccountBank) {
        this.parkProviderAccountBank = parkProviderAccountBank;
        return this;
    }

    public String getParkProviderAccountNo() {
        return parkProviderAccountNo;
    }

    public EnterpriseRegistrationDO setParkProviderAccountNo(String parkProviderAccountNo) {
        this.parkProviderAccountNo = parkProviderAccountNo;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public EnterpriseRegistrationDO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public EnterpriseRegistrationDO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getEnterpriseTaxNo() {
        return enterpriseTaxNo;
    }

    public EnterpriseRegistrationDO setEnterpriseTaxNo(String enterpriseTaxNo) {
        this.enterpriseTaxNo = enterpriseTaxNo;
        return this;
    }

    public Integer getEnterpriseType() {
        return enterpriseType;
    }

    public EnterpriseRegistrationDO setEnterpriseType(Integer enterpriseType) {
        this.enterpriseType = enterpriseType;
        return this;
    }

    public Integer getEnterpriseLicenseFileId() {
        return enterpriseLicenseFileId;
    }

    public EnterpriseRegistrationDO setEnterpriseLicenseFileId(Integer enterpriseLicenseFileId) {
        this.enterpriseLicenseFileId = enterpriseLicenseFileId;
        return this;
    }

    public String getRealCorporateName() {
        return realCorporateName;
    }

    public EnterpriseRegistrationDO setRealCorporateName(String realCorporateName) {
        this.realCorporateName = realCorporateName;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public EnterpriseRegistrationDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public EnterpriseRegistrationDO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}