package org.example.objects;

import org.example.utils.MiscUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MeczSiatkowki extends Mecz {
    private final Map<Druzyna, Integer> punkty;
    private final Map<Druzyna, Integer> bloki;
    private final Map<Druzyna, Integer> challenge;
    private final Map<Druzyna, Integer> bledyAtakujac;
    private final Map<Druzyna, Integer> bledyBlokujac;

    public MeczSiatkowki(String dataMeczu, Druzyna druzyna1, Druzyna druzyna2, Map<Druzyna, Integer> punkty, Map<Druzyna, Integer> bloki, Map<Druzyna, Integer> challenge, Map<Druzyna, Integer> bledyAtakujac, Map<Druzyna, Integer> bledyBlokujac) {
        super(dataMeczu, druzyna1, druzyna2);
        this.punkty = punkty;
        this.bloki = bloki;
        this.challenge = challenge;
        this.bledyAtakujac = bledyAtakujac;
        this.bledyBlokujac = bledyBlokujac;
    }

    public MeczSiatkowki(String dataMeczu, Druzyna druzyna1, Druzyna druzyna2) {
        super(dataMeczu, druzyna1, druzyna2);
        List<Druzyna> druzyny = Arrays.asList(druzyna1, druzyna2);
        this.punkty = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.bloki = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.challenge = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.bledyAtakujac = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.bledyBlokujac = MiscUtils.randomValuesOfDruzyny(druzyny);
    }

    public Map<Druzyna, Integer> getPunkty() {
        return punkty;
    }

    public Map<Druzyna, Integer> getBloki() {
        return bloki;
    }

    public Map<Druzyna, Integer> getChallenge() {
        return challenge;
    }

    public Map<Druzyna, Integer> getBledyAtakujac() {
        return bledyAtakujac;
    }

    public Map<Druzyna, Integer> getBledyBlokujac() {
        return bledyBlokujac;
    }

    @Override
    public String pickWinner() {
        if (punkty.get(getDruzyna1()) == punkty.get(getDruzyna2())) return "Remis";
        return punkty.get(getDruzyna1()) > punkty.get(getDruzyna2()) ? getDruzyna1().getNazwa() : getDruzyna2().getNazwa();
    }

    @Override
    public String detailedStats() {
        String base = "\n" + this.getClass().getSimpleName() + " | " + super.detailedStats() + "\n\n";
        return base + "Dru??yna 1: " + getDruzyna1().getNazwa() + "\n" +
                "Punkty: " + punkty.get(getDruzyna1()) + "\n" +
                "Bloki: " + bloki.get(getDruzyna1()) + "\n" +
                "Challenge: " + challenge.get(getDruzyna1()) + "\n" +
                "Bledy Atakujac: " + bledyAtakujac.get(getDruzyna1()) + "\n" +
                "Bledy Blokujac: " + bledyBlokujac.get(getDruzyna1()) + "\n" +
                "\n" +
                "Dru??yna 2: " + getDruzyna2().getNazwa() + "\n" +
                "Punkty: " + punkty.get(getDruzyna2()) + "\n" +
                "Bloki: " + bloki.get(getDruzyna2()) + "\n" +
                "Challenge: " + challenge.get(getDruzyna2()) + "\n" +
                "Bledy Atakujac: " + bledyAtakujac.get(getDruzyna2()) + "\n" +
                "Bledy Blokujac: " + bledyBlokujac.get(getDruzyna2()) + "\n\n" +
                "Wygra??a dru??yna: " + pickWinner();
    }
}
