package edu.school42.printer.app;

import edu.school42.printer.logic.Printer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Program {
	private static BufferedImage image;

	public static void main(String[] args) {
		if (args.length != 3 || (args[0].length() > 1 ) || (args[1].length() > 1)) {
			System.out.println("Input Error!");
			System.exit(-1);
		}
		try {
			image = ImageIO.read(new File(args[2]));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		new Printer(args[0].charAt(0), args[1].charAt(0)).printImage(image);
	}
}