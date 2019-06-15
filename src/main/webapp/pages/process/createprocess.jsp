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
    <h2>选择你要申请的流程：</h2>
    <div class="card bg-secondary text-white">
        <div class="card-body">
            <h4 class="card-title">请假流程</h4>
            <p class="card-text">可以申请年假、事假和病假。注意：如果申请天数小于三天，经理审批；大于三天，总监审批。</p>
            <a href="${ctx}/pages/process/vacation.jsp" class="card-link btn btn-outline-light float-right" target="mainFrame">申请</a>
        </div>
    </div>
    <br/>
    <div class="card bg-light text-dark">
        <div class="card-body">
            <h4 class="card-title">报销流程</h4>
            <p class="card-text">你的所有报销申请在财务审批后会通过银行转账的形式返还。</p>
            <a href="${ctx}/pages/process/expenseaccount.jsp" class="card-link btn btn-outline-dark float-right" target="mainFrame">申请</a>
        </div>
    </div>
    <br/>
    <div class="card bg-secondary text-white">
        <div class="card-body">
            <h4 class="card-title">调薪流程</h4>
            <p class="card-text">你可以发起薪资调整申请，在经过总监审批、认识审批和老板审批后调整薪资。</p>
            <a href="${ctx}/pages/process/salaryadjust.jsp" class="card-link btn btn btn-outline-light float-right" target="mainFrame">申请</a>
        </div>
    </div>
    <br/>
    <div class="card bg-light text-dark">
        <div class="card-body">
            <h4 class="card-title">用印流程</h4>
            <p class="card-text">你可以通过该流程申请公司印章，需要经过总监和人事审批。</p>
            <a href="${ctx}/pages/process/stamp.jsp" class="card-link btn btn-outline-dark float-right" target="mainFrame">申请</a>
        </div>
    </div>
</div>

</body>
</html>