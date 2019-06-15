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

<br/>
<div class="container">
<table class="table table-bordered table-hover">
    <thead>
    <tr>
        <th style="text-align: center">标题</th>
        <th style="text-align: center">发送人</th>
        <th style="text-align: center">发送时间</th>
        <th style="text-align: center">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${messagelist}" var="message">
        <tr>
            <td style="text-align: center">${message.title}</td>
            <td style="text-align: center">${message.sender}</td>
            <td style="text-align: center">${message.date}</td>
            <td style="text-align: center">
                <a href="${ctx}/receivemessagedetail/${message.id}" class="btn btn-outline-info">查看</a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="${ctx}/deletemessage/${message.id}" class="btn btn-outline-danger">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
