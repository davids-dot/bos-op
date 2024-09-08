package com.luoge.app.uc.model;

import com.luoge.ns.account.model.PageQuery;

public class ListEnterpriseBO extends PageQuery {
    /**
     * 企业名称
     */
    private String name;
    /**
     * 企业id
     */
    private Integer enterpriseId;

    public String getName() {
        return name;
    }

    public ListEnterpriseBO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public ListEnterpriseBO setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    @Override
    public String toString() {
        return "ListEnterpriseBO{" +
                "name='" + name + '\'' +
                "enterpriseId='" + enterpriseId + '\'' +
                '}' + super.toString();
    }

}
