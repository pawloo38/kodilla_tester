package com.kodilla.collections.adv.maps.homework;

import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private List<Integer> studentsInClasses;

    public School(String name) {
        this.name = name;
        this.studentsInClasses = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public List<Integer> getStudentsInClasses() {
        return studentsInClasses;
    }

    public void addClass(int numberOfStudents){
        studentsInClasses.add(numberOfStudents);
    }
    public int getTotalStudents() {
        int total = 0;
        for (int students : studentsInClasses) {
            total += students;
        }
        return total;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", studentsInClasses=" + studentsInClasses +
                '}';
    }
}
