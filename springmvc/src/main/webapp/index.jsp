<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ssm test</title>
</head>
<body>
	<h>${user.realname }</h>
	<a href="${pageContext.request.contextPath}/user/get?id=100000000">获取用户名</a>
</body>
</html>