package com.luoge.bos.gateway.filter;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.AntPathMatcher;

import java.util.Set;

public class Urls {

    private static final AntPathMatcher pathMatcher = new AntPathMatcher();
    private static final Set<String> EXCLUDE_URLS = Set.of("/bos-uc/common/**", "/uc/public/**");
    private static final Set<String> NOT_AUTHENTICATION_URLS = Set.of("/bos-uc/auth/**", "/mobile/invoice/**");


    public static boolean isExcludeUrl(String path) {
        if (CollectionUtils.isEmpty(EXCLUDE_URLS)) {
            return false;
        }
        for (var pattern : EXCLUDE_URLS) {
            if (pathMatcher.match(pattern, path)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotAuthenticationUrl(String path) {
        if (CollectionUtils.isEmpty(EXCLUDE_URLS)) {
            return false;
        }
        for (var pattern : NOT_AUTHENTICATION_URLS) {
            if (pathMatcher.match(pattern, path)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMobile(String path) {
        return StringUtils.isNotBlank(path) && path.startsWith("/mobile");
    }
}
