<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${ctx}/css/backgroundimg.css"/>
    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/popper.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
</head>

<body>
<%--设置背景图片--%>
<div class="divbg"><img class="image" src="${ctx}/image/user-bg.jpg" /></div>

<div class="container">
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <td width="30%" class="font-weight-bold">用户组ID</td>
            <td width="10%" class="font-weight-bold">用户组Name</td>
            <td width="10%" class="font-weight-bold">用户组Type</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="group" items="${groups}">
            <tr>
                <td>${group.id}</td>
                <td>${group.name}</td>
                <td>${group.type}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
    
</body>
</html>
