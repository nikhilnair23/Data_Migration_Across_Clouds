<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Out</title>
</head>
<body bgcolor=#111111>
 <%
// Set to expire far in the past.
//response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
// Set standard HTTP/1.1 no-cache headers.
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
response.addHeader("Cache-Control", "post-check=0, pre-check=0");
// Set standard HTTP/1.0 no-cache header.
response.setHeader("Pragma", "no-cache");
%>

 <%
   HttpSession hs = request.getSession();
   hs.invalidate();
   
   
   String path=request.getContextPath()+"/index1.jsp?no=4";
   response.sendRedirect(path);
   
   // RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
  // rd.forward(request,response);
               
   %>
</body>
</html>