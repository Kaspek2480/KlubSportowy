package org.example;

import org.example.objects.Mecz;
import org.example.objects.Zawodnik;

import java.util.List;

public interface StatystykiZawodnika {
    int czasNaBoisku(Mecz mecz, Zawodnik zawodnik);

    //np 5 ostatnich meczow
    int czasNaBoisku(List<Mecz> mecze, Zawodnik zawodnik);

    int strzeloneBramki(Mecz mecz, Zawodnik zawodnik);

    int przewinienia(Mecz mecz, Zawodnik zawodnik);

    int asysyty(Mecz mecz, Zawodnik zawodnik);

    int liczbaZoltychKartek(Mecz mecz, Zawodnik zawodnik);

    int liczbaCzerwonychKartek(Mecz mecz, Zawodnik zawodnik);
}
