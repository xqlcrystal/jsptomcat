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
	System.out.println("JspInit(),Jsp����ʼ����"+initvar+"��");
	
	//������������ͨ����
	//File tempdir=(File)application.getAttribute("javax.servlet.context.tempdir");
	
}


public void jspDestroy(){
	destroyvar++;
	System.out.println("jspDestroy(),Jsp������"+initvar+"��");
}

%>

<%

servicevar++;
System.out.println("_jspService(),Jsp����Ӧ��"+servicevar+"��");

String content1="��ʼ������"+initvar;
String content2="��Ӧ�ͻ����������"+servicevar;
String content3="���ٴ���"+destroyvar;
%>

<h1><%=content1 %></h1>
<h2><%=content2 %></h2>
<h2><%=content3 %></h2>

</body>
</html>