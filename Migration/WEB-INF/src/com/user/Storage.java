/**
 * 
 */
package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.helperclass.XPathReader;
import com.DAO.UserDAO;


public class Storage extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		HttpSession session = request.getSession( true );  
	       if ( session.getAttribute( "waitPage" ) == null ) 
	       {  
	    	   session.setAttribute( "waitPage", Boolean.TRUE );  
	    	   PrintWriter out = response.getWriter();  
	    	   out.println( "<html><head>" );  
	    	   out.println( "<title>Please Wait...</title>" );  
	       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
	    	   out.println( "</head><body bgcolor=''>" );  
	    	   out.println( "<br><br><br>" );
	    	   out.print( "<center><img src='img/2.gif'></img><br><br>");
	    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
	    	   out.println( "You are being redirected to Cloud Storage Server......  " );
	    	   out.println( "Please wait....</h1></center");  
	    	   out.close();  
	       }  
	       else 
	       { 
	    	   session.removeAttribute( "waitPage" );  
		try
		{
			PrintWriter out=response.getWriter();
			String filename=request.getParameter("fname");
			String userid=request.getParameter("user");
			
			System.out.println("File Name ---------"+filename+" "+"User ID -------->"+userid);
						
			String protocol=XPathReader.getProtocol(request.getRealPath("")+"/Config.xml","protocol", 2);
			String ip=XPathReader.getHost(request.getRealPath("")+"/Config.xml","ip", 2);
			String port=XPathReader.getPort(request.getRealPath("")+"/Config.xml","port", 2) ;
			String app=XPathReader.getApp(request.getRealPath("")+"/Config.xml","app", 2);
			String program=XPathReader.getProgram(request.getRealPath("")+"/Config.xml","program", 2);
			
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
			String date = formatter.format(currentDate.getTime());
			String time = formatter1.format(currentDate.getTime());
			
			UserDAO userDAO=UserDAO.getInstance();
			
			userDAO.addTransUpload(userDAO.getID(userid), filename, date, time);
			
			String url=protocol+"://"+ip+":"+port+"/"+app+"/"+program+"?fname="+filename+"&user="+userDAO.getName(userDAO.getID(userid));
			System.out.println("In Storage Process -- "+url);
			response.sendRedirect(url);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}}
}
