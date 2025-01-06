package com.kodilla.exception.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTestSuite {
    @Test
    public void testGetOrder_withNonExistingOrder() {
        Warehouse warehouse = new Warehouse();
        warehouse.addOrder(new Order("132"));
        warehouse.addOrder(new Order("249"));
        warehouse.addOrder(new Order("466"));
        warehouse.addOrder(new Order("743"));
        warehouse.addOrder(new Order("987"));

        assertThrows(OrderDoesntExistException.class, () -> warehouse.getOrder("123"));
    }

}