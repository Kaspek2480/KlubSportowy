package org.example.objects;

import java.util.Map;

public class Mecz {
    private String nazwaMeczu;
    private String dataMeczu;

    private Druzyna gospodarz;
    private Druzyna gosc;
    private int wynikGospodarz;
    private int wynikGosc;

    private Map<Zawodnik, Integer> czasNaBoisku; // mapa zawodników i ich czasu w meczu
    private Map<Zawodnik, Integer> kartki_zolte;
    private Map<Zawodnik, Integer> kartki_czerwone;
    private Map<Zawodnik, Integer> asysty;
    private Map<Zawodnik, Integer> przewinienia; //faule
    private Map<Zawodnik, Integer> strzelone_gole;

    private Map<Druzyna, Integer> rzuty_wolne;
    private Map<Druzyna, Integer> rzuty_karne;
    private Map<Druzyna, Integer> rzuty_rozne;
    private Map<Druzyna, Integer> akcje; //okazje bramkowe
    private Map<Druzyna, Integer> podania;
    private Map<Druzyna, Double> czasPosiadaniaPilki;
}