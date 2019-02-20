package com.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helperclass.WriteXML;




	
	public class AddServer extends HttpServlet
	{
		public void service(HttpServletRequest req,HttpServletResponse res)
		{
			try
			{
				String s_no=req.getParameter("s_no");
				String protocol=req.getParameter("protocol");
				String host=req.getParameter("host");
				String p_no=req.getParameter("p_no");
				String app=req.getParameter("app");
				String program=req.getParameter("program");
				System.out.println(protocol+host+ p_no+ app+ program);
				new WriteXML(req.getRealPath(""),s_no,protocol, host, p_no, app, program);
				RequestDispatcher rd=req.getRequestDispatcher("/admin/servers.jsp?no=2");
				rd.forward(req, res);
			}
			catch(Exception e)
			{
				System.out.println("errprrr "+e);
			}
		}
	}



