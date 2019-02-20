<%@ page import="com.DAO.*" %>
<%@ page import="java.sql.*" %>
<html>
<head></head>
<%
HttpSession hs = request.getSession();
String userid=hs.getAttribute("userid").toString();
hs.setAttribute("userid",userid);
%>
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
<link href="<%=request.getContextPath()%>/Res/CSS/style.css" rel="stylesheet" type="text/css"/>
<body>
<%
	UserDAO userDAO=UserDAO.getInstance();
	ResultSet rs= userDAO.getDFiles(userDAO.getID(userid));
	int count=0;
%>
<br></br>
<center>
<table class="pretty-table">
  <tr>
    <th scope="col">Serial No</th>
    <th scope="col">File Name</th>
    <th scope="col">User Name</th>
    <th scope="col">Time</th>
    <th scope="col">Date</th>
    <th scope="col">Retrieve</th>
  </tr>
 <%while(rs.next())
	{count++;%>
  <tr>
    <th scope="row"><%=count %></th>
    	<td><%=rs.getString(6) %></td>
    	<td><%=userDAO.getName(rs.getInt(5)) %></td>
    	<td><%=rs.getString(3) %></td>
    	<td><%=rs.getString(4) %></td>
    	<td><a href="<%=request.getContextPath() %>/Download?fname=<%=rs.getString(6) %>&user=<%=userid %>">Click Here To Download</a></td>
  </tr>
<%} %>
<caption>Total Number of Files [<%=count %>] ........</caption>
</table>
</center>
</body>
</html>