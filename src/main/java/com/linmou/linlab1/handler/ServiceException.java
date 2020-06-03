package com.linmou.linlab1.handler;

import com.linmou.linlab1.enumuation.ServiceExceptionEnum;

/**
 * @author linMou
 * @Description:
 * @Date: 2020/5/13 16:48
 * @Version: 1.0
 */
public final class ServiceException extends RuntimeException {

    private final int code;
    private  final String msg;

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
       super(serviceExceptionEnum.getMsg());
       this.code = serviceExceptionEnum.getCode();
        this.msg = serviceExceptionEnum.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
