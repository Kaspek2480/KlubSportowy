package org.example.objects;

//

//MeczPilkiNoznej
//MeczSiattkowki

import org.example.interfaces.MeczStats;

public class Mecz implements MeczStats {
    private String nazwaMeczu;
    private String dataMeczu;

    private Druzyna druzyna;
    private Druzyna druzyna2;

    //4-5 statystyk na mecz

    public Mecz(String dataMeczu, Druzyna druzyna, Druzyna druzyna2) {
        this.dataMeczu = dataMeczu;
        this.druzyna = druzyna;
        this.druzyna2 = druzyna2;
        this.nazwaMeczu = druzyna.getNazwa() + " - " + druzyna2.getNazwa();
    }


    public String getNazwaMeczu() {
        return nazwaMeczu;
    }

    public String getDataMeczu() {
        return dataMeczu;
    }

    public Druzyna getDruzyna() {
        return druzyna;
    }

    public Druzyna getDruzyna2() {
        return druzyna2;
    }

    @Override
    public Druzyna pickWinner() {
        System.err.println("Invoked on basic Mecz object");
        return null;
    }

    @Override
    public String detailedStats() {
        return nazwaMeczu + " | " + dataMeczu;
    }
}