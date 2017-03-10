package com.youanmi.commons.base.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页请求的结果,讲道理allPage应该也不需要,交给前端处理的
 * @author sunxiaolong on 2017/2/25
 */
public class PageResult<T> implements Serializable{
    private List<T> data;
    private Integer allRecord;
    private Integer allPage;

    public PageResult(){

    }

    public PageResult(List<T> data,Integer allRecord,Integer allPage){
        this.data = data;
        this.allRecord = allRecord;
    }

    public PageResult(List<T> data,Integer allRecord,PageParam pageParam){
        this(data,allRecord,allRecord/pageParam.getPageSize() + allRecord%pageParam.getPageSize() == 0 ? 0:1);
    }

    public PageResult(List<T> data,Long allRecord,Integer allPage){
        this(data,allRecord.intValue(),allPage);
    }

    public PageResult(List<T> data,Long allRecord,PageParam pageParam){
        this(data,allRecord.intValue(),pageParam);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getAllRecord() {
        return allRecord;
    }

    public void setAllRecord(Integer allRecord) {
        this.allRecord = allRecord;
    }

    public Integer getAllPage() {
        return allPage;
    }

    public void setAllPage(Integer allPage) {
        this.allPage = allPage;
    }

}
