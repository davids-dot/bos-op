package com.luoge.bos.op.invoice.entity.uc;

import java.time.LocalDateTime;

public class OrgDO {
    private Integer id;

    private String name;

    private String logo;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public OrgDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrgDO setName(String name) {
        this.name = name;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public OrgDO setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public OrgDO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public OrgDO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public OrgDO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}