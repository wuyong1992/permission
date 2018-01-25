package com.wuyong.permission.controller;

import com.wuyong.permission.model.SysUser;
import com.wuyong.permission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by JianGuo
 * on 2018/1/25
 * description:
 */
@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @RequestMapping("find_user")
    public SysUser findUser(){
        return userService.findUserById();
    }

}
