import java.io.*;

public class TheGreatestProblem implements Runnable {

	private int count = 0;
	private String msg = "";

	public TheGreatestProblem(int times, String msg) {
		count = times;
		this.msg = msg;
	}

	public void run() {
		while (count-- > 0){
			System.out.println(msg);
		}
	}
}
