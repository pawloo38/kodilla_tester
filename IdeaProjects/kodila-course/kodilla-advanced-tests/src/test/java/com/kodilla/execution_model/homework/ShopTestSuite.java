package com.kodilla.execution_model.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ShopTestSuite {
    Shop shop;

    @BeforeEach
    public void setup() {
        shop = new Shop();

        shop.addOrder(new Order(120.50, LocalDate.of(2025, 1, 10), "user1"));
        shop.addOrder(new Order(200.75, LocalDate.of(2025, 1, 11), "user2"));
        shop.addOrder(new Order(150.30, LocalDate.of(2025, 1, 12), "user3"));
        shop.addOrder(new Order(80.90, LocalDate.of(2025, 1, 13), "user4"));
    }

    @Test
    public void shouldAddNewOrder() {
        int initialSize = shop.getOrderCount();
        shop.addOrder(new Order(50.00, LocalDate.of(2025, 1, 14), "user5"));
        assertEquals(initialSize + 1, shop.getOrderCount());
    }

    @Test
    public void shouldReturnOrdersWithinDateRange() {
        LocalDate startDate = LocalDate.of(2025, 1, 11);
        LocalDate endDate = LocalDate.of(2025, 1, 12);
        assertEquals(2, shop.getOrdersInDateRange(startDate, endDate).size());
    }

    @Test
    public void shouldReturnOrdersWithinPriceRange() {
        double minPrice = 100.00;
        double maxPrice = 200.00;
        assertEquals(2, shop.getOrdersByPriceRange(minPrice, maxPrice).size());
    }

    @Test
    public void shouldReturnCorrectOrderCount() {
        assertEquals(4, shop.getOrderCount());
    }

    @Test
    public void shouldSumAllOrderValues() {
        double expectedSum = 120.50 + 200.75 + 150.30 + 80.90;
        assertEquals(expectedSum, shop.sumAllOrdersValue(), 0.01);
    }
}