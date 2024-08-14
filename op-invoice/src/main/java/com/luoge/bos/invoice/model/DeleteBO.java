package com.luoge.bos.invoice.model;

import jakarta.validation.constraints.NotNull;

public class DeleteBO {
    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public DeleteBO setId(Integer id) {
        this.id = id;
        return this;
    }
}
