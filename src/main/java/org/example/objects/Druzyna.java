package org.example.objects;

import java.util.ArrayList;
import java.util.List;

public class Druzyna extends Liga {
    private final String nazwa;
    private final List<Zawodnik> zawodnicy;


    public static void main(String[] args) {

    }

    public Druzyna(String nazwaKlubu, String nazwaLigi) {
        super(nazwaLigi);
        this.nazwa = nazwaKlubu;
        this.zawodnicy = new ArrayList<>();
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<Zawodnik> getZawodnicy() {
        return zawodnicy;
    }

    public void dodajZawodnika(Zawodnik zawodnik) {
        zawodnicy.add(zawodnik);
    }

    @Override
    public String toString() {
        return "Klub{" +
                "nazwa='" + nazwa + '\'' +
                ", zawodnicy=" + zawodnicy +
                '}';
    }
}
