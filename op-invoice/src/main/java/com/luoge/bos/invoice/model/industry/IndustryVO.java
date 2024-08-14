package com.luoge.bos.invoice.model.industry;

import java.util.List;

public class IndustryVO {
    /**
     * id
     */
    private Integer id;
    /**
     * 行业名称
     */
    private String name;
    /**
     * 实力商户名称
     */
    private String exampleEnterprise;
    /**
     * 发票类目
     */
    private List<String> invoiceItems;


    public Integer getId() {
        return id;
    }

    public IndustryVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public IndustryVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getExampleEnterprise() {
        return exampleEnterprise;
    }

    public IndustryVO setExampleEnterprise(String exampleEnterprise) {
        this.exampleEnterprise = exampleEnterprise;
        return this;
    }

    public List<String> getInvoiceItems() {
        return invoiceItems;
    }

    public IndustryVO setInvoiceItems(List<String> invoiceItems) {
        this.invoiceItems = invoiceItems;
        return this;
    }
}
