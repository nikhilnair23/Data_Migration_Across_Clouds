package com.user;


import com.DAO.UserDAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Random;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.helperclass.AES_File_EncNdec;
import com.util.Utility;
public class Packet1 extends HttpServlet 
{
    static int upload_flag;
    static int download_flag;
    static int num1;
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;	
	static byte[] byteArray=new byte[512];
	static Random random=new Random();
	 static boolean flag_new=false;
	
	static String readFile(File fileName) throws IOException
	{
		
	    BufferedReader br = new BufferedReader(new FileReader(fileName.getAbsolutePath()));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	
	public static boolean formPacket(String userid,File file, String root1,String root2 ) throws NoSuchAlgorithmException 
	{	
		
		System.out.println("=====User ID============"+userid);
		String key = UserDAO.getaeskey(userid);
     String str[]=key.split("~");
		
		String mid = str[0];
		String gpvtkey = str[1];
		//String Key=CommonDAO.getkey(userid);
		System.out.println("=====KEY======}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}======"+key);
		File file5;	
		File fileencrypt;
		int nChunks = 0;
		int fileSize=0;
		StringBuilder sb = new StringBuilder();
		String FILE_NAME="";
		String hash_blk_nos=null;
		int originalfilesize=0;
		try 
		{ 
			//String FILE_NAME1 = FILE_NAME;
			
			String pack=Utility.getPro("Packet");
			int  PART_SIZE=Integer.parseInt(pack);
			System.out.println(" - PACKET PACKET PACKET===============+++++++++++++++++++++++++++++++++++++++++++++- - "+ PART_SIZE);
			
			 FILE_NAME=file.getName();
            String extension = "";
			
			int i = FILE_NAME.lastIndexOf('.');
			
			System.out.println("i is"+i);
			
			if (i > 0)
			{
				
			 extension = FILE_NAME.substring(i+1);
			 System.out.println("extension of the file is     "  +extension);
			 
			 }
			
			String FILE_NAME5=FILE_NAME.replace(".", "_");
			
			
			
			FileInputStream inputStream;
			
			String newFileName;
			
			FileOutputStream filePart;
			
			 fileSize = (int) file.length();
			 originalfilesize=fileSize;
			 
			System.out.println("file size is>>>>>>>>>>>>>>>>>>>>>>>>>>"+fileSize);
			
			int read = 0, readLength = PART_SIZE;
			
			byte[] byteChunkPart;
			
			try 
			{
				
				inputStream = new FileInputStream(file);
				
				while (fileSize > 0) 
				{
					
					if (fileSize <= PART_SIZE) 
					{
						readLength = fileSize;
						
						
					}
					
					byteChunkPart = new byte[readLength];
			
					read = inputStream.read(byteChunkPart, 0, readLength);
					
					System.out.println("read is )))))))))))))))))"+read);
					
					fileSize -= read;
					
					System.out.println("file size after read"+fileSize);
					
					assert (read == byteChunkPart.length);
					
					
					
					
					System.out.println("byte chunk part lenght is//////"+byteChunkPart.length);
					
					nChunks++;
					
					System.out.println("Number of chunks are   "+nChunks);
					
					newFileName = FILE_NAME5 + ".p"+ Integer.toString(nChunks - 1);
					
					System.out.println("new file name is "+newFileName);
					
					filePart = new FileOutputStream(new File(root1+"\\"+FILE_NAME5+"_blk_"+Integer.toString(nChunks - 1)));
					
					//======================================================================================== 
					
					
					
					
					
					//=============================================================================================
					System.out.println("new filepart is "+filePart);
					
				        //String filename2= file5.getName();
				        
				       
					filePart.write(byteChunkPart);
					filePart.flush();
					filePart.close();
					AES_File_EncNdec.encryptFile(root1+"\\"+FILE_NAME5+"_blk_"+Integer.toString(nChunks - 1), root2+"\\"+FILE_NAME5+"_blk_"+Integer.toString(nChunks - 1),gpvtkey);
					
					try
					{
					boolean flag=UserDAO.addBlocksDetails(FILE_NAME, FILE_NAME5+"_blk_"+Integer.toString(nChunks - 1));
				     
				    }
					catch(Exception e)
					{
						e.printStackTrace();
					}  
					
				
				}
				
				inputStream.close();
			}
			catch (IOException exception) 
			{
				exception.printStackTrace();
			}
	     	}
			
			catch (Exception exception) 
			{
				exception.printStackTrace();
			}
		
	
		 return flag_new;
		} 
		
		
	
	public static void main(String[] args) throws IOException 
	{
	//Packet1 P = new Packet1();
	//File F = new File("JavaV1.txt");
	//Packet1.formPacket(F);
	}
}
