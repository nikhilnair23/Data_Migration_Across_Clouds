/**
 * 
 */
package com.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.PrivateKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;


import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;

import com.DAO.UserDAO;

import com.helperclass.AES_File_EncNdec;
import com.helperclass.Cloud1_Download;
import com.helperclass.FTP_DeleteFiles;
import com.helperclass.FileUpload1;



public class UploadFile extends HttpServlet
{
	
	javax.swing.Timer access_timer;
	String id="";
	String filename="", server="",user="",pass="",dirToCreate="",delete_ouput_path="";
	String dwn_file_path="",decrpt_file_path="",dwn_file_path2 ="",ouput_path2="",decrpt_file_path2="",decrpt_blocks_file_path="";
	
	
	ArrayList<String> list=new ArrayList<String>();
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
			{
		
		//=====================================
		 
			/*String dwn_file_path = request.getRealPath("") + "/Files/Download/"+file_name;
			
			String ouput_path1 = request.getRealPath("") + "/Files/Download_Blocks/";
			
			 String decrpt_file_path = request.getRealPath("") + "/Files/Decryption/Dec_"+file_name;
			
			 String decrpt_blocks_file_path = request.getRealPath("") + "/Files/DecryptBlocks/";*/
		//=====================================
		
		
		
		
		
		
		
		
		
		
		String dest ="", dest1="";
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		HttpSession hs = request.getSession();

		
		 id = hs.getAttribute("name").toString();

		FileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
		try {

			List fileItems = servletFileUpload.parseRequest(request);

			FileItem file = (FileItem) fileItems.get(0);
			
			FileItem file1 = (FileItem) fileItems.get(1);
			
			FileItem file2 = (FileItem) fileItems.get(2);
			
			String val = file1.getString();
			String val1 = file2.getString();
			
			System.out.println("File Intem cvcbcv:" + val+"val1 :"+val1);

			
			// Write input File into Upload_Files //
			
			String fileName = request.getRealPath("") + "/Upload_Files/"+ file.getName();
			File uploadedFile2=new File(fileName);
			String root1 = getServletContext().getRealPath("/OUT");
			String root2 = getServletContext().getRealPath("/OUT_ENC");
			OutputStream outputStream = new FileOutputStream(fileName);
			InputStream inputStream = file.getInputStream();

			int readBytes = 0;
			byte[] buffer = new byte[10000];
			while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1)
			{
				outputStream.write(buffer, 0, readBytes);
			}
			outputStream.close();
			inputStream.close();
						
			
			if (file.getName() != null )
			{
				
				boolean flag_packet=Packet1.formPacket(id,uploadedFile2,root1,root2);
				
				// Read file //
				String ouput_path = request.getRealPath("") + "/Files/Encryption/Enc_"+ file.getName();
				
				String ouput_path1 = request.getRealPath("") + "/OUT_ENC/";
				
				//String data1 = ReadFile.readfile(fileName);
				System.out.println("========================ID=================="+id);
				String key = UserDAO.getaeskey(id);
				
				String str[]=key.split("~");
				
				String mid = str[0];
				String gpvtkey = str[1];
				
				// Encrypt the file by using user AES key //
				
				//AES_File_EncNdec.encryptFile(fileName, ouput_path,gpvtkey);
				

				//File Upload Process //

				ArrayList<String> cloud = UserDAO.getCloud();
				
				server = cloud.get(0);
				filename = file.getName();
		        user = cloud.get(1);
		        pass = cloud.get(2);
		        
		        dirToCreate = "Cloud_SaDas/"+id;
		        File f = new File(ouput_path);
		        
		        File f1=new File(ouput_path);
		        list=UserDAO.getBlocks(filename);
		        for(int i=0;i<list.size();i++)
		        {
		        File ff=new File(ouput_path1+list.get(i));
				FileUpload1.upload(server,user,pass,list.get(i),ff,dirToCreate);
				
		        }
				// Date and Time Function //
		        System.out.println("hhjhjshdjhjd");
				
				
			}   
		        
		        
		        
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
			
		        
		        
		        
		     
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
				String date = formatter.format(currentDate.getTime());
				String time = formatter1.format(currentDate.getTime());
				
				date = date + "  " + time;
				
				delete_ouput_path = request.getRealPath("") + "/Files/Delete_Encryption/";
				
				 
				dwn_file_path=request.getRealPath("")+"/Files/Download/"+filename;
				decrpt_file_path=request.getRealPath("")+"/Files/Exp_Decryption/Dec_"+filename;
				
				//----------------------------------------------------------------------------------------
				
				 dwn_file_path2 = request.getRealPath("") + "/Files/Download/"+filename;
				
				 ouput_path2 = request.getRealPath("") + "/Files/Download_Blocks2/";
				
				  decrpt_file_path2 = request.getRealPath("") + "/Files/Decryption2/Dec_"+filename;
				
				  decrpt_blocks_file_path = request.getRealPath("") + "/Files/DecryptBlocks2/";
				 String val=null;
				 String val1=null;
				 
				
				//---------------------------------------------------------------------------------------------------
				
				boolean b =UserDAO.addFile(filename, id,date,val1,val);
				
				if(b)
				{
					 rd = request.getRequestDispatcher("/Res/JSP/User/uploadfile.jsp?no=1");
						
					 rd.forward(request, response);
				}
				else
				{
					 rd = request.getRequestDispatcher("/Res/JSP/User/uploadfile.jsp?no=2");
						
					 rd.forward(request, response);
				}
				
				
			}
		

		}


	/*
	   	        	//System.out.println("===================IF CONDITION===================+"+seconds1);
	   	        	   
	   	        	//javax.swing.Timer access_timer=new javax.swing.Timer(0, new AccessTimer(val));
	   	        	   try
	   	        	   {
	   	        		  
	   	        		String key = UserDAO.getaeskey(id);
	 	   	  			
	 	   	  			String str[]=key.split("~");
	 	   	  			
	 	   	  			String mid = str[0];
	 	   	  			String gpvtkey = str[1];
	 	   	  	        
	 	   	  			// Download file from cloud 1 //
	 	   	  			
	 	   	  			
	 	   	  			
	 	   	  		 list=UserDAO.getBlocks(filename);
	 				 System.out.println("----------LIST---------"+list);
	 				 
	 				 
	 				 
	 				
	 				 
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
	 	   	        	ArrayList<String> cloud = UserDAO.getCloud1();
	 					
	 	   	        	File f = new File(fpath);
	 					String server = cloud.get(0);
	 					//String filename = f.getName();
	 			        String user = cloud.get(1);
	 			        String pass = cloud.get(2);
	 			        
	 			        dirToCreate = "Cloud_SaDas/"+id;
	 			        
	 			       
	 					FileUpload1.upload(server,user,pass,list.get(i),f,dirToCreate);
	 			       }
	 	   	
	 			        
	 	   	        	Calendar currentDate = Calendar.getInstance();
	 					SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
	 					SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
	 					String date = formatter.format(currentDate.getTime());
	 					String time = formatter1.format(currentDate.getTime());
	 					
	 					date = date + "  " + time;
	 					
	 					// Add information into delete file tables //
	 					
	 	   	        	 boolean f1 = UserDAO.addDeletedfile(filename, id, date);
	 	   	        	 
	 	   	        	 System.out.println("Insert Deleted File Status :"+f1);
	   	        		 
	 			      
	   	        	
	   	        	   }
	   	        	   catch (Exception e1)
	   	        	   {
						// TODO: handle exception
					}
	   	        	
	   	           }
	   	        	 
	   	     	   
	   	           
	
		
	   	public int getTime()
		{
			String timeformat = "HH:mm:ss";
			SimpleDateFormat obDateFormat = new SimpleDateFormat(timeformat);
			Calendar cal = Calendar.getInstance();
			String time= obDateFormat.format(cal.getTime());
			
			 String time1[]=time.split(":");
			 int hour=Integer.parseInt(time1[0]);
			 int min=Integer.parseInt(time1[1]);
			 int sec=Integer.parseInt(time1[2]);
			 int seconds=hour*3600+min*60+sec;
			
			  return seconds;
		}
	
	}
	*/


