package com.wuyong.permission.handle;

import com.google.common.collect.Maps;
import com.wuyong.permission.exception.SaveSysDeptException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

/**
 * created by JianGuo
 * on 2018/1/25
 * description:
 */
@ControllerAdvice
public class ControllerExceptionHandle {

    @ExceptionHandler(SaveSysDeptException.class)
    public Map handleSaveSysDeptExceptionHandle(SaveSysDeptException ex) {
        Map map = Maps.newHashMap();
        map.put("message", ex.getMessage());
        return map;
    }
}
