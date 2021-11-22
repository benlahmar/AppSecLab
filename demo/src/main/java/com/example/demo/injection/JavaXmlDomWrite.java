package com.example.demo.injection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class JavaXmlDomWrite {

    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, TransformerException  {
    	JavaXmlDomWrite dd=new JavaXmlDomWrite();
    	dd.add();
    }
    public void add()throws ParserConfigurationException,
    TransformerException, FileNotFoundException
    {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element root = doc.createElementNS("appseclab", "users");
        doc.appendChild(root);

        root.appendChild(createUser(doc, "1", "habib", "pass"));
        root.appendChild(createUser(doc, "2", "jad", "pass2"));
        root.appendChild(createUser(doc, "3", "driss", "pass3"));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transf = transformerFactory.newTransformer();

        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DOMSource source = new DOMSource(doc);
        URL url = getClass().getResource("/users2.xml");
		 
		File myFile = new File(url.getFile());

        StreamResult console = new StreamResult(System.out);
        StreamResult file = new StreamResult(myFile);

        transf.transform(source, console);
        transf.transform(source, file);
    }

    private static Node createUser(Document doc, String id, String log,
            String pass) {

        Element user = doc.createElement("user");

        user.setAttribute("id", id);
        user.appendChild(createUserElement(doc, "log", log));
        user.appendChild(createUserElement(doc, "password", pass));
       

        return user;
    }

    private static Node createUserElement(Document doc, String name,
            String value) {

        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
       

        return node;
    }
}