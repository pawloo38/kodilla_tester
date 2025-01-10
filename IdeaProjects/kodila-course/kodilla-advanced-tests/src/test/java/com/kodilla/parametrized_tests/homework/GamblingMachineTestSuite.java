package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamblingMachineTestSuite {

    private final GamblingMachine gamblingMachine = new GamblingMachine();

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 0)
    public void shouldReturnCorrectWins(String userNumbersStr, int expectedResult) throws InvalidNumbersException {


        Set<Integer> userNumbers = new HashSet<>();

        for (String numStr : userNumbersStr.split(",")) {
            userNumbers.add(Integer.parseInt(numStr.trim()));
        }

        System.out.println("User numbers: " + userNumbers);
        int actualResult = gamblingMachine.howManyWins(userNumbers); // Wykonaj operację na maszynie do gier
        assertEquals(expectedResult, actualResult); // Porównaj z oczekiwanym wynikiem
    }
}
