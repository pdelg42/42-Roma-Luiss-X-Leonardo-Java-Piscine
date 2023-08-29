package edu.school42.printer.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.*;

import edu.school42.printer.logic.Printer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Program {
	private static BufferedImage image;

	public static void main(String[] argv) {
		Colors colors = new Colors();

		if (argv.length != 2) {
			System.out.println("Check the README.txt!");
			System.exit(-1);	
		}

		ArrayList<String> args = new ArrayList<String>();
		for (String a: argv) {
			for (String s: a.split("=")) {
				args.add(s);
			}
		}

		try {
			JCommander.newBuilder().addObject(colors).build().parse(args.toArray(argv));
		} catch (ParameterException e) {
			System.err.println(e.getMessage());
			return ;
		}

		try {
			image = ImageIO.read(new File("./src/resources/it.bmp"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		Printer.printImage(colors, image);
	}
}