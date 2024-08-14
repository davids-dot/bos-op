package com.luoge.bos.invoice.model;

import jakarta.validation.constraints.NotNull;

public class DeleteLongBO {
    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public DeleteLongBO setId(Long id) {
        this.id = id;
        return this;
    }
}
