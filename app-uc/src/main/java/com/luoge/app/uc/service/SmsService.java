package com.luoge.app.uc.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.cloud.apigateway.sdk.utils.Client;
import com.cloud.apigateway.sdk.utils.Request;
import com.luoge.app.uc.model.SmsPurpose;
import com.luoge.bos.data.configuration.AppConfiguration;
import com.luoge.bos.uc.core.UCCode;
import com.luoge.ns.core.Code;
import com.luoge.ns.core.R;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLContext;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

@Service
public class SmsService {

    private static final Logger logger = LoggerFactory.getLogger(SmsService.class);

    @Resource
    private AppConfiguration appConfiguration;

    HttpClient client;

    @PostConstruct
    public void init() {
        try {
            client = createIgnoreSSLHttpClient();
        } catch (Exception e) {
            logger.error("init client error", e);
        }
    }


    public R<Void> sendSms(SmsPurpose purpose, String receiver,
                           List<String> params) {
        String sender = purpose.channelNo;
        String templateId = purpose.templateId;
        String templateParas = JSON.toJSONString(params);

        String body = buildRequestBody(sender, receiver, templateId, templateParas);
        if (StringUtils.isBlank(body)) {
            logger.warn("body is null.");
            return R.fail(Code.ILLEGAL_PARAMETER);
        }

        Request request = new Request();
        AppConfiguration.SmsConfig smsConfig = appConfiguration.getSmsConfig();
        request.setKey(smsConfig.getAppKey());
        request.setSecret(smsConfig.getSecret());
        request.setMethod("POST");
        request.addHeader("Content-Type", "application/x-www-form-urlencoded");
        request.setBody(body);

        try {
            request.setUrl(smsConfig.getEndpoint() + "/sms/batchSendSms/v1");

            HttpRequestBase signedRequest = Client.sign(request);
            if (logger.isDebugEnabled()) {
                logger.debug("request: {}", body);
            }
            HttpResponse response = client.execute(signedRequest);
            HttpEntity resEntity = response.getEntity();
            if (Objects.nonNull(resEntity)) {
                String resBody = EntityUtils.toString(resEntity, StandardCharsets.UTF_8);
                logger.debug("res body: {}", resBody);
                Result<List<SendMsgResult>> result = JSON.parseObject(resBody, new TypeReference<>() {
                });
                if (result.ok()) {
                    return R.SUCCESS;
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return R.fail(UCCode.SMS_SEND_FAILED);
    }


    public static CloseableHttpClient createIgnoreSSLHttpClient() throws Exception {
        SSLContext sslContext = new SSLContextBuilder()
                .loadTrustMaterial(null, (x509CertChain, authType) -> true).
                build();
        return HttpClients
                .custom()
                .setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE))
                .build();
    }

    static String buildRequestBody(String sender, String receiver, String templateId, String templateParas) {
        if (StringUtils.isBlank(sender) || StringUtils.isBlank(receiver) || StringUtils.isBlank(templateId)) {
            logger.debug("buildRequestBody(): sender, receiver or templateId is null.");
            return null;
        }

        StringBuilder body = new StringBuilder();
        appendToBody(body, "from=", sender);
        appendToBody(body, "&to=", receiver);
        appendToBody(body, "&templateId=", templateId);
        appendToBody(body, "&templateParas=", templateParas);
        return body.toString();
    }

    private static void appendToBody(StringBuilder body, String key, String val) {
        if (StringUtils.isNotBlank(val)) {
            body.append(key).append(URLEncoder.encode(val, StandardCharsets.UTF_8));
        }
    }

}
