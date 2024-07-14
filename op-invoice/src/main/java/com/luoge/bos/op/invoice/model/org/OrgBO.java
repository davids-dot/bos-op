package com.luoge.bos.op.invoice.model.org;

public class OrgBO {
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String remark;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 机构下企业数量
     */
    private Integer enterpriseCount;

    public Integer getId() {
        return id;
    }

    public OrgBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrgBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public OrgBO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public OrgBO setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getEnterpriseCount() {
        return enterpriseCount;
    }

    public OrgBO setEnterpriseCount(Integer enterpriseCount) {
        this.enterpriseCount = enterpriseCount;
        return this;
    }
}
