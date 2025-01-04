package com.kodilla.optional.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {

    @Test
    public void testStudentWithTeacher() {
        Teacher teacher1 = new Teacher("Jan Kowalski");
        Teacher teacher2 = new Teacher("Adam Nowak");

        List<Student> students = Arrays.asList(
                new Student("Tomasz Mrowka", teacher1),
                new Student("Magdalena Matulka", teacher2)
        );

        StringBuilder result = new StringBuilder();
        for (Student student : students) {
            String teacherName = Optional.ofNullable(student.getTeacher())
                    .map(Teacher::getName)
                    .orElse("<undefined>");
            result.append("Uczen: ").append(student.getName())
                    .append(", nauczyciel: ").append(teacherName).append("\n");
        }
        String expectedOutput = "Uczen: Tomasz Mrowka, nauczyciel: Jan Kowalski\n" +
                "Uczen: Magdalena Matulka, nauczyciel: Adam Nowak\n";

        assertEquals(expectedOutput, result.toString());
    }
    @Test
    public void testStudentWithoutTeacher() {
        Teacher teacher1 = new Teacher("Jan Kowalski");

        List<Student> students = Arrays.asList(
                new Student("Piotr Kepka", null),
                new Student("Rafal Czerwinski", null)
        );

        StringBuilder result = new StringBuilder();
        for (Student student : students) {
            String teacherName = Optional.ofNullable(student.getTeacher())
                    .map(Teacher::getName)
                    .orElse("<undefined>");
            result.append("Uczen: ").append(student.getName())
                    .append(", nauczyciel: ").append(teacherName).append("\n");
        }

        String expectedOutput = "Uczen: Piotr Kepka, nauczyciel: <undefined>\n" +
                "Uczen: Rafal Czerwinski, nauczyciel: <undefined>\n";

        assertEquals(expectedOutput, result.toString());
    }

    @Test
    public void testStudentWithAndWithoutTeacher() {
        Teacher teacher1 = new Teacher("Jan Kowalski");
        Teacher teacher2 = new Teacher("Adam Nowak");

        List<Student> students = Arrays.asList(
                new Student("Tomasz Mrowka", teacher1),
                new Student("Piotr Kepka", null),
                new Student("Magdalena Matulka", teacher2),
                new Student("Rafal Czerwinski", null)
        );

        StringBuilder result = new StringBuilder();
        for (Student student : students) {
            String teacherName = Optional.ofNullable(student.getTeacher())
                    .map(Teacher::getName)
                    .orElse("<undefined>");
            result.append("Uczen: ").append(student.getName())
                    .append(", nauczyciel: ").append(teacherName).append("\n");
        }

        String expectedOutput = "Uczen: Tomasz Mrowka, nauczyciel: Jan Kowalski\n" +
                "Uczen: Piotr Kepka, nauczyciel: <undefined>\n" +
                "Uczen: Magdalena Matulka, nauczyciel: Adam Nowak\n" +
                "Uczen: Rafal Czerwinski, nauczyciel: <undefined>\n";

        assertEquals(expectedOutput, result.toString());
    }

}