package org.example;

import org.example.objects.*;
import org.example.utils.MiscUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        test();
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

                    if (mecz instanceof MeczKoszykowki) {
                        ((MeczKoszykowki) mecz).detailedStats();
                    } else if (mecz instanceof MeczPilkiNoznej) {
                        ((MeczPilkiNoznej) mecz).detailedStats();
                    }
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
                    System.out.println("Podaj imię zawodnika, którego szukasz: ");
                    String imie = scanner.nextLine();
                    System.out.println("Podaj nazwisko zawodnika, którego szukasz: ");
                    String nazwisko = scanner.nextLine();
                    System.out.println("Podaj wiek zawodnika, którego szukasz: ");
                    int wiek = Integer.parseInt(scanner.nextLine());

                    Zawodnik zawodnik = new Zawodnik(imie, nazwisko, wiek);
                    Storage.addPlayer(zawodnik);
                    System.out.println("Dodano zawodnika: " + zawodnik.getImie() + " " + zawodnik.getNazwisko());
                    break;
                }
                //add match
                case 8: {
                    System.out.println("Podaj rodzaj meczu (np. MeczKoszykowki, MeczPilkiNoznej): ");
                    String rodzajMeczu = scanner.nextLine();
                    System.out.println(rodzajMeczu);

                    Object mecz = null;
                    switch (rodzajMeczu) {


                        case "MeczKoszykowki": {
//                            mecz = new MeczKoszykowki();


                        }
                        case "MeczPilkiNoznej": {

                            break;
                        }
                    }

                    if (mecz == null) {
                        System.out.println("Nie ma takiego meczu");
                        break;
                    }

                    for (Field declaredField : mecz.getClass().getDeclaredFields()) {
                        System.out.println("Podaj " + declaredField.getName() + ": ");
                        String value = scanner.nextLine();
//                        declaredField.set(mecz, value);
                    }

                    try {
                        Mecz.class.getName().replace(".Mecz", "");
                        Class<?> aClass = Class.forName("org.example.objects." + rodzajMeczu);
                        Object instance = aClass.newInstance();

                        for (Field declaredField : aClass.getDeclaredFields()) {
                            System.out.println("Podaj wartość pola: " + declaredField.getName());
                            String wartosc = scanner.nextLine();
                            declaredField.setAccessible(true);
                            declaredField.set(instance, wartosc);
                        }
                        System.out.println("Dodano mecz: " + instance.toString());
                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }

                    //TODO: zaimplementować dodawanie meczu
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
                default:
                    System.out.println("Nie ma takiej opcji");
                    break;
            }
        }

    }

    private static void displayMenu() {
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
}