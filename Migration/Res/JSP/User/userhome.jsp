<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.DAO.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
   // Set refresh, autoload time as 5 seconds
   response.setIntHeader("Refresh", 60);
   // Get current time
   Calendar calendar = new GregorianCalendar();
   String am_pm;
   int hour = calendar.get(Calendar.HOUR);
   int minute = calendar.get(Calendar.MINUTE);
   int second = calendar.get(Calendar.SECOND);
   if(calendar.get(Calendar.AM_PM) == 0)
      am_pm = "AM";
   else
      am_pm = "PM";
   String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
   //out.println("Current Time: " + CT + "\n");
%>

<%
HttpSession hs = request.getSession();
String userid=hs.getAttribute("name").toString();

System.out.println("User ID------------ ;"+userid);

hs.setAttribute("userid",userid);
String sessionid=hs.getId();

%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/Res/CSS/style.css" type="text/css" media="screen">
<link href="<%=request.getContextPath()%>/Res/CSS/stylelog.css" rel="stylesheet" type="text/css" />



<script type="text/javascript">

<!--

javascript:window.history.forward(-1);

//-->

</script>
<%

String user = request.getParameter("userid");

UserDAO userDAO=UserDAO.getInstance();
String userName =userDAO.getName(userDAO.getID(user));


%>
</head>
<body>
<div 	style="position: centre;  left: -10px;"	>
<img alt="" src="<%=request.getContextPath()%>/Res/Images/top.png" height="100px" width=100%">
</img>
</div>
	<div style="color: #2A0A0A;position:absolute;top:120px;left:800px;font-family: Monotype Corsiva;font-size: 20px;font-style: bold"> Welcome[<%=userName %>]</div>
	
	<div class="example">
    <ul id="nav">
        <li class="current"><a href="<%=request.getContextPath()%>/Res/JSP/User/userhome.jsp?userid=<%=user%>"  >Home</a></li>
        <li class="current"><a href="<%=request.getContextPath()%>/Res/JSP/User/uploadfile.jsp" target="myIframe">Upload </a>
            
        </li>
        <li class="current"><a href="<%=request.getContextPath()%>/Res/JSP/User/download.jsp" target="myIframe">Download/View </a>
        </li>
        <li class="current"><a href="<%=request.getContextPath()%>/Res/JSP/User/view_deleted_fls.jsp" target="myIframe">Migrated Files</a></li>
        
        <li class="current"><a href="<%=request.getContextPath()%>/ChangePass1?name=<%=user%>&no=1&id=<%=user %>" target="myIframe">Change Password</a>
        </li>
        
        <li class="current"><a href="<%=request.getContextPath()%>/index1.jsp?no=4">Logout</a></li>
    </ul>
</div>
	
	
	
	

<div style="position:absolute;top:200px;left:100px;">
	<iframe align="middle" src="<%=request.getContextPath() %>/Res/JSP/User/usercontent.jsp" frameborder="1" scrolling="auto" name="myIframe" height="450" width="800" ></iframe>
</div>	
</body>
</html>