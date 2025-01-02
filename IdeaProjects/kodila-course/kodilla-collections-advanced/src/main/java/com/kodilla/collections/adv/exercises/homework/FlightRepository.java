package com.kodilla.collections.adv.exercises.homework;

import java.util.ArrayList;
import java.util.List;

public class FlightRepository {

    public static List<Flight> getFlightsTable() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Warszawa", "Radom"));
        flights.add(new Flight("Londyn", "Berlin"));
        flights.add(new Flight("Nowy Jork", "Warszawa"));
        flights.add(new Flight("Paryż", "Tokio"));
        flights.add(new Flight("Warszawa", "Rzym"));
        flights.add(new Flight("Berlin", "Paryż"));
        flights.add(new Flight("Londyn", "Tokio"));
        return flights;
    }
}
