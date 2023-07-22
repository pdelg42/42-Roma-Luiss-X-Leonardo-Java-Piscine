import java.util.Random;

class SumThread extends Thread {
    private int[] array;
    private int startIndex;
    private int endIndex;
    private int sum;

    public SumThread(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getSum() {
        return sum;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            sum += array[i];
        }
    }
}

public class Program {
    public static void main(String[] args) {
        int arraySize = 0;
        int threadsCount = 0;

        // Parsing command-line arguments
        if (args.length == 2) {
            try {
                arraySize = Integer.parseInt(args[0]);
                threadsCount = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid command-line arguments. Please provide valid integers.");
                System.exit(1);
            }
        } else {
            System.err.println("Invalid command-line arguments. Please provide arraySize and threadsCount.");
            System.exit(1);
        }

        // Generate the random array
        int[] array = new int[arraySize];
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(1001); // Random integer between 0 and 1000
        }

        // Calculate the sum using the standard method
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        System.out.println("Sum: " + sum);

        // Create and start summing threads
        int sectionSize = arraySize / threadsCount;
        int lastSectionSize = sectionSize + arraySize % threadsCount;
        SumThread[] threads = new SumThread[threadsCount];
        int startIndex = 0;

        for (int i = 0; i < threadsCount - 1; i++) {
            threads[i] = new SumThread(array, startIndex, startIndex + sectionSize - 1);
            threads[i].start();
            startIndex += sectionSize;
        }
        threads[threadsCount - 1] = new SumThread(array, startIndex, startIndex + lastSectionSize - 1);
        threads[threadsCount - 1].start();

        // Wait for all threads to finish
        try {
            for (int i = 0; i < threadsCount; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Calculate the sum of sections by threads
        int sumByThreads = 0;
        for (int i = 0; i < threadsCount; i++) {
            sumByThreads += threads[i].getSum();
            System.out.println("Thread " + (i + 1) + ": from " + threads[i].getStartIndex() + " to " + threads[i].getEndIndex() + " sum is " + threads[i].getSum());
        }
        System.out.println("Sum by threads: " + sumByThreads);
    }
}
