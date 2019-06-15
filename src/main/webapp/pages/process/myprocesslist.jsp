<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html>
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

<ul class="nav nav-tabs nav-justified">
    <li class="nav-item"><a class="nav-link btn-outline-secondary" href="${ctx}/queryvacationlist">请假申请</a></li>
    <li class="nav-item"><a class="nav-link btn-outline-secondary" href="${ctx}/queryexpenseaccount">报销申请</a></li>
    <li class="nav-item"><a class="nav-link btn-outline-secondary" href="${ctx}/querysalaryadjust">调薪申请</a></li>
    <li class="nav-item"><a class="nav-link btn-outline-secondary" href="${ctx}/querystamp">用印申请</a></li>
</ul>

<br/>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>标题</th>
            <th>创建时间</th>
            <th>流程图</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="pro" items="${processes}">
            <tr>
                <td>${pro.title}</td>
                <td>${pro.requestDate}</td>
                <td><a class="btn btn-outline-success" href="${ctx}/pages/process/diagram.jsp?processInstanceId=${pro.id}">查看</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>

</html>

