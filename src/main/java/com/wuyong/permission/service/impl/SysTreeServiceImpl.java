package com.wuyong.permission.service.impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.wuyong.permission.dto.DeptLevelDto;
import com.wuyong.permission.mapper.SysDeptMapper;
import com.wuyong.permission.model.SysDept;
import com.wuyong.permission.service.SysTreeService;
import com.wuyong.permission.utils.LevelUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * created by JianGuo
 * on 2018/1/25
 * description: 树形结构
 */


@Service("sysTreeService")
public class SysTreeServiceImpl implements SysTreeService {

    @Resource
    private SysDeptMapper sysDeptMapper;


    public List<DeptLevelDto> deptTree() {
        List<SysDept> sysDeptList = sysDeptMapper.getAllSysDept();
        List<DeptLevelDto> deptLevelDtoList = Lists.newArrayList();

        for (SysDept dept : sysDeptList) {
            DeptLevelDto dto = DeptLevelDto.adapt(dept);
            deptLevelDtoList.add(dto);
        }

        return deptLevelDtoListToTree(deptLevelDtoList);
    }

    private List<DeptLevelDto> deptLevelDtoListToTree(List<DeptLevelDto> deptLevelDtoList){
        if (CollectionUtils.isEmpty(deptLevelDtoList)) {
            return Lists.newArrayList();
        }

        Multimap<String, DeptLevelDto> levelDtoMap = ArrayListMultimap.create();
        List<DeptLevelDto> rootList = Lists.newArrayList();

        for (DeptLevelDto dto : deptLevelDtoList) {
            levelDtoMap.put(dto.getLevel(), dto);
            // 判断是否为一级部门
            if (LevelUtil.ROOT.equals(dto.getLevel())) {
                rootList.add(dto);
            }
        }

        // 排序 seq从到大
        Collections.sort(rootList, new Comparator<DeptLevelDto>() {
            @Override
            public int compare(DeptLevelDto o1, DeptLevelDto o2) {
                return o1.getSeq() - o2.getSeq();
            }
        });

        // 递归查询排序
        transformDeptTree(rootList, LevelUtil.ROOT, levelDtoMap);
        return rootList;
    }


    private void transformDeptTree(List<DeptLevelDto> deptLevelDtoList,
                                   String level,
                                   Multimap<String, DeptLevelDto> levelDtoMap) {
        for (int i = 0; i < deptLevelDtoList.size(); i++) {
            // 遍历该层级的元素
            DeptLevelDto deptLevelDto = deptLevelDtoList.get(i);

            // 处理当前层级的数据
            String nextLevel = LevelUtil.calculateLevel(level, deptLevelDto.getParentId());

            // 处理下一层
            List<DeptLevelDto> tempDeptList = (List<DeptLevelDto>) levelDtoMap.get(nextLevel);

            if (CollectionUtils.isEmpty(tempDeptList)) {
                //  排序
                Collections.sort(tempDeptList, new Comparator<DeptLevelDto>() {
                    @Override
                    public int compare(DeptLevelDto o1, DeptLevelDto o2) {
                        return o1.getSeq() - o2.getSeq();
                    }
                });

                //  设置下一层处理，
                deptLevelDto.setDeptLevelDtoList(tempDeptList);

                // 进入下一层
                transformDeptTree(tempDeptList, nextLevel, levelDtoMap);
            }
        }
    }





}











