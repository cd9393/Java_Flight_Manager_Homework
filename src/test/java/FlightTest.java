import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightTest {
    Flight flight;
    Passenger passenger1;

    @Before
    public void before(){
        flight = new Flight(PlaneType.BOEING747, "FR756", "GLA", "LDN", new Date(2018, 12, 8, 17,30));
        passenger1 = new Passenger("Jacob", 1);
    }

    @Test
    public void canReturnCapacity(){
        assertEquals(4, flight.getCapacity());
    }

    @Test
    public void canAddPassenger(){
        flight.addPassenger(passenger1);
        assertEquals(1, flight.getPassengers());
        assertEquals(3, flight.availableSeats());
    }
    @Test
    public void cantAddPassengerPastCapacity(){
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger1);
        assertEquals(4, flight.getPassengers());
        assertEquals(0, flight.availableSeats());
        assertEquals(4, flight.getBookedSeats());
    }

    @Test
    public void canGetBagWeight(){
        assertEquals(56, flight.getBagWeight());
    }

    @Test
    public void canReturnAvailableSeats(){
        flight.addPassenger(passenger1);
        assertEquals(3, flight.availableSeats());
    }

    @Test
    public void canGenerateUniqueSeatNumber(){
        ArrayList<Integer> seats = new ArrayList<Integer>();
        seats.add(flight.generateSeatNumber());
        seats.add(flight.generateSeatNumber());
        seats.add(flight.generateSeatNumber());
        seats.add(flight.generateSeatNumber());
        assertTrue(seats.contains(1));
        assertTrue(seats.contains(2));
        assertTrue(seats.contains(3));
        assertTrue(seats.contains(4));


    }
}
