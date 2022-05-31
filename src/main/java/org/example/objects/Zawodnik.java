package org.example.objects;

import java.util.Objects;

public class Zawodnik {
    private final String imie;
    private final String nazwisko;
    private final int wiek;

    public Zawodnik(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }


    @Override
    public String toString() {
        return "Imię: " + imie + ", Nazwisko: " + nazwisko + ", Wiek: " + wiek;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zawodnik zawodnik = (Zawodnik) o;
        return wiek == zawodnik.wiek && Objects.equals(imie, zawodnik.imie) && Objects.equals(nazwisko, zawodnik.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, wiek);
    }
}
