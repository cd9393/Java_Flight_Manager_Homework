import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightManagerTest {

    FlightManager flightManager;
    Flight flight;
    Passenger passenger1;

    @Before
    public void before(){
        flight = new Flight(PlaneType.BOEING747, "FR756", "GLA", "LDN", new Date(2018, 12, 3, 17, 30));
        passenger1 = new Passenger("Jacob", 1);

        flightManager = new FlightManager(flight);
    }

    @Test
    public void canCalculateBaggageWeightPerPassenger(){
        assertEquals(56, flightManager.baggageWeightPerPassenger());
    }

    @Test
    public void canCalculateBookedBaggageWeight(){
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger1);
        assertEquals(112, flightManager.checkedBaggageWeight());
    }

    @Test
    public void canCalculateRemainingBaggageWeight(){
        flight.addPassenger(passenger1);
        assertEquals(168, flightManager.remainingBaggageWeight());
    }

    @Test
    public void canBookPassengerOnFlight(){
        flightManager.bookPassenger(passenger1, flight);
        assertEquals(1, flight.getPassengers());
        assertEquals(flight, passenger1.getFlight());
        assertTrue(passenger1.getSeatNumber()> 0 && passenger1.getSeatNumber() <= flight.getCapacity());
    }
}
