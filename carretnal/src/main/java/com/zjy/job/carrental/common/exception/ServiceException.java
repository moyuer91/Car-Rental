package com.zjy.job.carrental.common.exception;

/**
 * 服务异常类
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = 1L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message,Exception e) {
        super(message,e);
    }
}
