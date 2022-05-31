package org.example;

import com.google.gson.Gson;
import org.example.objects.Druzyna;
import org.example.objects.Mecz;
import org.example.objects.MeczKoszykowki;
import org.example.objects.Zawodnik;
import org.example.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static final Map<Integer, Zawodnik> zawodnicy = new HashMap<>();
    private static final Map<Integer, Mecz> mecze = new HashMap<>();
    private static final Map<Integer, Druzyna> druzyny = new HashMap<>();

    /***
     * Metoda wczytująca dane testowe z pliku .json
     * Deserializacja przyogtowanych danych do obiektów
     */

    public static void loadSampleData() {
        //if reloading data, clear all data from maps
        zawodnicy.clear();
        mecze.clear();
        druzyny.clear();

        Gson gson = new Gson();
        List<String> serializedZawodnicyLines = FileUtils.readFileToListString("Zawodnik.txt");
        List<String> serializedMeczeLines = FileUtils.readFileToListString("Mecz.txt");
        List<String> serializedDruzynyLines = FileUtils.readFileToListString("Druzyna.txt");

        for (int i = 1; i < serializedZawodnicyLines.size(); i++) {
            String serializedZawodnicyLine = serializedZawodnicyLines.get(i);
            zawodnicy.put(i, gson.fromJson(serializedZawodnicyLine, Zawodnik.class));
        }

        for (int i = 1; i < serializedMeczeLines.size(); i++) {
            String serializedMeczeLine = serializedMeczeLines.get(i);
            mecze.put(i, gson.fromJson(serializedMeczeLine, Mecz.class));
        }

        for (int i = 1; i < serializedDruzynyLines.size(); i++) {
            String serializedDruzynyLine = serializedDruzynyLines.get(i);
            druzyny.put(i, gson.fromJson(serializedDruzynyLine, Druzyna.class));
        }

        System.out.println("Loaded " + zawodnicy.size() + " zawodników");
        System.out.println("Loaded " + mecze.size() + " meczy");
        System.out.println("Loaded " + druzyny.size() + " drużyn");

    }

    public static void displayAllPlayers() {
        for (Map.Entry<Integer, Zawodnik> entry : zawodnicy.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " w druzynach: " + listMemberTeams(entry.getValue()));
        }
    }

    public static List<Druzyna> listMemberTeams(Zawodnik zawodnik) {
        List<Druzyna> list = new ArrayList<>();
        druzyny.values().forEach(druzyna -> {
            for (Zawodnik zawodnik1 : druzyna.getZawodnicy()) {
                if (zawodnik.equals(zawodnik1)) {
                    list.add(druzyna);
                }
            }
        });
        return list;
    }

    public static void saveDatabase() {
        Gson gson = new Gson();
        FileUtils.removeFile("Zawodnik.txt");
        FileUtils.removeFile("Mecz.txt");
        FileUtils.removeFile("Druzyna.txt");

        for (Map.Entry<Integer, Zawodnik> entry : zawodnicy.entrySet()) {
            FileUtils.appendToFile(gson.toJson(entry.getValue()), "Zawodnik.txt");
        }
        for (Map.Entry<Integer, Mecz> entry : mecze.entrySet()) {
            FileUtils.appendToFile(gson.toJson(entry.getValue()), "Mecz.txt");
        }
        for (Map.Entry<Integer, Druzyna> entry : druzyny.entrySet()) {
            FileUtils.appendToFile(gson.toJson(entry.getValue()), "Druzyna.txt");
        }

        System.out.println("Database saved");
    }

    public static void addPlayer(Zawodnik zawodnik) {
        zawodnicy.put(zawodnicy.size(), zawodnik);
    }

    public static void addMatch(Mecz mecz) {
        mecze.put(mecze.size(), mecz);
    }

    public static void addTeam(Druzyna druzyna) {
        druzyny.put(druzyny.size(), druzyna);
    }

    public static Map<Integer, Zawodnik> getZawodnicy() {
        return zawodnicy;
    }

    public static Map<Integer, Mecz> getMecze() {
        return mecze;
    }

    public static Map<Integer, Druzyna> getDruzyny() {
        return druzyny;
    }

    public static void removePlayer(int id) {
        zawodnicy.remove(id);
    }

    public static void removeTeam(int id) {
        druzyny.remove(id);
    }
}
