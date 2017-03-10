/*
 * 文件名：ViewExceptionUtils.java
 * 版权：深圳柚安米科技有限公司版权所有
 * 修改人：tanguojun
 * 修改时间：2016年12月19日
 * 修改内容：新增
 */
package com.youanmi.commons.base.helper;

import com.youanmi.commons.base.exception.ViewExternalDisplayException;
import com.youanmi.scrm.commons.constants.result.ResultCode;
import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * ViewExternalDisplayException校验类,校验失败就会抛出ViewExternalDisplayException
 * 
 * @author tanguojun 2016年12月19日
 * @version 1.0.0
 */
public class ValidateViewExceptionUtils {

    /**
     * 校验参数不能为空,为空抛出异常
     *
     * @param resultCode
     * @param value
     * @param args
     * @author tanguojun on 2016年12月19日
     */
    public static void validateObjectIsNotNull(String resultCode, Object value, String... args) {
        if (value == null) {
            throw new ViewExternalDisplayException(resultCode, args);
        }
    }

    /**
     * 校验字符串不能为空,为空抛出异常
     *
     * @param resultCode
     * @param value
     * @param args
     * @author tanguojun on 2016年12月19日
     */
    public static void validateStringIsNotNull(String resultCode, String value, String... args) {
        if (StringUtils.isBlank(value)) {
            throw new ViewExternalDisplayException(resultCode, args);
        }
    }

    /**
     * 校验字符串长度,超出长度抛出异常
     * 
     * @param resultCode
     * @param str
     * @param maxLength
     * @param args
     * @author tanguojun on 2016年12月19日
     */
    public static void validateLength(String resultCode, String str, int maxLength, String... args) {
        if (str.length() > maxLength) {
            throw new ViewExternalDisplayException(resultCode, args);
        }
    }

    /**
     * 校验数字范围,超出范围抛出异常
     *
     * @param resultCode
     * @param num
     * @param min
     * @param max
     * @param args
     * @author tanguojun on 2016年12月19日
     */
    public static void validateIntRange(String resultCode, int num, int min, int max, String... args) {
        if (num < min || num > max) {
            throw new ViewExternalDisplayException(resultCode, args);
        }
    }

    /**
     * 校验字符串是否在list中,不存在抛出范围
     *
     * @param resultCode
     * @param value
     * @param list
     * @param args
     * @author tanguojun on 2016年12月19日
     */
    public static void validateStringInList(String resultCode, String value, List<String> list,
            String... args) {
        boolean exist = false;
        for (String str : list) {
            if (value.equals(str)) {
                exist = true;
                break;
            }
        }
        // 抛出异常
        if (!exist) {
            throw new ViewExternalDisplayException(resultCode, args);
        }
    }

    /**
     * 校验数字范围,超出范围抛出异常
     *
     * @param resultCode
     * @param num
     * @param min
     * @param max
     * @param args
     * @author tanguojun on 2016年12月19日
     */
    public static void validateByteRange(String resultCode, byte num, byte min, byte max, String... args) {
        if (num < min || num > max) {
            throw new ViewExternalDisplayException(resultCode, args);
        }
    }

    /**
     * 校验数字范围,超出范围抛出异常
     *
     * @param resultCode
     * @param num
     * @param min
     * @param max
     * @param args
     * @author tanguojun on 2016年12月19日
     */
    public static void validateLongRange(String resultCode, long num, long min, long max, String... args) {
        if (num < min || num > max) {
            throw new ViewExternalDisplayException(resultCode, args);
        }
    }

    /**
     * 这个方法抛出操作非法的异常
     * 操作非法的意思是前端应该做过校验,所以后端不应该出现这种情况,但由于用户非法操作(比如手动修改请求参数)而出现的情况
     * @param msg 异常内容,主要供前端调试用
     */
    public static void throwIllegalOperationException(String msg){
        throw new ViewExternalDisplayException(ResultCode.System.ILLEGAL_OPERATION,msg);
    }

    /**
     * 数据不存在或数据已被删除
     */
    public static void throwDataNotExistException() {
        throw new ViewExternalDisplayException(ResultCode.System.DATA_NOT_EXIST);
    }

}
