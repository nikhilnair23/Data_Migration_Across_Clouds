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
String userid = session.getAttribute("name").toString();
ResultSet rs = AdminDAO.getdeletedFiles(userid);




%>
<br></br>
<div class="CSSTableGenerator" style="width:600px;height:150px;">
<table class="pretty-table">
  
    <th scope="col">File No</th>
    <th scope="col">File Name</th>
    <th scope="col">M Id</th>
    <th scope="col">Data and Time</th>
    <th scope="col">Status</th>
    <th scope="col">Recovery</th>
    
  
<%while(rs.next())
	{%>
  <tr>
    <td><%=rs.getInt(1) %></td>
    	<td><%=rs.getString(2) %></td>
    	<td><%=rs.getString(3) %></td>
    	<td><%=rs.getString(4) %></td>
    	<td><%=rs.getString(5) %></td>
    	<%if(rs.getString(5).equals("Approved")) 
    	{%>
    	<td>File Recovered</td>
    	<%} 
    	else 
    	{%>
    	<td><a href="<%=request.getContextPath()%>/Res/JSP/User/request_recovery.jsp?fname=<%=rs.getString(2)%>&mid=<%=rs.getString(3)%>">Req for Recovery</a></td>
    	<%} %>
    	
 
  </tr>
<%
}
%>

</table>
</div>
</center>

<%
	if(Utility.parse(request.getParameter("no"))==1)
    {%>
    	<div class="success" id="message" style="position:absolute;top:-10px;font-size: 20px;color:#000;font-family: monotype corsiva;">	
    		<p>Request have Send Successfully.....!</p>
    	</div>			
    <%}
	if(Utility.parse(request.getParameter("no"))==2)
	{%>
		<div class="success" id="message" style="position:absolute;top:-10px;font-size: 20px;color: #000;font-family: monotype corsiva;">	
			<p>Opp's something went wrong.....!</p>
		</div>			
	<%
	}
	
	%>
	
</body></html>