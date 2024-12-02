package com.kodilla.basic_assertion;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        int sumResult = calculator.sum(a, b);
        boolean correct1 = ResultChecker.assertEquals(13, sumResult);
        if (correct1) {
            System.out.println("Metoda sum dziala poprawnie dla liczb " + a + " i " + b);
        } else {
            System.out.println("Metoda sum nie dzila popranie dla liczb " + a + " i " + b);
        }

        int subtractResult = calculator.subtract(b, a);
        boolean correct2 = ResultChecker.assertEquals(3, subtractResult);
        if (correct2) {
            System.out.println("Metoda subtract dziala poprawnie dla liczb " + b + " i " + a);
        } else {
            System.out.println("Metoda subtract nia dziala poprawnie dla liczb " + b + " i " + a);
        }

        int powerOfTwoResult = calculator.powerOfTwo(a);
        boolean correct3 = ResultChecker.assertEquals(25, powerOfTwoResult);
        if (correct3) {
            System.out.println("Metoda powerOfTwo dziala poprawnie dla liczby " + a);
        } else {
            System.out.println("Metoda powerOfTwo nie dziala poprawnie dla liczby " + a);
        }
    }
}
