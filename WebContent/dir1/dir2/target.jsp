<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Target page</title>
</head>
<body>

<p>
ÎÒÔÚDir1/dir2ÏÂ
hello <%=request.getParameter("username") %>
<%=request.getParameter("password") %>
</p>
</body>
</html>