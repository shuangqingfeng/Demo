package com.feng.Test;

import com.feng.bean.Article;
import com.feng.bean.Comment;
import com.feng.bean.User;
import com.feng.util.DataBaseUtils;
import com.feng.util.TableUtils;

/**
 * Created by Fengunion on 2017/6/6.
 */
public class TestMain {

    public static void main(String[] args) {
        String sql = TableUtils.getCreateTable(Comment.class);
        System.out.println(sql);


//        DataBaseUtils.config("com/feng/config/jdbc.properties");
//        List<Map<String, Object>> result = DataBaseUtils.queryForList("select * from t_user");
//        for (Map<String, Object> map : result) {
//            System.out.println(map);
//        }
//        System.out.println(result);


//        Map<String, Object> result = DataBaseUtils.queryForMap("select * from t_user where username=?", "习近平");
//        System.out.println(result);
//        User user = DataBaseUtils.queryForBean("select * from t_user  limit 1", User.class);
//        System.out.println(user);

    }

}
