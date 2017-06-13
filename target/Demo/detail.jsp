<%--
  Created by IntelliJ IDEA.
  User: Fengunion
  Date: 2017/6/13
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,com.feng.service.ArticleService" %>
<%@ page isELIgnored="false"%>
<%ArticleService articleService = new ArticleService(); %>
<% String id = request.getParameter("id");
    List<Map<String, Object>> contentByArticleId = articleService.getContentByArticleId(id);
    pageContext.setAttribute("article", contentByArticleId);
    System.out.println(id);%>
<html>
<head>
    <title>Title</title>
    <style>
        .article .title {
            text-align: center;
            font-size: 28px;
            color: #565353;
            letter-spacing: 2px;
            margin-top: 20px;
        }

        .article .light-font {
            font-size: 14px;
            color: #666;
        }

        .article .info {
            font-size: 14px;
            color: #3c3a3a;
        }

        .article .content p {
            text-indent: 2em;
            margin-bottom: 20px;
            font-family: 微软雅黑;
        }
    </style>
</head>
<body>
<!-- 内容区 -->

<div class='article'>
    <div class='title'>${article.name}</div>
    <div class='category'><span class='light-font'>分类：</span><span class='info'>${article.category_name}</span></div>
    <div class='publicDate'><span class='light-font'>发布时间：</span><span class='info'>${article.create_time}</span></div>
    <hr/>
    <div class='content'>
        ${article.content}

    </div>
    <div class="right mt32">
        <div class="author">
            <img src="images/avatar.jpg" class="header_pic" width="90" height="90">
            作者：张三
        </div>
    </div>
    <div class="commentBox">
        <textarea class="comment_input" id="commenttxt" placeholder="请输入评论信息(600)..." maxlength="600"></textarea>
        <input type="button" value="保存评论" class="button">
    </div>
    <div class="clearfix"></div>
    <br/>
    <hr/>
    <div class="mb64" class="comment_list">
        <div class="comment_info clearfix">
            <div style="border-bottom:1px solid #ccc" class="comment_word">
                <p style="border-bottom: 20px solid #fff">${comment.username}dwedewffrg 说：</p>
                <p class="mb32">内容不错，感谢分享！</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
