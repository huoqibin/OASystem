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

<br/>
<div class="container">
    <h2>添加用户</h2>
    <form method="post" action="${ctx}/adduser">
        <div class="form-group">
            <label for="lastName">姓名:</label>
            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="输入姓名">
        </div>
        <div class="form-group">
            <label for="passwd">密码:</label>
            <input type="password" class="form-control" id="passwd" name="passwd" placeholder="输入密码">
        </div>
        <label for="groupId">用户组:</label>
        <select class="form-control" id="groupId" name="groupId">
            <c:forEach var="group" items="${groups}">
                <option value="${group.id}">${group.id}</option>
            </c:forEach>
        </select>
        <div class="form-group">
            <label for="age">年龄:</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="输入年龄">
        </div>
        <div class="form-group">
            <label for="email">邮箱:</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="输入邮箱">
        </div>
        <div class="form-group">
            <label for="position">职位:</label>
            <input type="text" class="form-control" id="position" name="position" placeholder="输入职位">
        </div>
        <button type="submit" class="btn btn-primary">确认添加</button>
    </form>
</div>

</form>
</body>
</html>
