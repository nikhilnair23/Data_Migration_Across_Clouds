/**
 * 
 */
package com.helperclass;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XPathReader 
{

	private String xmlFile;
    private Document xmlDocument;
    private XPath xPath;
    public XPathReader(String xmlFile) 
    {
        this.xmlFile = xmlFile;
        System.out.println(this.xmlFile);
        initObjects();
    }
    private void initObjects()
    {        
        try
        {
        	xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
        	System.out.println(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile));
        	System.out.println(xmlDocument);
            xPath =  XPathFactory.newInstance().newXPath();
            System.out.println(xPath);
        }
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
        catch (SAXException ex) 
        {
            ex.printStackTrace();
        }
        catch (ParserConfigurationException ex) 
        {
            ex.printStackTrace();
        }       
    }
    
    public String read(String expression,QName returnType)
    {
        try 
        {
        	XPathExpression xPathExpression =xPath.compile(expression);
        	System.out.println(xPathExpression);
        	String a= (String) xPathExpression.evaluate(xmlDocument, returnType);
        	System.out.println(a);
        	return a;
        } 
        catch (XPathExpressionException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public static String getProtocol(String file,String protocol,int id)
    {
    	XPathReader reader = new XPathReader(file);
    	String expression = "/Config/server["+id+"]/"+protocol;
        String a=reader.read(expression,XPathConstants.STRING);
        return a;
    }
    public static String getHost(String file,String host,int id)
    {
    	XPathReader reader = new XPathReader(file);
    	String expression = "/Config/server["+id+"]/"+host;
        String a=reader.read(expression,XPathConstants.STRING);
        return a;
    }
    public static String getPort(String file,String port,int id)
    {
    	XPathReader reader = new XPathReader(file);
    	String expression = "/Config/server["+id+"]/"+port;
        String a=reader.read(expression,XPathConstants.STRING);
        return a;
    }
    public static String getApp(String file,String app,int id)
    {
    	XPathReader reader = new XPathReader(file);
    	String expression = "/Config/server["+id+"]/"+app;
        String a=reader.read(expression,XPathConstants.STRING);
        return a;
    }
    public static String getProgram(String file,String program,int id)
    {
    	XPathReader reader = new XPathReader(file);
    	String expression = "/Config/server["+id+"]/"+program;
        String a=reader.read(expression,XPathConstants.STRING);
        return a;
    }
    public static void main(String adf[])
    {
    	String a=XPathReader.getProgram("Config.xml","program", 1);
    	System.out.println(a);
    }
}
