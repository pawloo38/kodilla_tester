package com.kodilla.collections.lists.homework;

import com.kodilla.collections.arrays.homework.CarUtils;
import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Ford;
import com.kodilla.collections.interfaces.homework.Honda;
import com.kodilla.collections.interfaces.homework.Opel;

import java.util.ArrayList;
import java.util.List;

public class CarsListApplication {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Ford());
        cars.add(new Opel());
        cars.add(new Honda());

        System.out.println("Lista pojazdow: ");
        for (Car car : cars) {
            CarUtils.describeCar(car);
        }
        cars.remove(1);

        Car ford = cars.getFirst();
        cars.remove(ford);

        System.out.println("Lista pojazdow po redukcji: ");
        for (Car car : cars) {
            CarUtils.describeCar(car);
        }
        System.out.println("Ilosc pojazdow: " + cars.size());
    }
}
