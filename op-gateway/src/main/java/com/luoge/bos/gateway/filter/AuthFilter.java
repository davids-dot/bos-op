package com.luoge.bos.gateway.filter;

import cn.hutool.core.text.AntPathMatcher;
import com.luoge.bos.common.HttpUtil;
import com.luoge.bos.common.JsonUtil;
import com.luoge.bos.uc.core.HashIds;
import com.luoge.bos.uc.dubbo.UCService;
import com.luoge.ns.core.Code;
import com.luoge.ns.core.Constants;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class AuthFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(AuthFilter.class);
    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    @Resource
    private UCService ucService;

    private Map<String, List<String>> resourceMappers;

    public AuthFilter() {
        LOG.debug("auth filter init aaa");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            doBusinessFilter(request, response, chain);
        } catch (Exception e) {
            LOG.error("do filter error", e);
        }
    }

    private void doBusinessFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        // 获取机构ID和用户ID
        Integer orgId = null, userId = null;
        String token = req.getHeader(Constants.NS_TOKEN);
        if (Objects.isNull(token)) {
            token = req.getParameter(Constants.NS_TOKEN);
        }
        if (Objects.nonNull(token)) {
            var ns = HashIds.decode(token);
            if (Objects.nonNull(ns)) {
                orgId = ns[0];
                userId = ns[1];
            }
        }

        String path = req.getRequestURI();
        if (Urls.isExcludeUrl(path)) {
            if (Objects.nonNull(orgId)) {
                HttpServletRequest wrappedRequest = setAuthenticationInfo(orgId, userId, req);
                chain.doFilter(wrappedRequest, response);
                return;
            }
            chain.doFilter(request, response);
            return;
        }
        if (Objects.isNull(userId)) {
            renderFail(Code.UNAUTHORIZED, "用户没有登录", response);
            return;
        }

        var user = ucService.getUser(userId);
        if (user == null) {
            renderFail(Code.UNAUTHORIZED, "用户没有登录", response);
            return;
        }

        if (!Urls.isNotAuthenticationUrl(path) && !hasPermission(path, user.getPermissions())) {
            renderFail(Code.FORBIDDEN, "用户没有权限", response);
            return;
        }
        HttpServletRequest wrappedRequest = setAuthenticationInfo(orgId, userId, req);
        chain.doFilter(wrappedRequest, response);
    }

    private HttpServletRequest setAuthenticationInfo(Integer orgId, Integer userId, HttpServletRequest req) {
        // 创建HttpServletRequestWrapper，用于包装原始请求
        return new HttpServletRequestWrapper(req) {
            @Override
            public String getHeader(String name) {
                if (Constants.NS_ORG_ID.equalsIgnoreCase(name)) {
                    return String.valueOf(orgId);
                } else if (Constants.NS_USER_ID.equalsIgnoreCase(name)) {
                    return String.valueOf(userId);
                } else {
                    return super.getHeader(name);
                }
            }
        };
    }

    private void renderFail(int code, String message, ServletResponse response) {
        String content = JsonUtil.toJsonString(R.fail(code, message));
        int httpStatusCode = switch (code) {
            case Code.UNAUTHORIZED, Code.FORBIDDEN, Code.NOT_FOUNT, Code.SYSTEM_ERROR -> code;
            default -> Code.SUCCESS;
        };
        HttpUtil.writeRes((HttpServletResponse) response, httpStatusCode, content);
    }

    private boolean hasPermission(String path, List<String> permissions) {
        var mappers = getResourceMappers();
        permissions.retainAll(mappers.keySet());
        for (var permission : permissions) {
            var urls = mappers.get(permission);
            for (var url : urls) {
                if (pathMatcher.match(url, path)) {
                    return true;
                }
            }
        }

        return false;
    }

    private Map<String, List<String>> getResourceMappers() {
        if (Objects.isNull(resourceMappers)) {
            resourceMappers = ucService.getResourceMappers();
        }
        return resourceMappers;
    }


}
