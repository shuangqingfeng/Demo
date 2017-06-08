<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="common/taglib.jsp" %>
<html>
<head>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>登陆页面</title>

</head>
<body>


<!-- 展示信息 -->


<!-- 登陆框 -->
<div class='content'>
    <div class='logo'>用户登录</div>
    <div class='inputBox mt50 ml32'>
        <input type="text" id="username" autofocus="autofocus" autocomplete="off" maxlength="60"
               placeholder="请输入账号/邮箱/手机号">
    </div>
    <div class='inputBox mt50 ml32'>
        <input type="password" id="password" autofocus="autofocus" autocomplete="off" maxlength="60"
               placeholder="请输入密码">
    </div>

    <div class='mt50 ml32'>
        <button class="login_btn" onclick="login()">登陆</button>
    </div>
</div>

<script type="text/javascript">
    function login() {
        var username = $('#username').val();
        var password = $('#password').val();
//        alert(username + "-----" + password);
        $.ajax({
            type: "post",
            url: "<%=basePath%>/controller/loginController.jsp",
            data: {"username": username, "password": password},
            error: function () {
                alert("登录出错");
            },
            success: function (data) {
                if (data == -1) {
                    alert("用户名和密码不能为空！");
                } else if (data == -2) {
                    alert("用户名不存在");
                } else if (data == -3) {
                    alert("用户名或密码错误");
                } else {
                    window.location.href = "<%=basePath%>";
                }
            }
        });
    }

</script>

</body>
</html>