package com.wuyong.permission.common;

/**
 * Created by 坚果
 * on 2017/9/16
 * 返回的状态码
 */
public enum ResponseCode {

    /* 0 成功 */
    SUCCESS(0, "SUCCESS"),

    /* 1 错误 */
    ERROR(1, "ERROR");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
    }
