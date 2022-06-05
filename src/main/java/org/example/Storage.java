package org.example;

import com.google.gson.Gson;
import org.example.objects.*;
import org.example.utils.FileUtils;
import org.example.utils.MiscUtils;
import org.example.utils.SampleGenerator;

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
        List<String> serializedDruzynyLines = FileUtils.readFileToListString("Druzyna.txt");

       /* List<String> serializedMeczKoszykowki = FileUtils.readFileToListString("MeczKoszykowki.txt");
        List<String> serializedMeczPilkiNoznej = FileUtils.readFileToListString("MeczPilkiNoznej.txt");
        List<String> serializedMMeczSiatkowki = FileUtils.readFileToListString("MeczSiatkowki.txt");
        List<String> serializedMeczTenisa = FileUtils.readFileToListString("MeczTenisa.txt");*/

        for (int i = 1; i < serializedZawodnicyLines.size(); i++) {
            String serializedZawodnicyLine = serializedZawodnicyLines.get(i);
            zawodnicy.put(i, gson.fromJson(serializedZawodnicyLine, Zawodnik.class));
        }

        for (int i = 1; i < serializedDruzynyLines.size(); i++) {
            String serializedDruzynyLine = serializedDruzynyLines.get(i);
            druzyny.put(i, gson.fromJson(serializedDruzynyLine, Druzyna.class));
        }

       /* for (int i = 0; i < serializedMeczKoszykowki.size(); i++) {
            String serializedMeczKoszykowkiLine = serializedMeczKoszykowki.get(i);
            System.out.println(serializedMeczKoszykowkiLine);
            mecze.put(i, gson.fromJson(serializedMeczKoszykowkiLine, MeczKoszykowki.class));
        }

        for (int i = 0; i < serializedMeczPilkiNoznej.size(); i++) {
            String serializedMeczPilkiNoznejLine = serializedMeczPilkiNoznej.get(i);
            mecze.put(i, gson.fromJson(serializedMeczPilkiNoznejLine, MeczPilkiNoznej.class));
        }

        for (int i = 0; i < serializedMMeczSiatkowki.size(); i++) {
            String serializedMMeczSiatkowkiLine = serializedMMeczSiatkowki.get(i);
            mecze.put(i, gson.fromJson(serializedMMeczSiatkowkiLine, MeczSiatkowki.class));
        }

        for (int i = 0; i < serializedMeczTenisa.size(); i++) {
            String serializedMeczTenisaLine = serializedMeczTenisa.get(i);
            mecze.put(i, gson.fromJson(serializedMeczTenisaLine, MeczTenisa.class));
        }*/


        System.out.println("Loaded " + zawodnicy.size() + " zawodników");
//        System.out.println("Loaded " + mecze.size() + " meczy");
        System.out.println("Loaded " + druzyny.size() + " drużyn");
        SampleGenerator.prepareMecz();

    }

    public static void displayAllPlayers() {
        for (Map.Entry<Integer, Zawodnik> entry : zawodnicy.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void displayAllTeams() {
        for (Map.Entry<Integer, Druzyna> entry : druzyny.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
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

    public static Druzyna randomDruzyna() {
        return new ArrayList<>(druzyny.values()).get(MiscUtils.randInt(0, druzyny.size()));
    }

    public static void addPlayer(Zawodnik zawodnik) {
        zawodnicy.put(zawodnicy.size() + 1, zawodnik);
    }

    public static void addMatch(Mecz mecz) {
        mecze.put(mecze.size() + 1, mecz);
    }

    public static void addTeam(Druzyna druzyna) {
        druzyny.put(druzyny.size() + 1, druzyna);
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

    public static void removePlayer(int id) throws GeneralException {
        //TODO if player not exists
        if (!zawodnicy.containsKey(id)) throw new GeneralException("Zawodnik o podanym id nie istnieje");
        zawodnicy.remove(id);
    }

    public static void removeTeam(int id) throws GeneralException {
        if (!druzyny.containsKey(id)) throw new GeneralException("Drużyna o podanym id nie istnieje");
        druzyny.remove(id);
    }
}
