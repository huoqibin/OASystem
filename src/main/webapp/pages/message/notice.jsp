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
    <c:forEach items="${noticelist}" var="notice">
        <br/>
        <div class="jumbotron">
            <h1 style="text-align: center">${notice.title}</h1>
            <p>${notice.content}</p>
            <p style="text-align: center">发布人：<kbd>${notice.sender}</kbd>，于${notice.date}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>
