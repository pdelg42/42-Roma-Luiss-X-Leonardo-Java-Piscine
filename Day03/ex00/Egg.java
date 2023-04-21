public class Egg implements Runnable {
    private int count;

    public Egg(int count)
    {
        this.count = count;
    }

    @Override
    public void run()
    {
        int i = 0;
        while (true)
        {
            System.out.println("Egg");
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