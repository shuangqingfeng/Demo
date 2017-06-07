package com.feng.Test;

import com.feng.bean.Article;
import com.feng.model.User;
import com.feng.util.DataBaseUtils;
import com.feng.util.TableUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by Fengunion on 2017/6/6.
 */
public class TestMain {

    public static void main(String[] args) {
//        String sql = TableUtils.getCreateTable(Article.class);
//        System.out.println(sql);


        DataBaseUtils.config("com/feng/config/jdbc.properties");
//        List<Map<String, Object>> result = DataBaseUtils.queryForList("select * from t_user");
//        for (Map<String, Object> map : result) {
//            System.out.println(map);
//        }
//        System.out.println(result);


        Map<String, Object> result = DataBaseUtils.queryForMap("select * from t_user where username=?", "习近平");
        System.out.println(result);

    }

}
