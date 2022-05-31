package org.example.objects;

import org.example.utils.MiscUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MeczTenisa extends Mecz {
    private Map<Druzyna, Integer> punkty;
    private Map<Druzyna, Integer> asy;
    private Map<Druzyna, Integer> pierwszySerwis;
    private Map<Druzyna, Integer> punktySerwisowe;
    private Map<Druzyna, Integer> zagraniaKonczace;


    public MeczTenisa(String nazwaMeczu, String dataMeczu, Map<Druzyna, Integer> punkty, Map<Druzyna, Integer> asy, Map<Druzyna, Integer> pierwszySerwis, Map<Druzyna, Integer> punktySerwisowe, Map<Druzyna, Integer> zagraniaKonczace) {
        super(dataMeczu, null, null);
        this.punkty = punkty;
        this.asy = asy;
        this.pierwszySerwis = pierwszySerwis;
        this.punktySerwisowe = punktySerwisowe;
        this.zagraniaKonczace = zagraniaKonczace;
    }

    public MeczTenisa(String dataMeczu, Druzyna druzyna1, Druzyna druzyna2) {
        super(dataMeczu, druzyna1, druzyna2);
        List<Druzyna> druzyny = Arrays.asList(druzyna1, druzyna2);
        this.punkty = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.asy = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.pierwszySerwis = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.punktySerwisowe= MiscUtils.randomValuesOfDruzyny(druzyny);
        this.zagraniaKonczace = MiscUtils.randomValuesOfDruzyny(druzyny);
    }


    public Map<Druzyna, Integer> getPierwszySerwis() {
        return pierwszySerwis;
    }

    public Map<Druzyna, Integer> getPunktySerwisowe() {
        return punktySerwisowe;
    }

    public Map<Druzyna, Integer> getZagraniaKonczace() {
        return zagraniaKonczace;
    }

    @Override
    public Druzyna pickWinner() {
        return punkty.get(getDruzyna1()) > punkty.get(getDruzyna2()) ? getDruzyna1() : getDruzyna2();
    }

    @Override
    public String detailedStats() {
        String base = "\n" + this.getClass().getSimpleName() + " | " + super.detailedStats() + "\n\n";
        return base + "Drużyna 1: " + getDruzyna1().getNazwa() + "\n" +
                "Punkty: " + punkty.get(getDruzyna1()) + "\n" +
                "Asy: " + asy.get(getDruzyna1()) + "\n" +
                "Pierwszy Serwis: " + pierwszySerwis.get(getDruzyna1()) + "\n" +
                "punktySerwisowe: " + punktySerwisowe.get(getDruzyna1()) + "\n" +
                "Zagrania Konczace: " + zagraniaKonczace.get(getDruzyna1()) + "\n" +
                "\n" +
                "Drużyna 2: " + getDruzyna2().getNazwa() + "\n" +
                "Punkty: " + punkty.get(getDruzyna2()) + "\n" +
                "Asy: " + asy.get(getDruzyna2()) + "\n" +
                "Pierwszy Serwis: " + pierwszySerwis.get(getDruzyna2()) + "\n" +
                "Punkty Serwisowe: " + punktySerwisowe.get(getDruzyna2()) + "\n" +
                "Zagrania Konczace: " + zagraniaKonczace.get(getDruzyna2()) + "\n\n" +
                "Wygrała drużyna: " + pickWinner().getNazwa();

    }
}
