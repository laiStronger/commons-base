/*
 * 文件名：PageUtils.java
 * 版权：深圳柚安米科技有限公司版权所有
 * 修改人：tanguojun
 * 修改时间：2016年4月29日
 * 修改内容：新增
 */
package com.youanmi.commons.base.helper;

import java.util.List;

import com.youanmi.commons.base.vo.PageBean;


/**
 * 分页工具
 * 
 * @author tanguojun
 * @since 2.2.4
 */
public class PageUtils {

    /**
     * 默认每页最大大小=200
     */
    public static final Integer DEFAULT_MAX_PAGE_SIZE = 200;

    /**
     * 默认每页大小=10
     */
    public static final Integer DEFAULT_PAGE_SIZE = 10;

    /**
     * 默认当前页数=1
     */
    public static final Integer DEFAULT_PAGE_INDEX = 1;

    /**
     * 获取默认的页数
     * 
     * @author tanguojun 2016年4月29日
     * @param pageIndex
     * @param defaultPageIndex
     * @return
     */
    public static Integer getPageIndex(Integer pageIndex, Integer defaultPageIndex) {
        if (pageIndex != null && pageIndex > 0) {
            return pageIndex;
        }
        else if (defaultPageIndex != null && defaultPageIndex > 0) {
            return defaultPageIndex;
        }
        return DEFAULT_PAGE_INDEX;
    }

    /**
     * 获取每页大小
     * 
     * @author tanguojun 2016年4月29日
     * @param pageSize
     * @param defaultPageSize
     * @return
     */
    public static Integer getPageSize(Integer pageSize, Integer defaultPageSize) {
        if (pageSize == null || pageSize <= 0) {
            if (defaultPageSize == null || defaultPageSize <= 0) {
                return DEFAULT_PAGE_SIZE;
            }
            else if (defaultPageSize > DEFAULT_MAX_PAGE_SIZE) {
                return DEFAULT_MAX_PAGE_SIZE;
            }
            else {
                return defaultPageSize;
            }
        }
        else if (pageSize > DEFAULT_MAX_PAGE_SIZE) {
            return DEFAULT_MAX_PAGE_SIZE;
        }
        else {
            return pageSize;
        }
    }

    /**
     * 获取封装PageBean类
     * 
     * @author tanguojun 2016年5月3日
     * @param pageIndex
     * @param pageSize
     * @param allRecord
     * @param pages
     * @param datas
     * @return
     */
    public static <E> PageBean<E> getPageBean(Integer pageIndex, Integer pageSize, Integer allRecord,
            Integer pages, List<E> datas) {

        PageBean<E> page = new PageBean<E>();
        // 设置当前页数
        page.setPageIndex(pageIndex);
        // 设置每页大小
        page.setPageSize(pageSize);
        // 设置所有记录数
        page.setAllRecord(allRecord);
        // 设置所有页数
        page.setAllPage(pages);
        // 设置返回数据
        page.setData(datas);

        return page;
    }

}
