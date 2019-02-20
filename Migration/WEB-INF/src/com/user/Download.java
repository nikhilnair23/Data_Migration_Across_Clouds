/**
 * 
 */
package com.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.helperclass.AES_File_EncNdec;
import com.helperclass.Cloud1_Download;
import com.helperclass.XPathReader;
import com.DAO.UserDAO;;

public class Download extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		boolean flag610=false;
		
		HttpSession session = request.getSession( true );  
	       if ( session.getAttribute( "waitPage" ) == null ) 
	       {  
	    	   session.setAttribute( "waitPage", Boolean.TRUE ); 
	    	   
	    	   PrintWriter out = response.getWriter(); 
	    	   
	    	   out.println( "<html><head>" );  
	    	   out.println( "<title>Please Wait...</title>" );  
	       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
	    	   out.println( "</head><body bgcolor=''>" );  
	    	   out.println( "<br><br><br>" );
	    	   out.print( "<center><img src='img/2.gif'></img><br><br>");
	    	   out.println("<font color=white size=5>");
	    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
	    	   out.println( "You are being redirected to Cloud Storage Server......  " );
	    	   out.println( "Please wait....</h1></center");  
	    	   out.println("</font");
	    	   out.close();  
	       }  
	       else 
	       { 
	    	   session.removeAttribute( "waitPage" );  
		try
		{
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			
			
			String file_name = request.getParameter("filename");

			String memid = request.getParameter("mid");

			System.out.println("File Name :"+file_name+"Member Id :"+memid);
			
			String userid = UserDAO.getid(memid);

			String uid[] = userid.split("~");

			String useid = uid[0];

			String aes_key = uid[1];

			ArrayList<String> cloud = UserDAO.getCloud();

			String server = cloud.get(0);

			String user = cloud.get(1);
			String pass = cloud.get(2);


			String dirToCreate = "Cloud_SaDas/"+useid;

			String dwn_file_path = request.getRealPath("") + "/Files/Download/"+file_name;
			
			String ouput_path1 = request.getRealPath("") + "/Files/Download_Blocks/";
			
			 String decrpt_file_path = request.getRealPath("") + "/Files/Decryption/Dec_"+file_name;
			
			 File ff2=new File(decrpt_file_path);
			 if(ff2.exists())
			 {
				 flag610 =ff2.delete();
				 System.out.println("==============FLAG-------"+flag610);
			 }
			 if(flag610 || !ff2.exists())
			 {
			 
			 String decrpt_blocks_file_path = request.getRealPath("") + "/Files/DecryptBlocks/";
			 ArrayList<String> list=new ArrayList<String>();
			 List<File> list2 = new ArrayList<File>();
			 list=UserDAO.getBlocks(file_name);
			 System.out.println("----------LIST---------"+list);
		        for(int i=0;i<list.size();i++)
		        {
		        File ff=new File(ouput_path1+list.get(i));
		        
		        System.out.println("==============MMMMMMMMMMM========="+ouput_path1+list.get(i));
		        String dwn_form_cloud12 = Cloud1_Download.download(server, user, pass, list.get(i),dirToCreate,ouput_path1+list.get(i));
		        AES_File_EncNdec.decryptFile(ouput_path1+list.get(i),decrpt_blocks_file_path+list.get(i),aes_key);
		        System.out.println("==============KKKKKKKKKKKKKKKKKK========="+decrpt_blocks_file_path+list.get(i));
		        list2.add(new File(decrpt_blocks_file_path+list.get(i)));
		        }
		        
		        System.out.println("========J=SSSSSSSSSS==================="+list.size());
		        
		       /* for(int j=0;j<list.size();j++)
		        {
		   
		       
		       
		        }*/
		        
		        
		        FileOutputStream fos = null;
				FileInputStream fis;
				byte[] fileBytes;
				int bytesRead = 0;
			
				File ofile = new File(decrpt_file_path);
				 fos = new FileOutputStream(ofile,true);
				    
				    System.out.println("List contents are>>>>>>................."+list2);
		       
				    try
				    {
				    for (File file : list2)
			        {
			    	
			        fis = new FileInputStream(file);
			        
			        
			        
			        fileBytes = new byte[(int) file.length()];
			        
			       
			        
			        bytesRead = fis.read(fileBytes, 0,(int)  file.length());
			        
			        
			        System.out.println("file bytes are>>>>>>>>>>>>>>>>>>>>>>>> "+bytesRead);
			        
			        assert(bytesRead == fileBytes.length);
			        assert(bytesRead == (int) file.length());
			        fos.write(fileBytes);
			        fos.flush();
			        fileBytes = null;
			        fis.close();
			        fis = null;
			    }
			    
			    fos.close();
			    fos = null;
			    
			    
			    
			    
			    
			    ServletContext context = getServletContext();
			    String mimeType = context.getMimeType(decrpt_file_path);
			    if (mimeType == null) 
			    {
			    // set to binary type if MIME mapping not found
			    mimeType = "application/octet-stream";
			    }
			    System.out.println("MIME type: " + mimeType);
			    												
			    // modifies response
			    response.setContentType(mimeType);
			    response.setContentLength((int) ofile.length());

			    System.out.println("=======lenghthhhhh========="+(int) ofile.length());
			    FileInputStream inStream = new FileInputStream(ofile);												
			    // forces download
			    String headerKey = "Content-Disposition";
			    String headerValue = String.format("attachment; filename=\"%s\"", ofile.getName());
			    System.out.println("=======Fname========="+file_name);
			    response.setHeader(headerKey, headerValue);
			    // obtains response's output stream
			    OutputStream outStream = response.getOutputStream();
			    												
			    byte[] buffer = new byte[100096];
			    int bytesRead1 = -1;
			    												
			    while ((bytesRead1 = inStream.read(buffer)) != -1) 
			    {
			    outStream.write(buffer, 0, bytesRead1);
			    }
			    inStream.close();
			    outStream.close();
			    
			    
			    
			    
			    
			    
			    
				    }
				    catch(Exception e)
				    {
				    	
				    }

			// Download File From Cloud 1 //
			//String dwn_form_cloud1 = Cloud1_Download.download(server, user, pass, file_name,dirToCreate,dwn_file_path);
					
			// System.out.println("Download File Path :"+dwn_form_cloud1);
			     
			 // Decrypt the Downloaded file //
			 
			
		

				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
				String date = formatter.format(currentDate.getTime());
				String time = formatter1.format(currentDate.getTime());
				

				boolean flag = UserDAO.insertTrans(date,time,useid,file_name);
				
				System.out.println("Insertion Status :"+flag);

				
				response.sendRedirect(request.getContextPath()+"/Pass?fileNames="+decrpt_file_path+"&download=true");
			
			 }
			 else
			 {
				 response.sendRedirect(request.getContextPath()+"/Pass?fileNames="+decrpt_file_path+"&download=false");
			 }
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}}	
}
