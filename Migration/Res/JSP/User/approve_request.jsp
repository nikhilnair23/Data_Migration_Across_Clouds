<%@ page import="java.sql.*" %>
<%@ page import="com.DAO.*" %>
<%@ page import="com.helperclass.*" %>
<%@ page import="javax.xml.*" %>
<%@ page import="javax.xml.xpath.*" %>
<%@ page import="org.w3c.dom.*" %>
<%@ page import="javax.xml.parsers.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.io.*" %>

<%@page import="com.user.RandomValue"%><html>
<head>

<link href="<%=request.getContextPath()%>/Res/CSS/style1.css" rel="stylesheet" type="text/css"/>
</head>
<%
ArrayList<String> list=new ArrayList<String>();
String filename = request.getParameter("fname");

String mid = request.getParameter("mid");

System.out.println("filename :"+filename+"mid :"+mid);

String b = UserDAO.approveRequest(mid);


String[] uid_key = b.split("~");
String userid = uid_key[0];
String aes_key = uid_key[1];

ArrayList<String> cloud = UserDAO.getCloud1();

String server = cloud.get(0);

String user = cloud.get(1);
String pass = cloud.get(2);

String dirToCreate = "Cloud_SaDas/"+userid;

/* //String approve_file_path=request.getRealPath("")+"/Files/Approve_File/"+filename; */

String approve_file_pathnew=request.getRealPath("")+"/Files/ApprovedBlocks/";
String approve_filedecrypt_pathnew=request.getRealPath("")+"/Files/ApprovedBlocksDecrypt/";

list=UserDAO.getBlocks(filename);
 System.out.println("----------LIST---------"+list);
 
 
 String master_key = UserDAO.getMasterkey();

 
    for(int i=0;i<list.size();i++)
    {
   // File ff=new File(ouput_path1+list.get(i));
    
    System.out.println("==============Approved Path========="+approve_file_pathnew+list.get(i));
    String dwn_form_cloud12 = Cloud1_Download.download(server, user, pass, list.get(i),dirToCreate,approve_file_pathnew+list.get(i));
    AES_File_EncNdec.decryptFile(approve_file_pathnew+list.get(i),approve_filedecrypt_pathnew+list.get(i),master_key);
    System.out.println("==============Approve decrypt block========="+approve_filedecrypt_pathnew+list.get(i));
   // list2.add(new File(decrpt_blocks_file_path+list.get(i)));

	      //  String dwn_form_cloud1 = Cloud1_Download.download(server, user, pass, filename,dirToCreate,dwn_file_path);
			
	       // System.out.println("Download File Path :"+dwn_form_cloud1);
	        
	        // Decrypt the file by using user key //
	        
	     //   AES_File_EncNdec.decryptFile(dwn_form_cloud1,decrpt_file_path,gpvtkey);
	        
	        // Delete the file from cloud //
	        
    } 
    for(int i=0;i<list.size();i++)
    {
    	FTP_DeleteFiles.deleteFilesOnCloud2(userid,list.get(i));
    }


// Download File Cloud 2  //
//String dwn_form_cloud1 = Cloud1_Download.download(server, user, pass, filename,dirToCreate,approve_file_path);
		
//System.out.println("Approve File Path :"+dwn_form_cloud1);

//FTP_DeleteFiles.deleteFilesOnCloud(userid,filename);


// Decrypt the file By using Master key //

//String approve_decrypt_path=request.getRealPath("")+"/Files/Approve_Decryption/"+filename;



//AES_File_EncNdec.decryptFile(dwn_form_cloud1,approve_decrypt_path,master_key);

//Encrypt File By using user key //

String approve_encrypt_path=request.getRealPath("")+"/Files/Approve_Encryption/";
for(int i=0;i<list.size();i++)
{
AES_File_EncNdec.encryptFile(approve_filedecrypt_pathnew+list.get(i), approve_encrypt_path+list.get(i),aes_key);
}

// Upload Encrypted file into Cloud 1 //

ArrayList<String> cloud1 = UserDAO.getCloud();

String server1 = cloud1.get(0);

String user1 = cloud1.get(1);
String pass1 = cloud1.get(2);

System.out.println(" Cloud user1 :"+user1);

System.out.println("Cloud  pass1 :"+pass1);
for(int i=0;i<list.size();i++)
{

File f = new File(approve_encrypt_path+list.get(i));

FileUpload1.upload(server1,user1,pass1,list.get(i),f,dirToCreate);
}
boolean b1 = UserDAO.updateLivefile(mid,filename);


System.out.println("b1 :"+b);


if(b1)
{
	RequestDispatcher rd=request.getRequestDispatcher("/Res/JSP/Admin/view_request.jsp?no=1");
	rd.forward(request, response);
}
else
{
	RequestDispatcher rd=request.getRequestDispatcher("/Res/JSP/Admin/view_request.jsp?no=2");
	rd.forward(request, response);
}
%>
<body>


</body></html>