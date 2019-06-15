<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${ctx}/css/backgroundimg.css"/>
    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/popper.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>

    <style>
        #div2{
            width:700px;
            height:300px;
            position:absolute;
            left:30%;
            top:30%;
            margin:-100px 0 0 -100px;
            z-index:1;
        }
    </style>
</head>

<body>
<%--设置背景图片--%>
<div class="divbg"><img class="image" src="${ctx}/image/user-bg.jpg" /></div>
<div id="div2">
    <img src="${ctx}/image/message.png" style="height: 100px;width: 100px;vertical-align:middle"/><h1 style="text-align: center"><b>${message}</b></h1>
</div>
</body>
</html>
