package com.kodilla.basic_assertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultCheckerTest {
    @Test
    void testAssertEqualsWhenValuesAreEqual() {
        // Given
        int expected = 10;
        int actual = 10;

        // When
        boolean result = ResultChecker.assertEquals(expected, actual);

        // Then
        assertTrue(result, "Metoda assertEquals powinna zwrócić true, gdy wartości są równe.");
    }

    @Test
    void testAssertEqualsWhenValuesAreNotEqual() {
        // Given
        int expected = 10;
        int actual = 5;

        // When
        boolean result = ResultChecker.assertEquals(expected, actual);

        // Then
        assertFalse(result, "Metoda assertEquals powinna zwrócić false, gdy wartości są różne.");
    }

    @Test
    void testAssertEqualsWhenExpectedIsZero() {
        // Given
        int expected = 0;
        int actual = 0;

        // When
        boolean result = ResultChecker.assertEquals(expected, actual);

        // Then
        assertTrue(result, "Metoda assertEquals powinna zwrócić true, gdy obie wartości są zerami.");
    }

    @Test
    void testAssertEqualsWhenActualIsNegative() {
        // Given
        int expected = 10;
        int actual = -10;

        // When
        boolean result = ResultChecker.assertEquals(expected, actual);

        // Then
        assertFalse(result, "Metoda assertEquals powinna zwrócić false, gdy rzeczywista wartość jest ujemna.");
    }

    @Test
    void testAssertEqualsWhenExpectedIsNegative() {
        // Given
        int expected = -10;
        int actual = -10;

        // When
        boolean result = ResultChecker.assertEquals(expected, actual);

        // Then
        assertTrue(result, "Metoda assertEquals powinna zwrócić true, gdy obie wartości są ujemne i równe.");
    }
}
