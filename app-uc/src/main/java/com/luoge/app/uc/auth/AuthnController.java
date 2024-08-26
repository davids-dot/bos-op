package com.luoge.app.uc.auth;

import com.luoge.app.uc.model.SendVerifyCodeBO;
import com.luoge.bos.core.BosAppCode;
import com.luoge.bos.core.utils.ValidateUtil;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * uc/用户认证
 */
@Validated
@RestController
@RequestMapping("/uc/public")
public class AuthnController {

    @Resource
    private AuthnService authnService;

    @Resource
    private CacheService cacheService;


    /**
     * 发送验证码
     */
    @GetMapping("/auth/verify-code")
    public R<Void> sendVerifyCode(@Valid SendVerifyCodeBO sendVerifyCodeBO) {
        if (!ValidateUtil.isMobile(sendVerifyCodeBO.getMobile())) {
            return R.fail(BosAppCode.WRONG_PHONE_NUMBER);
        }

        return authnService.sendVerifyCode(sendVerifyCodeBO.getMobile(),
                sendVerifyCodeBO.getType(),
                sendVerifyCodeBO.getCheck());
    }


}