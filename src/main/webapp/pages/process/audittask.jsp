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
<h2>审批：</h2>
<form method="post" id="auditForm" action="${ctx}/complete">
    <input type="hidden" class="form-control" value="${taskId}" name="taskId"/>
    <table class="table table-bordered table-hover">
        <tbody>
        <c:forEach items="${formFields}" var="formField">
            <tr>
                <td>${formField.filedText}：</td>
                <td>${formField.fieldValue}</td>
            </tr>
        </c:forEach>
        <tr>
            <td width="15%" class="title1">评论：</td>
            <td class="left">
                <table>
                    <c:forEach var="comment" items="${comments}">
                        <tr>
                            <td>${comment.userName}：</td>
                        </tr>
                        <tr>
                            <td>${comment.content}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
        </tbody>
    </table>
    <div>
        <label>我的意见：</label>
        <textarea class="form-control" rows="3" id="content" name="content" required></textarea>
    </div>
    <br/>
    <button class="btn btn-outline-danger" onClick="rejectRequest()">驳回</button>
    <button type="submit" class="btn btn-outline-info float-right">同意</button>
</form>
    <br/>
    <br/>
</div>
<script>
    function rejectRequest() {
        document.getElementById("auditForm").action = "${ctx}/rejectrequest";
        document.getElementById("auditForm").submit();
    }
</script>
</body>
</html>
