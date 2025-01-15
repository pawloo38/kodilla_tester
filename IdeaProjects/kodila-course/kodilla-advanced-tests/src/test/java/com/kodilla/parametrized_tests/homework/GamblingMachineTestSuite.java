package com.kodilla.parametrized_tests.homework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.HashSet;
import java.util.Set;

public class GamblingMachineTestSuite {
private GamblingMachine gamblingMachine;

@BeforeEach
public void setUp() {
    gamblingMachine = new GamblingMachine();
}

        @ParameterizedTest
        @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
        void testHowManyWins(Set<Integer> userNumbers, int expectedWins) throws InvalidNumbersException {
            int wins = gamblingMachine.howManyWins(userNumbers);
            Assertions.assertEquals(expectedWins, wins);
}
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void testAtLeastOneMatch(Set<Integer> userNumbers) throws InvalidNumbersException {

        Set<Integer> computerNumbers = gamblingMachine.generateComputerNumbers();

        boolean atLeastOneMatch = true;
        for (Integer number : userNumbers) {
            if (computerNumbers.contains(number)) {
                atLeastOneMatch = false;
                break;
            }
        }
        Assertions.assertTrue(atLeastOneMatch, "No matching numbers between user and computer sets.");
    }

        private Set<Integer> parseNumbers(String str) {
            Set<Integer> numbers = new HashSet<>();
            String[] splitNumbers = str.split(" ");
            for (String num : splitNumbers) {
                numbers.add(Integer.parseInt(num.trim()));
            }
            return numbers;
        }

        @ParameterizedTest
        @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
        void testValidateNumbers(String userNumbersStr, boolean shouldPass) {

            Set<Integer> userNumbers = parseNumbers(userNumbersStr);
            System.out.println(userNumbers);

            if (shouldPass) {
                Assertions.assertDoesNotThrow(() -> gamblingMachine.validateNumbers(userNumbers));
            } else {
                Assertions.assertThrows(InvalidNumbersException.class, () -> gamblingMachine.validateNumbers(userNumbers));
            }
        }

    }