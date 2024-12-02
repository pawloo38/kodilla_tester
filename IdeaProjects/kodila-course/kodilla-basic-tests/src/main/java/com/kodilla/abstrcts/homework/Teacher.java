package com.kodilla.abstrcts.homework;

public class Teacher extends Job {
    public Teacher(double salary, String responsibilities, String profession) {
        super(salary, responsibilities, profession);
    }

    @Override
    public void displayJobInfo() {
        System.out.println("Wynagrodzenie nauczyciela: " + getSalary());
        System.out.println("Obowiazki nauczyciela: " + getResponsibilites());
        System.out.println("Wykonywany zawod to: " + getProfession());
    }
}
