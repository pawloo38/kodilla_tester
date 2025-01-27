package com.kodilla.spring.basic.spring_configuration.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarFactoryTestSuite {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_configuration");
    }

    @Test
    void testCarCreationInSummer() {

        CarFactory carFactory = new CarFactory() {

            public String getCurrentSeason() {
                return "SUMMER";
            }
        };
        context.getAutowireCapableBeanFactory().initializeBean(carFactory, "carFactory");
        Car car = context.getBean(Car.class);

        assertEquals("Cabrio", car.getCarType());

        LocalTime now = LocalTime.now();
        if (now.getHour() >= 20 || now.getHour() < 6) {
            assertTrue(car.hasHeadlightsTurnedOn());
        } else {
            assertEquals(false, car.hasHeadlightsTurnedOn());
        }
    }

    @Test
    void testCarCreationInWinter() {

        CarFactory carFactory = new CarFactory() {

            public String getCurrentSeason() {
                return "WINTER";
            }
        };
        context.getAutowireCapableBeanFactory().initializeBean(carFactory, "carFactory");
        Car car = context.getBean(Car.class);

        assertEquals("SUV", car.getCarType());

        LocalTime now = LocalTime.now();
        if (now.getHour() >= 20 || now.getHour() < 6) {
            assertTrue(car.hasHeadlightsTurnedOn());
        } else {
            assertEquals(false, car.hasHeadlightsTurnedOn());
        }
    }

    @Test
    void testCarCreationInSpring() {

        CarFactory carFactory = new CarFactory() {

            public String getCurrentSeason() {
                return "SPRING";
            }
        };
        context.getAutowireCapableBeanFactory().initializeBean(carFactory, "carFactory");
        Car car = context.getBean(Car.class);

        assertEquals("Sedan", car.getCarType());

        LocalTime now = LocalTime.now();
        if (now.getHour() >= 20 || now.getHour() < 6) {
            assertTrue(car.hasHeadlightsTurnedOn());
        } else {
            assertEquals(false, car.hasHeadlightsTurnedOn());
        }
    }
}
