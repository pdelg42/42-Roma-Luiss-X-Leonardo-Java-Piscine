import java.io.*;

public class Program {
	public static void main(String args[]) {
		if (args.length != 1) {
			printError("Usage: java Progam --count=[value greater than 0]");
			return ;
		}

		int count = parseCount(args[0]);

		if (count <= 0) {
			printError("Invalid parameter");
			return ;
		}

		Thread t1 = new Thread(new TheGreatestProblem(count, "Egg"));
		Thread t2 = new Thread(new TheGreatestProblem(count, "Hen"));
		t1.start();
		t2.start();

		while (t1.isAlive() || t2.isAlive());

		for (int i = 0; i < count; i++) {
			print("Human");
		}
	}

	private static void printError(String msg) {
		System.err.println("\033[0;31m" + msg + "\033[0m");
	}

	private static void print(String msg) {
		System.out.println(msg);
	}

	private static int parseCount(String param) {
		if (!param.matches("--count=\\d+")) {
			printError("Parse error: use --count=[value greater than 0]");
			return 0;
		}

		int parsed = 0;

		try {
			parsed = Integer.parseInt(param.substring(8));
		} catch (NumberFormatException e) {
			printError("Parse error: value out of bounds");
			return 0;
		}

		return parsed;
	}
}