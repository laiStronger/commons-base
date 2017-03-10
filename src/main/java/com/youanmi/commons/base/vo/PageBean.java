/*
 * 文件名：PageBean.java
 * 版权：Copyright 2014 youanmi Tech. Co. Ltd. All Rights Reserved. 
 * 描述： PageBean.java
 * 修改人：chenwenlong
 * 修改时间：2014年12月30日
 * 修改内容：新增
 */
package com.youanmi.commons.base.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author chenwenlong
 * @version YouAnMi-OTO 2014年12月30日
 * @since YouAnMi-OTO
 */
public class PageBean<E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 页索引 当前页
	 */
	private Integer pageIndex;

	/**
	 * 页大小
	 */
	private Integer pageSize = 10;

	/**
	 * sql 查询总记录数
	 */
	private Integer allRecord = 0;

	/**
	 * sql 查询总页数
	 */
	private Integer allPage;

	/**
	 * sql 查询集合
	 */
	private List<E> data;

	/**
	 * sql 查询开始索引
	 */
	private Integer startIndex;

	/**
	 * sql 查询结束索引
	 */
	private Integer endIndex;

	/**
	 * 参数对象 根据传入的自己拆箱
	 */
	private Object paramObject;

	/**
	 * 用于web接口查询活动
	 */
	private Long currentTime;

	private Integer pageNum = 1;

	public PageBean() {
	}

	public PageBean(Object paramObject) {
		this.paramObject = paramObject;
	}

	public PageBean(Object paramObject, Integer pageSize) {
		this.paramObject = paramObject;
		this.pageSize = pageSize;
	}

	public Long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Long currentTime) {
		this.currentTime = currentTime;
	}

	public Object getParamObject() {
		return paramObject;
	}

	public void setParamObject(Object paramObject) {
		this.paramObject = paramObject;
	}

	public Integer getStartIndex() {
		if (null == pageIndex || pageIndex < 1)
			return 0;
		Integer start = (pageIndex - 1) * pageSize;
		return start;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		if (null == pageIndex)
			return pageSize;
		Integer end = pageIndex * pageSize;
		return end;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

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

	public Integer getAllRecord() {
		return allRecord;
	}

	public void setAllRecord(Integer allRecord) {
		this.allRecord = allRecord;
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

	public Integer getAllPage() {
		int isZero = allRecord % pageSize;
		if (isZero == 0)
			allPage = allRecord / pageSize;
		else
			allPage = ((allRecord - isZero) / pageSize) + 1;
		return allPage;

	}

	public void setAllPage(Integer allPage) {
		this.allPage = allPage;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
}
