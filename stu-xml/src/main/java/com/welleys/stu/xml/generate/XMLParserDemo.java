package com.welleys.stu.xml.generate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XMLParserDemo {
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder localDocumentBuilder = localDocumentBuilderFactory
				.newDocumentBuilder();
		InputStream is = new FileInputStream(new File("IMIX10.xml"));
		Document doc = localDocumentBuilder.parse(is);
		Element localElement = doc.getDocumentElement();
		System.out.println(localElement.getNodeName());
	}
}
