package com.youanmi.commons.base.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.youanmi.commons.base.dao.BasicDAO;


/**
 * 业务抽象服务层功能类
 * 
 * @author tinglong
 */
public abstract class AbstractService {

    /**
     * 数据持久化公共类
     */
    @Autowired
    protected BasicDAO basicDAO;

}
