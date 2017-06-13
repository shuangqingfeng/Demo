<%--
  Created by IntelliJ IDEA.
  User: Fengunion
  Date: 2017/6/12
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    session.removeAttribute("username");
    session.invalidate();
    String contextPath = request.getContextPath();
    int serverPort = request.getServerPort();
    String basePath = null;
    if (serverPort == 80) {
        basePath = request.getScheme() + "://" + request.getServerName() + contextPath;
    } else {
        basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath;
    }
    response.sendRedirect(basePath+"/login.jsp");
%>