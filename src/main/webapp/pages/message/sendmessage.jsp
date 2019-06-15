<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<div class="container">
    <br/>
    <h2>发送消息/发布公告</h2>
    <form method="post" action="${ctx}/sendmessage">
        <div class="form-group">
            <label for="sender">发布方：</label>
            <input class="form-control" id="sender" name="sender" value="${sessionScope.user.id}" readonly="readonly"/>
        </div>
        <div class="form-group">
            <label for="title">标题：</label>
            <input class="form-control" id="title" name="title"/>
        </div>
        <div class="form-group">
            <label for="type">消息类型:</label>
            <select class="form-control" id="type" name="type">
                <option value="1">私人消息</option>
                <option value="2">小组消息</option>
                <c:if test="${sessionScope.userVO.groupId == 'bossGroup'}">
                    <option value="3">公告</option>
                </c:if>
            </select>
        </div>
        <div class="form-group">
            <label for="receiver">接收方（公告不填）：</label>
            <div class="input-group mb-3">
                <input class="form-control" id="receiver" name="receiver"/>
                <div class="input-group-prepend">
                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">
                        通讯录
                    </button>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="content">内容:</label>
            <textarea class="form-control" rows="3" id="content" name="content"></textarea>
        </div>
        <button type="submit" class="btn btn-outline-info" style="margin-left: 94.5%">发送</button>
    </form>


    <!-- 模态框 -->
    <div class="modal fade" id="myModal">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <!-- 模态框主体 -->
                <div class="modal-body">
                    <table class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <td width="25%" class="font-weight-bold">姓名</td>
                            <td width="15%" class="font-weight-bold">ID</td>
                            <td width="10%" class="font-weight-bold">年龄</td>
                            <td width="15%" class="font-weight-bold">用户组</td>
                            <td width="30%" class="font-weight-bold">邮箱</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.lastName}</td>
                                <td>${user.userId}</td>
                                <td>${user.age}</td>
                                <td>${user.groupId}</td>
                                <td>${user.email}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function(){

        $("#type").change(function(){
            var i = $('#type option:selected').val();//选中的值
            if(i==3) $("#receiver").attr("readonly","readonly");
        });
    });
</script>
</body>
</html>
