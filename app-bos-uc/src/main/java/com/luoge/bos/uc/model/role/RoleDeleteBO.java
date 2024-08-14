package com.luoge.bos.uc.model.role;

import jakarta.validation.constraints.NotNull;

public class RoleDeleteBO {

    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public RoleDeleteBO setId(Integer id) {
        this.id = id;
        return this;
    }
}
