package com.luoge.bos.op.uc.model.permission;

import java.util.List;

public class PermissionBO {
    private String code;

    private String name;

    private List<PermissionBO> children;

    private int level;

    private int seq;

    public PermissionBO(String code, String name, int level, int seq) {
        this.code = code;
        this.name = name;
        this.level = level;
        this.seq = seq;
    }

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

    public List<PermissionBO> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionBO> children) {
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
}
