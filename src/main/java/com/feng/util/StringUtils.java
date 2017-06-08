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

    /**
     * 把数据库字段名改为驼峰式
     *
     * @param column
     * @return
     */
    public static String columnToProperty(String column) {
        if (isEmpty(column))
            return "";
        byte length = (byte) column.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        int i = 0;
        for (byte j = 0; j < length; j++) {
            if (column.charAt(j) == '_') {
                while (column.charAt(j + 1) == '_') {
                    j += 1;
                }
                stringBuilder.append(("" + column.charAt(++j)).toUpperCase());
            } else {
                stringBuilder.append(column.charAt(j));
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 将一个字符创的首字母改成大写
     *
     * @param string
     * @return
     */
    public static String upperCaseFirstCharacter(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                stringBuilder.append((chars[i] + "").toUpperCase());
            } else {
                stringBuilder.append((chars[i] + ""));
            }
        }
        return stringBuilder.toString();
    }
}
