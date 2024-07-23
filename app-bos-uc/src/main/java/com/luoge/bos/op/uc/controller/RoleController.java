package com.luoge.bos.op.uc.controller;

import com.luoge.bos.op.uc.model.permission.PermissionVO;
import com.luoge.bos.op.uc.model.role.*;
import com.luoge.bos.op.uc.service.RoleService;
import com.luoge.bos.uc.ctx.Context;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理
 */
@RestController
@RequestMapping("bos-uc/setting")
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 查询角色
     *
     * @param ctx 上下文
     * @return 角色列表
     */
    @GetMapping("/roles")
    public R<List<RoleVO>> listRoles(Context ctx) {
        var r = roleService.listRoles(ctx.getOrgId());
        return R.success(r);
    }

    /**
     * 新增角色
     *
     * @param role 角色
     * @param ctx  上下文
     * @return 无
     */
    @PostMapping("/roles")
    public R<Void> insertRole(@RequestBody @Valid RoleCreateBO role, Context ctx) {
        return roleService.insertRole(ctx.getOrgId(), role);
    }

    /**
     * 修改角色
     *
     * @param roleBO 角色
     * @param ctx    上下文
     * @return 无
     */
    @PutMapping("/roles")
    public R<Void> updateRole(@RequestBody @Valid RoleUpdateBO roleBO, Context ctx) {
        return roleService.updateRole(ctx.getOrgId(), roleBO);
    }

    /**
     * 删除角色
     *
     * @param role 角色id
     * @param ctx  上下文
     * @return 无
     */
    @DeleteMapping("/roles")
    public R<Void> deleteRole(RoleDeleteBO role, Context ctx) {
        roleService.deleteRole(ctx.getOrgId(), role.getId());
        return R.SUCCESS;
    }

    /**
     * 查询机构的权限
     *
     * @return 机构权限列表
     */
    @GetMapping("/roles/permissions")
    public R<List<PermissionVO>> listPermissions() {
        var r = roleService.listPermissions();
        return R.success(r);
    }

    /**
     * 设置角色的权限
     *
     * @param permission 角色对应的权限
     * @param ctx        上下文
     */
    @PostMapping("/roles/permissions")
    public R<Void> setRolePermissions(@Valid @RequestBody RolePermissionBO permission, Context ctx) {
        roleService.setRolePermissions(ctx.getOrgId(), permission.getRoleId(), permission.getPermissions());
        return R.SUCCESS;
    }
}
