<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>life.jsp</title>
</head>
<body>

<%!
private int initvar=0;
private int servicevar=0;
private int destroyvar=0;

%>


<%!

public void jspInit(){
	
	initvar++;
	System.out.println("JspInit(),Jsp倍初始化了"+initvar+"次");
	
	//此语句编译器都通不过
	//File tempdir=(File)application.getAttribute("javax.servlet.context.tempdir");
	
}


public void jspDestroy(){
	destroyvar++;
	System.out.println("jspDestroy(),Jsp销毁了"+initvar+"次");
}

%>

<%

servicevar++;
System.out.println("_jspService(),Jsp共相应了"+servicevar+"次");

String content1="初始化次数"+initvar;
String content2="响应客户请求次数："+servicevar;
String content3="销毁次数"+destroyvar;
%>

<h1><%=content1 %></h1>
<h2><%=content2 %></h2>
<h2><%=content3 %></h2>

</body>
</html>