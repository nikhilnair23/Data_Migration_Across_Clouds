<%@ page import="java.sql.*" %>
<%@ page import="com.DAO.*" %>
<%@ page import="com.helperclass.*" %>
<%@ page import="javax.xml.*" %>
<%@ page import="javax.xml.xpath.*" %>
<%@ page import="org.w3c.dom.*" %>
<%@ page import="javax.xml.parsers.*" %>

<%@page import="com.user.RandomValue"%><html>
<head>

<link href="<%=request.getContextPath()%>/Res/CSS/style1.css" rel="stylesheet" type="text/css"/>
</head>
<%

String uid = request.getParameter("userid");
String aesKey = RandomValue.AESKeyValue();
boolean b = AdminDAO.masterKey(uid,aesKey);
System.out.println(b);

if(b)
{
	RequestDispatcher rd=request.getRequestDispatcher("/Res/JSP/Admin/content.jsp?no=3");
	rd.forward(request, response);
}
else
{
	RequestDispatcher rd=request.getRequestDispatcher("/Res/JSP/Admin/content.jsp?no=2");
	rd.forward(request, response);
}
%>
<body>


</body></html>