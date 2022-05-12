package org.example;

import org.example.objects.Druzyna;
import org.example.objects.Liga;
import org.example.objects.Zawodnik;

public class Main {
    public static void main(String[] args) {
        Zawodnik zawodnik = new Zawodnik("Jan", "Kowalski", "Bramkarz", 11, 36);
        Zawodnik zawodnik2 = new Zawodnik("Dawid", "Kowalski", "Obrona", 12, 25);

        Druzyna manchesterUnited = new Druzyna("Manchester United", "Jakas liga");
        manchesterUnited.dodajZawodnika(zawodnik);
        manchesterUnited.dodajZawodnika(zawodnik2);

        Liga liga = new Liga("Puchar Tymbark");
        liga.dodajDruzyne(manchesterUnited);

        System.out.println("Liga: " + liga.getNazwa());

        for (Druzyna druzyna : liga.getKluby()) {
            System.out.println("==============================");
            System.out.println("Klub: " + druzyna.getNazwa());
            System.out.println("Zawodnicy: ");
            for (Zawodnik zawodnik1 : druzyna.getZawodnicy()) {
                System.out.println(zawodnik1);
            }
            System.out.println("Rozegrane mecze: ");

        }

    }
}
