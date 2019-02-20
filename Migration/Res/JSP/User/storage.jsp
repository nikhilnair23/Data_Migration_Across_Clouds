<%@ page import="java.sql.*" %>
<%@ page import="com.DAO.*" %>
<html>
<head>
<%
HttpSession hs = request.getSession();
String userid=hs.getAttribute("userid").toString();
hs.setAttribute("userid",userid);
%>
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

<link href="<%=request.getContextPath()%>/Res/CSS/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<center>
<%
	System.out.println("User ID fgfg :"+userid);
	UserDAO userDAO=UserDAO.getInstance();
	ResultSet rs= userDAO.getFiles(userDAO.getID(userid));
	int count=0;
%>
<br></br>
<table class="pretty-table">
  <tr>
    <th scope="col">Serial No</th>
    <th scope="col">File Name</th>
    <th scope="col">Upload File</th>
  </tr>
<%while(rs.next())
	{count++;%>
  <tr>
    <th scope="row"><%=count %></th>
    	<td><%=rs.getString(6) %></td>
    	<td><a href="<%=request.getContextPath() %>/Storage?fname=<%=rs.getString(6) %>&user=<%=userid %>">Click Here to Upload</a></td>
  </tr>
<%} %>
<caption>Total Number of User [<%=count %>] ........</caption>
</table>
</center>
</body></html>