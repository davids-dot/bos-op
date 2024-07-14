package com.luoge.bos.op.core.types;

public interface OperationRecord {

    enum BusinessType {
        /**
         * 工商注册
         */
        ENTERPRISE_REGISTRATION("ENTERPRISE_REGISTRATION"),

        /**
         * 开票申请
         */
        INVOICE_APPLY("INVOICE_APPLY");

        public final String type;

        BusinessType(String type) {
            this.type = type;
        }
    }

    enum OperationType {
        /**
         * 工商注册审核通过
         */
        APPROVE(BusinessType.ENTERPRISE_REGISTRATION, "APPROVE"),
        /**
         * 办理完成
         */
        DONE(BusinessType.ENTERPRISE_REGISTRATION, "DONE"),
        /**
         * 作废
         */
        DEPRECATED(BusinessType.ENTERPRISE_REGISTRATION, "DEPRECATED"),
        /**
         * 开票申请审核通过
         */
        INVOICE_APPROVE(BusinessType.INVOICE_APPLY, "APPROVE"),
        /**
         * 审核驳回
         */
        INVOICE_REJECTED(BusinessType.INVOICE_APPLY, "REJECTED"),
        /**
         * 作废
         */
        INVOICE_DEPRECATED(BusinessType.INVOICE_APPLY, "DEPRECATED");

        public final BusinessType businessType;
        public final String type;

        OperationType(BusinessType businessType, String type) {
            this.businessType = businessType;
            this.type = type;
        }
    }


}
