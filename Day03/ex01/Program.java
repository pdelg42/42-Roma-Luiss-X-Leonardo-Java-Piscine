import java.io.*;
import java.util.concurrent.*;

public class Program {


	public static void main(String args[]) {
		PrinterObject pObj = PrinterObject.getInst();
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

		if (args.length != 1) {
			pObj.printError("Usage: java Progam --count=[value greater than 0]");
			return ;
		}
		
		int count = parseCount(args[0]);
		
		if (count <= 0) {
			pObj.printError("Invalid parameter");
			return ;
		}

		Producer prod = new Producer(queue, count);
		Consumer cons = new Consumer(queue, count);

		Thread t1 = new Thread(prod);
		Thread t2 = new Thread(cons);
		t1.start();
		t2.start();

		
	}

	private static int parseCount(String param) {
		PrinterObject pObj = PrinterObject.getInst();

		if (!param.matches("--count=\\d+")) {
			pObj.printError("Parse error: use --count=[value greater than 0]");
			return 0;
		}

		int parsed = 0;

		try {
			parsed = Integer.parseInt(param.substring(8));
		} catch (NumberFormatException e) {
			pObj.printError("Parse error: value out of bounds");
			return 0;
		}

		return parsed;
	}
}