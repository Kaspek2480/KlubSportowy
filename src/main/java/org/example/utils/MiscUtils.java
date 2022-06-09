package org.example.utils;

import org.example.objects.Druzyna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiscUtils {
    //random int in range
    public static int randInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }



    public static Map<Druzyna, Integer> randomValuesOfDruzyny(List<Druzyna> zawodnicy) {
        Map<Druzyna, Integer> map = new HashMap<>();
        for (Druzyna druzyna : zawodnicy) {
            map.put(druzyna, randInt(0, 5));
        }
        return map;
    }
}
