public class Program {

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
            eggThread.join();
            henThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= count; i++) {
            System.out.println("Human");
        }
    }

    private static class AnswerProvider implements Runnable {
        private final String answer;
        private final int count;

        public AnswerProvider(String answer, int count) {
            this.answer = answer;
            this.count = count;
        }

        public void run() {
            for (int i = 1; i <= count; i++)
                System.out.println(answer);
        }
    }
}
