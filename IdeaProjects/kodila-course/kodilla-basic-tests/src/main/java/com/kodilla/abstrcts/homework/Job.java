package com.kodilla.abstrcts.homework;

public abstract class Job {
    protected double salary;
    protected String responsibilites;
    protected String profession;

    public Job(double salary, String responsibilites, String profession) {
        this.salary = salary;
        this.responsibilites = responsibilites;
        this.profession = profession;
    }

    public double getSalary() {
        return salary;
    }

    public String getResponsibilites() {
        return responsibilites;
    }

    public String getProfession() {
        return profession;
    }

    public abstract void displayJobInfo();
}
