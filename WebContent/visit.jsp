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
	System.out.println("JspInit(),Jsp±¶³õÊ¼»¯ÁË"+initvar+"´Î");
	
	//´ËÓï¾ä±àÒëÆ÷¶¼Í¨²»¹ý
	//File tempdir=(File)application.getAttribute("javax.servlet.context.tempdir");
	
}


public void jspDestroy(){
	destroyvar++;
	System.out.println("jspDestroy(),JspÏú»ÙÁË"+initvar+"´Î");
}

%>

<%

servicevar++;
System.out.println("_jspService(),Jsp¹²ÏàÓ¦ÁË"+servicevar+"´Î");

String content1="³õÊ¼»¯´ÎÊý"+initvar;
String content2="ÏìÓ¦¿Í»§ÇëÇó´ÎÊý£º"+servicevar;
String content3="Ïú»Ù´ÎÊý"+destroyvar;
%>

<h1><%=content1 %></h1>
<h2><%=content2 %></h2>
<h2><%=content3 %></h2>

</body>
</html>