<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../commons/taglibs.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
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
            <td width="30%" class="font-weight-bold">公告标题</td>
            <td width="10%" class="font-weight-bold">发布时间</td>
            <td width="10%" class="font-weight-bold">操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="notice" items="${noticelist}">
            <tr>
                <td>${notice.title}</td>
                <td>${notice.date}</td>
                <td><a href="${ctx}/deletenotice/${notice.id}" class="btn btn-outline-danger">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
