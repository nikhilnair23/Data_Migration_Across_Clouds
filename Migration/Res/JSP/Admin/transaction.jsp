<%@ page import="com.DAO.*" %>
<%@ page import="java.sql.*" %>
<html>
<head></head>

<link href="<%=request.getContextPath()%>/Res/CSS/style1.css" rel="stylesheet" type="text/css"/>
<body>
<center>
<%
	
	AdminDAO adminDao=AdminDAO.getInstance();
	ResultSet rs= adminDao.getFiles();
	int count=0;
%>
<br></br>

<div class="CSSTableGenerator" style="width:600px;height:150px;">
<table class="pretty-table">
  
    <th scope="col">Serial No</th>
    <th scope="col">File Name</th>
    <th scope="col">Transaction Type</th>
    <th scope="col">Time</th>
    <th scope="col">Date</th>
  
  <%while(rs.next())
	{count++;%>
  <tr>
    <td><%=count %></td>
    	<td><%=rs.getString(6) %></td>
    	<td><%=rs.getString(2) %>ed by User :-[<%=adminDao.getUser(rs.getInt(5)) %>]</td>
    	<td><%=rs.getString(3) %></td>
    	<td><%=rs.getString(4) %></td>
  </tr>
<%} %>
</table>
</div>
</center>
</body>
</html>