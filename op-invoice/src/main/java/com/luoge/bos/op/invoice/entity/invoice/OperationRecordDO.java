package com.luoge.bos.op.invoice.entity.invoice;

import java.time.LocalDateTime;

public class OperationRecordDO {
    private Integer id;

    private Long businessId;

    private String businessType;

    private String operationType;

    private String operationRemark;

    private Integer operatorId;

    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public OperationRecordDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public OperationRecordDO setBusinessId(Long businessId) {
        this.businessId = businessId;
        return this;
    }

    public String getBusinessType() {
        return businessType;
    }

    public OperationRecordDO setBusinessType(String businessType) {
        this.businessType = businessType;
        return this;
    }

    public String getOperationType() {
        return operationType;
    }

    public OperationRecordDO setOperationType(String operationType) {
        this.operationType = operationType;
        return this;
    }

    public String getOperationRemark() {
        return operationRemark;
    }

    public OperationRecordDO setOperationRemark(String operationRemark) {
        this.operationRemark = operationRemark;
        return this;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public OperationRecordDO setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public OperationRecordDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
}