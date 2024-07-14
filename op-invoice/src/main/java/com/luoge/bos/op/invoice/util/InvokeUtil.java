package com.luoge.bos.op.invoice.util;


import com.alibaba.fastjson2.JSON;
import com.luoge.bos.op.core.BosAppCode;
import com.luoge.ns.core.Code;
import com.luoge.ns.core.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.time.Duration;
import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class InvokeUtil {
    private static final Logger log = LoggerFactory.getLogger(InvokeUtil.class);

    private static ExecutorService globalExecutor = new ThreadPoolExecutor(
            5,
            10,
            5L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(200),
            new CustomizableThreadFactory("global-async-task-"),
            new ThreadPoolExecutor.CallerRunsPolicy());
    ;

    public enum Status {
        WAIT,
        PROCESSING,
        FINISH;
    }

    public static <T> R<T> invokeUtilFinish(Function<Integer, R<Status>> statusFunction, Supplier<R<?>> invokeFunction, Duration timeout, Duration interval) {
        boolean isFinished = false;
        long startTime = System.nanoTime();
        long timeOutNano = timeout.toNanos();
        try {
            int count = 0;
            while (!isFinished) {
                count++;
                R<?> statusR = null;
                if (statusFunction == null) {
                    statusR = invokeFunction.get();
                } else {
                    statusR = statusFunction.apply(count);
                }

                if (statusR.failed()) {
                    return R.fail(statusR);
                }

                if (statusR.getData() instanceof Status status) {
                    // 判断是否超时
                    if (timeOutNano > 0 && (System.nanoTime() - startTime) > timeOutNano) {
                        log.warn("current invoke timeout, invoke aborted!");
                        return R.fail(BosAppCode.TIMEOUT);
                    }
                    // 如果已完成
                    if (status.equals(Status.FINISH)) {
                        isFinished = true;
                    } else {
                        Thread.sleep(interval.toMillis());
                    }
                } else {
                    return (R<T>) statusR;
                }
            }
            return (R<T>) invokeFunction.get();
        } catch (Exception e) {
            log.error("invoke util finish error：", e);
            return R.fail(Code.SYSTEM_ERROR);
        }
    }

    public static <T> R<T> invokeUtilFinish(Supplier<R<?>> invokeFunction, Duration timeout, Duration interval) {
        return invokeUtilFinish(null, invokeFunction, timeout, interval);
    }

    /**
     * 基于分页的方法调用
     *
     * @param supplier 业务方法，会传入分页参数，如果分页已结束则返回ture,否则返回false
     * @return 分页调用结果
     */
    public static R<Void> invokeWithPages(Function<Integer, R<Boolean>> supplier) {
        int pageNo = 1;
        boolean hasNextPage = true;
        try {
            while (hasNextPage) {
                R<Boolean> r = supplier.apply(pageNo);
                if (r.failed()) {
                    return R.fail(r);
                }
                hasNextPage = r.getData();
                pageNo = pageNo + 1;
            }
        } catch (Exception e) {
            log.error("invoke with pages error：", e);
            return R.fail(Code.SYSTEM_ERROR);
        }
        return R.SUCCESS;
    }

    /**
     * 基于分页的方法调用
     *
     * @param supplier 业务方法，会传入分页参数，如果分页已结束则返回ture,否则返回false
     * @return 分页调用结果
     */
    public static R<Void> invokeWithPages(String reqId, BiFunction<String, Integer, R<Boolean>> supplier) {
        int pageNo = 1;
        boolean hasNextPage = true;
        try {
            while (hasNextPage) {
                R<Boolean> r = supplier.apply(reqId, pageNo);
                if (r.failed()) {
                    return R.fail(r);
                }
                hasNextPage = r.getData();
                pageNo = pageNo + 1;
            }
        } catch (Exception e) {
            log.error("invoke with pages error：", e);
            return R.fail(Code.SYSTEM_ERROR);
        }
        return R.SUCCESS;
    }

    /**
     * invoke rpc method, get result.
     *
     * @param supplier invoke lambda
     * @param <T>      response object
     * @return return response if invoke success, otherwise result code in the StatusRuntimeException
     */
    public static <T> R<T> invoke(Supplier<T> supplier) {
        try {
            T reply = supplier.get();
            if (log.isDebugEnabled()) {
                try {
                    log.debug("invoke rsp:{}",  JSON.toJSONString(reply));
                } catch (Exception e) {
                    log.debug("invoke rsp:{}", reply);
                }
            }
            return R.success(reply);
        } catch (Throwable e) {
            log.error("invoke rpc error", e);
            return R.fail(BosAppCode.INVOKE_RPC_ERROR);
        }
    }

    /**
     * invoke rpc method, get result.
     *
     * @param supplier invoke lambda
     * @param <T>      response object
     * @return return response if invoke success, otherwise result code in the StatusRuntimeException
     */
    public static <T> R<T> invoke(Supplier<T> supplier, long timeOut) {
        try {
            Future<R<T>> submit = globalExecutor.submit(() -> invoke(supplier));
            return submit.get(timeOut, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            log.error("调用异常，超时参数：{}", timeOut, e);
            return R.fail(BosAppCode.INVOKE_RPC_ERROR);
        }
    }

    /**
     * 异步执行任务，异常时能打印日志
     *
     * @param runnable        任务
     * @param executorService 线程池
     */
    public static void runAsync(Runnable runnable, ExecutorService executorService) {
        CompletableFuture.runAsync(runnable, executorService)
                .exceptionally(e -> {
                    log.error("async run error", e);
                    return null;
                });
    }

    /**
     * 使用全局异常池异步执行任务，异常时能打印日志
     *
     * @param runnable 任务
     */
    public static void runAsync(Runnable runnable) {
        CompletableFuture.runAsync(runnable, globalExecutor)
                .exceptionally(e -> {
                    log.error("async run error", e);
                    return null;
                });
    }
}
