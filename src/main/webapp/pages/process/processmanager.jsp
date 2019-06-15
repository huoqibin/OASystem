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
</head>
<body>
<%--设置背景图片--%>
<div class="divbg"><img class="image" src="${ctx}/image/user-bg.jpg" /></div>

<div class="container">
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <td width="30%" class="font-weight-bold">流程ID</td>
            <td width="10%" class="font-weight-bold">流程名称</td>
            <td width="50%" class="font-weight-bold">Key</td>
            <td width="10%" class="font-weight-bold">流程图</td>
            <td width="10%" class="font-weight-bold">当前状态</td>
            <td width="10%" class="font-weight-bold">操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${defs}" var="def">
            <tr>
                <td>${def.id}</td>
                <td>${def.name}</td>
                <td>${def.key}</td>
                <td><a href="${ctx}/pages/process/processdefdiagram.jsp?processDefId=${def.id}" class="btn btn-outline-info">查看</a></td>
                <td>
                    <c:if test="${def.suspended == true}">
                        <a class="btn">中止</a>
                    </c:if>
                    <c:if test="${def.suspended == false}">
                        <a class="btn">激活</a>
                    </c:if>
                </td>
                <td>
                    <c:if test="${def.suspended == true}">
                        <a href="${ctx}/activateprocessdef/${def.id}" class="btn btn-outline-success">激活</a>
                    </c:if>
                    <c:if test="${def.suspended == false}">
                        <a href="${ctx}/suspendprocessdef/${def.id}" class="btn btn-outline-danger">中止</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
