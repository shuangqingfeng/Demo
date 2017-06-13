<%--
  Created by IntelliJ IDEA.
  User: Fengunion
  Date: 2017/6/5
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String path = request.getContextPath();
    int port = request.getServerPort();
    String basePath = null;
    if (port == 80) {
        basePath = request.getScheme() + "://" + request.getServerName() + path;
    } else {
        basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    }
    System.out.println(basePath + "-------------");
    request.setAttribute("basePath", basePath);
%>