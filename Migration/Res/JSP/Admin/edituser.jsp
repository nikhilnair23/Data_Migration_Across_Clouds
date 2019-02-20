
<%@ page import="java.sql.*" %>
<%@page import="com.DAO.*"  %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.helperclass.*"%>
<html>

<head>
	
	 <script src="jquery.toastmessage.js" type="text/javascript"></script>
    <link href="jquery.toastmessage.css" rel="stylesheet" type="text/css" />
</head>
<%

String userid = request.getParameter("id");
String name = request.getParameter("name");
int ucode = Integer.parseInt(request.getParameter("code")); 
String city = request.getParameter("city");
String mobile = request.getParameter("mobile");
	
String sub = request.getParameter("submit");
System.out.println("sub :"+sub);
%>

<body onload="startTimer()">
<div>


</div>
			
				<form action="<%=request.getContextPath()%>/EditUser" method="get">
				<input type="hidden" name="submit" value="Edit">
			
				
					<table id="login" align="center"  width="300px" style="position: absolute;top: 20px;left:200px;">
					<tr>
			     			<td colspan="2" align="center"><font style="font-family:cursive;font-size: 20px;color: black;"><b>Edit User Details</b></font></td>
			     	</tr>
			     	
			     	<tr><td>&nbsp;</td></tr>
			     	<tr >
			     		<td colspan="1" ><font color="#8B2323"><b>Code :</b></font></td>
			     		<td colspan="1"><input type="text" name="code" value="<%=ucode%>" readonly="readonly"> </td>
			     		
			     		
			     	</tr>
			     	
			     	<tr><td>&nbsp;</td></tr>
			     	<tr >
			     		<td colspan="1" ><font color="#8B2323"><b>LoginId :</b></font></td>
			     		<td colspan="1"><input type="text" name="loginid" value="<%=userid%>" readonly="readonly"> </td>
			     		
			     		
			     	</tr>
			     	<tr><td>&nbsp;</td></tr>
			     	<tr>
			     		<td colspan="1" ><font color="#8B2323"><b>Name :</b></font></td>
			     		<td colspan="1"><input type="text" name="unm" value="<%=name%>" required="yes"> </td>
			     		
			     		
			     	</tr>
			     	
			     	<tr><td>&nbsp;</td></tr>
			     	<tr>
			     		<td colspan="1" ><font color="#8B2323"><b>City :</b></font></td>
			     		<td colspan="1"><input type="text" name="ucity" value="<%=city%>" required="yes"> </td>
			     		
			     		
			     	</tr>
			     	
			     	<tr><td>&nbsp;</td></tr>
			     	<tr>
			     		<td colspan="1" ><font color="#8B2323"><b>Email :</b></font></td>
			     		<td colspan="1"><input type="text" name="umobile" value="<%=mobile%>" required="yes"> </td>
			     		
			     		
			     	</tr>
			     	
			     	<tr><td>&nbsp;</td></tr>
			     	<tr>
			     		
			     		<td colspan="4" align="center"><input type="submit" name="gname" value="Update"> </td>
			     		
			     		
			     	</tr>
			     	
			     	
			     	
			     	</table>
					
					</form>
					
					
					<%	
		int no=Utility.parse(request.getParameter("no"));
System.out.println("No :"+no);
		
		if(no==1)
		{%>
		
			<div  style="position: absolute;top: -10px;left: 50px;color: #8B4513;font-size: 20px; ">	
		
		<p>User Details Not Updated,..</p>	
		</div>		
		<%}
		
		
	%>
					
		
</body>
</html>