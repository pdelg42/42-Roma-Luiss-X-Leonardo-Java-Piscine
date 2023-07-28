
public class PrinterObject {
	
	private static PrinterObject  _inst = null;

	private int id = 0;
	
	private PrinterObject() {
		id += 1;
	};

	public static PrinterObject getInst() {
		if (_inst == null) {
			_inst = new PrinterObject();
		}

		return _inst;
	}

	public void printError(String msg) {
		System.err.println("\033[0;31m" + msg + "\033[0m");
	}

	public void printId() {
		_inst.print(String.valueOf(_inst.id));
	}

	public synchronized void print(String msg) {
		System.out.println(msg);
	}
}	