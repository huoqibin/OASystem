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

<ul class="nav nav-tabs nav-justified">
    <li class="nav-item">
        <a class="nav-link btn-outline-secondary" href="${ctx}/getcompanyfile/1">公司文件</a>
    </li>
    <li class="nav-item">
        <a class="nav-link btn-outline-secondary" href="${ctx}/getgroupfile/1">小组文件</a>
    </li>
</ul>
<br/>
<div class="container">
    <div class="mx-auto" style="width: 60%">
        <form class="form-inline" method="post" action="${ctx}/selectfile">
            <input type="hidden" name="currentType" value="${currentTpye}"/>
            <label for="fileClass">分类:</label>
            <input type="text" class="form-control" id="fileClass" name="fileClass" placeholder="base/company/log">
            &nbsp;&nbsp;&nbsp;&nbsp;
            <label for="keyWord">关键字:</label>
            <input type="text" class="form-control" id="keyWord" name="keyWord" placeholder="如：Java">
            &nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-outline-info">查找</button>
        </form>
    </div>
    <br/>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>文件名</th>
            <th>上传者</th>
            <th>分类</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <!-- 遍历Map集合 -->
        <c:forEach var="file" items="${fileList}">
            <tr>
                <td>${file.fileShowName}</td>
                <td>${file.fileUploader}</td>
                <td>${file.fileClass}</td>
                <td>${file.fileCreatetime}</td>
                <td>
                    <a href="${ctx}/downloadfile/${file.fileRealName}" class="btn btn-outline-success">下载</a>
                    <a href="${ctx}/deletefile/${file.fileRealName}" class="btn btn-outline-danger">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <%--分页--%>
    <div class="mx-auto" style="width: 40%">
         <ul class="pagination" >
             <c:if test="${currentTpye == 0}">
                 <c:if test="${page.startPage>=1}">
                     <li class="page-item"><a class="page-link" href="${ctx}/getcompanyfile/${page.startPage-1}">上一页</a></li>
                     <li class="page-item"><a class="page-link" href="${ctx}/getcompanyfile/${page.startPage-1}">${page.startPage-1}</a></li>
                 </c:if>
                 <li class="page-item"><a class="page-link" href="#" data-toggle="tooltip" title="当前为第${page.startPage}页,总${page.fullPage}页!">${page.startPage}</a></li>
                 <c:if test="${page.startPage <= page.fullPage}">
                     <li class="page-item"><a class="page-link" href="${ctx}/getcompanyfile/${page.startPage+1}">${page.startPage+1}</a></li>
                     <li class="page-item"><a class="page-link" href="${ctx}/getcompanyfile/${page.startPage+1}">下一页</a></li>
                 </c:if>
             </c:if>
             <c:if test="${currentTpye == 1}">
                 <c:if test="${page.startPage>=1}">
                     <li class="page-item"><a class="page-link" href="${ctx}/getgroupfile/${page.startPage-1}">上一页</a></li>
                     <li class="page-item"><a class="page-link" href="${ctx}/getgroupfile/${page.startPage-1}">${page.startPage-1}</a></li>
                 </c:if>
                 <li class="page-item"><a class="page-link" href="#" data-toggle="tooltip" title="当前为第${page.startPage}页,总${page.fullPage}页!">${page.startPage}</a></li>
                 <c:if test="${page.startPage <= page.fullPage}">
                     <li class="page-item"><a class="page-link" href="${ctx}/getgroupfile/${page.startPage+1}">${page.startPage+1}</a></li>
                     <li class="page-item"><a class="page-link" href="${ctx}/getgroupfile/${page.startPage+1}">下一页</a></li>
                 </c:if>
             </c:if>
         </ul>
    </div>
</div>

<script>
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>
</body>
</html>
