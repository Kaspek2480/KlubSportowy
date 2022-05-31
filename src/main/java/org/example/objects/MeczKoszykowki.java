package org.example.objects;

import org.example.utils.MiscUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MeczKoszykowki extends Mecz {
    private Map<Druzyna, Integer> punkty;
    private Map<Druzyna, Integer> faule;
    private Map<Druzyna, Integer> obrony;
    private Map<Druzyna, Integer> asysty;
    private Map<Druzyna, Integer> rzutyZaTrzy;


    public MeczKoszykowki(String nazwaMeczu, String dataMeczu, Map<Druzyna, Integer> punkty, Map<Druzyna, Integer> faule, Map<Druzyna, Integer> obrony, Map<Druzyna, Integer> asysty, Map<Druzyna, Integer> rzutyZaTrzy) {
        super(dataMeczu, null, null);
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
    public Druzyna pickWinner() {
        return punkty.get(getDruzyna()) > punkty.get(getDruzyna2()) ? getDruzyna() : getDruzyna2();
    }

    @Override
    public String detailedStats() {
        String base = "\n" + this.getClass().getSimpleName() + " | " + super.detailedStats() + "\n\n";
        StringBuilder sb = new StringBuilder(base);
        sb.append("Drużyna 1: ").append(getDruzyna().getNazwa()).append("\n");
        sb.append("Punkty: ").append(punkty.get(getDruzyna())).append("\n");
        sb.append("Faule: ").append(faule.get(getDruzyna())).append("\n");
        sb.append("Obrony: ").append(obrony.get(getDruzyna())).append("\n");
        sb.append("Asysty: ").append(asysty.get(getDruzyna())).append("\n");
        sb.append("Rzuty za trzy: ").append(rzutyZaTrzy.get(getDruzyna())).append("\n");
        sb.append("\n");
        sb.append("Drużyna 2: ").append(getDruzyna2().getNazwa()).append("\n");
        sb.append("Punkty: ").append(punkty.get(getDruzyna2())).append("\n");
        sb.append("Faule: ").append(faule.get(getDruzyna2())).append("\n");
        sb.append("Obrony: ").append(obrony.get(getDruzyna2())).append("\n");
        sb.append("Asysty: ").append(asysty.get(getDruzyna2())).append("\n");
        sb.append("Rzuty za trzy: ").append(rzutyZaTrzy.get(getDruzyna2())).append("\n\n");
        sb.append("Wygrała drużyna: ").append(pickWinner().getNazwa());
        return sb.toString();

    }
}
