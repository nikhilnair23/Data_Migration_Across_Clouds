<%@ page import="java.sql.*" %>
<%@ page import="com.DAO.*" %>
<%@ page import="com.helperclass.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<html>
<head>
<%! 
public int convert(String str) 
{ 
	int conv=0; 
	if(str==null) 
	{ 
		str="0"; 
	} 
	else if((str.trim()).equals("null")) 
	{ 
		str="0"; 
	} 
	else if(str.equals("")) 
	{ 
		str="0"; 
	} 
	try
	{ 
		conv=Integer.parseInt(str); 
	} 
	catch(Exception e) 
	{ 
	} 
	return conv; 
	} 
%>

<link href="<%=request.getContextPath()%>/Res/CSS/style1.css" rel="stylesheet" type="text/css"/>


</head>
<body>
<center>
<%

String file_name = request.getParameter("filename");

String memid = request.getParameter("mid");

String userid = UserDAO.getid(memid);


System.out.println("memid :"+memid+"aes_key :"+userid);


String uid[] = userid.split("~");

String useid = uid[0];

String aes_key = uid[1];

System.out.println("useid :"+useid+"aes_key :"+aes_key);

ArrayList<String> cloud = UserDAO.getCloud();

String server = cloud.get(0);

String user = cloud.get(1);
String pass = cloud.get(2);


String dirToCreate = "Cloud_SaDas/"+useid;

String dwn_file_path = request.getRealPath("") + "/Files/Download/"+file_name;

// Download File From Cloud 1 //
String dwn_form_cloud1 = Cloud1_Download.download(server, user, pass, file_name,dirToCreate,dwn_file_path);
		
 System.out.println("Download File Path :"+dwn_form_cloud1);
     
 // Decrypt the Downloaded file //
 
 String decrpt_file_path = request.getRealPath("") + "/Files/Decryption/Dec_"+file_name;
 
 AES_File_EncNdec.decryptFile(dwn_form_cloud1,decrpt_file_path,aes_key);

	Calendar currentDate = Calendar.getInstance();
	SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
	SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
	String date = formatter.format(currentDate.getTime());
	String time = formatter1.format(currentDate.getTime());
	

	boolean flag = UserDAO.insertTrans(date,time,useid,file_name);
	
	System.out.println("Insertion Status :"+flag);

	

	response.sendRedirect(request.getContextPath()+"/Pass?fileNames="+decrpt_file_path+"&download=true");
%>


</center>

<%
	if(Utility.parse(request.getParameter("no"))==1)
    {%>
    	<div class="success" id="message" style="position:absolute;top:-10px;font-size: 20px;color:#000;font-family: monotype corsiva;">	
    		<p>File Downloaded Successfully.....!</p>
    	</div>			
    <%}
	if(Utility.parse(request.getParameter("no"))==2)
	{%>
		<div class="success" id="message" style="position:absolute;top:-10px;font-size: 20px;color: #000;font-family: monotype corsiva;">	
			<p>Opp's something went wrong.....!</p>
		</div>			
	<%
	}
	
	%>
	
</body></html>