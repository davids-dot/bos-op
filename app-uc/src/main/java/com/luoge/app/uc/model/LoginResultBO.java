package com.luoge.app.uc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public class LoginResultBO {

    @JsonIgnore
    private int userId;

    private String token;

    private LocalDateTime expireTime;


    public int getUserId() {
        return userId;
    }

    public LoginResultBO setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getToken() {
        return token;
    }

    public LoginResultBO setToken(String token) {
        this.token = token;
        return this;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public LoginResultBO setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
        return this;
    }
}
