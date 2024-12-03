package com.kodilla.abstrcts.homework;

public class Person {
    private String firstName;
    private int age;
    private Job job;

    public Person(String firstName, int age, Job job) {
        this.firstName = firstName;
        this.age = age;
        this.job = job;
    }

    public void displayJobResponsibilities() {
        System.out.println(firstName + " jest " + job.getProfession() + ".");
        System.out.println("Obowiazki: " + job.getResponsibilites());
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public Job getJob() {
        return job;
    }

    public static void main(String[] args) {
        Job teacher = new Teacher(5000, "Prowadzenie zajec dydaktycznych", "Nauczyciel");
        Job engineer = new Engineer(7000, "Projektowanie budynkow", "Inzynier");
        Job doctor = new Doctor(10000, "Leczenie pacjentow", "Lekarz");

        Person firstPerson = new Person("Krystyna", 30, teacher);
        Person secondPerson = new Person("Roman", 40, engineer);
        Person thirdPerson = new Person("Adam", 35, doctor);

        firstPerson.displayJobResponsibilities();
        secondPerson.displayJobResponsibilities();
        thirdPerson.displayJobResponsibilities();
    }
}
