package com.paulo.common.utils;

/**
 * Create by tfy on 2020/3/30 10:55
 **/
public class ParseUtils {
    /**
     * 字符串转换为int
     */
    public static int parseInt(String i, int defaultVal) {
        int num;
        try {
            num = Integer.parseInt(i);
        } catch (NumberFormatException e) {
            num = defaultVal;
        }
        return num;
    }
}
