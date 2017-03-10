package com.youanmi.commons.base.service;

import java.util.List;
import java.util.Map;

import com.youanmi.commons.base.exception.BaseException;

/**
 * 
 * @ClassName: BaseCrudService
 * @Description: crud对应Service接口
 * @author li.jinwen
 * @email lijinwen@youanmi.com
 * @date 2017年2月20日 上午10:32:21
 *
 */
public interface BaseCrudService<T> {

	public int deleteById(Long id) throws BaseException;

	/**
	 * 
	 * @Description: 调用insertSelective进行插入
	 * @author li.jinwen
	 * @email lijinwen@youanmi.com
	 * @date 2017年2月20日 上午11:47:28
	 * @param model
	 * @return
	 * @throws BaseException
	 */
	public int add(T model) throws BaseException;

	/**
	 * 
	 * @Description: 使用原生insert插入
	 * @author li.jinwen
	 * @email lijinwen@youanmi.com
	 * @date 2017年2月20日 上午11:47:55
	 * @param model
	 * @return
	 * @throws BaseException
	 */
	public int insert(T model) throws BaseException;

	public T findById(Long id) throws BaseException;

	/**
	 * 
	 * @Description: 根据参数查询
	 * @author li.jinwen
	 * @email lijinwen@youanmi.com
	 * @date 2017年2月20日 上午11:49:20
	 * @param params 用map进行组装参数
	 * @return
	 * @throws BaseException
	 */
	public List<T> findByParams(Map<String, Object> params) throws BaseException;

	/**
	 * 
	 * @Description: 根据id修改实体
	 * @author li.jinwen
	 * @email lijinwen@youanmi.com
	 * @date 2017年2月20日 上午11:49:46
	 * @param model 传入一个带有id的实体
	 * @return
	 * @throws BaseException
	 */
	public int modifyById(T model) throws BaseException;

}
