package com.luoge.bos.op.uc.model.role;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class RolePermissionBO {

    @NotNull
    private Integer roleId;

    private List<String> permissions;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
