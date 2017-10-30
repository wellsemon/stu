package com.welleys.stu.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CreateImageTest {
	public static void main(String[] args) throws IOException {
		BufferedImage bi = ImageIO.read(new File("F:/uX2b88A-A0f3sK7Lf.jpg"));

		Graphics2D g = bi.createGraphics();
		g.setFont(new Font("����", Font.BOLD, 15));
		g.setColor(Color.BLUE);
		g.drawString("A lovely Cat!", 22, 22);
		File outputfile = new File("F:/saved.png");
		ImageIO.write(bi, "png", outputfile);
	}
}
