package com.kodilla.collections.interfaces.homework;

public class CarRace {
    public static void main(String[] args) {
        Car ford = new Ford();
        Car opel = new Opel();
        Car honda = new Honda();

        doRace(ford);
        doRace(opel);
        doRace(honda);
    }

    private static void doRace(Car car) {
        for (int i = 0; i < 3; i++) {
            car.increaseSpeed();
        }
        for (int i = 0; i < 2; i++) {
            car.decreaseSpeed();
        }
        System.out.println("Koncowa predkosc " + car.getClass().getSimpleName() + " to: " + car.getSpeed() + " km/h");
    }

}
