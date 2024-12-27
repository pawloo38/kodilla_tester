package com.kodilla.collections.adv.maps.homework;

import java.util.HashMap;
import java.util.Map;

public class SchoolDirectory {
    public static void main(String[] args) {
        Principal principal1 = new Principal("Jan", "Kowalski");
        Principal principal2 = new Principal("Adam", "Nowak");
        Principal principal3 = new Principal("Roman", "Mazur");


        School school1 = new School("Szkola srednia 1");
        school1.addClass(30);
        school1.addClass(25);
        school1.addClass(28);

        School school2 = new School("Szkola srednia 2");
        school2.addClass(20);
        school2.addClass(32);
        school2.addClass(27);

        School school3 = new School("Szkola srednia 3");
        school3.addClass(15);
        school3.addClass(18);
        school3.addClass(21);

        Map<School, Principal> schoolDirectory = new HashMap<>();
        schoolDirectory.put(school1, principal1);
        schoolDirectory.put(school2, principal2);
        schoolDirectory.put(school3, principal3);

        for (Map.Entry<School, Principal> entry : schoolDirectory.entrySet()) {
            School school = entry.getKey();
            Principal principal = entry.getValue();

            System.out.println("Principal: " + principal.getFirstName() + " " + principal.getLastName());
            System.out.println("School: " + school.getName());
            System.out.println("Total Students: " + school.getTotalStudents());
            System.out.println("------------------");
        }
    }
}