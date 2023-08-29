package edu.school42.printer.app;

import com.beust.jcommander.Parameter;

public class Colors {
	
	@Parameter(names = "--white", required = true)
	public String white = "WHITE";
	
	@Parameter(names = "--black", required = true)
	public String black = "BLACK";
}
