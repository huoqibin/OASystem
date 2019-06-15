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
    <link href="${ctx}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
    <script src="${ctx}/js/bootstrap-datetimepicker.js"></script>
    <script src="${ctx}/js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script>
        $.fn.datetimepicker.defaults = {
            //默认语言
            language: 'zh-CN',
            //默认选择格式
            format: "yyyy-mm-dd hh:ii:ss",
            autoclose: true,
            todayBtn: true,
            //选择板所在输入框位置
            pickerPosition: "bottom-top"
        };
    </script>
</head>

<body>
<%--设置背景图片--%>
<div class="divbg"><img class="image" src="${ctx}/image/user-bg.jpg" /></div>

<br/>
<div class="container">
    <h2>用印申请</h2>
    <p>你可以通过该流程申请公司印章，需要经过总监和人事审批。</p>
    <form method="post" action="${ctx}/startstamp">
        <div class="form-group">
            <label for="userId">申请人ID：</label>
            <input class="form-control" id="userId" name="userId" value="${sessionScope.user.id}" readonly="readonly"/>
        </div>
        <div class="form-group">
            <label for="userName">申请人姓名：</label>
            <input class="form-control" id="userName" name="userName" value="${sessionScope.user.lastName}" readonly="readonly"/>
        </div>
        <div class="form-group input-append date form_datetime">
            <label for="date">使用日期：</label>
            <input class="form-control" id="date" name="date" autocomplete="off" required/>
        </div>
        <div class="form-group">
            <label for="reason">原因:</label>
            <textarea class="form-control" rows="3" id="reason" name="reason" required></textarea>
        </div>
        <button type="submit" class="btn btn-outline-info float-right">提交</button>
    </form>
</div>

</body>
<script>
    $(function () {
        var picker1 = $('#date').datetimepicker();
        var picker2  = new Date();

        //动态设置最小值(选择前面一个日期后：后面一个日期不能小于前面一个)
        picker1.on('changeDate', function (e) {
            picker2.datetimepicker('setStartDate', e.date);
        });
    });

</script>
</html>
