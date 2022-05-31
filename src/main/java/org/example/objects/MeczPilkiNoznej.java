package org.example.objects;

import java.util.Map;

public class MeczPilkiNoznej extends Mecz {
    private Map<Zawodnik, Integer> gole;
    private Map<Zawodnik, Integer> asysty;
    private Map<Zawodnik, Integer> faule;
    private Map<Druzyna, Integer> podania;
    private Map<Druzyna, Integer> spalone;

    public MeczPilkiNoznej(String nazwaMeczu, String dataMeczu, Druzyna druzyna, Druzyna druzyna2) {
        super(dataMeczu, druzyna, druzyna2);
    }
}
