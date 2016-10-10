<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Source Page</title>
</head>
<body>
<p>
This is the source.jsp before forward
</p>

<jsp:forward page="/dir1/dir2/target.jsp">
<jsp:param value="tom" name="username"/>
<jsp:param value="1234" name="password"/>
</jsp:forward>
<p>
This is the source.jsp after forward
</p>
</body>
</html>