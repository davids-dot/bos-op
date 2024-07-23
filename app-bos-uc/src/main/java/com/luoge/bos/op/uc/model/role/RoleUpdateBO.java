package com.luoge.bos.op.uc.model.role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RoleUpdateBO {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 20)
    private String name;

    @Size(max = 200)
    private String remark;

    public Integer getId() {
        return id;
    }

    public RoleUpdateBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleUpdateBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public RoleUpdateBO setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
