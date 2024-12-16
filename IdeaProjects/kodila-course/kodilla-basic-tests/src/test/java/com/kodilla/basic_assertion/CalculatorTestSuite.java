package com.kodilla.basic_assertion;

import com.kodilla.basic_assertion.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestSuite {
    private Calculator calculator;
    int a, b;

    @BeforeEach
// @BeforeAll
    public void setUp() {
        this.calculator = new Calculator();
        this.a = 5;
        this.b = 8;
    }

    @Test
    public void testSum() {
        int sumResult = this.calculator.sum(a, b);
        assertEquals(13, sumResult);
    }

    @Test
    public void testSubtract() {
        int subtractResult = this.calculator.subtract(b, a);
        assertEquals(3, subtractResult);
    }

    @Test
    public void testPowerOfTwoNegativeNumbers() {
        this.a = -3;
        int powerOfTwoResult1 = this.calculator.powerOfTwo(a);
        assertEquals(9, powerOfTwoResult1);
    }

    @Test
    public void testPowerOfTwoZero() {
        this.a = 0;
        int powerOfTwoResult2 = this.calculator.powerOfTwo(this.a);
        assertEquals(0, powerOfTwoResult2);
    }

    @Test
    public void testPowerOfTwoPositiveNumbers() {
        this.a = 4;
        int powerOfTwoResult3 = this.calculator.powerOfTwo(this.a);
        assertEquals(16, powerOfTwoResult3);
    }
}