package org.example;

import com.google.gson.Gson;
import org.example.objects.*;
import org.example.utils.MiscUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MiscUtils.clearSamples();
        prepareSamples();
    }
    //FIXME gdzie przechowywac dane (statyczne listy obiektow?)
    //FIXME czy wartosci moga byc od razu finalne w przypadku gdy ladujemy dane [obiekty] (bez metod typu dodaj punkt itp)
    //FIXME czy w meczu muszą byc dwie druzyny czy prowadzimy statystyki tylko jednej druzyny (tej naszej z klubu)
    //FIXME czy to ma dzialac na zasadzie przechowywania danych (tylko) czy dodac metody na zasadzie dodajPunkt dodajMecz itp

    private static void prepareSamples() {
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
                appendToFile(json + "\n", object.getClass().getSimpleName() + ".txt");
            }
        }
    }

    private static void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.println("Wybierz opcję: ");
            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    loadData();
                    System.out.println("Załadowano przykładowe dane z pliku");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Do zobaczenia!");
                    return;
                default:
                    System.out.println("Nie ma takiej opcji");
                    break;
            }
        }

    }

    /***
     * Metoda wczytująca dane testowe z pliku .json
     * Deserializacja przyogtowanych danych do obiektów
     */
    private static void loadData() {
        System.out.println("Loading data..");

        List<String> druzyny = readFileToListString("samplesDruzyna.txt");
        List<String> zawodnicy = readFileToListString("samplesZawodnik.txt");

        if (druzyny == null || zawodnicy == null) {
            System.out.println("Fatal error while loading data");
            System.exit(0);
        }

        for (String druzyna : druzyny) {
            System.out.println(druzyna);
        }

        for (String zawodnik : zawodnicy) {
            System.out.println(zawodnik);
        }

    }

    private static List<String> readFileToListString(String fileName) {
        try {
            File sampleFile = new File(fileName);
            return Files.readAllLines(sampleFile.toPath());
        } catch (IOException e) {
            System.err.println("Error reading file due to: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private static void appendToFile(String line, String fileName) {
        try {
            if (!new File(fileName).exists()) {
                new File(fileName).createNewFile();
            }
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(line);
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error writing to file due to: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void displayMenu() {
        System.out.println("==============================");
        System.out.println("1. Załaduj przykładowe dane z pliku");
        System.out.println("2. Wyświetl listę meczy");
        System.out.println("3. Wyświetl listę zawodników");
        System.out.println("4. Wyświetl dokładne informacje o meczu");
        System.out.println("5. Usuń mecz z bazy");
        System.out.println("6. Dodaj zawodnika");
        System.out.println("7. Dodaj mecz");
        System.out.println("8. Dodaj drużynę");
        System.out.println("9. Wyjdź z programu");
        System.out.println("==============================");
        //TODO dodawanie zawodnika
        //TODO dodawanie meczu
        //TODO
    }
}