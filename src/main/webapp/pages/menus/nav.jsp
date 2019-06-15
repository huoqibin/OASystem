<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script src="${ctx}/js/jquery.min.js"></script>
	<script src="${ctx}/js/popper.min.js"></script>
	<script src="${ctx}/js/bootstrap.min.js"></script>
	<style>
		#cat{
			position: fixed;
			top: 85%;
			left: 0px;
			width: 100%;
			height: 100px;
		}
	</style>
</head>

<body style="background-color: #AAAAAA">
<img id="cat" src="${ctx}/image/cat.png"/>

	<div class="container">
		<div id="accordion">
			<!--个人中心-->
			<div class="card border border-bottom-0 border-top-0 border-left-0 border-right-0">
				<div class="card-header" style="text-align: center;background-color: #AAAAAA">
					<a class="card-link text-dark" data-toggle="collapse" href="#collapseOne">
						个人中心
					</a>
				</div>
				<div id="collapseOne" class="collapse show" data-parent="#accordion" style="background-color: #DDDDDD">
					<div class="card-body" style="text-align: center">
						<a href="${ctx}/getuserinfo" target="mainFrame" class="text-info"><h6>查看个人信息</h6></a>
						<a href="${ctx}/pages/user/updateinfo.jsp" target="mainFrame" class="text-info"><h6>更新个人信息</h6></a>
						<a href="${ctx}/pages/user/modifypd.jsp" target="mainFrame" class="text-info"><h6>修改密码</h6></a>
					</div>
				</div>
			</div>

			<!--流程中心-->
			<div class="card border border-bottom-0 border-top-0 border-left-0 border-right-0">
				<div class="card-header" style="text-align: center;background-color: #AAAAAA">
					<a class="collapsed card-link text-dark" data-toggle="collapse" href="#collapseTwo">
                        流程中心
					</a>
				</div>
				<div id="collapseTwo" class="collapse" data-parent="#accordion" style="background-color: #DDDDDD">
					<div class="card-body">
						<div class="list-group" style="text-align: center">
							<a href="${ctx}/pages/process/createprocess.jsp" target="mainFrame" class="text-info"><h6>创建流程</h6></a>
							<a href="${ctx}/pages/process/task.jsp" target="mainFrame" class="text-info"><h6>任务列表</h6></a>
							<a href="${ctx}/pages/process/myprocesslist.jsp" target="mainFrame" class="text-info"><h6>流程记录</h6></a>
						</div>
					</div>
				</div>
			</div>

			<!--消息中心-->
			<div class="card border border-bottom-0 border-top-0 border-left-0 border-right-0">
				<div class="card-header" style="text-align: center;background-color: #AAAAAA">
					<a class="collapsed card-link text-dark" data-toggle="collapse" href="#collapseThree">
                        消息中心
					</a>
				</div>
				<div id="collapseThree" class="collapse" data-parent="#accordion" style="background-color: #DDDDDD">
					<div class="card-body" style="text-align: center">
						<a href="${ctx}/receivemessage" target="mainFrame" class="text-info"><h6>我的消息</h6></a>
						<a href="${ctx}/receivenotice" target="mainFrame" class="text-info"><h6>公告</h6></a>
						<a href="${ctx}/getbook" target="mainFrame" class="text-info"><h6>发送消息</h6></a>
					</div>
				</div>
			</div>

			<!--文件中心-->
			<div class="card border border-bottom-0 border-top-0 border-left-0 border-right-0">
				<div class="card-header" style="text-align: center;background-color: #AAAAAA">
					<a class="collapsed card-link text-dark" data-toggle="collapse" href="#collapseFour">
                        文件中心
					</a>
				</div>
				<div id="collapseFour" class="collapse" data-parent="#accordion" style="background-color: #DDDDDD">
					<div class="card-body" style="text-align: center">
						<a href="${ctx}/getcompanyfile/1" target="mainFrame" class="text-info"><h6>文件列表</h6></a>
						<a href="${ctx}/pages/file/upload.jsp" target="mainFrame" class="text-info"><h6>上传文件</h6></a>
					</div>
				</div>
			</div>

			<!--管理员区-->
			<div class="card border border-bottom-0 border-top-0 border-left-0 border-right-0">
				<div class="card-header" style="text-align: center;background-color: #AAAAAA">
					<a class="collapsed card-link text-dark" data-toggle="collapse" href="#collapseFive">
                        管理员区
					</a>
				</div>
				<div id="collapseFive" class="collapse" data-parent="#accordion" style="background-color: #DDDDDD">
					<div class="card-body" style="text-align: center">
						<a href="${ctx}/queryalluser?group=${sessionScope.userVO.groupId}" target="mainFrame" class="text-info" id="one"><h6>员工管理</h6></a>
						<a href="${ctx}/queryallgroup?group=${sessionScope.userVO.groupId}" target="mainFrame" class="text-info" id="two"><h6>小组管理</h6></a>
						<a href="${ctx}/noticemag?group=${sessionScope.userVO.groupId}" target="mainFrame" class="text-info" id="three"><h6>公告管理</h6></a>
						<a href="${ctx}/getprocessdefinition?group=${sessionScope.userVO.groupId}" target="mainFrame" class="text-info" id="four"><h6>流程管理</h6></a>
						<a href="${ctx}/getcompanyallfile/1?group=${sessionScope.userVO.groupId}" target="mainFrame" class="text-info" id="five"><h6>文件管理</h6></a>
					</div>
				</div>
			</div>
			<input type="hidden" id="groupId" value="${sessionScope.userVO.groupId}" readonly="readonly"/>
		</div>
	</div>

</body>
</html>
