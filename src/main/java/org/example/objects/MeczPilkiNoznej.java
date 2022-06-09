package org.example.objects;

import org.example.utils.MiscUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MeczPilkiNoznej extends Mecz {
    private final Map<Druzyna, Integer> gole;
    private final Map<Druzyna, Integer> asysty;
    private final Map<Druzyna, Integer> faule;
    private final Map<Druzyna, Integer> podania;
    private final Map<Druzyna, Integer> spalone;

    public MeczPilkiNoznej(String dataMeczu, Druzyna druzyna1, Druzyna druzyna2) {
        super(dataMeczu, druzyna1, druzyna2);
        List<Druzyna> druzyny = Arrays.asList(druzyna1, druzyna2);
        this.gole = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.asysty = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.faule = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.podania = MiscUtils.randomValuesOfDruzyny(druzyny);
        this.spalone = MiscUtils.randomValuesOfDruzyny(druzyny);
    }

    public Map<Druzyna, Integer> getGole() {
        return gole;
    }

    public Map<Druzyna, Integer> getAsysty() {
        return asysty;
    }

    public Map<Druzyna, Integer> getFaule() {
        return faule;
    }

    public Map<Druzyna, Integer> getPodania() {
        return podania;
    }

    public Map<Druzyna, Integer> getSpalone() {
        return spalone;
    }

    @Override
    public String pickWinner() {
        if (gole.get(getDruzyna1()) == gole.get(getDruzyna2())) return "Remis";
        return gole.get(getDruzyna1()) > gole.get(getDruzyna2()) ? getDruzyna1().getNazwa() : getDruzyna2().getNazwa();
    }

    @Override
    public String detailedStats() {
        String base = "\n" + this.getClass().getSimpleName() + " | " + super.detailedStats() + "\n\n";
        return base + "Drużyna 1: " + getDruzyna1().getNazwa() + "\n" +
                "Gole: " + gole.get(getDruzyna1()) + "\n" +
                "Asysty: " + asysty.get(getDruzyna1()) + "\n" +
                "Faule: " + faule.get(getDruzyna1()) + "\n" +
                "Podania: " + podania.get(getDruzyna1()) + "\n" +
                "Spalone: " + spalone.get(getDruzyna1()) + "\n" +
                "\n" +
                "Drużyna 2: " + getDruzyna2().getNazwa() + "\n" +
                "Gole: " + gole.get(getDruzyna2()) + "\n" +
                "Asysty: " + asysty.get(getDruzyna2()) + "\n" +
                "Faule: " + faule.get(getDruzyna2()) + "\n" +
                "Podania: " + podania.get(getDruzyna2()) + "\n" +
                "Spalone: " + spalone.get(getDruzyna2()) + "\n\n" +
                "Wygrała drużyna: " + pickWinner();
    }
}
