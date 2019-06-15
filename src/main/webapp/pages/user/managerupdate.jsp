<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<form method="post" action="${ctx}/managerupdate" class="mx-auto" style="width: 50%; margin-top: 50px">
    <div class="container">
        <h2>更新员工信息</h2>
        <table class="table">
            <tbody>
            <tr>
                <td>用户：</td>
                <td><input class="form-control" id="userId"  name="userId" type="text" readonly="readonly"/></td>
            </tr>
            <tr>
                <td>用户组：</td>
                <td><input class="form-control"  name="groupName" type="text"/></td>
            </tr>
            <tr>
                <td>职位：</td>
                <td><input class="form-control"  name="position" type="text"/></td>
            </tr>
            </tbody>
        </table>
        <button type="submit" class="btn btn-outline-info" style="margin-left: 83.5%">确认修改</button>
    </div>
</form>
<script>
    $(document).ready(function(){
        var userId = getUrlParam('userId');
        $("#userId").val(userId);
    });

    //获取url中的参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    };
</script>
</body>
</html>
