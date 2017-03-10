package com.youanmi.commons.base.exception;

/**
 * 试图异常类，跳转到指定页面
 * 
 * @author 龙汀
 *
 */
@SuppressWarnings("serial")
public class ViewExternalDisplayException extends BaseException {

    /**
     * 异常消息
     */
    private String msg;

    /**
     * 
     * 构造函数。
     *
     */
    public ViewExternalDisplayException() {
    }

    /**
     * 
     * 构造函数。
     * 
     * @param errorCode
     */
    public ViewExternalDisplayException(String errorCode) {
        super(errorCode);
    }

    /**
     * 
     * 构造函数。
     * 
     * @param errorCode
     * @param cause
     */
    public ViewExternalDisplayException(String errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    /**
     * 
     * 构造函数。
     * 
     * @param errorCode
     * @param params
     */
    public ViewExternalDisplayException(String errorCode, Object... params) {
        super(errorCode, params);
    }

    /**
     * 
     * getMsg
     * 
     * @return
     */
    public String getMsg() {
        return msg;
    }


    /**
     * 
     * setMsg
     * 
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
