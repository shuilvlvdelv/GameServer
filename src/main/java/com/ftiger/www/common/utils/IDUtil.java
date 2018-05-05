package com.ftiger.www.common.utils;

/**
 * @author 宋旭源
 */
public class IDUtil {
    private static int id = 1;

    synchronized
    public static int createId(){
        return id++;
    }
}
