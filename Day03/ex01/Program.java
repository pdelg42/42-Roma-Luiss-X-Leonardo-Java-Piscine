import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Program {

    private static final BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {
        int count = 50;
        if (args.length > 0 && args[0].startsWith("--count=")) {
            String countArg = args[0].substring(8);
            try {
                count = Integer.parseInt(countArg);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        Thread eggThread = new Thread(new AnswerProvider("Egg", count));
        Thread henThread = new Thread(new AnswerProvider("Hen", count));

        eggThread.start();
        henThread.start();

        try {
            for (int i = 1; i <= count * 2; i++) {
                String response = queue.take();
                Thread.sleep(100);
                System.out.println(response);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class AnswerProvider implements Runnable {
        private final String answer;
        private final int count;

        public AnswerProvider(String answer, int count) {
            this.answer = answer;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= count; i++) {
                    Thread.sleep(100);
                    queue.put(answer);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
