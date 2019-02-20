<%@ page import="java.sql.*" %>
<%@ page import="com.DAO.*" %>
<%@ page import="com.helperclass.*" %>
<%@ page import="javax.xml.*" %>
<%@ page import="javax.xml.xpath.*" %>
<%@ page import="org.w3c.dom.*" %>
<%@ page import="javax.xml.parsers.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>

<%@page import="com.user.RandomValue"%><html>
<head>

<link href="<%=request.getContextPath()%>/Res/CSS/style1.css" rel="stylesheet" type="text/css"/>
</head>
<%

String uid = request.getParameter("mid");
String filename = request.getParameter("fname");

System.out.println("uid :"+uid+"."+filename);

Calendar currentDate = Calendar.getInstance();
	SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
	SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
	String date = formatter.format(currentDate.getTime());
	String time = formatter1.format(currentDate.getTime());
	
	date = date + "  " + time;
	

boolean b = UserDAO.addRequest(filename,uid,date);


System.out.println(b);

if(b)
{
	RequestDispatcher rd=request.getRequestDispatcher("/Res/JSP/User/view_deleted_fls.jsp?no=1");
	rd.forward(request, response);
}
else
{
	RequestDispatcher rd=request.getRequestDispatcher("/Res/JSP/User/view_deleted_fls.jsp?no=2");
	rd.forward(request, response);
}
%>
<body>


</body></html>