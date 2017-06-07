package com.feng.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Fengunion on 2017/6/6.
 */
@Target(ElementType.FIELD) //注解目标
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    public String field();//字段名称

    public boolean primaryKey() default false;//是否为主键

    public String type() default "VARCHAR(80)";//字段类型

    public boolean defaultNull() default true;//是否允许为空
}
