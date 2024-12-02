package com.kodilla.abstrcts.homework;

public class Doctor extends Job {
    public Doctor(double salary, String responsibilities, String profession) {
        super(salary, responsibilities, profession);
    }

    @Override
    public void displayJobInfo() {
        System.out.println("Wynagrodzenie lekarza: " + getSalary());
        System.out.println("Obowiazki lekarza: " + getResponsibilites());
        System.out.println("Wykonywany zawod to: " + getProfession());
    }
}
