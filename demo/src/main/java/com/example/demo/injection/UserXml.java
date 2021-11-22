package com.example.demo.injection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.*;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@RestController
public class UserXml {

	@PostMapping("UserXpathAttak")
	public String UserXmlAttak(@RequestParam String id)
	{
        StringBuffer output = new StringBuffer();

		FileInputStream file;
		try {
			 URL url = getClass().getResource("/employees.xml");
			 
			file = new FileInputStream(new File(url.getFile()));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder =  builderFactory.newDocumentBuilder();
			System.out.println("demmarer");
			Document xmlDocument = builder.parse(file);

			XPath xPath =  XPathFactory.newInstance().newXPath();
			
			String expression ="/Employees/Employee[@emplid='"+id+"']" ;
			output.append(expression+"<br/>");
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			Node node = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
			if(null != node) {
				nodeList = node.getChildNodes();
				
				for (int i = 0;null!=nodeList && i < nodeList.getLength(); i++) {
					Node nod = nodeList.item(i);
					if(nod.getNodeType() == Node.ELEMENT_NODE)
					{
						output.append("<br/>"+nodeList.item(i).getNodeName() + " : " + nod.getFirstChild().getNodeValue()); 
						nodeList.item(i).getNodeName();
						nod.getFirstChild().getNodeValue();
					}
				}
			}
		} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return output.toString();
	}
}
