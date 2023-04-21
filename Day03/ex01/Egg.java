public class Egg implements Runnable {
    private int count;
    private int queue;

    public Egg(int count, int queue)
    {
        this.count = count;
        this.queue = queue;
    }

    @Override
    public void run()
    {
        int i = 0;
        while (true)
        {
            if (queue % 2 == 0)
                System.out.println("Egg");
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