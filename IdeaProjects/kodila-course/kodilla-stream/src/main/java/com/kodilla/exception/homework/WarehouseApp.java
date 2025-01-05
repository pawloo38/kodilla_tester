package com.kodilla.exception.homework;

public class WarehouseApp {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        warehouse.addOrder(new Order("132"));
        warehouse.addOrder(new Order("249"));
        warehouse.addOrder(new Order("466"));
        warehouse.addOrder(new Order("743"));
        warehouse.addOrder(new Order("987"));

        try {
            Order order = warehouse.getOrder("123");
            System.out.println("Zamowienie: " + order.getNumber());
        } catch (OrderDoesntExistException e) {
            System.out.println("Brak zamowienia.");
        }
    }
}
