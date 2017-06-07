<%--
  Created by IntelliJ IDEA.
  User: Fengunion
  Date: 2017/5/26
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div id="gloobal">
    <h4>创建成功</h4>
    <p>
    <h5>详情：</h5>
    ID:${user.id}<br/>
    姓名：${user.name}<br/> 年龄：${user.age}<br/> 密码：${user.pwd}<br/> 创建日期：${user.creatTime}
    </p>
</div>
</body>
</html>