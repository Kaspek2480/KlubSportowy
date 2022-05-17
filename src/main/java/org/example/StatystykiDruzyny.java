package org.example;

import org.example.objects.Druzyna;

import java.util.List;

public interface StatystykiDruzyny {
    public int liczbaDruzyn(List<Druzyna> druzyny);

    public int liczbawyciestw(List<Druzyna> druzyny);

    public int liczbaRemis(List<Druzyna> druzyny);

    public int liczbaPorazek(List<Druzyna> druzyny);

}
