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
    <h2>报销申请</h2>
    <p>你的所有报销申请在财务审批后会通过银行转账的形式返还。</p>
    <form method="post" action="${ctx}/startexpenseaccount">
        <div class="form-group">
            <label for="userId">报销人ID：</label>
            <input class="form-control" id="userId" name="userId" value="${sessionScope.user.id}" readonly="readonly"/>
        </div>
        <div class="form-group">
            <label for="userName">报销人姓名：</label>
            <input class="form-control" id="userName" name="userName" value="${sessionScope.user.lastName}" readonly="readonly"/>
        </div>
        <div class="form-group input-append date form_datetime">
            <label for="date">发生日期：</label>
            <input class="form-control" id="date" name="date" autocomplete="off" required/>
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
