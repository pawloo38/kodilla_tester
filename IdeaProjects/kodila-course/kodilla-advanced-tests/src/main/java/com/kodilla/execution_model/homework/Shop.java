package com.kodilla.execution_model.homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {

    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        orders.add(order);
    }

    public List<Order> getOrdersInDateRange(LocalDate startDate, LocalDate endDate) {
        return orders.stream()
                .filter(order -> !order.getData().isBefore(startDate) && !order.getData().isAfter(endDate))
                .collect(Collectors.toList());
    }

    public List<Order> getOrdersByPriceRange(double minPrice, double maxPrice) {
        return orders.stream()
                .filter(order -> order.getValue() >= minPrice && order.getValue() <= maxPrice)
                .collect(Collectors.toList());
    }

    public int getOrderCount() {
        return orders.size();
    }

    public double sumAllOrdersValue() {
        return orders.stream()
                .mapToDouble(Order::getValue)
                .sum();
    }
}
