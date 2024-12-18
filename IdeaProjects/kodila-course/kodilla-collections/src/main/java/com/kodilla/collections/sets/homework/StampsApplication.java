package com.kodilla.collections.sets.homework;

import java.util.HashSet;
import java.util.Set;

public class StampsApplication {
    public static void main(String[] args) {
        Set<Stamp> stamps = new HashSet<>();

        stamps.add(new Stamp("Znaczek pocztowy", " 10x15 mm", false));
        stamps.add(new Stamp("Znaczek pocztowy", " 10x15 mm", false));
        stamps.add(new Stamp("Znaczek z edycji swiatecznej", " 20x30 mm", true));
        stamps.add(new Stamp("Znaczek z edycji limitowanej", " 25x35 mm", false));
        stamps.add(new Stamp("Znaczek pocztowy", " 10x15 mm", false));

        System.out.println("Liczba znaczkow w kolekcji: " + stamps.size());

        for (Stamp stamp: stamps) {
            System.out.println(stamp);
        }
    }
}
