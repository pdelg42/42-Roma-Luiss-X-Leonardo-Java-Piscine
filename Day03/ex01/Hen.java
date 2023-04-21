public class Hen implements Runnable {
    private int count;
    private int queue;

    public Hen(int count, int queue) {
        this.count = count;
        this.queue = queue;

    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (queue % 2 == 1)
                System.out.println("Hen");
            i++;
            queue++;
            if ( i == count )
                break;
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                // Lo stato di sleeping è stato interrotto
                // da un altro thread
            }
        }
    }
}