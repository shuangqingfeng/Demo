<%--
  Created by IntelliJ IDEA.
  User: Fengunion
  Date: 2017/4/14
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,com.feng.service.ArticleService" %>
<% ArticleService articleService = new ArticleService(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="common/taglib.jsp" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <script src="<%=basePath%>/static/js/jQuery.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/public.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/index.css"/>
    <style>


        .category .title {
            margin-bottom: 10px;
            border-bottom: 1px solid #cac5c5;
            height: 30px;
            text-indent: 1em;
            font-size: 18px;
            color: #666;
        }

        .category .items {
            margin-left: 10px;
        }

        .category .items .item {
            width: 230px;
            height: 320px;
            background: #ccc;
            margin: 20px;
            float: left;
            margin-right: 20px;
            cursor: pointer;
        }

        .category .items .item div {
            text-align: center;
        }

        .item-banner {
            background: #666;
            color: #FFF;
        }

        .item-header {
            font-size: 12px;
            line-height: 52px;
        }

        .item-name {
            font-size: 22px;
            line-height: 74px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        .item-author {
            font-size: 14px;
            text-indent: 7px;
            padding-bottom: 70px;
        }

        .item-description {
            background: #eee;
            height: 104px;
            line-height: 76px;
            text-indent: 3em;
            font-size: 12px;
        }
    </style>
</head>
<body>
<%@include file="common/header.jsp" %>
<div class="banner">
    <div class="content">
        <ul>
            <li class='f1'>
                <a href="javascript:void(0)">
                    <img src="/images/5.png">
                </a>
            </li>
            <li class='fl'>
                <a href="javascript:void(0)">
                    <img src="/images/1.png">
                </a>
            </li>
            <li class='f1'>
                <a href="javascript:void(0)">
                    <img src="/images/2.png">
                </a>
            </li>
            <li class='f1'>
                <a href="javascript:void(0)">
                    <img src="/images/3.png">
                </a>
            </li>
            <li class='f1'>
                <a href="javascript:void(0)">
                    <img src="/images/4.png">
                </a>
            </li>
            <li class='f1'>
                <a href="javascript:void(0)">
                    <img src="/images/5.png">
                </a>
            </li>
            <li class='f1'>
                <a href="javascript:void(0)">
                    <img src="/images/1.png">
                </a>
            </li>
        </ul>
        <%-- 按钮区--%>
        <span class='banner_left'><i class='btn_left'></i></span>
        <span class='banner_right'><i class='btn_right'></i></span>
    </div>
</div>

<div class=h1000 style="border:1px solid #ccc">
    <br/><br/>
    <div class="category">
        <div class="title">连载小说</div>
        <ul class="items">
            <li class="item">
                <div class="item-banner">
                    <div class="item-header"> 生活中总是充满了乐趣</div>
                    <div class="item-name">聊聊我的大学室友</div>
                    <div class="item-author">@张三 著</div>
                </div>
                <div class="item-description">那些回忆，那些事</div>
            </li>
            <li class="item"></li>
            <li class="item"></li>
            <div style="clear: both"></div>
        </ul>
    </div>
    <%
        //查询出编程代码类的相关文章
        List<Map<String, Object>> articles2 = articleService.getArticlesByCategoryId(2, 0, 6);
        pageContext.setAttribute("articles2", articles2);
    %>

    <div class="category">
        <div class="title">编程代码类</div>
        <ul class="items">
            <c:forEach items="${articles2}" var="item">
                <li class="item" onclick="detail('${item.id}')">
                    <div class="item-banner">
                        <div class="item-header">${item.header}</div>
                        <div class="item-name" title="${item.name}">${item.name}</div>
                        <div class="item-author">${item.author} 著</div>
                    </div>
                    <div class="item-description">${item.description}</div>
                </li>
            </c:forEach>
            <div style="clear: both"></div>
        </ul>
    </div>
</div>

<!-- 底部页面 -->
<%@include file="common/footer.jsp" %>

<script>

    var leftBtn = $('.btn_left').eq(0); //左按钮
    var rightBtn = $('.btn_right').eq(0);//右按钮

    var ul = $('.banner .content ul').eq(0);

    var index = 0;
    var timer = null;

    var imgwidth = $('.banner .content ul li').width(); //获取轮播图片的宽度
    var len = $('.banner .content ul li').length - 2//获取总共的图片数量

    //下一张
    rightBtn.on('click', function () {
        clearTimeout(timer); //定时器清零
        timer = setTimeout(function () {
            index++;
            movePicture();
        }, 500);
    });

    //上一张
    leftBtn.on('click', function () {
        clearTimeout(timer); //定时器清零
        timer = setTimeout(function () {
            index--;
            movePicture();
        }, 500);
    });

    //移动图片
    function movePicture() {
        $('.banner .content ul').animate({'margin-left': -imgwidth * (index + 1)}, 1000, function () {
            if (index == len) {
                $(this).css('margin-left', -imgwidth);
                index = 0;
            }
            if (index == -1) {
                $(this).css('margin-left', -imgwidth * len);
                index = len - 1;
            }
        });
    }
    function detail(id) {
        var a = document.createElement("a");
        a.href = "detail.jsp?id=" + id;
        console.log(a);
        a.target = "_new"
        a.click();
    }
</script>
</body>
</html>
