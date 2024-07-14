package com.luoge.bos.op.invoice.model.org;

import java.util.List;

public class IndustryBO {
    private String value;
    private String label;
    private boolean selectable = true;
    private List<IndustryBO> children;

    public String getValue() {
        return value;
    }

    public IndustryBO setValue(String value) {
        this.value = value;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public IndustryBO setLabel(String label) {
        this.label = label;
        return this;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public IndustryBO setSelectable(boolean selectable) {
        this.selectable = selectable;
        return this;
    }

    public List<IndustryBO> getChildren() {
        return children;
    }

    public IndustryBO setChildren(List<IndustryBO> children) {
        this.children = children;
        return this;
    }
}
