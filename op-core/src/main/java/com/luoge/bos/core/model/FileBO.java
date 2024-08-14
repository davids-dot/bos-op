package com.luoge.bos.core.model;

public class FileBO {
    /**
     * 文件id
     */
    private Integer id;
    /**
     * 文件名称
     */
    private String name;
    /**
     * 文件url
     */
    private String url;
    /**
     * 文件二进制内容
     */
    private byte[] content;
    /**
     * 媒体类型 如 image/jpeg
     */
    private String contentType;
    /**
     * 原始文件名
     */
    private String originalName;

    public Integer getId() {
        return id;
    }

    public FileBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FileBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public FileBO setUrl(String url) {
        this.url = url;
        return this;
    }

    public byte[] getContent() {
        return content;
    }

    public FileBO setContent(byte[] content) {
        this.content = content;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public FileBO setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public String getOriginalName() {
        return originalName;
    }

    public FileBO setOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }
}
