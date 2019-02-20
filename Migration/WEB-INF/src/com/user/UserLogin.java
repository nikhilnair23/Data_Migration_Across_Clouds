package com.user;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DBConnector.DBConnection;

public class UserLogin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
		
		String name=req.getParameter("username");
		String pass=req.getParameter("pass");
		
		UserDAO userDAO=UserDAO.getInstance();
		boolean flag=userDAO.checkUser(name, pass);
		
		if(flag)
		{
			RequestDispatcher rd=null;
			HttpSession hs=req.getSession();
			hs.setAttribute("name", name);
			rd=req.getRequestDispatcher("/Res/JSP/User/userhome.jsp?userid="+name+"");
			rd.forward(req,resp);
			
		}
		else
		{
			resp.sendRedirect("index1.jsp?no=3");
			
		}
		
		
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
		
		/*String name=req.getParameter("username");
		String pass=req.getParameter("pass");*/
		/*
		UserDAO userDAO=UserDAO.getInstance();
		boolean flag=userDAO.checkUser(name, pass);*/
		
		
			RequestDispatcher rd=null;
			HttpSession hs=req.getSession();
			String name=hs.getAttribute("name").toString();
			rd=req.getRequestDispatcher("/Res/JSP/User/userhome.jsp?userid="+name+"");
			rd.forward(req,resp);
			
		
		
		
		
	}

}
