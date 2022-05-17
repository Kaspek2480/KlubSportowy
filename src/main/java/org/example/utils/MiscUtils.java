package org.example.utils;

import org.example.objects.Zawodnik;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiscUtils {
    //random int in range
    public static int randInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }


    public static void clearSamples() {
        new File("Druzyna.txt").delete();
        new File("Zawodnik.txt").delete();
    }

    public static Map<Zawodnik, Integer> randomValuesOfZaowdnik(List<Zawodnik> zawodnicy) {
        Map<Zawodnik, Integer> map = new HashMap<>();
        for (Zawodnik zawodnik : zawodnicy) {
            if (randInt(0, 2) == 1) continue;
            map.put(zawodnik, randInt(0, 5));
        }
        return map;
    }
}
