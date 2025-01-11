package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GamblingMachineTestSuite {

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void testHowManyWins(String userNumbersStr, String expectedComputerNumbersStr, int expectedCount) throws InvalidNumbersException {
        GamblingMachine gamblingMachine = new GamblingMachine();

        /*

        Set<Integer> userNumbers = parseNumbers(userNumbersStr);
        Set<Integer> expectedComputerNumbers = parseNumbers(expectedComputerNumbersStr);

        int actualCount = gamblingMachine.howManyWins(userNumbers);

        Assertions.assertEquals(expectedCount, actualCount);
*/
    }

    private Set<Integer> parseNumbers(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }


    @ParameterizedTest
    @CsvSource({
            "1,2,3,4,5,6, true",
            "1,2,3,4,5,60, false",
            "1,2,3,4,5, true",
    })
    void testValidateNumbers(String userNumbersStr, boolean shouldPass) {
        GamblingMachine gamblingMachine = new GamblingMachine();
        Set<Integer> userNumbers = parseNumbers(userNumbersStr);

        if (shouldPass) {
            Assertions.assertDoesNotThrow(() -> gamblingMachine.validateNumbers(userNumbers));
        } else {
            Assertions.assertThrows(InvalidNumbersException.class, () -> gamblingMachine.validateNumbers(userNumbers));
        }
    }
}