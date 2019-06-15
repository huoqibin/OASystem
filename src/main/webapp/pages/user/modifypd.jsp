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

<div class="mx-auto" style="width: 50%; margin-top: 50px">
    <form method="post" action="${ctx}/modifypasswd" class="mx-auto" style="margin-top: 50px">
        <div class="container">
            <h2>更新密码</h2>
            <table class="table">
                <tbody>
                <tr>
                    <td>原密码：</td>
                    <td><input type="password" class="form-control" id="oldpasswd" name="oldpasswd"></td>
                </tr>
                <tr>
                    <td>新密码：</td>
                    <td><input type="password" class="form-control" id="passwd" name="passwd"></td>
                </tr>
                <tr>
                    <td>再输一次新密码：</td>
                    <td><input type="password" class="form-control" id="newpasswd" name="newpasswd"></td>
                </tr>
                </tbody>
            </table>
            <button type="submit" class="btn btn-outline-info" style="margin-left: 83.5%">确认修改</button>
        </div>
    </form>
</div>

</body>
</html>
