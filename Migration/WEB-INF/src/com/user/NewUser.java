package com.user;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.DAO.AdminDAO;
import com.DAO.UserDAO;
import com.helperclass.FTP_CreateDirecoryOnCloud;
import com.helperclass.CL_SendMail;

public class NewUser extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try
		{
			String userid=request.getParameter("id");
			String pass=request.getParameter("pwd");
			String name=request.getParameter("name");
			String city=request.getParameter("city");
			String email=request.getParameter("email");
			
			String key1=RandomValue.AESKeyValue();
			
			
			
			RequestDispatcher rd = null;
			String path = null;
			
			UserDAO userDao=UserDAO.getInstance();
			
			boolean f = AdminDAO.loginid(userid);
			
			if(f)
			{
				rd = request.getRequestDispatcher("/Res/JSP/Admin/content.jsp?no=6");
				rd.forward(request,response);
			}
			else
			{
				
				
				boolean result=userDao.addUser(userid, pass,name,city,email,key1);
				
				boolean cloud1_flag=FTP_CreateDirecoryOnCloud.createDirectoryOnCloud(userid);
				boolean cloud1_flag1=FTP_CreateDirecoryOnCloud.createDirectoryOnCloud1(userid);
				
				String LoginDetailPath = request.getRealPath("")+"\\Files\\userLogin_Details.txt";
				   
				   System.out.println("File Path :"+LoginDetailPath);
				   FileWriter fstream = new FileWriter(LoginDetailPath);
					
					BufferedWriter out = new BufferedWriter(fstream);

			        out.write("User Id is : "+userid+" And "+"Password is: "+pass);
			        out.close();
				
				
				
				boolean sendMailflag=CL_SendMail.sendPersonalizedMail(email, "send.user.details@gmail.com", "dhsinformatics", "Get User Login Details", "Login Details", LoginDetailPath, "smtp.gmail.com", "465");
				  
				System.out.println("sendMailflag :"+sendMailflag);
				
				
				
				if(result)
				{
						rd = request.getRequestDispatcher("/Res/JSP/Admin/content.jsp?no=5");
						rd.forward(request,response);
						
				}
				else
				{
					response.sendRedirect("Res/JSP/Admin/newuser.jsp?no=4");
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
