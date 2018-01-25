package com.wuyong.permission.service.impl;

import com.wuyong.permission.mapper.SysUserMapper;
import com.wuyong.permission.model.SysUser;
import com.wuyong.permission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * created by JianGuo
 * on 2018/1/25
 * description:
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById() {
        return sysUserMapper.selectByPrimaryKey(1);
    }

}
