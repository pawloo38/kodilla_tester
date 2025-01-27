package com.kodilla.spring.basic.spring_configuration.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;

@Configuration
public class CarFactory {

    @Bean
    public Car car() {

        LocalTime now = LocalTime.now();
        boolean isNight = now.getHour() >= 20 || now.getHour() < 6;

        String season = getCurrentSeason();
        Car car;

        switch (season) {
            case "SUMMER":
                car = new Cabrio(isNight);
                break;
            case "WINTER":
                car = new SUV(isNight);
                break;
            default:
                car = new Sedan(isNight);
                break;
        }

        return car;
    }

    private String getCurrentSeason() {

        int month = LocalDate.now().getMonthValue();
        if (month >= 6 && month <= 8) {
            return "SUMMER";
        } else if (month >= 12 || month <= 2) {
            return "WINTER";
        } else {
            return "SPRING";
        }
    }
}
