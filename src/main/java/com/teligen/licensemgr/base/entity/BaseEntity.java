package com.teligen.licensemgr.base.entity;

import javax.persistence.Transient;

public class BaseEntity {
    @Transient
    private Integer pageNum;

    @Transient
    private Integer pageSize;

    public int getPageNum() {
        if (null == pageNum || pageNum == 0) {
            return 1;
        }
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        if (null == pageSize || pageSize == 0) {
            return 10;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
