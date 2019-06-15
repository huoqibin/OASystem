<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/popper.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="${ctx}/css/component.css" />
    <script>
        function notifyme(){
            alert("请联系HR重置密码！");
        }
    </script>
</head>
<body>
<div style="width: 65px;position: fixed;bottom: 25px;right: 25px;font-size:25px;z-index: 100;">
    <a onclick="notifyme();" href="#">忘记<br/>密码</a>
</div>

<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h1 style="text-align: center"><big>欢迎登录OA系统</big></h1>
                <br/>
                <form action="${ctx}/main" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="userId" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="text" autocomplete="off" placeholder="请输入账户" required>
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="passwd" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码" required>
                    </div>
                    <%--<input class="form-check-input" type="checkbox" id="remember"> 7天免登录--%>
                    <div class="mb2"><button type="submit" class="act-but submit" style="width: 100%">登录</button></div>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="${ctx}/js/TweenLite.min.js"></script>
<script src="${ctx}/js/EasePack.min.js"></script>
<script src="${ctx}/js/rAF.js"></script>
<script src="${ctx}/js/demo-1.js"></script>

<!--Cookie-->
　　<script type="text/javascript">
    $(document).ready(function () {
        $("#userId").focus();    //页面刷新，聚焦用户ID输入框
        //如果勾选--记住用户名和密码，如果取消--删除用户名和密码
        $('#remebers').click(function () {
            if ($("#userId").val() == "") {alert("用户名不能为空！");}
            if ($("#passwd").val() == "") {alert("密码不能为空！");}
            else {
                if ($('#remeber').attr("checked")) {
                    setCookie("userId", $("#userId").val(), 60);
                    setCookie("passwd", $("#passwd").val(), 60);
                }
                else {
                    delCookie("userId");
                    delCookie("passwd");
                }
            }
        });
        //页面刷新时如果能够获取cookie，填充
        if (getCookie("userId") != null)
        {
            $('#remeber').attr("checked", "checked");
            $('#userId').val(getCookie("userId"));
            $('#passwd').val(getCookie("passwd"));
        }
    })

    //写cookies
    function setCookie(key, value) {
        var Days = 7;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
        document.cookie = key + "=" + escape(value) + ";expires=" + exp.toGMTString();
    }
    //读取cookies
    function getCookie(key) {
        var arr, reg = new RegExp("(^| )" + key + "=([^;]*)(;|$)");
        if (arr = document.cookie.match(reg)) return unescape(arr[2]);
        else return null;
    }
    //删除cookies
    function delCookie(key) {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval = getCookie(key);
        if (cval != null) document.cookie = key + "=" + cval + ";expires=" + exp.toGMTString();
    }
</script>
</body>
</html>