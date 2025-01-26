package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTestSuite {

        private ApplicationContext context;
        private Calculator calculator;

        @BeforeEach
        void setUp() {
            context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection");
            calculator = context.getBean(Calculator.class);
        }

        @Test
        void testAdd() {
            double result = calculator.add(5, 3);
            assertEquals(8.0, result);
        }

        @Test
        void testSubtract() {
            double result = calculator.subtract(5, 3);
            assertEquals(2.0, result);
        }

        @Test
        void testMultiply() {
            double result = calculator.multiply(5, 3);
            assertEquals(15.0, result);
        }

        @Test
        void testDivide() {
            double result = calculator.divide(6, 3);
            assertEquals(2.0, result);
        }

        @Test
        void testDivideByZero() {
            double result = calculator.divide(5, 0);
            assertEquals(Double.NaN, result);
        }
    }