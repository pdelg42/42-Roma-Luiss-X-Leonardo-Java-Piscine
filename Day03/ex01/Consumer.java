import java.io.*;
import java.util.concurrent.*;

public class Consumer implements Runnable {

	private BlockingQueue<String> queue;
	private static int _count = 0;

	public Consumer(BlockingQueue<String> queue, int count) {
		this.queue = queue;
		_count = count; 
	}

	public void run() {
		PrinterObject pObj = PrinterObject.getInst();

		while (decount() > 0) {
			try {
				pObj.print(queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private int decount() {
		return _count--;
	}
}