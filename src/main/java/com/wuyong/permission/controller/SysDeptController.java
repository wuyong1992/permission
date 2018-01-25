package com.wuyong.permission.controller;

import com.wuyong.permission.common.ServerResponse;
import com.wuyong.permission.exception.SaveSysDeptException;
import com.wuyong.permission.param.DeptParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * created by JianGuo
 * on 2018/1/25
 * description:
 */
@Controller
@RequestMapping("sys/dept")
@Slf4j
public class SysDeptController {


    @RequestMapping("save_dept")
    @ResponseBody
    public ServerResponse saveDept(@Valid DeptParam deptParam, BindingResult result) {
        if (result.hasErrors()) {
            result.getAllErrors().stream().forEach(
                    error->{
                        FieldError fieldError = (FieldError) error;
                        log.info("字段：{}，出现错误：{}", fieldError.getField(), fieldError.getDefaultMessage());
                    }
            );
            throw new SaveSysDeptException("save sys_dept exception");
        }
        return null;
    }


}
