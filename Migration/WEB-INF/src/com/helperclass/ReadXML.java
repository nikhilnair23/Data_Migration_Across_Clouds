/**
 * 
 */
package com.helperclass;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
/**
 * @author Nitin Gudle
 *Dec 10, 2011 5:34:56 PM
 *Project:-DNA
 *Package:-com.nitin.DNA.util
 *File:-ReadXML.java
 */
public class ReadXML
{
	public static String getURL(String path)
	{
		String protocol="";
		String ip="";
	      String port="";
	      String app="";
	      String program="";
		 
		  try {
	 
			File fXmlFile = new File("Config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
	 
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("server");
			System.out.println("-----------------------");
	 
			for (int temp = 0; temp < nList.getLength(); temp++) {
	 
			   Node nNode = nList.item(temp);
			   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
			      Element eElement = (Element) nNode;
			      protocol=getTagValue("protocol", eElement);
			      ip=getTagValue("ip", eElement);
			      port=getTagValue("port", eElement);
			      app=getTagValue("app", eElement);
			      program=getTagValue("program", eElement);
			      System.out.println("URL : " + getTagValue("protocol", eElement));
			      System.out.println("IP : " + getTagValue("ip", eElement));
			      System.out.println("PORT : " + getTagValue("port", eElement));
		              System.out.println("Application : " + getTagValue("app", eElement));
			      System.out.println("Program : " + getTagValue("program", eElement));
	 
			   }
			}
			 } catch (Exception e) {
			e.printStackTrace();
		  }
			 return protocol+"://"+ip+":"+port+"/"+app+"/"+program;
	  }
	 
	  private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	 
	        Node nValue = (Node) nlList.item(0);
	 
		return nValue.getNodeValue();
	  }
	  public static void main(String ad[])
		{
			System.out.println(getURL(""));
		}
}
