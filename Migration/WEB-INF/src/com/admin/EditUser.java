package com.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AdminDAO;


public class EditUser extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String sub = req.getParameter("submit");
		
		System.out.println("Submit val :"+sub);
		if(sub.trim().equals("Edit"))
		{
			System.out.println("Edit Start");
			
			String uid =req.getParameter("loginid");
			String name = req.getParameter("unm");
			String city =req.getParameter("ucity");
			String code =req.getParameter("code");
			String mobile = req.getParameter("umobile");
			RequestDispatcher rd = null;
			//String chk=req.getParameter("chk");
			
			System.out.println("User Id :"+uid);
			System.out.println("User Name :"+name);
			System.out.println("User city :"+city+"User Code :"+code+"Mobile :"+mobile);
			
			
			try
			{
				
				System.out.println("Edit Start");
				
				int val = AdminDAO.editUser(uid, name, city, mobile, Integer.parseInt(code));
				
				System.out.println("Val :"+val);
				if(val==1 )
				{
					
					 rd=req.getRequestDispatcher("/Res/JSP/User/users.jsp?no=1");
			         rd.forward(req,resp);
				}
				else
				{
					rd=req.getRequestDispatcher("/Res/JSP/Admin/edituser.jsp?no=1");
			        rd.forward(req,resp);
					
				}
				
			} 
			catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(sub.trim().equals("Delete"))
		{
			System.out.println(" Start to Delete ");
			
			RequestDispatcher rd = null;
			String [] chk1 =req.getParameterValues("chk");
			if(chk1==null)
			{
				
				rd=req.getRequestDispatcher("/Res/JSP/User/users.jsp?no=2");
				rd.forward(req,resp);
			}
			else
			{
				for(int i=0;i<chk1.length;i++)
				{
					
					AdminDAO.deleteUser(chk1[i]);
				}
				
				rd=req.getRequestDispatcher("/Res/JSP/User/users.jsp?no=2");
				rd.forward(req,resp);
			}
			
		}
		
		
	}
	
}
