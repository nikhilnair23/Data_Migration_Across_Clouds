<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/Res/CSS/style1.css" type="text/css" media="screen">
<link href="<%=request.getContextPath()%>/Res/CSS/stylelog.css" rel="stylesheet" type="text/css" />


<script type="text/javascript">
<!--

javascript:window.history.forward(-1);

//-->


</script>
<%
String username = (String)session.getAttribute("name");
String userid = request.getParameter("name");


%>
<script type="text/javascript">

</script>
</head>
<body>
<div 	style="position: centre;  left: -10px;"	>
<img alt="" src="<%=request.getContextPath()%>/Res/Images/top.png" height="100px" width=100%"></img>
</div>
<div style="color:#2A0A0A;position:absolute;top:110px;left:800px;font-family: Monotype Corsiva;font-size: 20px;font-style: bold">
  Welcome[<%=userid %>][<a href="<%=request.getContextPath()%>/index.jsp?no=4" ><font color="blue">Logout</font></a>]</div>
  
  
	
<div class="example">
    <ul id="nav">
        <li class="current"><a href="<%=request.getContextPath()%>/Res/JSP/Admin/adminhome.jsp?name=<%=userid%>" >Home</a></li>
         <li class="current"><a href="<%=request.getContextPath()%>/Res/JSP/User/newuser.jsp" target="myIframe">User Creation</a></li>
        <li class="current"><a href="<%=request.getContextPath()%>/Res/JSP/User/users.jsp" target="myIframe">User Details</a>
        </li>
        <li class="current"><a href="<%=request.getContextPath()%>/Res/JSP/Admin/cloud.jsp" target="myIframe">Cloud Config</a></li>
        <li class="current"><a href="<%=request.getContextPath()%>/Res/JSP/Admin/view_live_files.jsp" target="myIframe">Live Files</a>
        </li>
        <li class="current"><a href="<%=request.getContextPath()%>/Res/JSP/Admin/view_deleted_files.jsp" target="myIframe">Migrated Files</a>
        </li>
        
        <li class="current"><a href="<%=request.getContextPath()%>/Res/JSP/Admin/view_request.jsp" target="myIframe">View Req</a></li>
        
        <li class="current"><a href="<%=request.getContextPath()%>/Res/JSP/Admin/aesgen.jsp?userid=<%=userid%>" target="myIframe" onclick="alert('Previously Deteleted files are encrypted using Existing AES Master Key You action going to replace existing key with recent key, system may not able to retreive old files.');">AES Key Gen</a>
        </li>
        
        
        <li class="current"><a href="<%=request.getContextPath()%>/ChangePass?name=<%=userid%>&no=1&id=<%=userid%>" target="myIframe">ChangePass</a></li>
    </ul>
</div>
	

<div style="position:absolute;top:200px;left:100px;">
	<iframe align="middle" src="<%=request.getContextPath() %>/Res/JSP/Admin/content.jsp" frameborder="1" scrolling="auto" name="myIframe" height="450" width="750" ></iframe>
</div>	
</body>
</html>