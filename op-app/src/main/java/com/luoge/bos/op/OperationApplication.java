package com.luoge.bos.op;

import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients(basePackages = {"com.luoge.ns"})
@EnableFileStorage
@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"com.luoge.bos"})
public class OperationApplication {
    public static void main(String[] args) {
        SpringApplication.run(OperationApplication.class);
    }

}