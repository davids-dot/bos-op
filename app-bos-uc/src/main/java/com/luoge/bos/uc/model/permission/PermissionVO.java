package com.luoge.bos.uc.model.permission;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class PermissionVO {
    private String code;

    private String name;

    private List<PermissionVO> children;

    @JsonIgnore
    private int level;

    @JsonIgnore
    private int seq;

    private String remark;

//    public PermissionVO(String code, String name, int level, int seq, String remark) {
//        this.code = code;
//        this.name = name;
//        this.level = level;
//        this.seq = seq;
//        this.remark = remark;
//    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PermissionVO> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionVO> children) {
        this.children = children;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
