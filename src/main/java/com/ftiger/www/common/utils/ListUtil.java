package com.ftiger.www.common.utils;

import java.util.Collection;

/**
 * @author 宋旭源
 */
public class ListUtil {

    public static boolean isEmpty(Collection list){
        if (list == null || list.size() == 0){
            return true;
        }else {
            return false;
        }
    }
}
