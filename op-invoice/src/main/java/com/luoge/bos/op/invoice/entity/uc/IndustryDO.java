package com.luoge.bos.op.invoice.entity.uc;

public class IndustryDO {
    private String code;
    private String name;
    private String remark;

    public String getCode() {
        return code;
    }

    public IndustryDO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public IndustryDO setName(String name) {
        this.name = name;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public IndustryDO setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
