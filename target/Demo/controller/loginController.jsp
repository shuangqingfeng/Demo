<%--
  Created by IntelliJ IDEA.
  User: Fengunion
  Date: 2017/6/5
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*,com.feng.service.LoginService,com.feng.util.StringUtils,com.feng.bean.*"
         pageEncoding="UTF-8" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    System.out.println(username + "-------" + password);
    if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
        out.print("-1");
    } else {
        LoginService loginService = new LoginService();
        User user = loginService.getUser(username);
        if (user == null) {
            out.print("-2");
        } else {
            if (!username.equals(user.getUsername()) || !password.equals(user.getPassword())) {
                out.print("-3");
            } else {
                session.setAttribute("user", user);
                session.setAttribute("username", user.getUsername());
            }
        }
    }


%>

