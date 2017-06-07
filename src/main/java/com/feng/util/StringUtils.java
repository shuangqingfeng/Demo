package com.feng.util;

/**
 * Created by Fengunion on 2017/6/6.
 */
public class StringUtils {
    public static boolean isEmpty(String str) {
        return null == str || str.equals("") || str.matches("\\s*");
    }

    public static String defaultValue(String content, String defaultValue) {
        if (isEmpty(content))
            return defaultValue;

        return content;
    }
}
