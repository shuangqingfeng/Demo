package com.feng.service;

import com.feng.bean.User;
import com.feng.util.DataBaseUtils;

/**
 * Created by Fengunion on 2017/6/8.
 * 用户登录的服务类
 */
public class LoginService {
    public User getUser(String username) {
        String sql = "select * from t_user where username=?";
        DataBaseUtils.config("com/feng/config/jdbc.properties");
        User user = DataBaseUtils.queryForBean(sql, User.class, username);
        if (user == null) {
            return null;
        }
        return user;
    }
}
