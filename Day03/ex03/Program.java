import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;

class DownloadThread extends Thread {
    private Queue<String> urlQueue;

    public DownloadThread(Queue<String> urlQueue) {
        this.urlQueue = urlQueue;
    }

    @Override
    public void run() {
        while (!urlQueue.isEmpty()) {
            String url = null;
            synchronized (urlQueue) {
                if (!urlQueue.isEmpty()) {
                    url = urlQueue.poll();
                }
            }

            if (url != null) {
                try {
                    downloadFile(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void downloadFile(String fileUrl) throws IOException {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
        System.out.println(Thread.currentThread().getName() + " start download " + fileName);

        try (BufferedInputStream inputStream = new BufferedInputStream(new URL(fileUrl).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        }

        System.out.println(Thread.currentThread().getName() + " finish download " + fileName);
    }
}

public class Program {
    public static void main(String[] args) {
        int threadsCount = 0;

        // Parsing command-line arguments
        if (args.length == 1) {
            try {
                threadsCount = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid command-line argument. Please provide a valid integer for threadsCount.");
                System.exit(1);
            }
        } else {
            System.err.println("Invalid command-line arguments. Please provide threadsCount.");
            System.exit(1);
        }

        String fileUrlsFileName = "files_urls.txt";

        // Read URLs from file and populate the queue
        Queue<String> urlQueue = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileUrlsFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                urlQueue.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Start download threads
        DownloadThread[] threads = new DownloadThread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new DownloadThread(urlQueue);
            threads[i].start();
        }

        // Wait for all threads to finish
        try {
            for (int i = 0; i < threadsCount; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
