import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TextProcess {
    public static void main(String[] args) {
        String filePath = "/tmp/test.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                String upperLine = line.toUpperCase();

                if (upperLine.contains("ACTIVE")) {
                    String[] words = upperLine.split("\\s+");
                    //System.out.println("Split words: " + Arrays.toString(words));

                    if (words.length > 0) {
                        String preprocessLC = words[words.length - 1];
                        //System.out.println(preprocessLC);

                        String lastColumn = words[words.length - 1].replace("'", "");
                        System.out.println(lastColumn);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}