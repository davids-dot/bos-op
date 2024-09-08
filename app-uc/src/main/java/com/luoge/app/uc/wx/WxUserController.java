package com.luoge.app.uc.wx;

import com.luoge.app.uc.configuration.WxConfiguration;
import com.luoge.app.uc.model.LoginByCodeBO;
import com.luoge.app.uc.model.LoginByMobileAndCodeBO;
import com.luoge.app.uc.model.LoginResultBO;
import com.luoge.app.uc.wxctx.WxContext;
import com.luoge.bos.uc.core.UCCode;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * uc/微信用户
 */
@RestController
@RequestMapping("/uc/public/auth/wx/")
public class WxUserController {

    @Resource
    private WxConfiguration wxConfiguration;
    @Resource
    private WxUserService wxUserService;

    /**
     * 使用code登录
     */
    @PostMapping("/sign-in/code")
    public R<LoginResultBO> loginByCode(@Valid @RequestBody LoginByCodeBO loginByCodeBO) {
        return wxUserService.loginMiniApp(loginByCodeBO, wxConfiguration.getAppId());
    }

    /**
     * 使用手机号、验证码和code登录
     */
    @PostMapping("/sign-in/mobile-and-code")
    public R<LoginResultBO> loginByMobileAndCode(@Valid @RequestBody LoginByMobileAndCodeBO loginBO, WxContext ctx) {
        if (loginBO.getCode().contains("mock one")) {
            return R.fail(UCCode.WX_MOCK_USER);
        }
        return wxUserService.loginAndBindMiniAppByPhone(loginBO, ctx.getAppId());
    }


    // TODO user and code


}
