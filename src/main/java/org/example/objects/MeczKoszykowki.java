package org.example.objects;

import org.example.utils.MiscUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MeczKoszykowki extends Mecz {
    private final Map<Druzyna, Integer> punkty;
    private final Map<Druzyna, Integer> faule;
    private final Map<Druzyna, Integer> obrony;
    private final Map<Druzyna, Integer> asysty;
    private final Map<Druzyna, Integer> rzutyZaTrzy;

    public MeczKoszykowki(String dataMeczu, Druzyna druzyna1, Druzyna druzyna2, Map<Druzyna, Integer> punkty, Map<Druzyna, Integer> faule, Map<Druzyna, Integer> obrony, Map<Druzyna, Integer> asysty, Map<Druzyna, Integer> rzutyZaTrzy) {
        super(dataMeczu, druzyna1, druzyna2);
        this.punkty = punkty;
        this.faule = faule;
        this.obrony = obrony;
        this.asysty = asysty;
        this.rzutyZaTrzy = rzutyZaTrzy;
    }

    public MeczKoszykowki(String dataMeczu, Druzyna druzyna1, Druzyna druzyna2) {
        super(dataMeczu, druzyna1, druzyna2);
        List<Druzyna> druzyny = Arrays.asList(druzyna1, druzyna2);
        this.punkty = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.faule = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.obrony = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.asysty = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.rzutyZaTrzy = MiscUtils.randomValuesOfDruzyny(druzyny);
    }

    public Map<Druzyna, Integer> getPunkty() {
        return punkty;
    }

    public Map<Druzyna, Integer> getFaule() {
        return faule;
    }

    public Map<Druzyna, Integer> getObrony() {
        return obrony;
    }

    public Map<Druzyna, Integer> getAsysty() {
        return asysty;
    }

    public Map<Druzyna, Integer> getRzutyZaTrzy() {
        return rzutyZaTrzy;
    }

    @Override
    public String pickWinner() {
        if (punkty.get(getDruzyna1()) == punkty.get(getDruzyna2())) return "Remis";
        return punkty.get(getDruzyna1()) > punkty.get(getDruzyna2()) ? getDruzyna1().getNazwa() : getDruzyna2().getNazwa();
    }

    @Override
    public String detailedStats() {
        String base = "\n" + this.getClass().getSimpleName() + " | " + super.detailedStats() + "\n\n";
        return base + "Drużyna 1: " + getDruzyna1().getNazwa() + "\n" +
                "Punkty: " + punkty.get(getDruzyna1()) + "\n" +
                "Faule: " + faule.get(getDruzyna1()) + "\n" +
                "Obrony: " + obrony.get(getDruzyna1()) + "\n" +
                "Asysty: " + asysty.get(getDruzyna1()) + "\n" +
                "Rzuty za trzy: " + rzutyZaTrzy.get(getDruzyna1()) + "\n" +
                "\n" +
                "Drużyna 2: " + getDruzyna2().getNazwa() + "\n" +
                "Punkty: " + punkty.get(getDruzyna2()) + "\n" +
                "Faule: " + faule.get(getDruzyna2()) + "\n" +
                "Obrony: " + obrony.get(getDruzyna2()) + "\n" +
                "Asysty: " + asysty.get(getDruzyna2()) + "\n" +
                "Rzuty za trzy: " + rzutyZaTrzy.get(getDruzyna2()) + "\n\n" +
                "Wygrała drużyna: " + pickWinner();
    }
}
