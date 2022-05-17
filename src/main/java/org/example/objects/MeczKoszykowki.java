package org.example.objects;

import org.example.utils.MiscUtils;

import java.util.List;
import java.util.Map;

public class MeczKoszykowki extends Mecz {
    private Map<Zawodnik, Integer> punkty;
    private Map<Zawodnik, Integer> faule;
    private Map<Zawodnik, Integer> obrony;
    private Map<Zawodnik, Integer> asysty;
    private Map<Zawodnik, Integer> rzutyZaTrzy;


    public MeczKoszykowki(Mecz mecz, Map<Zawodnik, Integer> punkty, Map<Zawodnik, Integer> faule, Map<Zawodnik, Integer> obrony, Map<Zawodnik, Integer> asysty, Map<Zawodnik, Integer> rzutyZaTrzy) {
        super(mecz.getNazwaMeczu(), mecz.getDataMeczu());
        this.punkty = punkty;
        this.faule = faule;
        this.obrony = obrony;
        this.asysty = asysty;
        this.rzutyZaTrzy = rzutyZaTrzy;
    }
    public MeczKoszykowki(Mecz mecz, List<Zawodnik> zawodnicy) {
        super(mecz.getNazwaMeczu(), mecz.getDataMeczu());
        this.punkty = MiscUtils.randomValuesOfZaowdnik(zawodnicy);
        this.faule = MiscUtils.randomValuesOfZaowdnik(zawodnicy);;
        this.obrony = MiscUtils.randomValuesOfZaowdnik(zawodnicy);;
        this.asysty = MiscUtils.randomValuesOfZaowdnik(zawodnicy);;
        this.rzutyZaTrzy = MiscUtils.randomValuesOfZaowdnik(zawodnicy);;
    }

    @Override
    public int obliczWynikMeczu() {
        int sumaPunktow = 0;
        for (Map.Entry<Zawodnik, Integer> entry : punkty.entrySet()) {
            sumaPunktow += entry.getValue();
        }
        return sumaPunktow;
    }




}
