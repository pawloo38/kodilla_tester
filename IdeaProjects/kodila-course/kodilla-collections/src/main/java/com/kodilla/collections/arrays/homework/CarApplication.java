package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Ford;
import com.kodilla.collections.interfaces.homework.Honda;
import com.kodilla.collections.interfaces.homework.Opel;

import java.util.Random;

public class CarApplication {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int arraySize = RANDOM.nextInt(15) + 1;

        Car[] cars = new Car[arraySize];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = drawCar();
        }
        for (Car car : cars) {
            CarUtils.describeCar(car);

        }
    }

    public static Car drawCar() {
        int drawnCarKind = RANDOM.nextInt(3);
        Car car = null;

        if (drawnCarKind == 0) {
            car = new Ford();
        } else if (drawnCarKind == 1) {
            car = new Opel();
        } else {
            car = new Honda();
        }
        if (car != null) {
            int speedIncrease = RANDOM.nextInt(10) + 1;
            for (int i = 0; i < speedIncrease; i++) {
                car.increaseSpeed();
            }
        }
        return car;
    }
}
