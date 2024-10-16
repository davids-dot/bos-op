package com.luoge.app.uc.auth;

import com.alibaba.fastjson2.JSON;
import com.luoge.app.uc.model.*;
import com.luoge.app.uc.service.UcEnterpriseService;
import com.luoge.app.uc.service.UserService;
import com.luoge.bos.data.model.EnterpriseBO;
import com.luoge.bos.uc.ctx.Context;
import com.luoge.ns.core.R;
import com.luoge.ns.uc.core.UCCode;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * uc/用户认证授权
 */
@RestController
@RequestMapping("uc/auth")
public class AuthzController {
    private static final Logger log = LoggerFactory.getLogger(AuthzController.class);
    //    @Resource
//    private AuthzService authzService;
//
//    @Resource
//    private EnterpriseService enterpriseService;
    @Resource
    private UserService userService;

    @Resource
    private CacheService cacheService;

    @Resource
    private UcEnterpriseService ucEnterpriseService;

//    /**
//     * 获取用户菜单
//     */
//    @GetMapping("/users/menus")
//    public R<List<RouteBO>> listMenus(@RequestParam(required = false, value = "appId", defaultValue = "1") int appId, Context ctx) {
//        User user = cacheService.getUser(ctx.getUserId());
//        var menus = authzService.getRoutes(appId, user.getPermissions());
//        return R.success(menus);
//    }
//

    /**
     * 获取登录用户
     */
    @GetMapping("/users/current")
    public R<User> getCurrent(Context ctx) {
        User user = cacheService.getUser(ctx.getUserId());
        log.debug("get current user:{} {}", ctx.getUserId(), JSON.toJSONString(user));
        return R.success(user);
    }

    /**
     * 修改当前登录用户
     *
     * @param user 用户信息
     */
    @PutMapping("users/current")
    public R<Void> updateCurrent(@RequestBody @Valid UserUpdateBO user, Context ctx) {
        user.setId(ctx.getUserId());
        return R.toVoid(userService.update(ctx.getOrgId(), user));
    }

//    /**
//     * 当前用户修改密码
//     */
//    @PutMapping("users/passwd")
//    public R<Void> changePasswd(@RequestBody @Valid ChangePasswordBO reset, Context ctx) {
//        if (!UCValidator.validatePassword(reset.getNewPassword())
//                || !UCValidator.validatePassword(reset.getOldPassword())) {
//            return R.fail(UCCode.PASSWORD_FORMAT_ERROR);
//        }
//        return userService.changePasswd(ctx.getOrgId(), ctx.getUserId(), reset.getOldPassword(), reset.getNewPassword());
//    }

    /**
     * 获取用户可选择的企业列表
     */
    @GetMapping("/enterprises")
    public R<List<EnterpriseSelectBO>> listUserEnterprises(Context ctx, String name) {
        var r = ucEnterpriseService.listUserEnterprises(ctx.getOrgId(), ctx.getUserId(), name);
        return R.success(r);
    }

//
//    /**
//     * 获取企业列表(没有用户绑定关系也可查询出)
//     */
//    @GetMapping("/enterprise")
//    public R<Page<EnterpriseBO>> listEnterprises(ListEnterpriseBO query, Context ctx) {
//        return R.success(enterpriseService.listEnterprises(ctx.getOrgId(), query));
//    }
//
//

    /**
     * 获取当前用户选择企业的详情
     */
    @GetMapping("/enterprises/current")
    public R<EnterpriseBO> getCurrentEnterprises(Context ctx, @RequestParam("id") Integer enterpriseId) {
        var r = ucEnterpriseService.getSelectedEnterprise(ctx.getOrgId(), ctx.getUserId(), enterpriseId);
        if (r == null) {
            return R.fail(UCCode.ENTERPRISE_NOT_EXIST);
        }
        return R.success(r);
    }

    /**
     * 更新当前用户选择企业的详情
     */
    @PutMapping("/enterprises/current")
    public R<Void> updateCurrentEnterprises(Context ctx, @Valid @RequestBody SaveEnterpriseBO enterprise) {
        var r = ucEnterpriseService.updateEnterprise(ctx.getOrgId(), enterprise);
        return R.toVoid(r);
    }
}
