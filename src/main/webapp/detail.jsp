<%--
  Created by IntelliJ IDEA.
  User: Fengunion
  Date: 2017/6/13
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,com.feng.service.ArticleService,com.feng.service.CommentService" %>
<%@ page isELIgnored="false" %>
<%@include file="common/taglib.jsp" %>
<%ArticleService articleService = new ArticleService(); %>
<% String id = request.getParameter("id");
    Map<String, Object> map = articleService.getContentByArticleId(id);
    pageContext.setAttribute("article", map);
    System.out.println("文章:" + map);
    CommentService commentService = new CommentService();
    List<Map<String, Object>> commentByArticle = commentService.getCommentByArticleId(id);
    pageContext.setAttribute("comments", commentByArticle);
    System.out.println(id);
    System.out.println("评论内容：" + commentByArticle);
%>

<html>
<head>
    <title>文章详情</title>
    <script src="${basePath}/static/js/jQuery.js"></script>
    <link rel="stylesheet" type="text/css" href="${basePath}/static/css/public.css"/>
    <style>
        .wrap {
            margin: 20px auto;
            width: 1000px;
        }

        .left {
            width: 70%;
            float: left;
        }

        .article {
            font-family: 微软雅黑;
            line-height: 30px;
        }

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

        .wrap hr {
            opacity: 0.6;
            margin-bottom: 30px;
        }

        .article .content p {
            text-indent: 0em;
            margin-bottom: 20px;
            font-family: 微软雅黑;
        }

        .commentBox .comment_input {
            width: 100%;
            height: 70px;
            padding: 9px;
            border: 1px solid #d0d5d9;
            box-shadow: inset 1px 1px 5px #ccc;
        }

        .commentBox .button {
            width: 90px;
            height: 28px;
            line-height: 26px;
            border: 1px solid #1e80c2;
            background: #3498db;
            color: #fff;
            cursor: pointer;
            border-radius: 2px;
            transition: all 0.3s ease;
            float: right;
            margin: 19px;
            margin-right: -22px;
        }

        .right {
            width: 30%;
            float: right;
            text-align: right;
        }

        .clearfix {
            clear: both;
        }

        .header_pic {
            position: relative;
            top: 18px;
            left: -16px
        }

        .comment_word p {
            text-indent: 8px;
            font-family: 微软雅黑;
        }

        code {
            font-size: 20px;
        }
    </style>
</head>
<body>

<!-- 头部页面 -->
<%@include file="common/header.jsp" %>
<!-- 内容区 -->

<div class='wrap'>
    <div class='left'>
        <!-- 内容区 -->
        <div class='article'>
            <div class='title'>${article.name}</div>
            <div class='category'><span class='light-font'>分类：</span><span class='info'>${article.category_name}</span>
            </div>
            <div class='publicDate'><span class='light-font'>发布时间：</span><span
                    class='info'>${article.create_time}</span></div>
            <hr/>
            <div class='content'>
                ${article.content}

            </div>
        </div>

        <!-- 评论区 -->
        <div class='commentBox'>
            <textarea class="comment_input" id="commenttxt" placeholder="请输入评论信息(600)..." maxlength="600"></textarea>
            <input type="button" value="保存评论" class="button">
        </div>
        <div class='clearfix'></div>
        <br/>
        <hr/>
        <div class='mb64' class="comment_list">
            <c:forEach items="${comments}" var="comment">
             <div class="comment_infor clearfix">
                <div style='border-bottom:1px solid #ccc' class="comment_word">
                    <p style='border-bottom:20px solid #fff'>${comment.username}说：</p>
                    <p class='mb32'>${comment.content}</p>
                </div>
            </div>
            </c:forEach>
        </div>

    </div>


    <div class='right mt32'>
        <div class='author'>
            <img src='${basePath}/images/avatar.jpg' class='header_pic' width='90' height='90'></img>
            作者：${article.author}
        </div>
    </div>


</div>

<div class='clearfix'></div>

<%@include file="common/footer.jsp"%>

<script>
    $(".button").eq(0).on("click", function () {
        var txt = $("#commenttxt").val();
        $.ajax({
            type: "post",
            url: "<%=basePath%>/controller/commentController.jsp",
            data: {"txt": txt, "articleId": "${article.id}"},
            error: function () {
                alert("保存失败");
            },
            success: function (data) {
                if (data == -1) {
                    alert("请先登录");
                } else if (data == -2) {
                    alert("评论保存失败")
                } else if (data == 0) {
                    alert("保存成功")
                    location.reload();
                }
            }
        });


        <%--$.post("<%=basePath%>/controller/CommentController.jsp", {txt: txt}, function (data) {--%>
        <%--alert("haha")--%>
        <%--data = data.trim();--%>
        <%--if (data == "-1") {--%>
        <%--alert("请先登录！");--%>
        <%--}--%>
        <%--});--%>
    });


</script>
</body>
</html>
