package com.luoge.bos.invoice.model.apply;

public class UpdateInvoiceApplyStatusBO {
    private Long id;
    /**
     * 审核操作 1-审核通过 2-作废
     */
    private Integer operation;
    private String operationRemark;

    public Long getId() {
        return id;
    }

    public UpdateInvoiceApplyStatusBO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getOperation() {
        return operation;
    }

    public UpdateInvoiceApplyStatusBO setOperation(Integer operation) {
        this.operation = operation;
        return this;
    }

    public String getOperationRemark() {
        return operationRemark;
    }

    public UpdateInvoiceApplyStatusBO setOperationRemark(String operationRemark) {
        this.operationRemark = operationRemark;
        return this;
    }
}