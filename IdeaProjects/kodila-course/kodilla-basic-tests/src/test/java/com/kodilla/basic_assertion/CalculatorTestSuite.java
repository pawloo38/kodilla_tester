package com.kodilla.basic_assertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestSuite {
    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        int sumResult = calculator.sum(a, b);
        assertEquals(13, sumResult);
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        int subtractResult = calculator.subtract(b, a);
        assertEquals(3, subtractResult);
    }

    @Test
    public void testPowerOfTwoNegativeNumbers() {
        Calculator calculator = new Calculator();
        int a = -3;
        int powerOfTwoResult1 = calculator.powerOfTwo(a);
        assertEquals(9, powerOfTwoResult1);
    }

    @Test
    public void testPowerOfTwoZero() {
        Calculator calculator = new Calculator();
        int b = 0;
        int powerOfTwoResult2 = calculator.powerOfTwo(b);
        assertEquals(0, powerOfTwoResult2);
    }

    @Test
    public void testPowerOfTwoPositiveNumbers() {
        Calculator calculator = new Calculator();
        int c = 4;
        int powerOfTwoResult3 = calculator.powerOfTwo(c);
        assertEquals(16, powerOfTwoResult3);
    }
}