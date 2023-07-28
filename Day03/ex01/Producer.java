import java.io.*;
import java.util.concurrent.*;


public class Producer implements Runnable {
	private BlockingQueue<String> queue;
	private static int _count = 0;
	private static String msg = "Egg";

	public Producer(BlockingQueue<String> queue, int count) {
		this.queue = queue; 
		_count = count;
	}

	public void run() {
		while (decount() > 0) {
			try {
				queue.put(msg);
				switchMsg();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void switchMsg() {
		if (msg.compareTo("Egg") == 0) {
			msg = "Hen";
		} else {
			msg = "Egg";
		}
	}

	private int decount() {
		return _count--;
	}
}