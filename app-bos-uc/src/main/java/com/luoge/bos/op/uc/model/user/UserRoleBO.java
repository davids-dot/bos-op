package com.luoge.bos.op.uc.model.user;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class UserRoleBO {

    @NotNull
    private Integer userId;

    private List<Integer> roleIds;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }
}
