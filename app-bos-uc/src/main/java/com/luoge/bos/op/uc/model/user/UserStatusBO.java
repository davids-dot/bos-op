package com.luoge.bos.op.uc.model.user;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UserStatusBO {
    @NotNull
    private Integer userId;

    @NotNull
    @Min(1)
    @Max(3)
    private Integer status;

    public Integer getUserId() {
        return userId;
    }

    public UserStatusBO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UserStatusBO setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
