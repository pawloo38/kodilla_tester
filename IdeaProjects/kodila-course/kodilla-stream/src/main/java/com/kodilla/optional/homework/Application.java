package com.kodilla.optional.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Jan Kowalski");
        Teacher teacher2 = new Teacher("Adam Nowak");

        List<Student> students = Arrays.asList(
                new Student("Tomasz Mrowka", teacher1),
                new Student("Magdalena Matulka", teacher2),
                new Student("Piotr Kepka", null),
                new Student("Rafal Czerwinski", null)
        );
        for (Student student : students) {
            String teacherName = Optional.ofNullable(student.getTeacher())
                    .map(Teacher::getName)
                    .orElse("<undefined>");
            System.out.println("Uczen: " + student.getName() + ", nauczyciel: " + teacherName);
        }
    }
}
