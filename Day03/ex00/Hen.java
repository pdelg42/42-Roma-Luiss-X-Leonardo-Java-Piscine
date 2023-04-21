public class Hen implements Runnable {
    private int count;

    public Hen(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("Hen");
            i++;
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