package org.example;

import org.example.objects.Zawodnik;

import java.util.List;

public interface StatystykiMeczu {
    public int liczbaGoli(Zawodnik zawodnik);

    public int liczbaGoli(List<Zawodnik> zawodnik);

    public int liczbaAsyst(Zawodnik zawodnik);

    public int liczbaAsyst(List<Zawodnik> zawodnik);

    public int liczbaCzerownychKartek(Zawodnik zawodnik);

    public int liczbaZoltychKartek(Zawodnik zawodnik);

    public int liczbaFauli(Zawodnik zawodnik);

    public int liczbaFauli(List<Zawodnik> zawodnik);
}
