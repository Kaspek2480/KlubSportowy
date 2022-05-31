package org.example;

import org.example.objects.*;
import org.example.utils.MiscUtils;

import java.lang.reflect.Field;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        test();
        start();
    }

    public static void test() {
        Storage.loadSampleData();

        //get random Druzyna from storage
        Druzyna d = Storage.getDruzyny().get(MiscUtils.randInt(0, Storage.getDruzyny().size() - 1));
        Druzyna d2 = Storage.getDruzyny().get(MiscUtils.randInt(0, Storage.getDruzyny().size() - 1));

        MeczKoszykowki mecz = new MeczKoszykowki("12.07.2020 20:00", d, d2);
        Storage.addMatch(mecz);

        String s = mecz.detailedStats();
        System.out.println(s);
    }

    private static void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.println("Wybierz opcję: ");
            int wybor = Integer.parseInt(scanner.nextLine());

            switch (wybor) {
                //load sample data
                case 1: {
                    Storage.loadSampleData();
                    System.out.println("Załadowano przykładowe dane z pliku");
                    break;
                }
                //display matches
                case 2: {

                    break;
                }
                //display players
                case 3: {
                    Storage.displayAllPlayers();
                    break;
                }
                //display detailed match info
                case 4: {
                    System.out.println("Podaj typ meczu: ");
                    String typMeczu = scanner.nextLine();

                    for (Map.Entry<Integer, Mecz> entry : Storage.getMecze().entrySet()) {
                        if (entry.getValue().getClass().getSimpleName().equals(typMeczu)) {
                            System.out.println(entry.getKey() + ": " + entry.getValue().getNazwaMeczu() + " | " + entry.getValue().getDataMeczu());
                        }
                    }

                    System.out.println("Podaj numer meczu: ");
                    int numerMeczu = Integer.parseInt(scanner.nextLine());

                    Mecz mecz = Storage.getMecze().get(numerMeczu);
                    System.out.println(mecz.detailedStats());
                    break;
                }
                //delete player
                case 5: {
                    for (Map.Entry<Integer, Zawodnik> entry : Storage.getZawodnicy().entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue().getImie() + " " + entry.getValue().getNazwisko());
                    }
                    System.out.println("Podaj id zawodnika do usunięcia: ");
                    int id = scanner.nextInt();
                    Storage.removePlayer(id);
                    System.out.println("Usunięto zawodnika o id: " + id);
                    break;
                }
                //delete team
                case 6: {

                    break;
                }
                //add player
                case 7: {
                    System.out.println("Podaj imię zawodnika, którego chcesz dodać: ");
                    String imie = scanner.nextLine();
                    System.out.println("Podaj nazwisko zawodnika, którego chcesz dodać: ");
                    String nazwisko = scanner.nextLine();
                    System.out.println("Podaj wiek zawodnika, którego chcesz dodać: ");
                    int wiek = Integer.parseInt(scanner.nextLine());

                    Zawodnik zawodnik = new Zawodnik(imie, nazwisko, wiek);
                    Storage.addPlayer(zawodnik);
                    System.out.println("Dodano zawodnika: " + zawodnik.getImie() + " " + zawodnik.getNazwisko());
                    break;
                }
                //add match
                case 8: {
                    //
                    Mecz mecz;

                    System.out.println("Podaj datę meczu: ");
                    String dataMeczu = scanner.nextLine();

                    Storage.displayAllTeams();
                    System.out.println("Podaj drużynę 1: ");
                    Druzyna druzyna1 = Storage.getDruzyny().get(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Podaj drużynę 2: ");
                    Druzyna druzyna2 = Storage.getDruzyny().get(Integer.parseInt(scanner.nextLine()));

                    System.out.println("Podaj rodzaj meczu (np. MeczKoszykowki, MeczPilkiNoznej): ");
                    switch (scanner.nextLine()) {

                        case "MeczKoszykowki": {
                            mecz = new MeczKoszykowki(dataMeczu, druzyna1, druzyna2);
                            break;
                        }
                        case "MeczPilkiNoznej": {
                            mecz = new MeczPilkiNoznej(dataMeczu, druzyna1, druzyna2);
                            break;
                        }
                        case "MeczTenisa": {
                            mecz = new MeczTenisa(dataMeczu, druzyna1, druzyna2);
                            break;
                        }
                        case "MeczSiatkowki": {
                            mecz = new MeczSiatkowki(dataMeczu, druzyna1, druzyna2);
                            break;
                        }
                        default: {
                            System.out.println("Nie ma takiego typu meczu");
                            System.exit(0xfffe7961);
                            return;
                        }
                    }

                    try {
                        for (Field declaredField : mecz.getClass().getDeclaredFields()) {
                            Map<Druzyna, Integer> stat = new HashMap<>();

                            System.out.println("Podaj " + declaredField.getName() + " dla " + druzyna1.getNazwa() + ": ");
                            stat.put(druzyna1, Integer.parseInt(scanner.nextLine()));

                            System.out.println("Podaj " + declaredField.getName() + " dla " + druzyna2.getNazwa() + ": ");
                            stat.put(druzyna2, Integer.parseInt(scanner.nextLine()));

                            //setter for declared field is not accessible so we need to use reflection to set it
                            declaredField.setAccessible(true);
                            //set value of field to object of class Mecz or any of its subclasses (MeczKoszykowki, MeczPilkiNoznej, MeczSiatkowki, MeczTenisa)
                            declaredField.set(mecz, stat);
                        }
                    } catch (Exception e) {
                        System.out.println("Nie udało się dodać meczu z powodu błędu: " + e.getMessage());
                    }

                    Storage.addMatch(mecz);
                    break;
                }
                //add team
                case 9: {
                    System.out.println("Podaj rodzaj meczu, dla którego chcesz wpisać wynik: ");
                    String rodzajMeczu = scanner.nextLine();

                    for (Map.Entry<Integer, Mecz> entry : Storage.getMecze().entrySet()) {
                        if (entry.getValue().getClass().getSimpleName().equals(rodzajMeczu)) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                    }

                    System.out.println("Podaj id meczu, dla którego chcesz wpisać wynik: ");
                    int idMeczu = Integer.parseInt(scanner.nextLine());

                    System.out.println("Podaj wynik meczu: ");
                    int wynik = Integer.parseInt(scanner.nextLine());


//                    Mecz mecz = new Mecz(nazwaMeczu, dataMeczu);
//                    Storage.addMatch(mecz);
//                    System.out.println("Dodano mecz: " + mecz.getNazwaMeczu() + " " + mecz.getDataMeczu());

                }
                //save database to file
                case 10: {
                    Storage.saveDatabase();
                    break;
                }
                //if any other number is entered
                default: {
                    System.out.println("Nie ma takiej opcji");
                    break;
                }

            }
        }

    }

    private static void displayMenu() {
        displayLogo();
        System.out.println("==============================");
        System.out.println("1. Załaduj przykładowe dane z pliku");
        System.out.println("2. Wyświetl listę meczy");
        System.out.println("3. Wyświetl listę zawodników");
        System.out.println("4. Wyświetl dokładne informacje o meczu");
        System.out.println("5. Usuń zawodnika z bazy");
        System.out.println("6. Usuń drużynę z bazy");
        System.out.println("7. Dodaj zawodnika");
        System.out.println("8. Dodaj mecz");
        System.out.println("9. Dodaj drużynę");
        System.out.println("10. Zapisz bazę do pliku");
        System.out.println("11. Wyjdź z programu");
        System.out.println("==============================");
    }

    private static void displayLogo() {
        System.out.println("\n" +
                "   ██   ██ ██      ██    ██ ██████      ███████ ██████   ██████  ██████  ████████  ██████  ██     ██ ██    ██ \n" +
                "   ██  ██  ██      ██    ██ ██   ██     ██      ██   ██ ██    ██ ██   ██    ██    ██    ██ ██     ██  ██  ██  \n" +
                "   █████   ██      ██    ██ ██████      ███████ ██████  ██    ██ ██████     ██    ██    ██ ██  █  ██   ████   \n" +
                "   ██  ██  ██      ██    ██ ██   ██          ██ ██      ██    ██ ██   ██    ██    ██    ██ ██ ███ ██    ██    \n" +
                "   ██   ██ ███████  ██████  ██████      ███████ ██       ██████  ██   ██    ██     ██████   ███ ███     ██    \n");
    }
}