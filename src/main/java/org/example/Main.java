package org.example;

import com.google.gson.Gson;
import org.example.objects.*;
import org.example.utils.FileUtils;
import org.example.utils.MiscUtils;
import org.example.utils.SampleGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        start();
    }


    private static void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.println("Wybierz opcję: ");
            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    Storage.loadSampleData();
                    System.out.println("Załadowano przykładowe dane z pliku");
                    break;
                case 2:
                    break;
                case 3:
                    Storage.displayAllPlayers();
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
        System.out.println("9. Zapisz bazę do pliku");
        System.out.println("10. Wyjdź z programu");
        System.out.println("==============================");
    }
}