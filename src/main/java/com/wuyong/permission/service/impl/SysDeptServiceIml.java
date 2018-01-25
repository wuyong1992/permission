package com.wuyong.permission.service.impl;

import com.wuyong.permission.mapper.SysDeptMapper;
import com.wuyong.permission.model.SysDept;
import com.wuyong.permission.param.DeptParam;
import com.wuyong.permission.service.SysDeptService;
import com.wuyong.permission.utils.LevelUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * created by JianGuo
 * on 2018/1/25
 * description:
 */
@Service("deptService")

public class SysDeptServiceIml implements SysDeptService {


    @Resource
    private SysDeptMapper sysDeptMapper;


    @Override
    public void save(DeptParam deptParam) {
        if (checkExist(deptParam.getParentId(), deptParam.getName(), deptParam.getId())) {
            throw new SecurityException("同一层级下该部门已存在");
        }
        SysDept sysDept =
                SysDept.builder()
                        .name(deptParam.getName())
                        .id(deptParam.getId())
                        .parentId(deptParam.getParentId())
                        .remark(deptParam.getRemark())
                        .seq(deptParam.getSeq())
                        .build();

        // 构造level
        String level = getLevel(deptParam.getParentId());
        sysDept.setLevel(LevelUtil.calculateLevel(level, deptParam.getParentId()));

        sysDept.setOperator("system");  // todo
        sysDept.setOperateIp("123.0.1");    // todo
        sysDept.setOperateTime(new Date()); // todo

    }


    /**
     * 同一层级下该部门是否已存在
     *
     * @param parentId
     * @param deptName
     * @param deptId
     * @return
     */
    @Override
    public boolean checkExist(Integer parentId, String deptName, Integer deptId) {
        // todo
        return true;
    }


    private String getLevel(Integer deptId) {
        SysDept sysDept = sysDeptMapper.selectByPrimaryKey(deptId);
        if (sysDept == null) {
            return null;
        }
        return sysDept.getLevel();
    }

}
