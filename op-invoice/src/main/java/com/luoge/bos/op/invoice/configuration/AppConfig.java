package com.luoge.bos.op.invoice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value("${bos.file.storage-path}")
    private String fileStoragePath;
    @Value("${bos.file.temporary-path}")
    private String temporaryPath;

    public String getFileStoragePath() {
        return fileStoragePath;
    }

    public AppConfig setFileStoragePath(String fileStoragePath) {
        this.fileStoragePath = fileStoragePath;
        return this;
    }

    public String getTemporaryPath() {
        return temporaryPath;
    }

    public AppConfig setTemporaryPath(String temporaryPath) {
        this.temporaryPath = temporaryPath;
        return this;
    }
}
