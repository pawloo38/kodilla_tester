package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class PersonTestSuite {
    @ParameterizedTest
    @CsvFileSource(resources = "/person_data.csv", numLinesToSkip = 1)
public void shouldReturnCorrectBMI(String height, String weight, String expectedBMI) {
        double heightInMeters = Double.parseDouble(height);
        double weightInKilograms = Double.parseDouble(weight);

        Person person = new Person(heightInMeters, weightInKilograms);
        String actualBMI = person.getBMI();
        assertEquals(expectedBMI, actualBMI);
    }
}