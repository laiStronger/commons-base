package com.youanmi.commons.base.vo;

import java.io.Serializable;

/**
 * 分页请求参数
 * @author sunxiaolong on 2017/2/25
 */
public class PageParam implements Serializable{
    private Integer pageIndex = 1;
    private Integer pageSize = 10;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart(){
        return (pageIndex-1) * pageSize;
    }



}
