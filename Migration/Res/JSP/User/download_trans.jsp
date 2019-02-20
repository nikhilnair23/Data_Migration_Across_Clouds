<%@ page import="com.DAO.*" %>
<%@ page import="java.sql.*" %>
<html>
<head></head>
<%
HttpSession hs = request.getSession();
String userid=hs.getAttribute("userid").toString();
hs.setAttribute("userid",userid);
%>
<link href="<%=request.getContextPath()%>/Res/CSS/style.css" rel="stylesheet" type="text/css"/>
<body>
<%
	UserDAO userAO=UserDAO.getInstance();
	ResultSet rs= userAO.getUFiles1(userAO.getID(userid));
	int count=0;
%>
<br></br>
<center>
<table class="pretty-table">
  <tr>
    <th scope="col">Serial No</th>
    <th scope="col">File Name</th>
    <th scope="col">User Name</th>
    <th scope="col">Transaction Type</th>
    <th scope="col">Time</th>
    <th scope="col">Date</th>
  </tr>
  <%while(rs.next())
	{count++;%>
  <tr>
    <th scope="row"><%=count %></th>
    	<td><%=rs.getString(6) %></td>
    	<td><%=userAO.getName(rs.getInt(5)) %></td>
    	<td><%=rs.getString(2) %>ed</td>
    	<td><%=rs.getString(3) %></td>
    	<td><%=rs.getString(4) %></td>
  </tr>
<%} %>
<caption>Total Number of Uploaded Files [<%=count %>] ........</caption>
</table>
</center>
</body>
</html>