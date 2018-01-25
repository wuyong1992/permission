package com.wuyong.permission.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * created by JianGuo
 * on 2018/1/25
 * description: 层级工具类
 */

public class LevelUtil {

    private static final String SEPARATOR = ".";

    public static final String ROOT = "0";


    public static String calculateLevel(String parentLevel, Integer parentId) {
        if (StringUtils.isBlank(parentLevel)) {
            // 首层
            return ROOT;
        } else {
            // 拼装级别 0.1    0.1.1   0.2
            return StringUtils.join(parentLevel, SEPARATOR, parentId);
        }

    }


}
