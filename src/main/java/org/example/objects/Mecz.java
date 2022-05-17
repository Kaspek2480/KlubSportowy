package org.example.objects;

//

//MeczPilkiNoznej
//MeczSiattkowki

import org.example.interfaces.MeczStats;

public class Mecz implements MeczStats {
    private String nazwaMeczu;
    private String dataMeczu;
    private Druzyna druzyna;
    private int wynikMeczu;

    //4-5 statystyk na mecz



    public Mecz(String nazwaMeczu, String dataMeczu) {
        this.nazwaMeczu = nazwaMeczu;
        this.dataMeczu = dataMeczu;
    }


    public String getNazwaMeczu() {
        return nazwaMeczu;
    }

    public String getDataMeczu() {
        return dataMeczu;
    }


    @Override
    public int obliczWynikMeczu() {
        System.err.println("Invoked on basic Mecz object");
        return 0;
    }
}