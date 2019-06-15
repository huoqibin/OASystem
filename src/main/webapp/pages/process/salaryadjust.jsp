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

<br/>
<div class="container">
    <h2>调薪申请</h2>
    <p>你可以发起薪资调整申请，在经过总监审批、认识审批和老板审批后调整薪资。</p>
    <form method="post" action="${ctx}/startsalaryadjust">
        <div class="form-group">
            <label for="userId">调薪人ID：</label>
            <input class="form-control" id="userId" name="userId" value="${sessionScope.user.id}" readonly="readonly"/>
        </div>
        <div class="form-group">
            <label for="lastName">调薪人姓名：</label>
            <input class="form-control" id="lastName" name="lastName" value="${sessionScope.user.lastName}" readonly="readonly"/>
        </div>
        <div class="form-group">
            <label for="money">金额：</label>
            <input class="form-control" id="money" name="money" required/>
        </div>
        <div class="form-group">
            <label for="dscp">描述:</label>
            <textarea class="form-control" rows="3" id="dscp" name="dscp" required></textarea>
        </div>
        <button type="submit" class="btn btn-outline-info float-right">提交</button>
    </form>
</div>

</body>

</html>
