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
        <li class="nav-item">
           <a class="nav-link btn-outline-secondary" href="${ctx}/querytasks">待办的任务</a>
         </li>
        <li class="nav-item">
            <a class="nav-link btn-outline-secondary" href="${ctx}/queryassigneetasks">受理的任务</a>
        </li>
    </ul>
<div class="container">
    <br/>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>标题</th>
            <th>申请时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td>${task.title}</td>
                <td>${task.requestDate}</td>
                <td>
                    <c:if test="${taskType == 'candidate'}">
                        <a href="${ctx}/receiveTask/${task.taskId}" class="btn btn-outline-success">领取</a>
                    </c:if>
                    <c:if test="${taskType == 'assignee'}">
                        <a href="${ctx}/getprocessinfo/${task.taskId}" class="btn btn-outline-success">办理</a>
                    </c:if>
                    <a href="${ctx}/pages/process/diagram.jsp?processInstanceId=${task.processInstanceId}" class="btn btn-outline-info">查看</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>

</html>