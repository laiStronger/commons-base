package com.youanmi.commons.base.service.impl;

import com.youanmi.commons.base.dao.BaseDAO;
import com.youanmi.commons.base.exception.BaseException;
import com.youanmi.commons.base.service.BaseCrudService;
import com.youanmi.scrm.commons.util.object.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: BaseCrudServiceImpl
 * @Description: TODO
 * @author li.jinwen
 * @email lijinwen@youanmi.com
 * @date 2017年2月20日 上午10:37:38
 *
 */
public abstract class BaseCrudServiceImpl<T> implements BaseCrudService<T> {

	/**
	 * 日志对象
	 */
	protected Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	protected BaseDAO baseDAO;

	//子类初始化的时候获取T的类型
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public BaseCrudServiceImpl() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	} 
	
	/**
	 * 
	 * @Description: 抽象方法,返回具体业务对应的mybatis 命名空间
	 * @author li.jinwen
	 * @email lijinwen@youanmi.com
	 * @date 2017年2月20日 下午1:29:13
	 * @return
	 */
	protected abstract String getNameSpace();

	/**
	 * 
	 * @Description: Po对象的类型
	 * @author li.jinwen
	 * @email lijinwen@youanmi.com
	 * @date 2017年2月20日 下午1:29:06
	 * @return
	 */
	protected abstract Class<?> getPoClazz();
	
	@Override
	@Transactional
	public int deleteById(Long id) throws BaseException {
		try {
			return baseDAO.delete(getNameSpace() + ".deleteByPrimaryKey", id);
		} catch (Exception e) {
			throw new BaseException("", e);
		}
	}

	@Override
	@Transactional
	public int add(T entity) throws BaseException {
		try {
			return baseDAO.save(getNameSpace() + ".insertSelective", BeanCopyUtils.map(entity, getPoClazz()));
		} catch (Exception e) {
			throw new BaseException("", e);
		}
	}
	
	@Override
	@Transactional
	public int insert(T entity) throws BaseException {
		try {
			return baseDAO.save(getNameSpace() + ".insert", BeanCopyUtils.map(entity, getPoClazz()));
		} catch (Exception e) {
			throw new BaseException("", e);
		}
	}
	

	@Override
	public T findById(Long id) throws BaseException {
		try {
			Object source = baseDAO.findForObject(getNameSpace() + ".selectByPrimaryKey", id);
			return BeanCopyUtils.map(source, entityClass);
		} catch (Exception e) {
			throw new BaseException("", e);
		}
	}

	@Override
	public List<T> findByParams(Map<String, Object> params) throws BaseException {
		try {
			List<Object> list = baseDAO.findForList(getNameSpace() + ".selectByParams", params);
			return BeanCopyUtils.mapList(list, entityClass);
		} catch (Exception e) {
			throw new BaseException("", e);
		}
	}

	@Override
	@Transactional
	public int modifyById(T entity) throws BaseException {
		try {
			return baseDAO.update(getNameSpace() + ".updateByPrimaryKeySelective", BeanCopyUtils.map(entity, getPoClazz()));
		} catch (Exception e) {
			throw new BaseException("", e);
		}
	}

}
