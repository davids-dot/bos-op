package com.luoge.bos.op.core.types;

import java.util.Arrays;
import java.util.Objects;

/**
 * 发票状态
 */
public enum InvoiceStatus {
    UNKNOWN(0),
    DRAFT(1),
    ISSUING(2),
    SUCCESS(3),
    FAILED(4),
    BY_RED_PART(5),
    BY_RED_FULL(6),
    CANCELED(7),
    EXCEPTION(8),
    /**
     * 待开票
     */
    MOBILE_APPLYING(9);

    public final int status;

    InvoiceStatus(int status) {
        this.status = status;
    }

    public static InvoiceStatus of(int status) {
        return Arrays.stream(InvoiceStatus.values()).filter(t -> t.status == status).findFirst().orElse(UNKNOWN);
    }

    public static boolean canDelete(int status) {
        return DRAFT.status == status || FAILED.status == status || MOBILE_APPLYING.status == status;
    }

    public static boolean canEdit(Integer status) {
        return DRAFT.status == status || FAILED.status == status || MOBILE_APPLYING.status == status;
    }

    /**
     * 是否 已成功开具过
     */
    public static boolean hasIssued(Integer status) {
        return Objects.nonNull(status) && (SUCCESS.status == status || BY_RED_FULL.status == status || BY_RED_PART.status == status);
    }

    /**
     * 是否可冲红
     *
     * @param status 状态
     */
    public static boolean canApplyRed(int status) {
        return SUCCESS.status == status || BY_RED_PART.status == status;
    }

    public static boolean canIssueMobile(int status) {
        return MOBILE_APPLYING.status == status;
    }
}
