<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/popper.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
</head>

<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="#">
        <img src="${ctx}/image/logo.png" alt="logo" class="rounded-circle" style="width:30px;">
    </a>

    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="#">${sessionScope.user.lastName}</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${ctx}/pages/help.jsp" target="_blank" class="white underline">帮助</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${ctx}/logout" target="_parent" class="white underline">退出</a>
        </li>
    </ul>
</nav>
    
</body>
</html>
