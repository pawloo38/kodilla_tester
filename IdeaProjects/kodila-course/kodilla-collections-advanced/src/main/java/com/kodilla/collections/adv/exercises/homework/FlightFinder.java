package com.kodilla.collections.adv.exercises.homework;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFinder {

    public List<Flight> findFlightsFrom(String departure) {
        return FlightRepository.getFlightsTable().stream().filter(flight -> flight.getDeparture().equals(departure)).collect(Collectors.toList());

    }
    public List<Flight> findFlightsTo(String arrival) {
        return FlightRepository.getFlightsTable().stream().filter(flight -> flight.getArrival().equals(arrival)).collect(Collectors.toList());
    }
}
