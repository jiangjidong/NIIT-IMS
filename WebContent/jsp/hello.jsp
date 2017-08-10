<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Hello</title>
</head>
<body>
<h1>Say:HelloWorld</h1>
<h2>${info.name}</h2>

<form action="<%=request.getContextPath()%>/helloworld/form" method="post">
		<input type="text" name="name"/>
		<input type="text" name="name2"/>
		<input type="submit" value="提交" />
	</form>

</body>
</html>