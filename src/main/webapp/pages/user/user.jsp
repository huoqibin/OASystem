<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
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
                <td width="20%" class="font-weight-bold">姓名</td>
                <td width="10%" class="font-weight-bold">年龄</td>
                <td width="15%" class="font-weight-bold">用户组</td>
                <td width="30%" class="font-weight-bold">邮箱</td>
                <td width="25%" class="font-weight-bold">操作</td>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
                <td>${user.groupName}</td>
                <td>${user.email}</td>
                <td>
                    <a href="${ctx}/pages/user/managerupdate.jsp?userId=${user.userId}" class="btn btn-outline-info">更新</a>
                    <a href="${ctx}/resetpasswd/${user.userId}" class="btn btn-outline-warning">重置</a>
                    <a href="${ctx}/deleteuser/${user.userId}" class="btn btn-outline-danger">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div style="width: 80px;position: fixed;bottom: 40px;right: 30px;font-size:30px;z-index: 100;">
    <a  class="btn btn-primary" href="${ctx}/querygrouplist">添加<br/>用户</a>
</div>

</body>
</html>
