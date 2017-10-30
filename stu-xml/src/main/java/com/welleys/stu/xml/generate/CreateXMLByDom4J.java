//package com.welleys.stu.xml.generate;
//
//import java.io.File;
//import java.io.FileWriter;
//
//
//public class CreateXMLByDom4J {
//
//	public static void main(String[] args) {
//
//		createXMLFile();
//
//	}
//
//
//	public static void createXMLFile() {
//		Document document = DocumentHelper.createDocument();
//		Element booksElement = document.addElement("books");
//		booksElement.addComment("This is a test for dom4j, holen, 2004.9.11");
//		Element bookElement = booksElement.addElement("book");
//		bookElement.addAttribute("show", "yes");
//		Element titleElement = bookElement.addElement("title");
//		titleElement.setText("Dom4j Tutorials");
//		bookElement = booksElement.addElement("book");
//		bookElement.addAttribute("show", "yes");
//		titleElement = bookElement.addElement("title");
//		titleElement.setText("Lucene Studing");
//		bookElement = booksElement.addElement("book");
//		bookElement.addAttribute("show", "no");
//		titleElement = bookElement.addElement("title");
//		titleElement.setText("Lucene in Action");
//		Element ownerElement = booksElement.addElement("owner");
//		ownerElement.setText("��������");
//		try {
//
//			// XMLWriter writer = new XMLWriter(new FileWriter(new File(
//			// "e://jwp.xml")));
//			// writer.write(document);
//			// writer.close();
//
//			// ���������̨
//			OutputFormat format = OutputFormat.createPrettyPrint();
//			// OutputFormat format = OutputFormat.createCompactFormat();
//			format.setEncoding("utf-8");
//			// format.setEncoding("gb2312");
//			// format.setTrimText(false);
//			XMLWriter writer2 = new XMLWriter(System.out, format);
//			writer2.write(document);
//			writer2.close();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//
//
//	public int createXMLFile(String filename) {
//
//		int returnValue = 0;
//		Document document = DocumentHelper.createDocument();
//		Element booksElement = document.addElement("books");
//		booksElement.addComment("This is a test for dom4j, holen, 2004.9.11");
//		Element bookElement = booksElement.addElement("book");
//		bookElement.addAttribute("show", "yes");
//		Element titleElement = bookElement.addElement("title");
//		titleElement.setText("Dom4j Tutorials");
//		bookElement = booksElement.addElement("book");
//		bookElement.addAttribute("show", "yes");
//		titleElement = bookElement.addElement("title");
//		titleElement.setText("Lucene Studing");
//		bookElement = booksElement.addElement("book");
//		bookElement.addAttribute("show", "no");
//		titleElement = bookElement.addElement("title");
//		titleElement.setText("Lucene in Action");
//		Element ownerElement = booksElement.addElement("owner");
//		ownerElement.setText("O'Reilly");
//		try {
//			XMLWriter writer = new XMLWriter(new FileWriter(new File(filename)));
//			writer.write(document);
//			writer.close();
//			returnValue = 1;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return returnValue;
//	}
//}