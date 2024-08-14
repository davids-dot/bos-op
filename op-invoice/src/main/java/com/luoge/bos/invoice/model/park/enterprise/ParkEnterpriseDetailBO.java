package com.luoge.bos.invoice.model.park.enterprise;

import com.luoge.bos.invoice.model.org.EnterpriseDetailBO;

public class ParkEnterpriseDetailBO {
    EnterpriseDetailBO enterprise;
    ParkEnterpriseFeeBO feeSetting;

    public EnterpriseDetailBO getEnterprise() {
        return enterprise;
    }

    public ParkEnterpriseDetailBO setEnterprise(EnterpriseDetailBO enterprise) {
        this.enterprise = enterprise;
        return this;
    }

    public ParkEnterpriseFeeBO getFeeSetting() {
        return feeSetting;
    }

    public ParkEnterpriseDetailBO setFeeSetting(ParkEnterpriseFeeBO feeSetting) {
        this.feeSetting = feeSetting;
        return this;
    }
}
