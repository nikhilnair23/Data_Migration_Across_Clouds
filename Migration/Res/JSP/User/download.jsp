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
String filename;
String userid = session.getAttribute("name").toString();

System.out.println("userid :"+userid);

ResultSet rs = AdminDAO.getliveFiles(userid);




%>
<br></br>
<form action="<%=request.getContextPath()%>/ManualMigrate">
<div align="right" style="position:absolute;top:190px;left:710px">
	<input type="submit" name="submit" value="migrate" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
	;
</div>
<div class="CSSTableGenerator" style="width:600px;height:150px;">
<table class="pretty-table">
  
    <th scope="col">FileNo</th>
    <th scope="col">FileName</th>
    <th scope="col">User Id</th>
    <th scope="col">Data and Time</th>
    <th scope="col">Status</th>
    <th scope="col">Download</th>
    <th scope="col">Migrate</th>
    
    
  
<%while(rs.next())
	{
	
	filename=rs.getString(2);
	System.out.println(filename);
	%>
  <tr>
    <td><%=rs.getInt(1) %></td>
    	<td><%=filename%></td>
    	<td><%=rs.getString(3)%></td>
    	<td><%=rs.getString(4)%></td>
    	<td><%=rs.getString(5)%></td>
    	<td><a href="<%=request.getContextPath()%>/Download?filename=<%=rs.getString(2)%>&mid=<%=rs.getString(3) %>">Download</a></td>
    	<td><input name="chk" type="checkbox" value="<%=rs.getInt(1) %>"></td>
 
  </tr>
<%
}
rs.close();%>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>

</tr>



</table>
</div>
</center>
</form>

<%
	if(Utility.parse(request.getParameter("no"))==1)
    {%>
    	<div class="success" id="message" style="position:absolute;top:-10px;font-size: 20px;color:#000;font-family: monotype corsiva;">	
    		<p>File Downloaded Successfully.....!</p>
    	</div>			
    <%}
	if(Utility.parse(request.getParameter("no"))==2)
	{%>
		<div class="success" id="message" style="position:absolute;top:-10px;font-size: 20px;color: #000;font-family: monotype corsiva;">	
			<p>Opp's something went wrong.....!</p>
		</div>			
	<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
		{%>
		<div class="success" id="message" style="position:absolute;top:-10px;font-size: 20px;color:#000;font-family: monotype corsiva;">	
    		<p>File Migrated Successfully.....!</p>
    	</div>			
    <%}
	%>
	
	
	
</body></html>