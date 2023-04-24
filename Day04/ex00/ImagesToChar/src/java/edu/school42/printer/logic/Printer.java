package edu.school42.printer.logic;

import java.awt.image.BufferedImage;

public class Printer {
	public char white;
	public char black;

	public Printer(char white, char black) {
		this.white = white;
		this.black = black;
	}
	
	public void printImage(BufferedImage image)	{
		for (int i = 0; i < image.getHeight(); i++) {
			for (int j = 0; j < image.getWidth(); j++) {
				int pixel = image.getRGB(j, i);
				if ((pixel & 0x00FFFFFF) == 0) {
					System.out.print(black);
				} else {
					System.out.print(white);
				}
			}
			System.out.println();
		}
	}
}