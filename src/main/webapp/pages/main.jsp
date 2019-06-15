<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>OA系统</title>
</head>

<frameset rows="55,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="${ctx}/pages/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset rows="*" cols="195,*" framespacing="0" frameborder="no" border="0">
    <frame src="${ctx}/pages/menus/nav.jsp" name="navFrame" scrolling="Yes" noresize="noresize" id="navFrame" title="leftFrame" />
    <frame src="${ctx}/getuserinfo" name="mainFrame" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
<body>
</body>
</html>
