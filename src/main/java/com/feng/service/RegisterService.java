package com.feng.service;

import com.feng.util.DataBaseUtils;

import java.util.Map;

/**
 * Created by Fengunion on 2017/6/19.
 */
public class RegisterService {
    public void queryUsername(String username) {
        String sql = "select * from t_user where username=?";
        DataBaseUtils.config("com/feng/config/jdbc.properties");
        boolean flag = DataBaseUtils.queryIsExist(sql, username);
        System.out.println(flag+"---------");
    }
}
