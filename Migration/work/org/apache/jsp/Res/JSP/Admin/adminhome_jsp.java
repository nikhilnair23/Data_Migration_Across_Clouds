/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.35
 * Generated at: 2016-05-03 08:05:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminhome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Res/CSS/style1.css\" type=\"text/css\" media=\"screen\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/Res/CSS/stylelog.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("\r\n");
      out.write("javascript:window.history.forward(-1);\r\n");
      out.write("\r\n");
      out.write("//-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");

String username = (String)session.getAttribute("name");
String userid = request.getParameter("name");



      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div \tstyle=\"position: centre;  left: -10px;\"\t>\r\n");
      out.write("<img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/Res/Images/top.png\" height=\"100px\" width=100%\"></img>\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"color:#2A0A0A;position:absolute;top:110px;left:800px;font-family: Monotype Corsiva;font-size: 20px;font-style: bold\">\r\n");
      out.write("  Welcome[");
      out.print(userid );
      out.write("][<a href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp?no=4\" ><font color=\"blue\">Logout</font></a>]</div>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("\t\r\n");
      out.write("<div class=\"example\">\r\n");
      out.write("    <ul id=\"nav\">\r\n");
      out.write("        <li class=\"current\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/Admin/adminhome.jsp?name=");
      out.print(userid);
      out.write("\" >Home</a></li>\r\n");
      out.write("         <li class=\"current\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/User/newuser.jsp\" target=\"myIframe\">User Creation</a></li>\r\n");
      out.write("        <li class=\"current\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/User/users.jsp\" target=\"myIframe\">User Details</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"current\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/Admin/cloud.jsp\" target=\"myIframe\">Cloud Config</a></li>\r\n");
      out.write("        <li class=\"current\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/Admin/view_live_files.jsp\" target=\"myIframe\">Live Files</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"current\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/Admin/view_deleted_files.jsp\" target=\"myIframe\">Migrated Files</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        <li class=\"current\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/Admin/view_request.jsp\" target=\"myIframe\">View Req</a></li>\r\n");
      out.write("        \r\n");
      out.write("        <li class=\"current\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/Admin/aesgen.jsp?userid=");
      out.print(userid);
      out.write("\" target=\"myIframe\" onclick=\"alert('Previously Deteleted files are encrypted using Existing AES Master Key You action going to replace existing key with recent key, system may not able to retreive old files.');\">AES Key Gen</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <li class=\"current\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/ChangePass?name=");
      out.print(userid);
      out.write("&no=1&id=");
      out.print(userid);
      out.write("\" target=\"myIframe\">ChangePass</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("<div style=\"position:absolute;top:200px;left:100px;\">\r\n");
      out.write("\t<iframe align=\"middle\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Res/JSP/Admin/content.jsp\" frameborder=\"1\" scrolling=\"auto\" name=\"myIframe\" height=\"450\" width=\"750\" ></iframe>\r\n");
      out.write("</div>\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
