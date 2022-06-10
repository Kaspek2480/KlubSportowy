package org.example.objects;


import org.example.interfaces.MeczStats;

public class Mecz implements MeczStats {
    private final String nazwaMeczu;
    private final String dataMeczu;

    private final Druzyna druzyna1;
    private final Druzyna druzyna2;


    public Mecz(String dataMeczu, Druzyna druzyna1, Druzyna druzyna2) {
        this.dataMeczu = dataMeczu;
        this.druzyna1 = druzyna1;
        this.druzyna2 = druzyna2;
        this.nazwaMeczu = druzyna1.getNazwa() + " - " + druzyna2.getNazwa();
    }

    public String getNazwaMeczu() {
        return nazwaMeczu;
    }

    public String getDataMeczu() {
        return dataMeczu;
    }

    public Druzyna getDruzyna1() {
        return druzyna1;
    }

    public Druzyna getDruzyna2() {
        return druzyna2;
    }

    public String basicInfo() {
        return nazwaMeczu + " | " + dataMeczu;
    }

    /**
     *
     * @return podstawowe informacje o meczu, zawiera nazwę meczu i datę meczu
     */
    @Override
    public String pickWinner() {
        System.err.println("Invoked on basic Mecz object");
        return null;
    }

    /**
     *
     * @return podstawowe informacje o meczu, w klasach które dziedziczą z klasy bazowej
     * zwracane są również dokładne informacje o meeczu
     */
    @Override
    public String detailedStats() {
        return basicInfo();
    }


}