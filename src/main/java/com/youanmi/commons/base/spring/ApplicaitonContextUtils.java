/*
 * 文件名：applicationUtils.java
 * 版权：深圳柚安米科技有限公司版权所有
 * 修改人：liulj
 * 修改时间：2016年6月6日
 * 修改内容：新增
 */
package com.youanmi.commons.base.spring;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * spiring appliction工具类
 * <p>
 * spiring appliction工具类方法
 * 
 * 
 * @author Administrator
 * @since 2.2.4
 */
public class ApplicaitonContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    /**
     * 根具类型，返回bean
     * 
     * @author liulj Sep 13, 2016
     * @param clas
     * @return
     */
    public static <T> T getBean(Class<T> clas) {
        // TODO Auto-generated method stub
        return applicationContext.getBean(clas);
    }


    /**
     * 根具名称，返回bean
     * 
     * @author liulj Sep 13, 2016
     * @param clas
     * @return
     */
    public static Object getBean(String beanName) {
        // TODO Auto-generated method stub
        return applicationContext.getBean(beanName);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        ApplicaitonContextUtils.applicationContext = applicationContext;
    }


    public static String getMessage(String code, Object... args) {
        return applicationContext.getMessage(code, args, Locale.CHINESE);
    }
}
