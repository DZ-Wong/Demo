package com.wdz.springboot.core.handler.exception;

/**
 * 自定义异常类。
 * */
public class HandleException extends Exception {
    public HandleException() {
        super();
    }

    public HandleException(String message) {
        super(message);
    }

    public HandleException(String message, Throwable cause) {
        super(message, cause);
    }

    public HandleException(Throwable cause) {
        super(cause);
    }

    protected HandleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
