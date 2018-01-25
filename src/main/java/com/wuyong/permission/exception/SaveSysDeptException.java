package com.wuyong.permission.exception;

/**
 * created by JianGuo
 * on 2018/1/25
 * description: 自定义异常
 * 保存SysDept异常
 */
public class SaveSysDeptException extends RuntimeException {

    public SaveSysDeptException() {
        super("save sys_dept exception");
    }

    public SaveSysDeptException(String message) {
        super(message);
    }

    public SaveSysDeptException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaveSysDeptException(Throwable cause) {
        super(cause);
    }

    protected SaveSysDeptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
