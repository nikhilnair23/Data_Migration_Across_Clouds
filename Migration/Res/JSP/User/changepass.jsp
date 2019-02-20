<%@ page import="com.helperclass.*" %>
<html>
<head>
	<%
		String admin=Utility.parse1(request.getAttribute("admin"));
		int no=Utility.parse(request.getParameter("no"));
		int id=Utility.parse(request.getParameter("id"));
	%>
	
</head>
<body onload="startTimer()">
	<form id="login" action="<%=request.getContextPath() %>/ChangePass1">
		<input type="hidden" name="admin" value="<%=admin %>"></input>
		<input type="hidden" name="id" value="<%=id %>"></input>
		<input type="hidden" name="no" value="2"></input>
		
		<br></br>
	<div id="a1" style="position: absolute;top: 30px;left: 200px;">
	
	 <table id="login" align="center">
			     	<tr>
			     			<td colspan="3" align="center"><font style="font-family:cursive;font-size: 20px;color: black;"><b>Change Password</b></font></td>
			     	</tr>
			     	
			     	<tr>
			     			<td>&nbsp;</td>
			     	</tr>
			     	
			     	<tr>
			     		<td>Admin Id</td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="text" name="user_id" value="<%=admin %>" readonly="readonly">
			     		</td>
			     	</tr>
			     	<tr><td>&nbsp;</td></tr>
			     	
			     	<tr>
			     		<td>Current Password</td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="password" name="pass" required="yes"></input>
			     		</td>
			     	</tr>
			     	<tr><td>&nbsp;</td></tr>
			     	
			     	<tr>
			     		<td>New Password </td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="password" name="npass"  required="yes"></input>
			     		</td>
			     	</tr>
			     	<tr><td>&nbsp;</td></tr>
			     	
			     	<tr>
			     		<td>Confirm new password</td>
			     		<td>:</td>
			     		<td><input class="field" type="password" name="cpass"  required="yes"></input></td>
			     	</tr>
			     	<tr><td>&nbsp;</td></tr>
			     	<tr>
			     	<td colspan="3" align="center">
			     	<input type="submit" value="Change Pass" />
			     	
			     	</td>
			     	</tr>
	
		
	</table></div></form>
<%
if(no==1)
{
	%>
		<div class="error" id="message" style="position: absolute;top: -10px;color:#000;font-size: 20px;">	
			<p>Opp's,your current password is wrong ..!</p>
		</div>
	<%
}
if(no==2)
{
	%>
		<div class="error" id="message" style="position: absolute;top: -10px;color: #000;font-size: 20px;">	
			<p>Opp's,your new password do not match with confirm password ..!</p>
		</div>
	<%
}
if(no==3)
{
	%>
		<div class="error" id="message" style="position: absolute;top: -10px;color: #000;font-size: 20px;">	
			<p>Opp's,Seems something went wrong....!</p>
		</div>
	<%
}
if(no==4)
{
	%>
		<div class="error" id="message" style="position: absolute;top: -10px;color:#000;font-size: 20px;">	
			<p>Your Password Updated Successfully....!</p>
		</div>
	<%
}
%>	
	
</body>
</html>