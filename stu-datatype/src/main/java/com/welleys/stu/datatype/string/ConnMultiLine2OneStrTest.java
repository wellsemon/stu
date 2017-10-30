package com.welleys.stu.datatype.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConnMultiLine2OneStrTest {
	public static void main(String[] args) throws IOException {
		File file = new File("E:/test.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
				"E:/test2.txt"), true));

		String tmp = "";

		while (null != (tmp = br.readLine())) {
			bw.write(tmp);
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
