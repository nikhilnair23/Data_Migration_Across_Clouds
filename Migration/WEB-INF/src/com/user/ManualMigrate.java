package com.user;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.helperclass.AES_File_EncNdec;
import com.helperclass.Cloud1_Download;
import com.helperclass.FTP_DeleteFiles;
import com.helperclass.FileUpload1;





public class ManualMigrate extends HttpServlet 
{
	String id="";
	String filename="", server="",user="",pass="",dirToCreate="",delete_ouput_path="";
	String dwn_file_path="",decrpt_file_path="",dwn_file_path2 ="",ouput_path2="",decrpt_file_path2="",decrpt_blocks_file_path="";
	
	boolean f1=false,b=false;
	ArrayList<String> list=new ArrayList<String>();


	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
	
		 delete_ouput_path = request.getRealPath("") + "/Files/Delete_Encryption/";
			
		 
			dwn_file_path=request.getRealPath("")+"/Files/Download/"+filename;
			decrpt_file_path=request.getRealPath("")+"/Files/Exp_Decryption/Dec_"+filename;
			
			//----------------------------------------------------------------------------------------
			
			 dwn_file_path2 = request.getRealPath("") + "/Files/Download/"+filename;
			
			 ouput_path2 = request.getRealPath("") + "/Files/Download_Blocks2/";
			
			  decrpt_file_path2 = request.getRealPath("") + "/Files/Decryption2/Dec_"+filename;
			
			  decrpt_blocks_file_path = request.getRealPath("") + "/Files/DecryptBlocks2/";
		HttpSession hs = request.getSession();

		
		 id = hs.getAttribute("name").toString();
		 System.out.println("logged in Uid"+id);		 
		try
		{
			String submit=request.getParameter("submit").trim();
			
			
			if(submit.equals("migrate"))
			{
				String []chk=request.getParameterValues("chk");
					//String filename = request.getParameter("filename");
					//System.out.println("filename is"+filename);

				for(int i=0;i<chk.length;i++)
				{
					System.out.println(chk[i]);
				b=doMigrate(chk[i]);
				}
					
				if(b)
				{
					 rd = request.getRequestDispatcher("/Res/JSP/User/download.jsp?no=3");
						
					 rd.forward(request, response);
				}
				else
				{
					 rd = request.getRequestDispatcher("/Res/JSP/User/download.jsp?no=2");
						
					 rd.forward(request, response);
				}
					
			}
		}
		catch(Exception e){}
		
	}
		public boolean doMigrate(String fileid){
			
			
			
			 try
	        	   {
	        		  
	        		String key = UserDAO.getaeskey(id);
	        		System.out.println("do Migrate"+key);
  	  			
  	  			String str[]=key.split("~");
  	  		
  	  			
  	  			String mid = str[0];
  	  		System.out.println("do Migrate mid --"+mid);
  	  		
  	  			String gpvtkey = str[1];
  	  		System.out.println("do Migrate gpvtkey --"+mid);
  	  		
  	  	        
  	  			// Download file from cloud 1 //
  	  			
  	  				int f_id=Integer.parseInt(fileid);
  	  				String filename=UserDAO.getFileName(f_id);
  	  			System.out.println("filename from manualMigrate"+filename);
  	  			
  	  		 list=UserDAO.getBlocks(filename);
			 System.out.println("----------LIST---------"+list);
			 
			 ArrayList<String> cloud = UserDAO.getCloud();
				
				server = cloud.get(0);
			
		        user = cloud.get(1);
		        pass = cloud.get(2);
		        
		        dirToCreate = "Cloud_SaDas/"+id;
		       
				 String val=null;
			 
		        for(int i=0;i<list.size();i++)
		        {
		       // File ff=new File(ouput_path1+list.get(i));
		        
		        System.out.println("==============MMMMMMMMMMM========="+ouput_path2+list.get(i));
		        String dwn_form_cloud12 = Cloud1_Download.download(server, user, pass, list.get(i),dirToCreate,ouput_path2+list.get(i));
		        AES_File_EncNdec.decryptFile(ouput_path2+list.get(i),decrpt_blocks_file_path+list.get(i),gpvtkey);
		        System.out.println("==============KKKKKKKKKKKKKKKKKK========="+decrpt_blocks_file_path+list.get(i));
		       // list2.add(new File(decrpt_blocks_file_path+list.get(i)));
		    
  	  	      //  String dwn_form_cloud1 = Cloud1_Download.download(server, user, pass, filename,dirToCreate,dwn_file_path);
  	  			
  	  	       // System.out.println("Download File Path :"+dwn_form_cloud1);
  	  	        
  	  	        // Decrypt the file by using user key //
  	  	        
  	  	     //   AES_File_EncNdec.decryptFile(dwn_form_cloud1,decrpt_file_path,gpvtkey);
  	  	        
  	  	        // Delete the file from cloud //
  	  	        
		        } 
		       for(int i=0;i<list.size();i++)
		        {
		    	  FTP_DeleteFiles.deleteFilesOnCloud(id,list.get(i));
		        }
  	  	        // Stop Timer //
  	  	       // access_timer.stop();
  	  	        
  	  	       // System.out.println(" Timer event is working :"+time);
        	 
  	  	  for(int i=0;i<list.size();i++)
	        {
  	        	 //Encrypt the file by using master key//
  	        	 
  	        	 String fpath = delete_ouput_path+list.get(i);
  	        	 
  	        	 String master_key = UserDAO.getMasterkey();
  	        	 
  	        	AES_File_EncNdec.encryptFile(decrpt_blocks_file_path+list.get(i), fpath,master_key);
  	        	 
  	        	// Upload the file into Cloud 2 //
  	        	ArrayList<String> cloud2 = UserDAO.getCloud1();
				
  	        	File f = new File(fpath);
				String server = cloud2.get(0);
				//String filename = f.getName();
		        String user = cloud2.get(1);
		        String pass = cloud2.get(2);
		        
		        dirToCreate = "Cloud_SaDas/"+id;
		        
		       
				FileUpload1.upload(server,user,pass,list.get(i),f,dirToCreate);
				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
				String date = formatter.format(currentDate.getTime());
				String time = formatter1.format(currentDate.getTime());
	  		f1 = UserDAO.addDeletedfile(filename, id, date);
				
		       }
	        	   }
			 catch(Exception e){}	 
			 
		
  	  	
  	  	if(f1)
		{
			 return true;
		}
		else
		{
			return false;
		}
  	

}
}
	


	