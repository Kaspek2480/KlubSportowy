package org.example;

import org.example.objects.Druzyna;

import java.util.List;

public interface StatystykiDruzyny {
    public int liczbaDruzyn(List<Druzyna> druzyny);

    public int liczbaDruzynZwyciestw(List<Druzyna> druzyny);

    public int liczbaDruzynRemis(List<Druzyna> druzyny);

    public int liczbaDruzynPorazek(List<Druzyna> druzyny);

}
