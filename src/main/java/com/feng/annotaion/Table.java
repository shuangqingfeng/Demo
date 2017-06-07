package com.feng.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Fengunion on 2017/6/6.
 */
@Target(ElementType.TYPE)   //注解的目标是类
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    public String tableName();

}
