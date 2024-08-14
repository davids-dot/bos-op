package com.luoge.bos.invoice.entity.invoice;

/**
 * 开票行业类型
 */
public class IndustryDO {
    private Integer id;

    private String name;

    private String exampleEnterprise;

    private String invoiceItems;

    public Integer getId() {
        return id;
    }

    public IndustryDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public IndustryDO setName(String name) {
        this.name = name;
        return this;
    }

    public String getExampleEnterprise() {
        return exampleEnterprise;
    }

    public IndustryDO setExampleEnterprise(String exampleEnterprise) {
        this.exampleEnterprise = exampleEnterprise;
        return this;
    }

    public String getInvoiceItems() {
        return invoiceItems;
    }

    public IndustryDO setInvoiceItems(String invoiceItems) {
        this.invoiceItems = invoiceItems;
        return this;
    }
}