package com.youanmi.commons.base.exception;


/**
 * 异常基类
 * 
 * @author 龙汀
 *
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -1000965192651043874L;

    protected String code;

    protected Object[] params;


    /**
     * 
     * 构造函数。
     *
     */
    public BaseException() {
    }


    /**
     * 
     * 构造函数。
     * 
     * @param t
     */
    public BaseException(Throwable t) {
        super(t);
    }


    /**
     * 
     * 构造函数。
     * 
     * @param errorCode
     * @param t
     */
    public BaseException(String errorCode, Throwable t) {
        super(paramsStr(errorCode));
        this.code = errorCode;
    }


    /**
     * 
     * 构造函数。
     * 
     * @param errorCode
     * @param params
     */
    public BaseException(String errorCode, Object... params) {
        super(paramsStr(errorCode, params));
        this.params = params;
        this.code = errorCode;
    }
    
    private static String paramsStr(String errorCode, Object... params){
        StringBuilder sb=new StringBuilder(errorCode);
        if(params!=null&&params.length>0){
            sb.append(",");
            for (int i = 0; i < params.length; i++) {
                sb.append(i+":");
                sb.append(params[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 
     * 获取错误码
     * 
     * @return
     */
    public String getErrorCode() {
        return code;
    }


    /**
     * 获取params
     */
    public Object[] getParams() {
        return params;
    }


    /**
     * setCode
     */
    public void setCode(String code) {
        this.code = code;
    }


    /**
     * setParams
     */
    public void setParams(Object[] params) {
        this.params = params;
    }


    /**
     * getCode
     */
    public String getCode() {
        return code;
    }

}
