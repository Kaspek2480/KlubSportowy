package org.example.objects;

import java.util.Map;

public class MeczPilkiNoznej {
    private Map<Zawodnik, Integer> czasNaBoisku; // mapa zawodników i ich czasu w meczu
    private Map<Zawodnik, Integer> przewinienia; //faule
    private Map<Zawodnik, Integer> strzelone_gole;
    private Map<Druzyna, Integer> podania;
    private Map<Druzyna, Double> czasPosiadaniaPilki;
}
