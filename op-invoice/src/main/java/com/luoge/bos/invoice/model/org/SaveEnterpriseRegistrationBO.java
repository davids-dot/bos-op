package com.luoge.bos.invoice.model.org;

import org.wildfly.common.annotation.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public class SaveEnterpriseRegistrationBO {
    /**
     * 注册单的id
     */
    @NotNull
    private Long id;
    /**
     * 所选园区id
     */
    private Integer parkProviderId;

    /**
     * 所选园区名称
     */
    private String parkProviderName;
    /**
     * 行业id
     */
    private Integer industryId;
    /**
     * 身份证正面文件id
     */
    private Integer idCardFrontFileId;
    /**
     * 身份证反面文件id
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
    private Boolean isBureau;
    /**
     * 候选企业列表
     */
    private List<String> candidateEnterpriseName;
    /**
     * 付款凭证图片id
     */
    private List<Integer> paymentProofFileId;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

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

    public Boolean getIsBureau() {
        return isBureau;
    }

    public SaveEnterpriseRegistrationBO setIsBureau(Boolean isBureau) {
        this.isBureau = isBureau;
        return this;
    }

    public List<String> getCandidateEnterpriseName() {
        return candidateEnterpriseName;
    }

    public SaveEnterpriseRegistrationBO setCandidateEnterpriseName(List<String> candidateEnterpriseName) {
        this.candidateEnterpriseName = candidateEnterpriseName;
        return this;
    }

    public List<Integer> getPaymentProofFileId() {
        return paymentProofFileId;
    }

    public SaveEnterpriseRegistrationBO setPaymentProofFileId(List<Integer> paymentProofFileId) {
        this.paymentProofFileId = paymentProofFileId;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public SaveEnterpriseRegistrationBO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getParkProviderName() {
        return parkProviderName;
    }

    public SaveEnterpriseRegistrationBO setParkProviderName(String parkProviderName) {
        this.parkProviderName = parkProviderName;
        return this;
    }
}
