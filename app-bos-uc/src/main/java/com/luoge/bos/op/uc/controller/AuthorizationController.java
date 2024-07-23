package com.luoge.bos.op.uc.controller;

import com.luoge.bos.op.uc.core.UCValidator;
import com.luoge.bos.op.uc.model.MenuBO;
import com.luoge.bos.op.uc.model.user.ChangePasswordBO;
import com.luoge.bos.op.uc.service.AuthenticationService;
import com.luoge.bos.op.uc.service.AuthorizationService;
import com.luoge.bos.op.uc.service.UserService;
import com.luoge.bos.uc.core.UCCode;
import com.luoge.bos.uc.ctx.Context;

import com.luoge.bos.uc.model.User;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * uc/用户授权
 */
@RestController
@RequestMapping("bos-uc/auth")
public class AuthorizationController {
    @Resource
    private AuthenticationService authenticationService;

    @Resource
    private AuthorizationService authorizationService;

    @Resource
    private UserService userService;

    /**
     * 获取用户菜单
     */
    @GetMapping("menus")
    public R<List<MenuBO>> listMenus(@RequestParam(required = false, value = "appId", defaultValue = "1") int appId, Context ctx) {
        User user = authenticationService.getUser(ctx.getUserId());
        var menus = authorizationService.getMenus(appId, user.getPermissions());
        return R.success(menus);
    }

    /**
     * 获取登录用户
     */
    @GetMapping("/users/current")
    public R<User> getCurrent(Context ctx) {
        return R.success(authenticationService.getUser(ctx.getUserId()));
    }

    /**
     * 用户修改密码
     */
    @PutMapping("users/passwd/change")
    public R<Void> changePasswd(@RequestBody @Valid ChangePasswordBO reset, Context ctx) {
        if (!UCValidator.validatePassword(reset.getNewPassword())
        || !UCValidator.validatePassword(reset.getOldPassword())) {
            return R.fail(UCCode.PASSWORD_FORMAT_ERROR);
        }
        return userService.changePasswd(ctx.getOrgId(), ctx.getUserId(), reset.getOldPassword(), reset.getNewPassword());
    }
}
