package org.example.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<String> readFileToListString(String fileName) {
        try {
            File sampleFile = new File(fileName);
            return Files.readAllLines(sampleFile.toPath());
        } catch (IOException e) {
            System.err.println("Error reading file due to: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void appendToFile(String line, String fileName) {
        try {
            if (!new File(fileName).exists()) {
                new File(fileName).createNewFile();
            }
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(line);
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error writing to file due to: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
