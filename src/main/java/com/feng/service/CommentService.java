package com.feng.service;

import com.feng.bean.Comment;
import com.feng.util.DataBaseUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Fengunion on 2017/6/14.
 */
public class CommentService {

    /**
     * 保存评论
     */
    public int saveComment(Comment comment) {
        String sql = "insert into t_comment(id,user_id,content,article_id,create_time,is_delete) values(?,?,?,?,?,?)";
        int update = DataBaseUtils.update(sql, comment.getId(), comment.getUserId(), comment.getContent(), comment.getArticleId()
                , new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), 0);
        return update;
    }

    public List<Map<String, Object>> getCommentByArticleId(String id) {
        return DataBaseUtils.queryForList("select b.username ,a.content from t_comment a left JOIN t_user b "
                + "on a.user_id = b.id where a.article_id = ?", id);
    }

    public static void main(String[] args) {
        CommentService commentService = new CommentService();
        List<Map<String, Object>> commentByArticleId = commentService.getCommentByArticleId("641f806b-719e-4420-b453-fa3010a11855");
        System.out.println(commentByArticleId);
    }
}
