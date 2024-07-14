package com.luoge.bos.op.core.model;


import com.luoge.ns.core.Code;

public class PageQuery {
    private static final int MAX_PAGE_NO = 1000;
    private static final int MAX_PAGE_SIZE = 200;
    private static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 页码
     */
    private Integer pageNo;
    /**
     * 页大小
     */
    private Integer pageSize;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo == null ? 1 : pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public int check() {
        if (pageNo == null || pageNo < 0 || pageNo > MAX_PAGE_NO) {
            pageNo = 1;
        }
        if (pageSize == null || pageSize < 0 || pageSize > MAX_PAGE_SIZE) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return Code.SUCCESS;
    }

    @Override
    public String toString() {
        return "PageQuery{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
