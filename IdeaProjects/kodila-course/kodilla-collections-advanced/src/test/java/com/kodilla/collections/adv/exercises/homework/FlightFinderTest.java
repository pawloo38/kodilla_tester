package com.kodilla.collections.adv.exercises.homework;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlightFinderTest {

    @Test
    public void testFindFlightsFrom() {

        FlightFinder flightFinder = new FlightFinder();
        List<Flight> result = flightFinder.findFlightsFrom("Warszawa");

        assertEquals(2, result.size());
        assertTrue(result.contains(new Flight("Warszawa", "Radom")));
        assertTrue(result.contains(new Flight("Warszawa", "Rzym")));
  }

    @Test
    public void testFindFlightsTo() {
        FlightFinder flightFinder = new FlightFinder();
        List<Flight> result = flightFinder.findFlightsTo("Tokio");
        assertEquals(2, result.size());
        assertTrue(result.contains(new Flight("Paryż", "Tokio")));
        assertTrue(result.contains(new Flight("Londyn", "Tokio")));
    }

}