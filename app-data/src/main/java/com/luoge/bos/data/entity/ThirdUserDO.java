package com.luoge.bos.data.entity;

import java.time.LocalDateTime;

public class ThirdUserDO {
    private Long id;

    private Integer type;

    private String appId;

    private String openId;

    private String unionId;

    private Long userId;

    private Integer status;

    private String remark;

    private Object ext;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public ThirdUserDO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public ThirdUserDO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public ThirdUserDO setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getOpenId() {
        return openId;
    }

    public ThirdUserDO setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public String getUnionId() {
        return unionId;
    }

    public ThirdUserDO setUnionId(String unionId) {
        this.unionId = unionId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public ThirdUserDO setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ThirdUserDO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public ThirdUserDO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Object getExt() {
        return ext;
    }

    public ThirdUserDO setExt(Object ext) {
        this.ext = ext;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ThirdUserDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public ThirdUserDO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}