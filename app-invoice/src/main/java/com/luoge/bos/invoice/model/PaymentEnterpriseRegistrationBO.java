package com.luoge.bos.invoice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * 工商注册付款信息
 */
public class PaymentEnterpriseRegistrationBO {

    /**
     * 注册单的id
     */
    @NotNull
    private Long id;
    /**
     * 付款凭证图片id
     */
    private List<Integer> paymentProofFileId;

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

    @JsonIgnore
    private Integer status;


    public Long getId() {
        return id;
    }

    public PaymentEnterpriseRegistrationBO setId(Long id) {
        this.id = id;
        return this;
    }

    public List<Integer> getPaymentProofFileId() {
        return paymentProofFileId;
    }

    public PaymentEnterpriseRegistrationBO setPaymentProofFileId(List<Integer> paymentProofFileId) {
        this.paymentProofFileId = paymentProofFileId;
        return this;
    }

    public String getParkProviderAccountName() {
        return parkProviderAccountName;
    }

    public PaymentEnterpriseRegistrationBO setParkProviderAccountName(String parkProviderAccountName) {
        this.parkProviderAccountName = parkProviderAccountName;
        return this;
    }

    public String getParkProviderAccountBank() {
        return parkProviderAccountBank;
    }

    public PaymentEnterpriseRegistrationBO setParkProviderAccountBank(String parkProviderAccountBank) {
        this.parkProviderAccountBank = parkProviderAccountBank;
        return this;
    }

    public String getParkProviderAccountNo() {
        return parkProviderAccountNo;
    }

    public PaymentEnterpriseRegistrationBO setParkProviderAccountNo(String parkProviderAccountNo) {
        this.parkProviderAccountNo = parkProviderAccountNo;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public PaymentEnterpriseRegistrationBO setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
