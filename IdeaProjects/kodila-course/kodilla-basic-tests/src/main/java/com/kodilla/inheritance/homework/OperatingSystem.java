package com.kodilla.inheritance.homework;

public class OperatingSystem {
    private int relaseYear;

    public OperatingSystem(int relaseYear) {
        this.relaseYear = relaseYear;
    }

    public void turnOn() {
        System.out.println("Włączam system operacyjny.");
    }

    public void turnOff() {
        System.out.println("Wyłączam system operacyjny.");
    }

    public int getRelaseYear() {
        return relaseYear;
    }
}
