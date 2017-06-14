<%--
  Created by IntelliJ IDEA.
  User: Fengunion
  Date: 2017/6/14
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,com.feng.bean.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        out.print("-1");
        return;
    }
    String txt = request.getParameter("txt").toString();
    System.out.println(txt);
%>
