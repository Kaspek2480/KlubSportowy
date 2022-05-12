package org.example.objects;

import java.util.ArrayList;
import java.util.List;

public class Liga {
    private final String nazwa;
    private final List<Druzyna> kluby;
    private List<Mecz> mecze;


    public Liga(String nazwa) {
        this.nazwa = nazwa;
        this.kluby = new ArrayList<>();
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<Druzyna> getKluby() {
        return kluby;
    }

    public void dodajDruzyne(Druzyna druzyna) {
        kluby.add(druzyna);
    }

    @Override
    public String toString() {
        return "Liga{" +
                "nazwa='" + nazwa + '\'' +
                ", druzyny=" + kluby +
                '}';
    }
}