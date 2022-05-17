package org.example.objects;

//

//MeczPilkiNoznej
//MeczSiattkowki

public class Mecz {
    private String nazwaMeczu;
    private String dataMeczu;

    private Druzyna gospodarz;
    private Druzyna gosc;
    private int wynikGospodarz;
    private int wynikGosc;

    //4-5 statystyk na mecz

    //FIXME czy wartosci moga byc od razu finalne (bez metod typu dodaj punkt itp)


    public Mecz(String nazwaMeczu, String dataMeczu, Druzyna gospodarz, Druzyna gosc, int wynikGospodarz, int wynikGosc) {
        this.nazwaMeczu = nazwaMeczu;
        this.dataMeczu = dataMeczu;
        this.gospodarz = gospodarz;
        this.gosc = gosc;
        this.wynikGospodarz = wynikGospodarz;
        this.wynikGosc = wynikGosc;
    }

    public int getWynikGospodarz() {
        return wynikGospodarz;
    }

    public int getWynikGosc() {
        return wynikGosc;
    }

    public String getNazwaMeczu() {
        return nazwaMeczu;
    }

    public String getDataMeczu() {
        return dataMeczu;
    }


}