package com.luoge.bos.data.configuration;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({AppConfiguration.SmsConfig.class})
public class AppConfiguration {
    @Resource
    private SmsConfig smsConfig;

    @Value("${bos.file.storage-path}")
    private String fileStoragePath;

    @ConfigurationProperties(prefix = "sms")
    public static class SmsConfig {
        private String endpoint;
        private String appKey;
        private String secret;

        public String getEndpoint() {
            return endpoint;
        }

        public SmsConfig setEndpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        public String getAppKey() {
            return appKey;
        }

        public SmsConfig setAppKey(String appKey) {
            this.appKey = appKey;
            return this;
        }

        public String getSecret() {
            return secret;
        }

        public SmsConfig setSecret(String secret) {
            this.secret = secret;
            return this;
        }
    }

    public SmsConfig getSmsConfig() {
        return smsConfig;
    }

    public AppConfiguration setSmsConfig(SmsConfig smsConfig) {
        this.smsConfig = smsConfig;
        return this;
    }

    public String getFileStoragePath() {
        return fileStoragePath;
    }

    public AppConfiguration setFileStoragePath(String fileStoragePath) {
        this.fileStoragePath = fileStoragePath;
        return this;
    }
}
