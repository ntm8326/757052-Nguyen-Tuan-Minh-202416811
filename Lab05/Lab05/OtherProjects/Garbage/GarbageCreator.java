package OtherProjects.Garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class GarbageCreator {

    public static void main(String[] args) {

        String filename = "test.txt";
        Path filePath = Paths.get(filename);

        if (!Files.exists(filePath)) {
            System.err.println("Error: File not found at path: " + filePath.toAbsolutePath());
            return;
        }

        try {
            System.out.println("Reading file: " + filename);
            byte[] inputBytes = Files.readAllBytes(filePath);
            System.out.println("File read successfully. Total bytes: " + inputBytes.length);

            long startTime = System.currentTimeMillis();

            // '+' concatenation
            String s1 = "";

            for (byte b : inputBytes) {
                s1 += (char) b;
            }

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            System.out.println("'+' concatenation execution time: " + duration + "ms");

            // StringBuilder concatenation
            StringBuilder s2 = new StringBuilder();
            startTime = System.currentTimeMillis();
            for (byte b : inputBytes) {
                s2.append((char) b);
            }
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            System.out.println(s1 + " Stringbuilder execution time: " + duration + "ms");

        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
