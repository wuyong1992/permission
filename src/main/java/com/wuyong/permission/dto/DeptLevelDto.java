package com.wuyong.permission.dto;

import com.google.common.collect.Lists;
import com.wuyong.permission.model.SysDept;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * created by JianGuo
 * on 2018/1/25
 * description:
 */

@Data
public class DeptLevelDto extends SysDept {


    private List<DeptLevelDto> deptLevelDtoList = Lists.newArrayList();


    // 适配的方法
    public static DeptLevelDto adapt(SysDept dept) {
        DeptLevelDto deptLevelDto = new DeptLevelDto();
        BeanUtils.copyProperties(dept, deptLevelDto);
        return deptLevelDto;
    }


}
