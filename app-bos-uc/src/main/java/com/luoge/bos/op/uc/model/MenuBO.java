package com.luoge.bos.op.uc.model;

import java.util.List;
import java.util.Objects;

public class MenuBO {
    private String key;

    private String label;

    private String url;

    private String parent;

    private int seq;

    private List<MenuBO> children;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        return obj instanceof MenuBO vo && Objects.equals(this.key, vo.getKey());
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.key);
    }

    public MenuBO(String key, String label, String url, String parent, int seq) {
        this.key = key;
        this.label = label;
        this.url = url;
        this.parent = parent;
        this.seq = seq;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public List<MenuBO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuBO> children) {
        this.children = children;
    }
}
