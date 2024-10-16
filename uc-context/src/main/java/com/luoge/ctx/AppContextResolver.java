package com.luoge.ctx;

import com.luoge.ns.core.Constants;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class AppContextResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType() != null && methodParameter.getParameterType().equals(Context.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        var request = webRequest.getNativeRequest(HttpServletRequest.class);
        String orgId = request.getHeader(Constants.NS_ORG_ID);
        String userId = request.getHeader(Constants.NS_USER_ID);
        String enterpriseId = request.getHeader(Constants.NS_ENTERPRISE_ID);

        int iOrgId = StringUtils.isBlank(orgId) ? Constants.ZERO : Integer.parseInt(orgId);
        int iUserId = StringUtils.isBlank(userId) ? Constants.ZERO : Integer.parseInt(userId);
        int iEnterpriseId = StringUtils.isBlank(enterpriseId) ? Constants.ZERO : Integer.parseInt(enterpriseId);
        return new Context()
                .setOrgId(iOrgId)
                .setEnterpriseId(iEnterpriseId)
                .setUserId(iUserId);
    }

}