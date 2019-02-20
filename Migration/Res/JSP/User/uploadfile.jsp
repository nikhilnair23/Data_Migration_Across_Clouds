<%@page import="com.DAO.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="com.helperclass.*"%>
<html>
<head>

  <script>
        function validateTime(TimeField)
        {
       // var reg = /^(?:2[0-3]|[01]?[0-9]):[0-5][0-9]:[0-5][0-9]$/;
        
        var reg = /[0-2][0-9]:[0-5][0-9]:[0-5][0-9]$/;

        if (reg.test(TimeField.value) == false) 
        {
        	alert('Time format should be like this[hh:mm:ss]')
            TimeField.value = null;
            return false;
        }

        return true;

}
        </script>
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
<script language="javascript">
	function check()
	{
		if(document.f1.file.value.length==0)
		{
			alert("Please Select a File");
			return false
		}
	}
</script>

<form name="f1" method="post" action="<%=request.getContextPath() %>/UploadFile"   enctype="multipart/form-data"  >
<div style="position: absolute; top: 50px; left: 150px">
<table border="0" width="100%" cellpadding="15" cellspacing="10"
	align="center">
	<tr>
		<td colspan="3" align="center"><font
			style="font-family: cursive; font-size: 20px; color: black;"><b>File
		Upload Process</b></font></td>
	</tr>

<tr>
		<td>Choose Your File:</td>

		<td><input class="field" type="file" name="file"></input></td>

	</tr>


	<tr>
		<td>File Subject:</td>

		<td><input class="field" type="text" name="subject"></input></td>
	</tr>


	<tr>


		<td colspan="2" align="center"><input type="submit" name="submit" value="Upload" />
		</td>
	</tr>

</table>
</div>
</form>

<%
	if(Utility.parse(request.getParameter("no"))==1)
    {%>
    	<div class="success" id="message" style="position:absolute;top:-10px;font-size: 20px;color:#000;font-family: monotype corsiva;">	
    		<p>File Uploaded Successfully.....!</p>
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

</body>
</html>