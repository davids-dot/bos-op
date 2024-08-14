package com.luoge.bos.invoice.model.park.enterprise;

import java.util.List;

public class AddParkEnterpriseBO {
    /**
     * 企业id 列表
     */
    private List<Integer> enterpriseIds;


    public List<Integer> getEnterpriseIds() {
        return enterpriseIds;
    }

    public AddParkEnterpriseBO setEnterpriseIds(List<Integer> enterpriseIds) {
        this.enterpriseIds = enterpriseIds;
        return this;
    }
}
