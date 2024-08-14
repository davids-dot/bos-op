package com.luoge.bos.uc.controller;

import com.luoge.bos.uc.model.AuthenticationBO;
import com.luoge.bos.uc.service.UserService;
import com.luoge.bos.uc.ctx.Context;
import com.luoge.bos.uc.service.AuthenticationService;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * uc/用户认证
 */
@Validated
@RestController
@RequestMapping("bos-uc/common")
public class AuthenticationController {

    @Resource
    private AuthenticationService authenticationService;
    @Resource
    private UserService userService;

    /**
     * 登录
     */
    @PostMapping("sign-in")
    public R<String> signIn(@RequestBody AuthenticationBO user) {
        return authenticationService.signIn(user);
    }

    /**
     * 退出登录
     */
    @PostMapping("sign-out")
    public void signOut(Context ctx) {
        authenticationService.signOut(ctx.getUserId());
    }
}
