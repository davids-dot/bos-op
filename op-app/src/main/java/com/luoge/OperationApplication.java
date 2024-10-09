package com.luoge;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.luoge")
@EnableFeignClients(basePackages = {"com.luoge.ns"})
@EnableFileStorage
@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"com.luoge"})
public class OperationApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperationApplication.class);
    }

}