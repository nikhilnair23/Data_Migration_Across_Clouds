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
import com.DAO.UserDAO;;


public class Decrypt extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		HttpSession session = req.getSession( true );  
	       if ( session.getAttribute( "waitPage" ) == null ) 
	       {  
	    	   session.setAttribute( "waitPage", Boolean.TRUE );  
	    	   PrintWriter out = res.getWriter();  
	    	   out.println( "<html><head>" );  
	    	   out.println( "<title>Please Wait...</title>" );  
	       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
	    	   out.println( "</head><body bgcolor=''>" );  
	    	   out.println( "<br><br><br>" );
	    	   out.print( "<center><img src='images/2.gif'></img><br><br>");
	    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
	    	   out.println( "You are being redirected to Cloud RNS Encryption & Decryption Server......  " );
	    	   out.println( "Please wait....</h1></center");  
	    	   out.close();  
	       }  
	       else 
	       { 
	    	   session.removeAttribute( "waitPage" );  
		try
		{
			PrintWriter out=res.getWriter();
			res.setContentType("text/html");
			String filename=req.getParameter("fname");
			String userid=req.getParameter("user");
			
			System.out.println(" File Name fffff ------>"+filename+" "+" User ID yyyy ---------->"+userid);
			
			String protocol=XPathReader.getProtocol(req.getRealPath("")+"/Config.xml","protocol", 4);
			String ip=XPathReader.getHost(req.getRealPath("")+"/Config.xml","ip", 4);
			String port=XPathReader.getPort(req.getRealPath("")+"/Config.xml","port", 4) ;
			String app=XPathReader.getApp(req.getRealPath("")+"/Config.xml","app", 4);
			String program=XPathReader.getProgram(req.getRealPath("")+"/Config.xml","program", 4);
			
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
			String date = formatter.format(currentDate.getTime());
			String time = formatter1.format(currentDate.getTime());
			
			UserDAO userDAO=UserDAO.getInstance();
			userDAO.addTransDec(userDAO.getID(userid),filename,date,time);
			int key1=userDAO.getKey1(userDAO.getID(userid));
			int key2=userDAO.getKey2(userDAO.getID(userid));
			
			
			String url=protocol+"://"+ip+":"+port+"/"+app+"/"+program+"?fname="+filename+"&user="+userDAO.getName(userDAO.getID(userid))+"&key1="+key1+"&key2="+key2;;
			System.out.println("In Decryption Process -- "+url);
			res.sendRedirect(url);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}}
}
