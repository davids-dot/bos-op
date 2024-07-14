package com.luoge.bos.op.invoice.model;

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
