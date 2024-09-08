package com.luoge.bos.invoice.entity;

import java.time.LocalDateTime;

public class FileDO {
    private Integer id;

    private Integer orgId;

    private Integer enterpriseId;

    private String name;

    private String originalName;

    private String contentType;

    private Long size;

    private String url;

    private String storageType;

    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public FileDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public FileDO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public FileDO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public String getName() {
        return name;
    }

    public FileDO setName(String name) {
        this.name = name;
        return this;
    }

    public String getOriginalName() {
        return originalName;
    }

    public FileDO setOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public FileDO setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public Long getSize() {
        return size;
    }

    public FileDO setSize(Long size) {
        this.size = size;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public FileDO setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getStorageType() {
        return storageType;
    }

    public FileDO setStorageType(String storageType) {
        this.storageType = storageType;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public FileDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "SysFileDO{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", enterpriseId=" + enterpriseId +
                ", name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", fileType='" + contentType + '\'' +
                ", size=" + size +
                ", url='" + url + '\'' +
                ", storageType='" + storageType + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}