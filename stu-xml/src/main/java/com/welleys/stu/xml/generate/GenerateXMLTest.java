package com.welleys.stu.xml.generate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateXMLTest {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File("D:/N20150504.xml"));
			fw.write("<?xml version=\"1.0\" encoding=\"GBK\"?>\n");
			fw.write("<Check>\n");
			fw.write("\t<Count>4</Count>\n");
			fw.write("\t<FileName>N104008140718104849961</FileName>\n");
			fw.write("\t<FileName>N104008140718133235523</FileName>\n");
			fw.write("\t<FileName>N104008140718155112498</FileName>\n");
			fw.write("\t<FileName>N104008140718164329907</FileName>\n");
			fw.write("</Check>");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
