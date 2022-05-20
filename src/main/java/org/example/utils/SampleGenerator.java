package org.example.utils;

import com.google.gson.Gson;
import org.example.objects.*;

import java.util.ArrayList;
import java.util.List;

public class SampleGenerator {
    public static void prepareSamples() {
        Gson gson = new Gson();
        List<Zawodnik> zawodnicy = new ArrayList<>();
        List<Druzyna> druzyny = new ArrayList<>();
        List<Mecz> mecze = new ArrayList<>();
        List<MeczKoszykowki> meczKoszykowki = new ArrayList<>();
        List<MeczSiatkowki> meczSiatkowki = new ArrayList<>();
        List<MeczPilkiNoznej> meczPilkiNoznej = new ArrayList<>();
        List<MeczTenisa> meczTenisa = new ArrayList<>();

        zawodnicy.add(new Zawodnik("Jan", "Kowalski", 11));
        zawodnicy.add(new Zawodnik("Mateusz", "Nowak", 27));
        zawodnicy.add(new Zawodnik("Kamil", "Wojtas", 34));
        zawodnicy.add(new Zawodnik("Łukasz", "Laskowski", 22));
        zawodnicy.add(new Zawodnik("Piotr", "Chrypko", 23));
        zawodnicy.add(new Zawodnik("Lech", "Komorowski", 28));
        zawodnicy.add(new Zawodnik("Kazimierz", "Chryńko", 33));
        zawodnicy.add(new Zawodnik("Grzegorz", "Mioduszewski", 19));
        zawodnicy.add(new Zawodnik("Paweł", "Tyborowski", 18));
        zawodnicy.add(new Zawodnik("Michał", "Kopeć", 21));
        zawodnicy.add(new Zawodnik("Bartosz", "Gierek", 29));
        zawodnicy.add(new Zawodnik("Krzysztof", "Opolski", 36));
        zawodnicy.add(new Zawodnik("Władysław", "Skała", 34));
        zawodnicy.add(new Zawodnik("Jędrzej", "Prawandowski", 23));
        zawodnicy.add(new Zawodnik("Hubert", "Prawandowski", 24));
        zawodnicy.add(new Zawodnik("Eugieniusz", "Zamojski", 18));
        zawodnicy.add(new Zawodnik("Darek", "Oświęcicki", 17));
        zawodnicy.add(new Zawodnik("Piotr", "Szeliga", 30));
        zawodnicy.add(new Zawodnik("Norman", "Parkowski", 26));
        zawodnicy.add(new Zawodnik("Damian", "Kwiatkowski", 25));

        druzyny.add(new Druzyna("Legia Warszawa"));
        druzyny.add(new Druzyna("Wisła Kraków"));
        druzyny.add(new Druzyna("Lech Poznań"));
        druzyny.add(new Druzyna("Zaglebie Lubin"));
        druzyny.add(new Druzyna("Piast Gliwice"));
        druzyny.add(new Druzyna("Górnik Zabrze"));
        druzyny.add(new Druzyna("Sparta Nowy Sacz"));
        druzyny.add(new Druzyna("Lechia Gdańsk"));
        druzyny.add(new Druzyna("GKS Rutki"));
        druzyny.add(new Druzyna("Olimpia Zambrów"));
        druzyny.add(new Druzyna("Stal Rzeszów"));
        druzyny.add(new Druzyna("Chojniczanka"));
        druzyny.add(new Druzyna("Olimpia Elbląg"));
        druzyny.add(new Druzyna("Wigry Suwałki"));
        druzyny.add(new Druzyna("Hutnik Kraków"));
        druzyny.add(new Druzyna("Znicz Pruszków"));

        mecze.add(new Mecz("Nazwa meczu", "data"));


        for (Druzyna druzyna : druzyny) {
            for (int i = 0; i < MiscUtils.randInt(3, 12); i++) {
                druzyna.dodajZawodnika(zawodnicy.get(MiscUtils.randInt(0, zawodnicy.size() - 1)));
            }
        }


        serialize(meczKoszykowki, meczSiatkowki, meczPilkiNoznej, meczTenisa, zawodnicy, druzyny);
    }

    private static void serialize(List<?>... list) {
        Gson gson = new Gson();
        for (List<?> objects : list) {

            for (Object object : objects) {
                String json = gson.toJson(object);
                FileUtils.appendToFile(json + "\n", object.getClass().getSimpleName() + ".txt");
            }
        }
    }
}
