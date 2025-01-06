package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamblingMachineTestSuite {

    private final GamblingMachine gamblingMachine = new GamblingMachine();

    @ParameterizedTest
    @CsvSource({
            "1,2,3,4,5,6,1",
            "7,8,9,10,11,12,2",
            "5,10,15,20,25,30,2",
            "1,3,5,7,9,11,2",
            "10,20,30,37,40,45,2"
    })
    public void shouldReturnCorrectWins(String userNumbersStr, int expectedResult) throws InvalidNumbersException {
        Set<Integer> userNumbers = new HashSet<>();
        for (String numStr : userNumbersStr.split(",")) {
            userNumbers.add(Integer.parseInt(numStr.trim()));
        }

        System.out.println("User numbers: " + userNumbers);
        int actualResult = gamblingMachine.howManyWins(userNumbers);
        assertEquals(expectedResult, actualResult);
    }
}
