package com.luoge.bos.invoice.model;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

public class IdBO {
    @NotBlank
    private String id;

    public IdBO() {
    }
    public IdBO(String id) {
        this.id = id;
    }

    public IdBO(Integer id) {
        this.id = String.valueOf(id);
    }

    public IdBO(Long id) {
        this.id = String.valueOf(id);
    }

    public String getId() {
        return id;
    }

    public IdBO setId(String id) {
        this.id = id;
        return this;
    }
}
