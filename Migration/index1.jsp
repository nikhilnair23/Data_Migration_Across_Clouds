<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

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
<head><title>Cloud_SaDas</title>
<script type = "text/javascript">
function hideMessage()
{
	document.getElementById("message").style.display="none"; 
}
function startTimer() 
{
	var tim = window.setTimeout("hideMessage()", 2000);  // 5000 milliseconds = 5 seconds
}
</script>
<style>

#amutha
{
	position:absolute;
	top: 150px;
	left:520px;
	background:#606060;
	color:#fff;
	text-align:center;
	width:500px
}





</style>


<link href="<%=request.getContextPath()%>/Res/CSS/stylelog.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/Res/CSS/message.css" rel="stylesheet" type="text/css" />

</head>
<%int no=convert(request.getParameter("no"));
if(no==1)
{%>
<div id="amutha">
	<p id="message">Opp's.......Please enter your userid</p>
</div>
<%}if(no==2)
{%>
<div id="amutha">
	<p id="message">Opp's.......Please enter your password</p>
</div>
<%}%>
<%if(no==3)
{%>
<div id="amutha">
	<p id="message">Opp's.......invalid username/password...!</p>
</div>
<%}%>
<%if(no==4)
{%>
<div id="amutha">
	<p id="message">You have Logged out successfully...!</p>
</div>
<%}%>
<%if(no==5)
{%>
<div id="amutha">
	<p id="message">User Registered Successfully...!</p>
</div>
<%}%>


<body>
<div 	style="position: centre;  left: -10px;"	>
<img alt="" src="<%=request.getContextPath()%>/Res/Images/top.png" height="100px" width=100%">
</img>
</div>
<form id="login" action="<%=request.getContextPath()%>/UserLogin" method="post">
    <h1 id="ff-proof" class="ribbon">User Login &nbsp;&nbsp;</h1>
    
    <fieldset id="inputs">
        <input id="username" type="text" name="username" onblur="if(this.value=='')this.value='user name';" onfocus="if(this.value=='user name')this.value='';"  required="yes" />
        <input id="password" type="password" name="pass" onblur="if(this.value=='')this.value='user password';" onfocus="if(this.value=='user password')this.value='';" required="yes"  />
    </fieldset>
    <fieldset id="actions">
        <input type="submit" id="submit" value="Login"/>
       <p class="option"><a href="<%=request.getContextPath() %>/index.jsp">Admin</a>&nbsp;&nbsp;|<a href="<%=request.getContextPath()%>/index1.jsp">User</a></p>
    </fieldset>
</form>
</body>
</html>