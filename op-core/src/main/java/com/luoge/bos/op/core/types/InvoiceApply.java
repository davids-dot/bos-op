package com.luoge.bos.op.core.types;

import com.luoge.bos.op.core.BosAppCode;
import com.luoge.ns.core.R;

import java.util.Objects;
import java.util.stream.Stream;

public interface InvoiceApply {


    enum Action {
        /**
         * 提交付款凭证
         */
        SUBMIT_PAYMENT,
        /**
         * 审核通过
         */
        APPROVE,
        /**
         * 作废
         */
        MARK_DEPRECATED,
        /**
         * 审核驳回
         */
        REJECT;
    }

    enum Status {
        /**
         * 待付款
         */
        TO_PAY(1) {
            @Override
            public R<Status> onAction(Action action) {
                if (action == Action.SUBMIT_PAYMENT) {
                    return R.success(TO_APPROVE);
                }
                return R.fail(BosAppCode.ILLEGAL_ACTION);
            }
        },
        /**
         * 待审核
         */
        TO_APPROVE(2) {
            @Override
            public R<Status> onAction(Action action) {
                if (action == Action.APPROVE) {
                    return R.success(DONE);
                }
                if (action == Action.MARK_DEPRECATED) {
                    return R.success(DEPRECATED);
                }
                if (action == Action.REJECT) {
                    return R.success(REJECTED);
                }
                return R.fail(BosAppCode.ILLEGAL_ACTION);
            }
        },
        /**
         * 已通过
         */
        DONE(3) {
            @Override
            public R<Status> onAction(Action action) {
                return super.onAction(action);
            }
        },
        /**
         * 已驳回
         */
        REJECTED(4) {
            @Override
            public R<Status> onAction(Action action) {
                if (action == Action.MARK_DEPRECATED) {
                    return R.success(DEPRECATED);
                }
                return R.fail(BosAppCode.ILLEGAL_ACTION);
            }
        },
        /**
         * 已作废
         */
        DEPRECATED(5) {
            @Override
            public R<Status> onAction(Action action) {
                return super.onAction(action);
            }
        };

        public final int status;

        Status(int status) {
            this.status = status;
        }

        public R<Status> onAction(Action action) {
            return R.fail(BosAppCode.ILLEGAL_ACTION);
        }

        public static Status of(int status) {
            return Stream.of(values()).filter(x -> Objects.equals(x.status, status)).findAny().orElseThrow();
        }

    }
}
