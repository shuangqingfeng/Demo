<%--
  Created by IntelliJ IDEA.
  User: Fengunion
  Date: 2017/6/19
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*,com.feng.util.*,com.feng.service.*"
         pageEncoding="UTF-8" %>
<%@ page import="com.feng.service.RegisterService" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    System.out.println("注册账号：" + username + "-----" + password);
    if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
        out.print(-1);
    } else {
        RegisterService registerService = new RegisterService();
        registerService.queryUsername("");
    }
%>

