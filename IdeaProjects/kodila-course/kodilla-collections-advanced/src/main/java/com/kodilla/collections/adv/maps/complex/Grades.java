package com.kodilla.collections.adv.maps.complex;

import java.util.ArrayList;
import java.util.List;

public class Grades {
    private List<Double> grades = new ArrayList<>();

    public Grades(List<Double> grades) {
        this.grades = grades;
    }

    public Grades(double v, double v1, double v2, double v3, double v4) {
        this.grades.add(v);
        this.grades.add(v1);
        this.grades.add(v2);
        this.grades.add(v3);
        this.grades.add(v4);
    }

    public Grades(double v, double v1, double v2) {
        this.grades.add(v);
        this.grades.add(v1);
        this.grades.add(v2);
    }

    public double getAverage() {
        double sum = 0.0;
        for (double grade : grades)
            sum += grade;
        return sum / grades.size();
    }

    @Override
    public String toString() {
        return "Grades: " + grades.toString();
    }
    
}
