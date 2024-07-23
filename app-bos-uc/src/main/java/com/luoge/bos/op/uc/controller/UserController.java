package com.luoge.bos.op.uc.controller;

import com.luoge.bos.op.uc.model.user.*;
import com.luoge.bos.op.uc.service.UserService;
import com.luoge.bos.uc.core.UCCode;
import com.luoge.bos.op.uc.core.UCValidator;
import com.luoge.bos.uc.ctx.Context;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户管理
 */
@RestController
@RequestMapping("bos-uc/setting")
public class UserController {

    @Resource
    private UserService userService;


    /**
     * 查询用户
     *
     * @param name 用户姓名
     * @param ctx  上下文
     * @return 返回码
     */
    @GetMapping("users")
    public R<List<UserVO>> listUsers(String name, Context ctx) {
        return R.success(userService.listUser(ctx.getOrgId(), name));
    }

    /**
     * 新增用户
     *
     * @param user 用户
     */
    @PostMapping("users")
    public R<Void> insert(@RequestBody @Valid UserCreateBO user, Context ctx) {
        if (!UCValidator.validatePassword(user.getPasswd())) {
            return R.fail(UCCode.PASSWORD_FORMAT_ERROR);
        }
        return userService.insert(ctx.getOrgId(), user);
    }

    /**
     * 修改用户
     *
     * @param user 用户信息
     */
    @PutMapping("users")
    public R<Void> update(@RequestBody @Valid UserUpdateBO user, Context ctx) {
        return userService.update(ctx.getOrgId(), user);
    }


    /**
     * 重置密码
     *
     * @param reset 密码
     * @param ctx   上下文
     * @return 无
     */
    @PutMapping("users/passwd")
    public R<Void> resetPasswd(@RequestBody @Valid UserPasswdBO reset, Context ctx) {
        if (!UCValidator.validatePassword(reset.getPasswd())) {
            return R.fail(UCCode.PASSWORD_FORMAT_ERROR);
        }
        userService.resetPasswd(ctx.getOrgId(), reset.getUserId(), reset.getPasswd());
        return R.SUCCESS;
    }

    @PutMapping("users/status")
    public R<Void> updateStatus(@RequestBody @Valid UserStatusBO userStatusBO, Context ctx) {
        userService.updateStatus(ctx.getOrgId(), userStatusBO.getUserId(), userStatusBO.getStatus());
        return R.SUCCESS;
    }

    /**
     * 查询用户角色
     *
     * @param userId 用户id
     * @param ctx    上下文
     * @return 用户角色列表
     */
    @GetMapping("users/roles")
    public R<List<String>> listUserRoles(Integer userId, Context ctx) {
        var r = userService.listUserRoles(ctx.getOrgId(), userId);
        return R.success(r.stream().map(String::valueOf).collect(Collectors.toList()));
    }

    /**
     * 设置用户角色
     *
     * @param userRoleBO 用户角色对象
     * @param ctx        上下文
     * @return 无
     */
    @PutMapping("users/roles")
    public R<Void> setUserRoles(@RequestBody @Valid UserRoleBO userRoleBO, Context ctx) {
        userService.setUserRoles(ctx.getOrgId(), userRoleBO.getUserId(), userRoleBO.getRoleIds());
        return R.SUCCESS;
    }
}
