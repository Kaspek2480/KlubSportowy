package org.example;

import com.google.gson.Gson;
import org.example.objects.Druzyna;
import org.example.objects.Mecz;
import org.example.objects.MeczKoszykowki;
import org.example.objects.Zawodnik;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static final Map<Integer, Zawodnik> zawodnicy = new HashMap<>();
    private static final Map<Integer, Mecz> mecze = new HashMap<>();
    private static final Map<Integer, Druzyna> druzyny = new HashMap<>();

    public static void loadSampleData() {
        Gson gson = new Gson();
        try {
            List<String> serializedZawodnicyLines = Files.readAllLines(new File("Zawodnik.txt").toPath());
            List<String> serializedMeczeLines = Files.readAllLines(new File("Mecz.txt").toPath());
            List<String> serializedDruzynyLines = Files.readAllLines(new File("Druzyna.txt").toPath());

            for (int i = 0; i < serializedZawodnicyLines.size(); i++) {
                String serializedZawodnicyLine = serializedZawodnicyLines.get(i);
                zawodnicy.put(i, gson.fromJson(serializedZawodnicyLine, Zawodnik.class));
            }

            for (int i = 0; i < serializedMeczeLines.size(); i++) {
                String serializedMeczeLine = serializedMeczeLines.get(i);
                mecze.put(i, gson.fromJson(serializedMeczeLine, Mecz.class));
            }

            for (int i = 0; i < serializedDruzynyLines.size(); i++) {
                String serializedDruzynyLine = serializedDruzynyLines.get(i);
                druzyny.put(i, gson.fromJson(serializedDruzynyLine, Druzyna.class));
            }

            System.out.println("Loaded " + zawodnicy.size() + " zawodników");
            System.out.println("Loaded " + mecze.size() + " meczy");
            System.out.println("Loaded " + druzyny.size() + " drużyn");

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
