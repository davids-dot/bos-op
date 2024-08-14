package com.luoge.bos.invoice.model.org;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Size;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

public class EnterpriseRegistrationResultBO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 企业名称
     */
    @NotBlank(message = "企业名称不能为空")
    @Size(min = 2, max = 100, message = "企业名称长度必须在2和100之间")
    private String enterpriseName;
    /**
     * 纳税人识别号
     */
    @NotBlank(message = "企业税号不能为空")
    private String enterpriseTaxNo;
    /**
     * 企业类型
     */
    private Integer enterpriseType;
    /**
     * 企业法人
     */
    @NotBlank(message = "企业法人名称不能为空")
    private String realCorporateName;
    /**
     * 营业执照图片id
     */
    private Integer enterpriseLicenseFileId;

    public Long getId() {
        return id;
    }

    public EnterpriseRegistrationResultBO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public EnterpriseRegistrationResultBO setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getEnterpriseTaxNo() {
        return enterpriseTaxNo;
    }

    public EnterpriseRegistrationResultBO setEnterpriseTaxNo(String enterpriseTaxNo) {
        this.enterpriseTaxNo = enterpriseTaxNo;
        return this;
    }

    public Integer getEnterpriseType() {
        return enterpriseType;
    }

    public EnterpriseRegistrationResultBO setEnterpriseType(Integer enterpriseType) {
        this.enterpriseType = enterpriseType;
        return this;
    }

    public String getRealCorporateName() {
        return realCorporateName;
    }

    public EnterpriseRegistrationResultBO setRealCorporateName(String realCorporateName) {
        this.realCorporateName = realCorporateName;
        return this;
    }

    public Integer getEnterpriseLicenseFileId() {
        return enterpriseLicenseFileId;
    }

    public EnterpriseRegistrationResultBO setEnterpriseLicenseFileId(Integer enterpriseLicenseFileId) {
        this.enterpriseLicenseFileId = enterpriseLicenseFileId;
        return this;
    }

}
