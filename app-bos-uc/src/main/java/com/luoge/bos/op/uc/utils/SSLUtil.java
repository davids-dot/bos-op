package com.luoge.bos.op.uc.utils;

import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

public class SSLUtil {

    private SSLUtil() {
    }

    public static X509TrustManager getAllTrustX509TrustManager() {
        return new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            @Override
            public void checkClientTrusted(
                    X509Certificate[] certs, String authType) {
            }

            @Override
            public void checkServerTrusted(
                    X509Certificate[] certs, String authType) {
            }
        };
    }
}
