package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DBConnector.DBConnection;






public class UserDAO {
	
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static UserDAO userDAO=null;
	private UserDAO()
	{
		
	}
	public static UserDAO getInstance()
	{
		if(userDAO == null)
		{
			userDAO= new UserDAO();
		}
		return userDAO;
	}
	
	public boolean checkUser(String user,String pass)
	{
		boolean flag=false;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where m_user='"+user+"' and m_pass='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String admin,String pass): "+ e);
		}
		return flag;
	}
	
	
	public static ResultSet getUsers()
	{
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user");
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminProcess-->getUsers(): "+ e);
		}
		return resultSet;
		
	}
	
	public static ResultSet getClouds()
	{
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_cloud");
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminProcess-->getUsers(): "+ e);
		}
		return resultSet;
		
	}
	
	public static boolean addDeletedfile(String filename,String mid,String date)
	{
		boolean flag=false;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			statement.executeUpdate("update m_live_files set f_status='Deleted' where f_name='"+filename+"'");
			
			int i = statement.executeUpdate("insert into m_deleted_files(f_name,m_id,f_date_time,recovery_status) values('"+filename+"','"+mid+"','"+date+"','Pending')");
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->addTrans(int id,String fname,String date,String time): "+ e);
		}
		return flag;
	}
	
	public static boolean addRequest(String filename,String mid,String date)
	{
		boolean flag=false;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			
			int i = statement.executeUpdate("insert into m_recovery(f_name,m_id,reco_date_time) values('"+filename+"','"+mid+"','"+date+"')");
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->addTrans(int id,String fname,String date,String time): "+ e);
		}
		return flag;
	}
	
	public static boolean deleteRequest(int recoid)
	{
		boolean flag=false;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			
			int i = statement.executeUpdate("delete from m_recovery where reco_id='"+recoid+"'");
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->addTrans(int id,String fname,String date,String time): "+ e);
		}
		return flag;
	}
	
	public static String approveRequest(String mid)
	{
		String data="";
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			
			resultSet= statement.executeQuery("select m_user,m_key1 from m_user where m_user='"+mid+"'");
			
			while(resultSet.next())
			{
				data = resultSet.getString(1)+"~"+resultSet.getString(2);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->addTrans(int id,String fname,String date,String time): "+ e);
		}
		return data;
	}
	public static boolean ChangePass(String name,String pwd)
	{
		
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "update m_user set m_pass = '"+pwd+"' where m_user = '"+name+"' ";
			
		 statement.executeUpdate(sql);
			
			
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return true;
		
	}
	
	public static ResultSet getprofile(String name)
	{

		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_user where m_user = '"+name+"' ";
			
			resultSet =  statement.executeQuery(sql);
			
			
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
		
	}
	
	public static boolean loginCHK(String name, String pass) 
	{
		boolean flag=false;
		try
		{
			DBConnection database=DBConnection.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where m_user='"+name+"' and m_pass='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO.loginCHK()....."+e);
		}
		return flag;
	}
	
	public static String getMasterkey()
	{
		String key = "";
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select m_master_key from m_admin where m_admin='admin'");
			while(resultSet.next())
			{
				key=resultSet.getString(1);
			}
			System.out.println("User name is : "+key);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->addTrans(int id,String fname,String date,String time): "+ e);
		}
		return key;
	}
	
	public String getName(int id)
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
			System.out.println("User name is : "+name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->GetName(int id): "+ e);
		}
		return name;
	}
	public static String getFileName(int id)
	{
		String name="";
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select f_name from m_live_files where f_no='"+id+"'");
			while(resultSet.next())
			{
				name=resultSet.getString(1);
			}
			System.out.println("Filename  is : "+name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->GetFileName(int id): "+ e);
		}
		return name;
	}
	public static String getaeskey(String id)
	{
		String key="";
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql="select m_id,m_key1 from m_user where m_user='"+id+"'";
			System.out.println("=====================KEY FETCH====="+sql);
			resultSet = statement.executeQuery("select m_id,m_key1 from m_user where m_user='"+id+"'");
			while(resultSet.next())
			{
				key=resultSet.getInt(1)+"~"+resultSet.getString(2);
			}
			System.out.println("key is : "+key);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->GetName(int id): "+ e);
		}
		return key;
	}
	
	public static String getid(String id)
	{
		String key="";
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select m_user,m_key1 from m_user where m_user='"+id+"'");
			while(resultSet.next())
			{
				key=resultSet.getString(1)+"~"+resultSet.getString(2);
			}
			System.out.println("key is : "+key);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->GetName(int id): "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return key;
	}
	
	
	public int getID(String userid)
	{
		int i=0;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select m_id from m_user where m_user='"+userid+"'");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->etID(String userid): "+ e);
		}
		return i;
	}
	
	public static boolean addFile(String fname,String uid,String date,String sub,String living_time)
	{
		boolean flag=false;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("insert into m_live_files(f_name,m_id,f_date_time,f_status,f_subject,f_living_time) values('"+fname+"','"+uid+"','"+date+"','Live','"+sub+"','"+living_time+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->etID(String userid): "+ e);
		}
		return flag;
	}
	
	public int getKey1(int id)
	{
		int i=0;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select m_key1 from m_user where m_id='"+id+"'");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("User Key is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getKey(String userid): "+ e);
		}
		return i;
	}
	public int getKey2(int id)
	{
		int i=0;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select m_key2 from m_user where m_id='"+id+"'");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("User Key1 is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getKey1(String userid): "+ e);
		}
		return i;
	}
	
	public boolean addUser(String id,String pwd,String name,String city,String email,String key1)
	{
		boolean flag=false;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("insert into m_user (m_user,m_pass,m_name,m_city,m_email,m_key1) values('"+id+"','"+pwd+"','"+name+"','"+city+"','"+email+"','"+key1+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Register status  : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->register(): "+ e);
		}
		return flag;
	}
	
	public static boolean insertTrans(String date,String time,String loid,String fname) throws SQLException
	{
		boolean flag=false;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("insert into m_transaction(t_date,t_time,m_loginid,f_name,f_status) values('"+date+"','"+time+"','"+loid+"','"+fname+"','Downloaded')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("insertTrans download status  : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception : "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return flag;
	}
	
	
	public ResultSet getFiles(int userid)
	{
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select *  from trans where type='Encrypt' and userid='"+userid+"' and flag='true'");
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		return resultSet;
	}
	
	public static ArrayList<String> getCloudFirst()
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select c_url,c_uname,c_pwd from m_cloud where c_code='1'");
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
				list.add(resultSet.getString(2));
				list.add(resultSet.getString(3));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	
	public static ArrayList<String> getCloud1()
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select c_url,c_uname,c_pwd from m_cloud where c_code='2'");
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
				list.add(resultSet.getString(2));
				list.add(resultSet.getString(3));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		return list;
	}
	public static ArrayList<String> getCloud()
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select c_url,c_uname,c_pwd from m_cloud where c_code='1'");
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
				list.add(resultSet.getString(2));
				list.add(resultSet.getString(3));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		return list;
	}
	
	public boolean addTransUpload(int id,String fname,String date,String time)
	{
		boolean flag=false;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			//makeFalse("Encrypt",fname);
			int i = statement.executeUpdate("insert into trans(type,time,date,userid,file_name,flag)values('Upload','"+time+"','"+date+"','"+id+"','"+fname+"','True')");
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->addTrans(int id,String fname,String date,String time): "+ e);
		}
		return flag;
	}
	
	public static boolean updateLivefile(String mid,String fname)
	{
		boolean flag=false;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			statement.executeUpdate("update m_deleted_files set recovery_status='Approved' where m_id='"+mid+"' and f_name='"+fname+"'");
			int i=statement.executeUpdate("update m_live_files set f_status='Live' where m_id='"+mid+"' and f_name='"+fname+"'");
			if(i!=0)
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->makeFalse(): "+ e);
		}
		return flag;
	}
	
	public ResultSet getUploadFiles(int userid)
	{
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from trans where userid='"+userid+"' and (type='Encrypt' or type='Upload')");
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		return resultSet;
	}
	
	public ResultSet getDFiles(int userid)
	{
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from trans where userid='"+userid+"'and type='Upload' and flag='True'");
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		return resultSet;
	}
	
	public boolean addTransD(int id,String fname,String date,String time)
	{
		boolean flag=false;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			//makeFalse("Upload",fname);
			int i = statement.executeUpdate("insert into trans(type,time,date,userid,file_name,flag)values('Download','"+time+"','"+date+"','"+id+"','"+fname+"','True')");
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->addTrans(int id,String fname,String date,String time): "+ e);
		}
		return flag;
	}
	
	public ResultSet getDFiles1(int userid)
	{
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from trans where userid='"+userid+"' and type='Download' and flag='True'");
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		return resultSet;
	}
	
	public boolean addTransDec(int id,String fname,String date,String time)
	{
		boolean flag=false;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		//	makeFalse("Download",fname);
			int i = statement.executeUpdate("insert into trans(type,time,date,userid,file_name,flag)values('Decrypt','"+time+"','"+date+"','"+id+"','"+fname+"','True')");
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->addTrans(int id,String fname,String date,String time): "+ e);
		}
		return flag;
	}
	
	public ResultSet getUFiles1(int userid)
	{
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from trans where userid='"+userid+"' and (type='Decrypt' or type='Download')");
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		return resultSet;
	}
	
	
	//------------------------------2/2/2016----------------------------------------------------------------------------------
	
	public static boolean addBlocksDetails(String filename,String blocks)
	{
		boolean flag=false;
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			
			int i = statement.executeUpdate("insert into m_fileblocks(file_name,block_names) values('"+filename+"','"+blocks+"')");
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->addTrans(int id,String fname,String date,String time): "+ e);
		}
		return flag;
	}
	
	
	
	public static ArrayList<String> getBlocks(String filename)
	{
		boolean flag=false;
		ResultSet rs=null;
		ArrayList<String> list=new ArrayList<String>();
		try
		{
			DBConnection dao=DBConnection.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			
		rs= statement.executeQuery("select block_names from m_fileblocks where file_name='"+filename+"'");
		while(rs.next())
		{
			String bname=rs.getString(1);
			list.add(bname);
		}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->addTrans(int id,String fname,String date,String time): "+ e);
		}
		return list;
	}
	
	

}
