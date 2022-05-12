package org.example.objects;

public class Zawodnik {
    private final String imie;
    private final String nazwisko;
    private final String pozycja;
    private final int numer;
    private final int wiek;

    //odnosnie gry
    private int gole;
    private int asysty;
    private int kartki_zolte;
    private int kartki_czerwone;
    private int rozegrane_minuty; //ile minut rozegral łacznie
    private int przewinienia;


    public Zawodnik(String imie, String nazwisko, String pozycja, int numer, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pozycja = pozycja;
        this.numer = numer;
        this.wiek = wiek;
    }


    @Override
    public String toString() {
        return "Zawodnik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pozycja='" + pozycja + '\'' +
                ", numer=" + numer +
                ", wiek=" + wiek +
                ", gole=" + gole +
                ", asysty=" + asysty +
                ", kartki_zolte=" + kartki_zolte +
                ", kartki_czerwone=" + kartki_czerwone +
                ", rozegrane_minuty=" + rozegrane_minuty +
                ", przewinienia=" + przewinienia +
                '}';
    }
}
