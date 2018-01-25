package com.wuyong.permission.service;

import com.wuyong.permission.param.DeptParam;

/**
 * created by JianGuo
 * on 2018/1/25
 * description:
 */
public interface SysDeptService {

    void save(DeptParam deptParam);

    boolean checkExist(Integer parentId, String deptName, Integer deptId);

}
