package com.kodilla.execution_model.homework;

import java.time.LocalDate;

public class Order {

    private double value;
    private LocalDate date;
    private String username;

    public Order(double value, LocalDate data, String username) {
        this.value = value;
        this.date = data;
        this.username = username;
    }

    public double getValue() {
        return value;
    }

    public LocalDate getData() {
        return date;
    }

    public String getUsername() {
        return username;
    }
}
