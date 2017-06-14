package com.feng.Test;

import com.feng.util.DataBaseUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

/**
 * Created by Fengunion on 2017/6/7.
 */
public class TestProperties {
    public static void main(String[] args) {
        DataBaseUtils.config("com/feng/config/jdbc.properties");
        String id = UUID.randomUUID() + "";
        String createTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        DataBaseUtils.update("INSERT INTO t_user(id,username,password,sex,create_time,is_delete,address,telephone)"
                + "VALUES(?,?,?,?,?,?,?,?)", id, "小沈阳", 123456, 0, createTime, 0, "男", "保密");
    }
}
