package com.kodilla.inheritance.homework;

public class Application {
    public static void main(String[] args) {
        OperatingSystem windows = new Windows(1985);
        OperatingSystem macOS = new MacOS(2001);

        System.out.println("Rok wydania systemu Windows: " + windows.getRelaseYear());
        System.out.println("Rok wydania systemu MacOS: " + macOS.getRelaseYear());
    }
}
