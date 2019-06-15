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
<br/>
<%--设置背景图片--%>
<div class="divbg"><img class="image" src="${ctx}/image/user-bg.jpg" /></div>

<div class="container mx-auto">
    <h2 style="text-align: center">我的资料</h2>
    <div class="card border border-secondery mx-auto" style="width:400px">
        <img class="card-img-top" src="${ctx}/image/headphoto.png" alt="Card image" style="width:100%">
        <div class="card-body">
            <h4 class="card-title" style="text-align: center">${user.lastName}</h4>
            <p class="card-text" style="text-align: center">age：${user.age}</p>
            <p class="card-text" style="text-align: center">group：${user.groupName}</p>
            <p class="card-text" style="text-align: center">email：${user.email}</p>
            <a href="${ctx}/pages/user/updateinfo.jsp" class="btn btn-outline-info float-right">更新信息</a>
            <a href="${ctx}/pages/user/modifypd.jsp" class="btn btn-outline-info">修改密码</a>
        </div>
    </div>
    <br>
</div>

</body>

</html>
