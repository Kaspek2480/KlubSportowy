package org.example.utils;

import com.google.gson.Gson;
import org.example.Storage;
import org.example.objects.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class SampleGenerator {

    public static void prepareSamples() {
        Gson gson = new Gson();
        List<Zawodnik> zawodnicy = new ArrayList<>();
        List<Druzyna> druzyny = new ArrayList<>();


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
        zawodnicy.add(new Zawodnik("Joseph", "Greenwood", 38));
        zawodnicy.add(new Zawodnik("Kamil", "Śliwowski", 19));
        zawodnicy.add(new Zawodnik("Teodor", "Czerczesow", 22));
        zawodnicy.add(new Zawodnik("Marian", "Lutostański", 21));
        zawodnicy.add(new Zawodnik("Leaonardo", "Karpio", 29));


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
        druzyny.add(new Druzyna("Raków Częstochowa"));
        druzyny.add(new Druzyna("KS Śniadowo"));
        druzyny.add(new Druzyna("Jagielonia Białystok"));
        druzyny.add(new Druzyna("Stal Mielec"));
        druzyny.add(new Druzyna("Warta Poznań"));
        druzyny.add(new Druzyna("Anwil Włocławek"));
        druzyny.add(new Druzyna("GTK Gliwice"));
        druzyny.add(new Druzyna("Trefl Sopot"));
        druzyny.add(new Druzyna("ŁKS Łódź"));
        druzyny.add(new Druzyna("Legion Legionowo"));
        druzyny.add(new Druzyna("Pogoń Puławy"));
        druzyny.add(new Druzyna("Harmattan Gniewkowo"));
        druzyny.add(new Druzyna("Tytan Częstochowa"));
        druzyny.add(new Druzyna("Rawia Rawicz"));
        druzyny.add(new Druzyna("Okęcie Warszawa"));
        druzyny.add(new Druzyna("Śląsk Wrocław"));
        druzyny.add(new Druzyna("Orzeł Polkowice"));
        druzyny.add(new Druzyna("Znicz Jarosław"));
        druzyny.add(new Druzyna("Zastal Zielona Góra"));
        druzyny.add(new Druzyna("Olimpia Stulęcin"));
        druzyny.add(new Druzyna("Anioły Toruń"));
        druzyny.add(new Druzyna("Jastrzębski Węgiel"));
        druzyny.add(new Druzyna("Stal Nysa"));
        druzyny.add(new Druzyna("UNI Opole"));
        druzyny.add(new Druzyna("GKS Stoczniowiec"));


        for (Druzyna druzyna : druzyny) {
            for (int i = 0; i < MiscUtils.randInt(3, 12); i++) {
                druzyna.dodajZawodnika(zawodnicy.get(MiscUtils.randInt(0, zawodnicy.size() - 1)));
            }
        }


        serialize(druzyny);
    }

    public static void prepareMecz() {
        List<Mecz> mecze = new ArrayList<>();
        List<String> dateList = getDateList();
        //random date from list

        for (int i = 0; i < 40; i++) {
            Druzyna d = Storage.randomDruzyna();
            Druzyna d2 = Storage.randomDruzyna();
            String date = dateList.get(MiscUtils.randInt(0, dateList.size() - 1));

            if (d == null || d2 == null) {
                System.out.println("null");
                continue;
            }

            Mecz mecz;
            int randInt = MiscUtils.randInt(0, 4);
            switch (randInt) {
                case 0: {
                    mecz = new MeczKoszykowki(date, d, d2);
                    break;
                }
                case 1: {
                    mecz = new MeczSiatkowki(date, d, d2);
                    break;
                }
                case 2: {
                    mecz = new MeczPilkiNoznej(date, d, d2);
                    break;
                }
                case 3: {
                    mecz = new MeczTenisa(date, d, d2);
                    break;
                }
                default: {
                    mecz = new MeczTenisa(date, d, d2);
                }
            }
            mecze.add(mecz);
//            MeczKoszykowki mecz = new MeczKoszykowki("12.07.2020 20:00", d, d2);
//            Storage.addMatch(mecz);
        }
        Storage.getMecze().clear();
        mecze.forEach(Storage::addMatch);
        System.out.println("Mecze: " + mecze.size());

    }

    public static void main(String[] args) {
        prepareSamples();
//       Storage.loadSampleData();
//        for (Mecz value : Storage.getMecze().values()) {
//            System.out.println(value.getClass().getSimpleName() + " " + value.basicInfo());
//        }

//        prepareMecz();
//        prepareSamples();
    }

    private static void serialize(List<?>... list) {
        Gson gson = new Gson();
        for (List<?> objects : list) {
            System.out.println(objects.getClass().getSimpleName() + " " + objects.size());
            for (Object object : objects) {
                String json = gson.toJson(object);
                FileUtils.appendToFile(json, object.getClass().getSimpleName() + ".txt");
            }
        }
    }

    public static List<String> getDateList() {
        List<String> list = new ArrayList<>();
        list.add("12.09.2020 | 20:00");
        list.add("03.06.2020 | 15:15");
        list.add("23.06.2020 | 18:30");
        list.add("01.11.2020 | 20:00");
        list.add("16.10.2020 | 13:00");
        list.add("13.04.2020 | 20:30");
        list.add("18.02.2020 | 22:00");
        list.add("17.09.2020 | 18:15");
        list.add("22.12.2020 | 19:00");
        list.add("09.11.2020 | 13:30");
        list.add("08.11.2020 | 14:00");
        list.add("10.10.2020 | 17:45");
        list.add("11.09.2020 | 21:00");
        list.add("14.08.2020 | 22:30");
        list.add("12.08.2020 | 21:00");
        list.add("17.05.2020 | 11:45");
        list.add("28.02.2020 | 14:00");
        list.add("05.02.2020 | 19:30");
        list.add("31.01.2020 | 18:00");
        list.add("30.09.2020 | 18:15");
        list.add("29.05.2020 | 18:30");
        list.add("02.12.2020 | 17:00");
        list.add("01.11.2020 | 16:30");
        list.add("24.10.2020 | 15:00");
        list.add("23.09.2020 | 11:30");
        list.add("28.04.2020 | 16:00");
        list.add("18.02.2020 | 20:45");
        list.add("19.05.2020 | 21:30");
        list.add("20.04.2020 | 19:00");
        list.add("03.08.2020 | 18:30");


        return list;
    }
}
