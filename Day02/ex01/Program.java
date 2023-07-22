import java.io.*;
import java.util.*;

public class Program {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Program inputA.txt inputB.txt");
            return;
        }

        String inputFileA = args[0];
        String inputFileB = args[1];

        try {
            // Create dictionary and frequency vectors
            Map<String, Integer> dictionary = createDictionary(inputFileA, inputFileB);
            int[] vectorA = calculateFrequencyVector(inputFileA, dictionary);
            int[] vectorB = calculateFrequencyVector(inputFileB, dictionary);

            // Calculate similarity using cosine similarity formula
            double similarity = calculateCosineSimilarity(vectorA, vectorB);

            System.out.println("Similarity = " + similarity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> createDictionary(String inputFileA, String inputFileB) throws IOException {
        Set<String> dictionarySet = new HashSet<>();

        try (BufferedReader readerA = new BufferedReader(new FileReader(inputFileA));
             BufferedReader readerB = new BufferedReader(new FileReader(inputFileB))) {
            String line;
            while ((line = readerA.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    dictionarySet.add(word);
                }
            }
            while ((line = readerB.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    dictionarySet.add(word);
                }
            }
        }

        List<String> dictionaryList = new ArrayList<>(dictionarySet);
        Collections.sort(dictionaryList);

        // Save the dictionary to dictionary.txt file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dictionary.txt"))) {
            for (String word : dictionaryList) {
                writer.write(word + "\n");
            }
        }

        // Create the dictionary with word-index mappings
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < dictionaryList.size(); i++) {
            dictionary.put(dictionaryList.get(i), i);
        }

        return dictionary;
    }

    private static int[] calculateFrequencyVector(String inputFile, Map<String, Integer> dictionary) throws IOException {
        int[] vector = new int[dictionary.size()];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    int index = dictionary.getOrDefault(word, -1);
                    if (index != -1) {
                        vector[index]++;
                    }
                }
            }
        }

        return vector;
    }

    private static double calculateCosineSimilarity(int[] vectorA, int[] vectorB) {
        int dotProduct = 0;
        int normA = 0;
        int normB = 0;

        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += vectorA[i] * vectorA[i];
            normB += vectorB[i] * vectorB[i];
        }

        double similarity = dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
        return similarity;
    }
}
