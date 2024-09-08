package com.luoge.app.uc.service;

public class Result<T> {

    private String code;
    private String description;
    private T result;

    private static final String SUCCESS_CODE = "000000";

    public String getCode() {
        return code;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Result<T> setDescription(String description) {
        this.description = description;
        return this;
    }

    public T getResult() {
        return result;
    }

    public Result<T> setResult(T result) {
        this.result = result;
        return this;
    }

    public boolean ok() {
        return SUCCESS_CODE.equals(code);
    }

    public boolean failed() {
        return !SUCCESS_CODE.equals(code);
    }

}
