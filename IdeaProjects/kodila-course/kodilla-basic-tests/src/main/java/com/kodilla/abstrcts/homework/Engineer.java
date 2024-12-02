package com.kodilla.abstrcts.homework;

public class Engineer extends Job {
    public Engineer(double salary, String responsibilities, String proffesion) {
        super(salary, responsibilities, proffesion);
    }

    @Override
    public void displayJobInfo() {
        System.out.println("Wynagrodzenie inzyniera: " + getSalary());
        System.out.println("Obowiazki inzyniera: " + getResponsibilites());
        System.out.println("Wykonywany zawód to: " + getProfession());
    }
}
