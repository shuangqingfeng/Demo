package com.feng.Test;

import com.feng.bean.Comment;
import com.feng.service.CommentService;
import com.feng.util.DataBaseUtils;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by Fengunion on 2017/6/14.
 */
public class TestComment {
    @Test
    public void insertComment(){
        CommentService cs = new CommentService();
        Comment comment = new Comment();
        comment.setId(UUID.randomUUID().toString());
        comment.setContent("很不错的文章，赞一个！");
        comment.setArticleId("641f806b-719e-4420-b453-fa3010a11855");
        comment.setUserId("2bba8212-b70e-45a2-87f3-b9542c1b7d30");
        cs.saveComment(comment);
        System.out.println("保存成功！");
        System.out.println(DataBaseUtils.queryForList("select a.content from t_comment a left JOIN t_user b "
                + "on a.user_id = b.id where a.article_id = '641f806b-719e-4420-b453-fa3010a11855'"));
    }
}
