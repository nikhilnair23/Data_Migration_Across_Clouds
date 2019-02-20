/**
 * 
 */
package com.helperclass;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Nitin Gudle
 *Dec 10, 2011 5:34:00 PM
 *Project:-DNA
 *Package:-com.nitin.DNA.util
 *File:-WriteXML.java
 */
public class WriteXML
{
	public WriteXML(String path,String no,String protocol,String ip,String port,String app,String program)
	{
		 
		  try {
	 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Config");
			doc.appendChild(rootElement);
	 
			// Server elements
			Element Server = doc.createElement("Server");
			rootElement.appendChild(Server);
	 
			// shorten way
			 Server.setAttribute("id", no);
	 
			// firstname elements
			Element PROTOCOL = doc.createElement("PROTOCOL");
			PROTOCOL.appendChild(doc.createTextNode(protocol));
			Server.appendChild(PROTOCOL);
	 
			// firstname elements
			Element IP = doc.createElement("IP");
			IP.appendChild(doc.createTextNode(ip));
			Server.appendChild(IP);
			
			// lastname elements
			Element PORT = doc.createElement("PORT");
			PORT.appendChild(doc.createTextNode(port));
			Server.appendChild(PORT);
	 
			// nickname elements
			Element APP = doc.createElement("APP");
			APP.appendChild(doc.createTextNode(app));
			Server.appendChild(APP);
	 
			// salary elements
			Element PROGRAM = doc.createElement("PROGRAM");
			PROGRAM.appendChild(doc.createTextNode(program));
			Server.appendChild(PROGRAM);
	 
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			File f=new File(path+"/Config.xml");
			StreamResult result = new StreamResult(new File(path+"/Config.xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			System.out.println("File saved!");
	 
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		}
	public static void main(String ad[])
	{
		new WriteXML("","1","http","nitin","8085","DNA_Service","Service");
	}
	
}
