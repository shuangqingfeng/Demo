<%--
  Created by IntelliJ IDEA.
  User: Fengunion
  Date: 2017/6/14
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,com.feng.bean.User" %>
<%@ page import="com.feng.bean.Comment" %>
<%@ page import="com.feng.service.CommentService" %>
<%
    User user = (User) session.getAttribute("user");
    System.out.println("评论控制层");
    if (user == null) {
        out.print("-1");
        return;
    }
    String txt = request.getParameter("txt").toString();
    String articleId = request.getParameter("articleId").toString();
    System.out.println(txt + "----文章id：" + articleId);
    CommentService commentService = new CommentService();
    Comment comment = new Comment();
    comment.setId(UUID.randomUUID().toString());
    comment.setUserId(user.getId());
    comment.setArticleId(articleId);
    comment.setContent(txt);
    int i = commentService.saveComment(comment);
    if (i == 0) {
        out.print("-2");
    } else {
        out.print("0");
    }

%>
