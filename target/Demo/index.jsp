<%--
  Created by IntelliJ IDEA.
  User: Fengunion
  Date: 2017/4/14
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include  file="common/taglib.jsp"%>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <title>首页</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            font-family: "微软雅黑";
        }

        .header {
            height: 60px;
            background: #458fce;
        }

        .header .logo {
            color: #ffffff;
            font-size: 30px;
            margin-left: 20px;
            display: inline-block;
            font-weight: 100;
            height: 60px;
            line-height: 60px;
        }

        .   header ul {
            display: inline-block;
        }

        .header ul li.first {
            margin-left: 30px;
        }

        .header ul li {
            float: left;
            list-style: none;
            display: inline-block;
            color: #fff;
            text-align: center;
            width: 112px;
            cursor: pointer;
        }

        a {
            color: #ffffff;
            text-decoration: none;
        }

        .header ul li:hover {
            background: #74b0e2;
        }

        .header .login {
            float: right;
            color: #ffffff;
            line-height: 60px;
            margin-right: 20px;
        }

        ul li {
            list-style: none;
        }

        .banner {
            height: 400px;
            margin-top: 2px;
            overflow: hidden;
        }

        .banner {
            height: 360px;
            margin-top: 2px;
            overflow: hidden;
        }

        .banner .content {
            width: 1060px;
            height: 360px;
            margin: 20px auto;
            position: relative;
        }

        .banner ul li img {
            width: 1024px;
            height: 360px;
        }

        .banner .content ul {
            width: 10000px;

        }

        .btn_left, .btn_right {
            display: inline-block;
            width: 21px;
            height: 150px;
            background: url(/images/banner_tb.png) no-repeat;
            position: absolute;
            left: 38px;
            top: 90px;

        }

        .btn_right {
            background-position: 29px 0;
            position: absolute;
            left: 1000px;
            top: 90px;
        }

        .banner_left, .banner_right {
            width: 160px;
            height: 360px;
            display: inline-block;
            position: absolute;
            background: #7fa5ea;
            left: -160px;
            top: 0;
            opacity: 0.6;
        }

        .banner_right {
            width: 200px;
            height: 360px;
            display: inline-block;
            position: absolute;
            background: #7fa5ea;
            left: 1023px;
            top: 0;
            opacity: 0.6;
        }

        .btn_left, .btn_right {
            display: inline-block;
            width: 21px;
            height: 150px;
            background: url(images/banner_tb.png) no-repeat 0 center;
            position: absolute;
            left: 120px;
            top: 112px;
            opacity: 0;
            transition: all ease 0.6s;
            cursor: pointer;
        }

        .btn_right {
            background-position: -29px 0;
            position: absolute;
            left: 16px;
            top: 112px;
        }

        .banner .content:hover .btn_left {
            opacity: 1;
        }

        .banner .content:hover .btn_right {
            opacity: 1;
        }

    </style>
</head>
<body>
<%@include file="common/header.jsp" %>
<%--<div class="header">
    <div class="logo">原创文字</div>
    <ul>
        <li class="first">首页</li>
        <li><a href="javascript:void(0)"></a>原创故事</li>
        <li><a href="javascript:void(0)"></a>热门专题</li>
        <li><a href="javascript:void(0)"></a>欣赏美文</li>
        <li><a href="javascript:void(0)"></a>赞助</li>
    </ul>
    <div class='login'>
        <c:choose>
            <c:when  test="${empty sessionScope.username}">
                <span><a href="login.jsp">登陆</a></span>
                <span>|</span>
                <span><a href="javascript:void(0)">注册</a></span>
            </c:when>
            <c:otherwise>
                <span><a href="javascript:void(0)">欢迎您，${sessionScope.username}</a></span>
                <span> | </span>
                <span><a href="javascript:void(0)">登出</a></span>
            </c:otherwise>
        </c:choose>
    </div>

</div>--%>
<div class="banner">
    <div class="content">
        <ul>
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
<!-- 底部页面 -->
<div class='footer'>
    免责声明：本站所有素材均来自网络，仅供学习交流。如果侵犯了您的权益，请联系我，我会第一时间删除侵权内容。
</div>
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
</script>
</body>
</html>
