<%@ page import="java.sql.*" %>
<%@ page import="com.DAO.*" %>
<%@ page import="com.helperclass.*" %>
<%@ page import="javax.xml.*" %>
<%@ page import="javax.xml.xpath.*" %>
<%@ page import="org.w3c.dom.*" %>
<%@ page import="javax.xml.parsers.*" %>
<html>
<head>
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
<link href="<%=request.getContextPath()%>/Res/CSS/style1.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<center>
<%
	UserDAO userDao=UserDAO.getInstance();
	ResultSet rs= userDao.getUsers();
	int count=0;
%>
<%int no=convert(request.getParameter("no"));
if(no==1)
{%>
<br></br>
<div class="CSSTableGenerator" style="width:600px;height:150px;">
<table class="pretty-table">
  
    <th scope="col">Server No</th>
    <th scope="col">Protocol</th>
    <th scope="col">Host or IP</th>
    <th scope="col">Port No</th>
    <th scope="col">Application</th>
    <th scope="col">Program</th>
  
  <form action="<%=request.getContextPath()%>/AddServer">
  <tr>
    <th scope="row"><input type="text" name="s_no" size="1"></input></th>
    <td><input type="text" name="protocol" size="2"></input></td>
    <td><input type="text" name="host" size="10"></input></td>
    <td><input type="text" name="p_no" size="2"></input></td>
    <td><input type="text" name="app" size="10"></input></td>
    <td><input type="text" name="program" size="10"></input></td>
  </tr>
<caption><input type="submit" value="Add server"></input></caption>  
  </form>
  </table>
  </div>
 
<%}
else
{%>
	<br></br>
	<div class="CSSTableGenerator" style="width:600px;height:150px;">
<table class="pretty-table">
  
    <th scope="col">Server No</th>
    <th scope="col">Protocol</th>
    <th scope="col">Host or IP</th>
    <th scope="col">Port No</th>
    <th scope="col">Application</th>
    <th scope="col">Program</th>
  
  <tr>
  <th scope="row">1</th>
  <td><%=XPathReader.getProtocol(request.getRealPath("")+"/Config.xml","protocol", 1) %></td>
  <td><%=XPathReader.getHost(request.getRealPath("")+"/Config.xml","ip", 1) %></td>
  <td><%=XPathReader.getPort(request.getRealPath("")+"/Config.xml","port", 1) %></td>
  <td><%=XPathReader.getApp(request.getRealPath("")+"/Config.xml","app", 1) %></td>
  <td><%=XPathReader.getProgram(request.getRealPath("")+"/Config.xml","program", 1) %></td>
  </tr>
  <tr>
  <th scope="row">2</th>
  <td><%=XPathReader.getProtocol(request.getRealPath("")+"/Config.xml","protocol", 2) %></td>
  <td><%=XPathReader.getHost(request.getRealPath("")+"/Config.xml","ip", 2) %></td>
  <td><%=XPathReader.getPort(request.getRealPath("")+"/Config.xml","port", 2) %></td>
  <td><%=XPathReader.getApp(request.getRealPath("")+"/Config.xml","app", 2) %></td>
  <td><%=XPathReader.getProgram(request.getRealPath("")+"/Config.xml","program", 2) %></td>
  </tr>
  <tr>
  <th scope="row">3</th>
  <td><%=XPathReader.getProtocol(request.getRealPath("")+"/Config.xml","protocol", 3) %></td>
  <td><%=XPathReader.getHost(request.getRealPath("")+"/Config.xml","ip", 3) %></td>
  <td><%=XPathReader.getPort(request.getRealPath("")+"/Config.xml","port", 3) %></td>
  <td><%=XPathReader.getApp(request.getRealPath("")+"/Config.xml","app", 3) %></td>
  <td><%=XPathReader.getProgram(request.getRealPath("")+"/Config.xml","program", 3) %></td>
  </tr>
  <tr>
  <th scope="row">4</th>
  <td><%=XPathReader.getProtocol(request.getRealPath("")+"/Config.xml","protocol", 4) %></td>
  <td><%=XPathReader.getHost(request.getRealPath("")+"/Config.xml","ip", 4) %></td>
  <td><%=XPathReader.getPort(request.getRealPath("")+"/Config.xml","port", 4) %></td>
  <td><%=XPathReader.getApp(request.getRealPath("")+"/Config.xml","app", 4) %></td>
  <td><%=XPathReader.getProgram(request.getRealPath("")+"/Config.xml","program", 4) %></td>
  </tr>

</table>
</div>
<%}%>
</center>
</body></html>