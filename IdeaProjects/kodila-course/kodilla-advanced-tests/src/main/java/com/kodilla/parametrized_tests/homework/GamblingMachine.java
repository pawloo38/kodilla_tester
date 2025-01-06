package com.kodilla.parametrized_tests.homework;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class GamblingMachine {

    public int howManyWins(Set<Integer> userNumbers) throws InvalidNumbersException {
        validateNumbers(userNumbers);
        Set<Integer> computerNumbers = generateComputerNumbers();
        System.out.println("User Numbers: " + userNumbers);
        System.out.println("Computer Numbers: " + computerNumbers);
        int count = 0;
        for (Integer number : userNumbers) {
            if (computerNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void validateNumbers(Set<Integer> numbers) throws InvalidNumbersException {
        int size = numbers.size();
        if (isNotCorrectSize(numbers)) {
            throw new InvalidNumbersException("Invalid number count: Expected 6 numbers, but got " + size + ".");
        }
        if (isAnyNumberOutOfDeclaredScope(numbers)) {
            throw new InvalidNumbersException("Numbers must be in the range from 1 to 49.");
        }
    }


    private boolean isAnyNumberOutOfDeclaredScope(Set<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < 1 || number > 49);
    }

    private boolean isNotCorrectSize(Set<Integer> numbers) {
        return numbers.size() != 6;
    }

    private Set<Integer> generateComputerNumbers() {
        Set<Integer> numbers = new HashSet<>();
        Random generator = new Random();
        while(numbers.size() < 6) {
            numbers.add(generator.nextInt(49) + 1);
        }
        return numbers;
    }
}
