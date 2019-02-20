package com.admin;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AdminDAO;
import com.DBConnector.DBConnection;

public class AdminLogin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String name=req.getParameter("username");
		String pass=req.getParameter("pass");
		
		AdminDAO adminDAO=AdminDAO.getInstance();
		
		boolean flag=adminDAO.checkAdmin(name, pass);
		
		if(flag)
		{
			
			RequestDispatcher rd=null;
			
			HttpSession hs=req.getSession();
			hs.setAttribute("name", name);
			
			rd=req.getRequestDispatcher("/Res/JSP/Admin/adminhome.jsp?name="+name+"");
			rd.forward(req,resp);
			
		}
		else
		{
			resp.sendRedirect("index.jsp?no=3");
			
		}
		
		
	}

}
