<%@ page import="java.sql.*" %>
<%@ page import="com.DAO.*" %>
<%@ page import="com.helperclass.*" %>
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

ResultSet rs = AdminDAO.getdeletedFiles();




%>
<br></br>
<div class="CSSTableGenerator" style="width:600px;height:150px;">
<table class="pretty-table">
  
    <th scope="col">File No</th>
    <th scope="col">File Name</th>
    <th scope="col">User Id</th>
    <th scope="col">Data and Time</th>
    <th scope="col">Recovery Status</th>
    
  
<%while(rs.next())
	{%>
  <tr>
    <td><%=rs.getInt(1) %></td>
    	<td><%=rs.getString(2) %></td>
    	<td><%=rs.getString(3) %></td>
    	<td><%=rs.getString(4) %></td>
    	<td><%=rs.getString(5) %></td>
    	
 
  </tr>
<%
}
%>

</table>
</div>
</center>

</body></html>