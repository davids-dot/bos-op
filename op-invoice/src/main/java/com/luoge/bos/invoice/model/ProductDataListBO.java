package com.luoge.bos.invoice.model;

public class ProductDataListBO {
    private int id;
    private int productId;
    private String dataId;
    private String dataName;

    public int getProductId() {
        return productId;
    }

    public ProductDataListBO setProductId(int productId) {
        this.productId = productId;
        return this;
    }

    public int getId() {
        return id;
    }

    public ProductDataListBO setId(int id) {
        this.id = id;
        return this;
    }

    public String getDataId() {
        return dataId;
    }

    public ProductDataListBO setDataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public String getDataName() {
        return dataName;
    }

    public ProductDataListBO setDataName(String dataName) {
        this.dataName = dataName;
        return this;
    }
}
