package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DAO.*;
import com.DBConnector.*;
import com.DBConnector.*;
import com.DBConnector.*;

import com.admin.AdminLogin;



public class AdminDAO {
	
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static AdminDAO adminDAO=null;
	private AdminDAO()
	{
		
	}
	public static AdminDAO getInstance()
	{
		if(adminDAO == null)
		{
			adminDAO= new AdminDAO();
		}
		return adminDAO;
	}
	public boolean checkAdmin(String admin,String pass)
	{
		boolean flag=false;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_admin where m_admin='"+admin+"' and m_pass='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->checkAdmin(String admin,String pass): "+ e);
		}
		return flag;
	}
	
	public static boolean loginCHK(String name, String pass) 
	{
		boolean flag=false;
		try
		{
			DBConnection database=DBConnection.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_admin where m_admin='"+name+"' and m_pass='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO.loginCHK()....."+e);
		}
		return flag;
	}
	public static boolean loginid(String id) 
	{
		boolean flag=false;
		try
		{
			DBConnection database=DBConnection.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where m_user='"+id+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO.loginCHK()....."+e);
		}
		return flag;
	}
	public static boolean ChangePass(String name,String pwd)
	{
		
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "update m_admin set m_pass = '"+pwd+"' where m_admin = '"+name+"' ";
			
		 statement.executeUpdate(sql);
			
			
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return true;
		
	}
	
	public static boolean masterKey(String name,String key)
	{
		
		try
		{
			System.out.println("=====KEY in "+key);
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "update m_admin set m_master_key = '"+key+"' where m_admin = '"+name+"' ";
			System.out.println(sql);
		 statement.executeUpdate(sql);
			
			
			 
			System.out.println("Key Generated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return true;
		
	}
	
	public static int editUser(String adminid, String name, String city,String mobile,int code) throws SQLException
	{
		int flag=0,n2;
		

		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			n2=statement.executeUpdate("update m_user set m_user='"+adminid+"',m_name='"+name+"',m_city='"+city+"',m_email='"+mobile+"' where m_id='"+code+"'");
			
			System.out.println(n2);
			if(n2==1)
			{
				flag=1;
				System.out.println("Flag :"+flag);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			connection.close();
		}

		return flag;
	}
	
	 public static boolean deleteUser(String id) 
		{
			boolean flag=false;
			
			
			try
			{
				DBConnection dao=DBConnection.getInstance();
				connection=dao.connector();
				statement = connection.createStatement();
				
				String sql = "delete from m_user where m_id='"+id+"'";
				System.out.println(sql);
				int i=statement.executeUpdate(sql);
				if(i!=0)
				{
					flag=true;
				}
				System.out.println("Admin delete user Status : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-deleteUser()....."+e);
			}
			return flag;
		}
		
	 
	 
	public static ResultSet getliveFiles(String userid)
	{
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_live_files where f_status='Live' and m_id='"+userid+"'");
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminProcess-->getFiles(): "+ e);
		}
		return resultSet;
	}
	
	public static ResultSet getliveFiles()
	{
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_live_files where f_status='Live' ");
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminProcess-->getFiles(): "+ e);
		}
		return resultSet;
	}
	
	public static ResultSet getdeletedFiles(String userid)
	{
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_deleted_files where m_id='"+userid+"'");
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminProcess-->getFiles(): "+ e);
		}
		return resultSet;
	}
	
	public static ResultSet getdeletedFiles()
	{
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_deleted_files ");
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminProcess-->getFiles(): "+ e);
		}
		return resultSet;
	}
	
	public static ResultSet viewRequest()
	{
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_recovery");
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminProcess-->getFiles(): "+ e);
		}
		return resultSet;
	}
	
	
	public String getUser(int id)
	{
		String name="";
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select m_name from m_user where m_id='"+id+"'");
			while(resultSet.next())
			{
				name=resultSet.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminProcess-->getUser(int id): "+ e);
		}
		return name;
	}
	
	public static ResultSet getprofile(String name)
	{
		
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_admin where m_admin = '"+name+"' ";
			
		resultSet =  statement.executeQuery(sql);
			
			
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
		
	}

}
