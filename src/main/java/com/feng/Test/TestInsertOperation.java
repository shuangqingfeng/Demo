package com.feng.Test;

import com.feng.bean.Article;
import com.feng.service.ArticleService;
import com.feng.util.DataBaseUtils;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

/**
 * Created by Fengunion on 2017/6/13.
 */
public class TestInsertOperation {
    /**
     * 测试：给文章插入数据
     */
    @Test
    public void insertArticle() {
        DataBaseUtils.config("com/feng/config/jdbc.properties");
        String sql = "INSERT INTO t_article(id,header,name,content,author,"
                + "description,is_published,is_delete,create_time,update_time"
                + ",user_id,category_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
        String id = UUID.randomUUID().toString(); //主键
        String header = "第一行代码";
        String name = "第一行代码";
        String content = "我们经常会在网上下载一些开源项目，或者从别的地方迁移一些项目进来，但经常会发现导入后各种报错。这是初学java肯定会遇到的问题，本文对一些常见的处理方案做一个总结。（本文将MyEclipse项目导入eclipse的过程为例，其他情况也可参考这个流程）";
        String author = "Jack";
        String description = "走进安卓的世界";
        int isPublished = 1;
        int isDelete = 0;
        String create_time = "2017-1-19 10:43:10";
        String update_time = "2016-2-20 10:43:10";
        String userId = "319600c3-550a-4f9f-80cf-deebe2376528";
        int categoryId = 2;
        DataBaseUtils.update(sql, id, header, name, content, author, description, isPublished, isDelete, create_time, update_time, userId, categoryId);
        System.out.println("新增成功！");
    }

    @Test
    public void getArticle() {
        String sql = "select * from t_article where id = ?";
        Article article = DataBaseUtils.queryForBean(sql, Article.class, "1c41df99-4131-419a-9b26-56204de72aed ");
        System.out.println(article);
    }

    /**
     * 插入分类数据
     */
    @Test
    public void insertCategory() {
        DataBaseUtils.update("insert into t_category set category_name = ?", "连载小说");
        DataBaseUtils.update("insert into t_category set category_name = ?", "编程代码类");
        DataBaseUtils.update("insert into t_category set category_name = ?", "生活感悟");
    }

    /**
     * 获取分类列表
     */
    @Test
    public void getCategoryList() {
//        String sql = "select * from t_category where 1 = 1";
//        List list = DataBaseUtils.queryForList(sql);
//        System.out.println(list);
        ArticleService ArticleService = new ArticleService();
        List list = ArticleService.getArticlesByCategoryId(2, 0, 10);
        System.out.println(list);
    }
}

