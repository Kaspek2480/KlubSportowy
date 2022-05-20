package org.example.objects;

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
}
