package com.luoge.bos.invoice.model.org;


public class EnterpriseRegistrationStatusBO {
    private Long id;
    /**
     *  操作状态类型  1-审核  2-作废
     */
    private Integer operation;

    public Long getId() {
        return id;
    }

    public EnterpriseRegistrationStatusBO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getOperation() {
        return operation;
    }

    public EnterpriseRegistrationStatusBO setOperation(Integer operation) {
        this.operation = operation;
        return this;
    }

}
