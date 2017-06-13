package com.feng.service;

import com.feng.util.DataBaseUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by Fengunion on 2017/6/13.
 */
public class ArticleService {
    /**
     * 通过类别获取文章列表
     *
     * @param categoryId
     * @param start
     * @param end
     * @return
     */
    public List<Map<String, Object>> getArticlesByCategoryId(Integer categoryId, Integer start, Integer end) {
        String sql = "select id ,header,name,author,"
                + "description from t_article where 1 = 1"
                + " and is_delete =0"
                + " and is_published = 1"
                + " and category_id = ?"
                + " order by update_time desc limit ?,?";
        return DataBaseUtils.queryForList(sql, categoryId, start, end);
    }

    /**
     * 通过文章di 获取文章内容
     *
     * @param id
     * @return
     */
    public List<Map<String, Object>> getContentByArticleId(String id) {
        String sql = "select * from t_article a inner join t_category b on a.category_id = b.category_id where a.id = ?";
        return DataBaseUtils.queryForList(sql, id);

    }


}
