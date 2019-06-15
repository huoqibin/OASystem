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
    <h2>请假申请</h2>
    <p>可以申请年假、事假和病假。注意：如果申请天数小于三天，经理审批；大于三天，总监审批。</p>
    <form method="post" action="${ctx}/startvacation">
        <div class="form-group">
            <label for="userId">请假人ID：</label>
            <input class="form-control" id="userId" name="userId" value="${sessionScope.user.id}" readonly="readonly"/>
        </div>
        <div class="form-group">
            <label for="userName">请假人姓名：</label>
            <input class="form-control" id="userName" name="userName" value="${sessionScope.user.lastName}" readonly="readonly"/>
        </div>
        <div class="form-group input-append date form_datetime">
            <label for="startDate">开始日期：</label>
            <input class="form-control" id="startDate" name="startDate" autocomplete="off" required/>
        </div>
        <div class="form-group input-append date form_datetime">
            <label for="endDate">结束日期：</label>
            <input class="form-control" id="endDate" name="endDate" autocomplete="off" required/>
        </div>
        <div class="form-group">
            <label for="days">请假天数：</label>
            <input class="form-control" id="days" name="days" autocomplete="off" required/>
        </div>
        <div class="form-group mx-auto">
            <label class="radio-inline"><input type="radio" value="0" name="vacationType" required>年假</label>
            <label class="radio-inline"><input type="radio" value="1" name="vacationType" required>事假</label>
            <label class="radio-inline"><input type="radio" value="2" name="vacationType" required>病假</label>
        </div>
        <div class="form-group">
            <label for="reason">原因:</label>
            <textarea class="form-control" rows="3" id="reason" name="reason" required></textarea>
        </div>
        <button type="submit" class="btn btn-outline-info float-right">提交</button>
    </form>
</div>

<script>
    $(function () {

        var picker1 = $('#startDate').datetimepicker();
        var picker2 = $("#endDate").datetimepicker();

        //动态设置最小值(选择前面一个日期后：后面一个日期不能小于前面一个)
        picker1.on('changeDate', function (e) {
            picker2.datetimepicker('setStartDate', e.date);
        });
        //动态设置最大值(选择后面一个日期后：前面一个日期不能大于前面一个）
        picker2.on('changeDate', function (e) {
            picker1.datetimepicker('setEndDate', e.date);
        });
    });

</script>
</body>
</html>
