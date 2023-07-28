import java.util.*;

public class Program {
	private static PrinterObject pObj = PrinterObject.getInst();
	private static int arraySize = 0;
	private static int threads = 0;
	private static int[] arr;
	
	public static void main(String[] args) {
		Random rObj = new Random();

		if (args.length != 2) {
			pObj.printError("Usage: java Progam --arraySize={value} --threadsCount={value}");
			return ;
		}

		if (!parseArgs(args)) {
			pObj.printError("Invalid parameters");
			return ;
		}

		arr = new int[arraySize + 1];
		for (int i = 0; i < arraySize; i++) {
			arr[i] = rObj.nextInt(1000);
		}

		int stdSum = 0;
		for (int a: arr) {
			stdSum += a;
		}
		pObj.print("Sum: " + stdSum);

		int startArrPos = 0;
		int finalArrPos = 0;
		Thread[] tasks = new Thread[threads];
		for (int i = 1; i <= threads; i++) {
			finalArrPos = arraySize * i / threads;
			Thread task = new Thread(new AdderClass(i, startArrPos, finalArrPos, arr));
			startArrPos = finalArrPos + 1;
			tasks[i - 1] = task;
			task.start();
		}
		
		int stillRunning = 1;
		while (stillRunning > 0) {
			stillRunning = 0;
			for (Thread t: tasks) {
				if (t.isAlive()) {
					stillRunning += 1;
				}
			}
		};

		pObj.print("Sum by threads: " + AdderClass.getTotalSum());	
	}

	private static boolean parseArgs(String[] args) {
		if (!args[0].matches("--arraySize=\\d+")) {
			pObj.printError("flag '--arraySize={value}' not matching");
			return false;
		}

		arraySize = parseIntVal(args[0], 12);
		if (arraySize == 0 || arraySize > 2 * 10e6) {
			pObj.printError("values accepted: 0 < value <= 2000000");
			return false;
		}
		
		if (!args[1].matches("--threadsCount=\\d+")) {
			pObj.printError("flag '--threadsCount={value}' not matching");
			return false;
		}

		threads = parseIntVal(args[1], 15);
		if (threads == 0 || threads > arraySize) {
			pObj.printError("values accepted: 0 < value <= arraySize");
			return false;
		}
		return true;
	}

	private static int parseIntVal(String param, int from) {
		int parsed = 0;

		try {
			parsed = Integer.parseInt(param.substring(from));
		} catch (NumberFormatException e) {
			pObj.printError("Parse error: value out of bounds");
			return 0;
		}

		return parsed;
	}
}
