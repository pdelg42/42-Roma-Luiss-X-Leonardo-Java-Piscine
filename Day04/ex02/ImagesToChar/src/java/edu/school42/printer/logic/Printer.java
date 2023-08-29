package edu.school42.printer.logic;

import com.diogonunes.jcolor.*;
import static com.diogonunes.jcolor.Attribute.*;
import static com.diogonunes.jcolor.Ansi.colorize;


import edu.school42.printer.app.Colors;
import java.awt.image.BufferedImage;
import java.util.*;

class ParseColor {

	static HashMap<String, Integer> colorMap = initMap();

	public static HashMap<String, Integer> initMap() {
		HashMap<String, Integer> newMap = new HashMap<>();

		newMap.put("BLACK", 0x00000000);
		newMap.put("WHITE", 0x00ffffff);
		newMap.put("RED", 0x00ff0000);
		newMap.put("GREEN", 0x0000ff00);
		newMap.put("BLUE", 0x000000ff);
		newMap.put("YELLOW", 0x00ffff00);
		newMap.put("PURPLE", 0x00ff00ff);
		newMap.put("CYAN", 0x0000ffff);
		return newMap;
	}

	public static Attribute stringToColor(String key) {
		Integer r = 0;
		Integer g = 0;
		Integer b = 0;
		
		if (colorMap.containsKey(key)) {
			r = (colorMap.get(key) & colorMap.get("RED")) >>> (8l * 2l);
			g = (colorMap.get(key) & colorMap.get("GREEN")) >>> (8l * 1l);
			b = (colorMap.get(key) & colorMap.get("BLUE")) >>> (8l * 0l);
		}

		return BACK_COLOR(r, g, b);
	}

}

public class Printer {
	
	public static void printImage(Colors colors, BufferedImage image)	{
		ParseColor.initMap();

		Attribute black = ParseColor.stringToColor(colors.black);
		Attribute white = ParseColor.stringToColor(colors.white);
		for (int i = 0; i < image.getHeight(); i++) {
			for (int j = 0; j < image.getWidth(); j++) {
				int pixel = image.getRGB(j, i);
				if ((pixel & 0x00FFFFFF) == 0) {
					System.out.print(colorize("  ", black));
				} else {
					System.out.print(colorize("  ", white));
				}
			}
			System.out.println();
		}
	}
}