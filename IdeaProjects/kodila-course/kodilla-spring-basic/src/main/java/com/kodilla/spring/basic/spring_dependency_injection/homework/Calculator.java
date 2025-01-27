package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    private final Display display;

    public Calculator(Display display) {
        this.display = display;
    }

    public double add(double a, double b) {
        double result = Math.addExact((int)a, (int)b);
        display.display(result);
        return result;
    }

    public double subtract(double a, double b) {
        double result = Math.subtractExact((int)a, (int)b);
        display.display(result);
        return result;
    }

    public double multiply(double a, double b) {
        double result = Math.multiplyExact((int)a, (int)b);
        display.display(result);
        return result;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            display.display(Double.NaN);
            System.out.println("Błąd: Dzielenie przez zero!");
            return Double.NaN;
        }
        double result = a / b;
        display.display(result);
        return result;
    }
}