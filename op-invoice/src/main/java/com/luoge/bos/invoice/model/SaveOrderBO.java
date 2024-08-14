package com.luoge.bos.invoice.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class SaveOrderBO {
    /**
     * 机构id
     */
    @NotNull
    private Integer orgId;
    /**
     * 机构名称
     */
    @NotEmpty
    private String orgName;
    /**
     * 订单商品明细
     */
    @NotEmpty @Valid
    private List<SaveOrderItemBO> items;

    public Integer getOrgId() {
        return orgId;
    }

    public SaveOrderBO setOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public SaveOrderBO setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public List<SaveOrderItemBO> getItems() {
        return items;
    }

    public SaveOrderBO setItems(List<SaveOrderItemBO> items) {
        this.items = items;
        return this;
    }
}
