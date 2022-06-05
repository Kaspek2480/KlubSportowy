package org.example.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Druzyna {
    private final String nazwa;
    private final List<Zawodnik> zawodnicy;


    public static void main(String[] args) {

    }

    public Druzyna(String nazwaKlubu) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Druzyna druzyna = (Druzyna) o;
        return Objects.equals(nazwa, druzyna.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa);
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
