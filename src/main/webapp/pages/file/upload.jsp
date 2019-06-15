<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE HTML>
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

<br/>
<div class="container">
    <h2>上传文件</h2>
    <br/>
    <form action="${ctx}/uploadfile" enctype="multipart/form-data" method="post">
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text">上传用户：</span>
            </div>
            <input class="form-control" type="text" name="uploader" value="${sessionScope.user.id}" readonly="readonly">
        </div>
        <br/>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text">所属小组：</span>
            </div>
            <input class="form-control" type="text" name="groupId" value="${sessionScope.userVO.groupId}" readonly="readonly">
        </div>
        <br/>

        选择分区：<label class="radio-inline"><input type="radio" name="type" value="0">公司文件</label>
        <label class="radio-inline"><input type="radio" name="type" value="1">小组文件</label><br>
        选择分类： <label class="radio-inline"><input type="radio" name="fileClass" value="base">基础知识</label>
        <label class="radio-inline"><input type="radio" name="fileClass" value="company">公司架构</label>
        <label class="radio-inline"><input type="radio" name="fileClass" value="log">生产日志</label><br/>
        <input type="file" name="file" class="form-control input-large" enctype="multipart/form-data" style="display: none"/><br/>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <button class="btn btn-outline-dark" type="button" onclick="$('input[name=file]').click();">选择文件：</button>
            </div>
            <input id="showfilename" type="text" class="form-control" placeholder="选择要上传的文件">
        </div>

        <input type="submit" class="btn btn-outline-info" style="margin-left: 94.5%" value="提交">
    </form>
</div>

<script type="text/javascript">
    $('input[name=file]').change(function() {
        $('#showfilename').val($(this).val());
    });
</script>
</body>
</html>
