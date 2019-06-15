<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../commons/taglibs.jsp"%>
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

<form method="post" action="${ctx}/updateuserinfo" class="mx-auto" style="width: 50%; margin-top: 50px">
<div class="container">
    <h2>更新个人信息</h2>
    <p>请确保信息真实有效！</p>
    <table class="table">
        <tbody>
        <tr>
            <td>用户组：</td>
            <td><input class="form-control"  name="groupName" type="text" value="${sessionScope.userVO.groupName}" readonly="readonly"/></td>
        </tr>
        <tr>
            <td>职位：</td>
            <td><input class="form-control"  name="position" type="text" value="${sessionScope.userVO.position}" readonly="readonly"/></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input class="form-control"  name="age" type="text" /></td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td><input class="form-control"  name="email" type="text" /></td>
        </tr>
        </tbody>
    </table>
    <button type="submit" class="btn btn-outline-info" style="margin-left: 83.5%">确认修改</button>
</div>
</form>

</body>
</html>
