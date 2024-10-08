package com.luoge.bos.core.types;

import com.luoge.bos.core.BosAppCode;
import com.luoge.ns.core.R;

import java.util.Objects;
import java.util.stream.Stream;

public interface EnterpriseRegistration {

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
         * 录入结果
         */
        RECORD_RESULT;

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
                    return R.success(PROCESSING);
                }
                if (action == Action.MARK_DEPRECATED) {
                    return R.success(DEPRECATED);
                }
                return R.fail(BosAppCode.ILLEGAL_ACTION);
            }
        },
        /**
         * 办理中
         */
        PROCESSING(3) {
            @Override
            public R<Status> onAction(Action action) {
                if (action == Action.RECORD_RESULT) {
                    return R.success(DONE);
                }
                if (action == Action.MARK_DEPRECATED) {
                    return R.success(DEPRECATED);
                }
                return R.fail(BosAppCode.ILLEGAL_ACTION);
            }
        },
        /**
         * 已完成
         */
        DONE(4) {
            @Override
            public R<Status> onAction(Action action) {
                return super.onAction(action);
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
