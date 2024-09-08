package com.luoge.app.uc.service;

public class SendMsgResult {
    private Integer total;
    private String from;
    private String originTo;
    private String smsMsgId;
    private String countryId;
    private String status;
    private String createTime;

    public Integer getTotal() {
        return total;
    }

    public SendMsgResult setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public SendMsgResult setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getOriginTo() {
        return originTo;
    }

    public SendMsgResult setOriginTo(String originTo) {
        this.originTo = originTo;
        return this;
    }

    public String getSmsMsgId() {
        return smsMsgId;
    }

    public SendMsgResult setSmsMsgId(String smsMsgId) {
        this.smsMsgId = smsMsgId;
        return this;
    }

    public String getCountryId() {
        return countryId;
    }

    public SendMsgResult setCountryId(String countryId) {
        this.countryId = countryId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public SendMsgResult setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public SendMsgResult setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }
}
