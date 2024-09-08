package com.luoge.bos.data.model;

import java.util.Map;

public class SendSmsBO {
    /**
     * 收件人
     */
    private String receiver;
    /**
     * 标题
     */
    String subject;
    /**
     * 正文
     */
    String content;
    /**
     * 模板内参数
     */
    private Map<String, String> params;


    public String getReceiver() {
        return receiver;
    }

    public SendSmsBO setReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public SendSmsBO setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getContent() {
        return content;
    }

    public SendSmsBO setContent(String content) {
        this.content = content;
        return this;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public SendSmsBO setParams(Map<String, String> params) {
        this.params = params;
        return this;
    }
}
