package com.luoge.bos.uc.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpKit {
    private static final Logger log = LoggerFactory.getLogger(HttpKit.class);
    /**
     * 忽略局端ssl 证书验证，如果有解决方法，可删除httpClient 的sslContext 配置
     */
    private static TrustManager[] trustAllCerts = new TrustManager[]{
          SSLUtil.getAllTrustX509TrustManager()
    };
    private static SSLContext sslContext;
    static {
        try {
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new SecureRandom());
        } catch (Exception e) {
            log.error("sslContext error", e);
        }
    }

    private final static HttpClient httpClient = HttpClient.newBuilder().sslContext(sslContext).build();

    public enum MediaType {
        JSON,
        Form,
        FormData
    }
    public static <T> T postForm(String url, Map<String, Object> data, Map<String, String> header, Class<T> resClass) {
        return (T) post(url, MediaType.Form, data, header, TypeReference.get(resClass));
    }

    public static <T> T postForm(String url, Map<String, Object> data, Map<String, String> header, TypeReference<T> reference) {
        return post(url, MediaType.Form, data, header, reference);
    }

    public static <T> T postFormData(String url, Map<String, Object> data, Map<String, String> header, TypeReference<T> reference) {
        return post(url, MediaType.FormData, data, header, reference);
    }

    public static String post(String url, Map<String, Object> data) {
        return post(url, MediaType.JSON, data, null, new TypeReference<String>() {
        });
    }

    public static <T> T post(String url, Map<String, Object> data, Map<String, String> header, TypeReference<T> typeReference) {
        return post(url, MediaType.JSON, data, header, typeReference);
    }

    private static <T> T post(String url, MediaType type, Map<String, Object> data, Map<String, String> header, TypeReference<T> typeReference) {
        log.debug("post[{}] request:{} {}", type, url, data);
        try {
            // Create the POST request
            HttpRequest.Builder reqBuilder = HttpRequest.newBuilder().uri(new URI(url));
            // Add header
            if (header != null && !header.isEmpty()) {
                header.forEach(reqBuilder::header);
            }

            // Create a MultipartBody with the data
            switch (type) {
                case JSON ->
                        reqBuilder.header("Content-Type", "application/json;charset=utf-8").POST(HttpRequest.BodyPublishers.ofString(JSON.toJSONString(data)));
                case Form ->
                        reqBuilder.header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8").POST(HttpRequest.BodyPublishers.ofString(getFormDataAsString(data)));
                case FormData ->
                        reqBuilder.header("Content-Type", "multipart/form-data; boundary=-----------------BOUNDARY123456").POST(HttpRequest.BodyPublishers.ofByteArray(getFormDataAsByte(data)));
            }

            HttpRequest request = reqBuilder.build();
            // Send the request and print the response
            CompletableFuture<HttpResponse<String>> responseFuture =
                    httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

            HttpResponse<String> response = responseFuture.get();
            if (response.statusCode() != 200) {
                log.error("post by form request fail, status:{}", response.statusCode());
            }
            log.debug("post[{}] result:{} {}", type, response.statusCode(), response.body());
            return JSON.parseObject(response.body(), typeReference);
        } catch (Exception e) {
            log.error("post by form request error:", e);
            return null;
        }
    }

    public static String get(String url) {

        return get(url, null, String.class);
    }

    public static <T> T get(String url, Class<T> resClass) {
        return get(url, null, null, resClass);
    }

    public static String get(String url, Map<String, Object> data, Map<String, String> header) {
        return get(url, data, header, String.class);
    }

    public static <T> T get(String url, Map<String, Object> data, Class<T> resClass) {
        return get(url, data, null, resClass);
    }

    private static <T> T get(String url, Map<String, Object> data, Map<String, String> header, Class<T> resClass) {
        try {

            // Create the POST request
            HttpRequest.Builder reqBuilder = HttpRequest.newBuilder();
            if (data != null && !data.isEmpty()) {
                reqBuilder.uri(new URI(url + "?" + getFormDataAsString(data)));
            } else {
                reqBuilder.uri(new URI(url));
            }

            // Add header
            if (header != null && !header.isEmpty()) {
                header.forEach(reqBuilder::header);
            }

            return sendAsync(reqBuilder.build(), resClass);
        } catch (Exception e) {
            log.error("get by form request error:", e);
            return null;
        }
    }

    private static <T> T upload(String url, byte[] data, Map<String, String> header, Class<T> resClass) {
        try {
            // Create the POST request
            HttpRequest.Builder reqBuilder = HttpRequest.newBuilder().uri(new URI(url));
            // Add header
            if (header != null && !header.isEmpty()) {
                header.forEach(reqBuilder::header);
            }
            reqBuilder.POST(HttpRequest.BodyPublishers.ofByteArray(data));
            return sendAsync(reqBuilder.build(), resClass);
        } catch (Exception e) {
            log.error("upload request error:", e);
            return null;
        }
    }

    public static byte[] download(String url, Map<String, String> header) {
        try {
            // Create the POST request
            HttpRequest.Builder reqBuilder = HttpRequest.newBuilder().uri(new URI(url)).GET();
            // Add header
            if (header != null && !header.isEmpty()) {
                header.forEach(reqBuilder::header);
            }
            HttpResponse<byte[]> response = httpClient.sendAsync(reqBuilder.build(), HttpResponse.BodyHandlers.ofByteArray()).get();
            if (response.statusCode() != 200) {
                log.error("get by form request fail, status:{}", response.statusCode());
                return null;
            }
            return response.body();
        } catch (Exception e) {
            log.error("download request error:", e);
            return null;
        }
    }


    private static <T> T sendAsync(HttpRequest request, Class<T> resClass) throws ExecutionException, InterruptedException {
        log.debug("get request:{} {}", request.uri(), request.bodyPublisher().toString());
        HttpResponse<String> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)).get();
        if (response.statusCode() != 200) {
            log.error("sendAsync request fail, status:{}", response.statusCode());
            return null;
        }

        log.debug("get result:{} {}", response.statusCode(), response.body());
        return resClass != null ? JSON.parseObject(response.body(), resClass) : JSON.parseObject(response.body(), new TypeReference<>() {
        });
    }

    public static String getFormDataAsString(Map<String, Object> formData) {
        StringBuilder formBodyBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : formData.entrySet()) {
            if (!formBodyBuilder.isEmpty()) {
                formBodyBuilder.append("&");
            }
            if (entry.getValue() instanceof List<?> list) {
                formBodyBuilder.append(getFormDataAsString(entry.getKey(), list));
                continue;
            }
            formBodyBuilder.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            formBodyBuilder.append("=");
            formBodyBuilder.append(URLEncoder.encode(Objects.requireNonNullElse(entry.getValue(), "").toString(), StandardCharsets.UTF_8));
        }
        return formBodyBuilder.toString();
    }

    public static String getFormDataAsString(String formKey, List<?> list) {
        StringBuilder formBodyBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (!formBodyBuilder.isEmpty()) {
                formBodyBuilder.append("&");
            }
            Object objectData = list.get(i);
            if (objectData instanceof Map<?, ?> entryData) {
                for (Map.Entry<?, ?> entry : entryData.entrySet()) {
                    formBodyBuilder.append(URLEncoder.encode(formKey + "[" + i + "][" + entry.getKey() + "]", StandardCharsets.UTF_8));
                    formBodyBuilder.append("=");
                    formBodyBuilder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
                    formBodyBuilder.append("&");
                }
            } else {
                formBodyBuilder.append(URLEncoder.encode(formKey + "[" + i + "]", StandardCharsets.UTF_8));
                formBodyBuilder.append("=");
                formBodyBuilder.append(URLEncoder.encode(objectData.toString(), StandardCharsets.UTF_8));
            }
        }
        return formBodyBuilder.toString();
    }

    public static byte[] getFormDataAsByte(Map<String, Object> formData) throws IOException {
        return new PostData(formData).formData();
    }

    @SuppressWarnings("unchecked")
    public record PostData<T>(T data) {
        private static final String BOUNDARY = "-----------------BOUNDARY123456";

        public byte[] formData() throws IOException {

            Map<String, Object> formData;
            assert data instanceof Map<?, ?>;
            formData = (Map<String, Object>) data;

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1024);
            StringBuilder strBuf = new StringBuilder();
            File file = null;
            String formFileName = null;
            for (Map.Entry<String, Object> entry : formData.entrySet()) {
                String inputName = entry.getKey();
                Object inputValue = entry.getValue();
                if (inputValue == null) {
                    continue;
                }
                if (inputValue instanceof File f) {
                    file = f;
                    formFileName = inputName;
                } else {
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"").append(inputName).append("\"\r\n\r\n");
                    strBuf.append(inputValue);
                }
            }
            outputStream.write(strBuf.toString().getBytes(StandardCharsets.UTF_8));
            strBuf.delete(0, strBuf.length());
            strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");

            if (file != null && formFileName != null) {
                String filename = file.getName();
                String contentType = Files.probeContentType(Paths.get(filename));
                strBuf.append("Content-Disposition: form-data; name=\"").append(formFileName).append("\"; filename=\"").append(filename).append("\"\r\n");
                strBuf.append("Content-Type:").append(contentType).append("\r\n\r\n");

                outputStream.write(strBuf.toString().getBytes(StandardCharsets.UTF_8));
                strBuf.delete(0, strBuf.length());
                DataInputStream in = new DataInputStream(new FileInputStream(file));

                int b;
                byte[] bufferOut = new byte[1024];
                while ((b = in.read(bufferOut)) != -1) {
                    outputStream.write(bufferOut, 0, b);
                }
                in.close();
            }

            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes(StandardCharsets.UTF_8);
            outputStream.write(endData);

            outputStream.close();
            return outputStream.toByteArray();
        }

        public byte[] formUrlencoded() {
            if (data instanceof String s)
                return s.getBytes(StandardCharsets.UTF_8);

            Map<String, String> formData;
            assert data instanceof Map<?, ?>;
            formData = (Map<String, String>) data;

            StringBuilder sb = new StringBuilder();
            Iterator<Map.Entry<String, String>> iterator = formData.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                sb.append(entry.getKey()).append("=").append(entry.getValue());
                if (iterator.hasNext())
                    sb.append("&");
            }
            return sb.toString().getBytes(StandardCharsets.UTF_8);
        }

        public byte[] json() {
            if (data instanceof String string)
                return string.getBytes();
            if (data instanceof byte[] bytes)
                return bytes;
            else
                throw new IllegalArgumentException("json数据需要换成字符串或者字节数组");
        }
    }
}
