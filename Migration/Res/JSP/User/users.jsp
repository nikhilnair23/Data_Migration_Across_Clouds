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
UserDAO userDAO = UserDAO.getInstance();

ResultSet rs = userDAO.getUsers();

%>
<br></br>
<div class="CSSTableGenerator" style="width:600px;height:150px;">
<table class="pretty-table">
  
    <th scope="col">User No</th>
    <th scope="col">User ID</th>
    <th scope="col">User Name</th>
    <th scope="col">User City</th>
    <th scope="col">User Email</th>
    <th scope="col">Edit</th>
    <th scope="col">Delete</th>
  
<%while(rs.next())
	{%>
  <tr>
    <td><%=rs.getInt(1) %></td>
    	<td><%=rs.getString(2) %></td>
    	<td><%=rs.getString(4) %></td>
    	<td><%=rs.getString(5) %></td>
    	<td><%=rs.getString(6) %></td>
    	<td><a href="<%=request.getContextPath()%>/Res/JSP/Admin/edituser.jsp?code=<%=rs.getInt(1)%>&id=<%=rs.getString(2)%>&name=<%=rs.getString(4)%>&city=<%=rs.getString(5) %>&mobile=<%=rs.getString(6)%>&submit=Edit"><font style="color: blue;"><b>Edit</b></font></a></td>
    	<td><a href="<%=request.getContextPath()%>/EditUser?submit=Delete&chk=<%=rs.getInt(1) %>"><font style="color: blue;"><b>Delete</b></font></a></td>
  </tr>
<%
}
%>

</table>
</div>
</center>
<%	
		int no=Utility.parse(request.getParameter("no"));
System.out.println("No :"+no);
		if(no==1)
		{%>
		<div  style="position: absolute;top: -10px;left: 50px;color: #000;font-size: 20px;font-family: monotype corsiva; ">
		<p>User Details Updated Successfully..</p>	
		</div>
		
					
		<%}
		if(no==2)
		{%>
		
			<div  style="position: absolute;top: -10px;left: 50px;color: #000;font-size: 20px; ">	
		
		<p>User Deleted Successfully</p>	
		</div>		
		<%}
		
		
	%>
</body></html>