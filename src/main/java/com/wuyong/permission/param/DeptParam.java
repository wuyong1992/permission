package com.wuyong.permission.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * created by JianGuo
 * on 2018/1/25
 * description:
 */

@Data
public class DeptParam {

    private Integer id;

    @NotNull(message = "部门名称不能为空")
    @Length(max = 15, min = 2, message = "部门名称只能在2-15个字")
    private String name;

    private Integer parentId;

    @NotNull(message = "展示顺序不可以为空")
    private Integer seq;

    @Length(max = 150, message = "备注不能超过150个字")
    private String remark;


}
