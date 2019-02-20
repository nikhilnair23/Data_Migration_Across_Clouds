<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/Res/CSS/message.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%! 
public int convert(String str) 
{ 
	int conv=0; 
	if(str==null) 
	{ 
		str="0"; 
	} 
	else if((str.trim()).equals("null")) 
	{ 
		str="0"; 
	} 
	else if(str.equals("")) 
	{ 
		str="0"; 
	} 
	try
	{ 
		conv=Integer.parseInt(str); 
	} 
	catch(Exception e) 
	{ 
	} 
	return conv; 
	} 
%>
<%int no=convert(request.getParameter("no"));
if(no==1)
{%>
<div id="amutha">
	<p id="message">Opp's.......Please enter your userid</p>
</div>
<%}if(no==2)
{%>
<div id="amutha">
	<p id="message">Opp's.......Please enter your password</p>
</div>
<%}%>
<%if(no==3)
{%>
<div id="amutha">
	<p id="message">Master Key Generated Successfully...!</p>
</div>
<%}%>
<%if(no==4)
{%>
<div id="amutha">
	<p id="message">You have Logged out successfully...!</p>
</div>
<%}%>
<%if(no==5)
{%>
<div id="amutha">
	<p id="message">User Registered Successfully...!</p>
</div>
<%}%>
<%if(no==6)
{%>
<div id="amutha">
	<p id="message">Userid already exist...!</p>
</div>
<%}%>
</body>
</html>