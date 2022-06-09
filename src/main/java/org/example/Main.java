package org.example;

import org.example.objects.*;
import org.example.utils.SampleGenerator;
import org.example.utils.SerializeUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    public static void main(String[] args) {
//        Storage.loadSampleData();
//        Storage.saveDatabase();
        start();
    }

    private static void start() {
        Scanner scanner = new Scanner(System.in);
        displayLogo();

        while (true) {
            displayMenu();
            System.out.println("Wybierz opcję: ");
            int wybor = Integer.parseInt(scanner.nextLine());
            System.out.println();

            try {
                switch (wybor) {
                    //load sample data
                    case 1: {
                        Storage.loadSampleData();
                        System.out.println("Załadowano przykładowe dane z pliku");
                        break;
                    }
                    //display matches
                    case 2: {
                        System.out.println("Lista wszystkich rozegranych meczy:");

                        System.out.println("Mecze koszykowki:");
                        Storage.getMecze().values().stream().filter(m -> m instanceof MeczKoszykowki).forEach(m -> System.out.println(m.basicInfo() + " | Zwycięzca: " + m.pickWinner()));
                        System.out.println();

                        System.out.println("Mecze piłki nożnej:");
                        Storage.getMecze().values().stream().filter(m -> m instanceof MeczPilkiNoznej).forEach(m -> System.out.println(m.basicInfo() + " | Zwycięzca: " + m.pickWinner()));
                        System.out.println();

                        System.out.println("Mecze siatkówki:");
                        Storage.getMecze().values().stream().filter(m -> m instanceof MeczSiatkowki).forEach(m -> System.out.println(m.basicInfo() + " | Zwycięzca: " + m.pickWinner()));
                        System.out.println();

                        System.out.println("Mecz tenisowy:");
                        Storage.getMecze().values().stream().filter(m -> m instanceof MeczTenisa).forEach(m -> System.out.println(m.basicInfo() + " | Zwycięzca: " + m.pickWinner()));
                        System.out.println();

                        break;
                    }
                    //display players
                    case 3: {
                        System.out.println("Lista wszystkich zawodników:");
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
                        int id = Integer.parseInt(scanner.nextLine());

                        Storage.removePlayer(id);
                        System.out.println("Usunięto zawodnika o id: " + id);
                        break;
                    }
                    //delete team
                    case 6: {
                        for (Map.Entry<Integer, Druzyna> entry : Storage.getDruzyny().entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue().getNazwa());
                        }
                        System.out.println("Podaj id drużyny do usunięcia: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        Storage.removeTeam(id);
                        System.out.println("Usunięto drużynę o id: " + id);
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

                        if (wiek < 16) throw new BladProgramu("Zawodnik musi mieć więcej niż 16 lat");

                        Zawodnik zawodnik = new Zawodnik(imie, nazwisko, wiek);
                        Storage.addPlayer(zawodnik);
                        System.out.println("Dodano zawodnika: " + zawodnik.getImie() + " " + zawodnik.getNazwisko());
                        break;
                    }
                    //add match
                    case 8: {
                        Mecz mecz;

                        System.out.println("Podaj datę meczu: ");
                        String dataMeczu = scanner.nextLine();

                        Storage.displayAllTeams();
                        System.out.println("Podaj drużynę 1: ");
                        Druzyna druzyna1 = Storage.getDruzyny().get(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Podaj drużynę 2: ");
                        Druzyna druzyna2 = Storage.getDruzyny().get(Integer.parseInt(scanner.nextLine()));

                        if (druzyna1.equals(druzyna2)) throw new BladProgramu("Drużyny nie mogą być takie same");

                        System.out.println("Podaj rodzaj meczu (np. MeczKoszykowki, MeczPilkiNoznej, MeczSiatkowki, MeczTenisa): ");
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
                                return;
                            }
                        }

                        try {
                            for (Field declaredField : mecz.getClass().getDeclaredFields()) {
                                Map<Druzyna, Integer> stat = new HashMap<>();

                                System.out.println("Podaj " + declaredField.getName() + " dla " + druzyna1.getNazwa() + ": ");
                                int i = Integer.parseInt(scanner.nextLine());
                                if (i < 0) throw new BladProgramu("Liczba nie może być ujemna");
                                stat.put(druzyna1, i);

                                System.out.println("Podaj " + declaredField.getName() + " dla " + druzyna2.getNazwa() + ": ");
                                i = Integer.parseInt(scanner.nextLine());
                                if (i < 0) throw new BladProgramu("Liczba nie może być ujemna");
                                stat.put(druzyna2, i);

                                //setter for declared field is not accessible so we need to use reflection to set it
                                declaredField.setAccessible(true);
                                //set value of field to object of class Mecz or any of its subclasses (MeczKoszykowki, MeczPilkiNoznej, MeczSiatkowki, MeczTenisa)
                                declaredField.set(mecz, stat);
                            }
                        } catch (Exception e) {
                            System.out.println("Nie udało się dodać meczu z powodu błędu: " + e.getMessage());
                        }

                        Storage.addMatch(mecz);
                        System.out.println("Dodano mecz " + mecz.getClass().getSimpleName() + " " + druzyna1.getNazwa() + " vs " + druzyna2.getNazwa());
                        break;
                    }
                    //add team
                    case 9: {
                        System.out.println("Podaj nazwę drużyny: ");
                        String nazwa = scanner.nextLine();

                        Druzyna druzyna = new Druzyna(nazwa);
                        Storage.addTeam(druzyna);

                        System.out.println("Dodano drużynę " + druzyna.getNazwa());
                        break;
                    }
                    case 10: {
                        for (Map.Entry<Integer, Druzyna> entry : Storage.getDruzyny().entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue().getNazwa());
                        }
                        System.out.println("Podaj id drużyny do zarządzania: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        Druzyna druzyna = Storage.getDruzyny().get(id);
                        if (druzyna == null) {
                            throw new BladProgramu("Nie ma takiej drużyny");
                        }

                        boolean manage = true;
                        while (manage) {

                            System.out.println("==============================");
                            System.out.println("1. Dodaj zawodnika");
                            System.out.println("2. Usuń zawodnika");
                            System.out.println("3. Wyświetl listę zawodników");
                            System.out.println("4. Zakończ zarządzanie drużyną");
                            System.out.println("==============================");

                            int choice = Integer.parseInt(scanner.nextLine());
                            switch (choice) {
                                case 1: {
                                    System.out.println("Podaj id zawodnika do dodania: ");
                                    id = Integer.parseInt(scanner.nextLine());

                                    Zawodnik zawodnik = Storage.getZawodnicy().get(id);
                                    if (zawodnik == null) {
                                        throw new BladProgramu("Nie ma takiego zawodnika");
                                    }

                                    druzyna.getZawodnicy().add(zawodnik);
                                    System.out.println("Dodano zawodnika " + zawodnik.getImie() + " " + zawodnik.getNazwisko() + " do drużyny " + druzyna.getNazwa());
                                    break;
                                }
                                case 2: {
                                    if (druzyna.getZawodnicy().size() == 0) {
                                        System.out.println("Brak zawodników do usunięcia");
                                        break;
                                    }

                                    for (int i = 0; i < druzyna.getZawodnicy().size(); i++) {
                                        System.out.println((i + 1) + ": " + druzyna.getZawodnicy().get(i).getImie() + " " + druzyna.getZawodnicy().get(i).getNazwisko());
                                    }

                                    System.out.println("Podaj id zawodnika do usunięcia: ");
                                    id = Integer.parseInt(scanner.nextLine());

                                    Zawodnik zawodnik = druzyna.getZawodnicy().get(id - 1);
                                    if (zawodnik == null) {
                                        throw new BladProgramu("Nie ma takiego zawodnika");
                                    }

                                    druzyna.getZawodnicy().remove(zawodnik);

                                    System.out.println("Usunięto zawodnika " + zawodnik.getImie() + " " + zawodnik.getNazwisko() + " z drużyny " + druzyna.getNazwa());
                                    break;
                                }
                                case 3: {
                                    System.out.println();
                                    for (int i = 0; i < druzyna.getZawodnicy().size(); i++) {
                                        System.out.println((i + 1) + ": " + druzyna.getZawodnicy().get(i).getImie() + " " + druzyna.getZawodnicy().get(i).getNazwisko());
                                    }
                                    System.out.println();
                                    break;
                                }
                                case 4: {
                                    manage = false;
                                    break;
                                }
                            }
                        }

                        break;
                    }
                    //save database to file
                    case 11: {
                        Storage.saveDatabase();
                        break;
                    }

                    case 12: {
                        System.out.println("Dziękujemy za skorzystanie z programu!");
                        System.exit(0);
                        break;
                    }

                    //if any other number is entered
                    default: {
                        throw new BladProgramu("Niepoprawny wybór, spróbuj ponownie");
                    }

                }
            } catch (BladProgramu e) {
                System.err.println("Wystąpił błąd podczas wykonywania programu, operacja została przerwana z powodu: " + e.getMessage());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        }

    }

    private static void displayMenu() {
        System.out.println();
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
        System.out.println("10. Zarządzanie drużyną");
        System.out.println("11. Zapisz bazę do pliku");
        System.out.println("12. Wyjdź z programu");
        System.out.println("==============================");
        System.out.println();
    }

    private static void displayLogo() {
        System.out.println("\n" +
                "   ██   ██ ██      ██    ██ ██████      ███████ ██████   ██████  ██████  ████████  ██████  ██     ██ ██    ██ \n" +
                "   ██  ██  ██      ██    ██ ██   ██     ██      ██   ██ ██    ██ ██   ██    ██    ██    ██ ██     ██  ██  ██  \n" +
                "   █████   ██      ██    ██ ██████      ███████ ██████  ██    ██ ██████     ██    ██    ██ ██  █  ██   ████   \n" +
                "   ██  ██  ██      ██    ██ ██   ██          ██ ██      ██    ██ ██   ██    ██    ██    ██ ██ ███ ██    ██    \n" +
                "   ██   ██ ███████  ██████  ██████      ███████ ██       ██████  ██   ██    ██     ██████   ███ ███     ██    \n");
    }


    @Test
    public void sprawdzanieZwyciezcy() {
        Druzyna druzyna1 = new Druzyna("Drużyna 1");
        Druzyna druzyna2 = new Druzyna("Drużyna 2");

        Zawodnik zawodnik1 = new Zawodnik("Jan", "Kowalski", 25);
        Zawodnik zawodnik2 = new Zawodnik("Dawid", "Kowalski", 20);

        druzyna1.dodajZawodnika(zawodnik1);
        druzyna2.dodajZawodnika(zawodnik2);

        MeczTenisa meczTenisa = new MeczTenisa("Data", druzyna1, druzyna2, 1, 2);

        //zwyciezca druzyna 2 | zmień drużynę podczas testow aby pokazac ze test się nie powiedzie
        assertEquals(druzyna2.getNazwa(), meczTenisa.pickWinner());
    }
}