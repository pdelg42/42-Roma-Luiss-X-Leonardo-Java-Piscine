public class AdderClass implements Runnable {

	AdderClass adder;
	
	private static int globalSum = 0;
	private static PrinterObject pObj = PrinterObject.getInst();
	private int localChunkSize;
	private int[] chunk;
	private int localSum = 0;
	private int start;
	private int chunkSize;
	private String name = "Thread";

	public AdderClass(int id, int start, int chunkSize, int[] array) {
		this.name += " " + id;
		this.start = start;
		this.chunkSize = chunkSize;
		localChunkSize = chunkSize - (start - 1);
		chunk = new int[localChunkSize];
		for (int i = 0; i < localChunkSize; i++) {
			chunk[i] = array[i + start];
		}
	}

	public static int getTotalSum() {
		int val = globalSum;
		return val;
	}

	private synchronized static void doTotalSum(int quantity) {
		globalSum += quantity; 
	} 

	public void run() {
		for (int i = 0; i < localChunkSize; i++) {
			localSum += chunk[i];
		}
		pObj.print(name + ": " + String.format("from %d to %d sum is %d", this.start, this.chunkSize, localSum));
		doTotalSum(localSum);
	}
}
