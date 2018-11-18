import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Flight {
    private ArrayList<Passenger> passengers;
    private PlaneType planeType;
    private String flightNumber;
    private String destination;
    private String departure;
    private Date departureTime;
    private int availableSeats;
    private int bagWeight;
    private ArrayList<Integer> bookedSeats;


    public Flight(PlaneType planeType, String flightNumber, String destination, String departure, Date departureTime){
        this.planeType = planeType;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departure = departure;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<Passenger>();
        this.availableSeats = planeType.getCapacity();
        this.bagWeight = ((planeType.getWeight()/2)/planeType.getCapacity());
        this.bookedSeats = new ArrayList<Integer>();
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getBagWeight(){
        return this.bagWeight;
    }

    public String getDestination() {
        return destination;
    }

    public String getDeparture() {
        return departure;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public int getCapacity() {
        return this.planeType.getCapacity();
    }

    public int generateRandom(){
        Random rand = new Random();
        int random = rand.nextInt(getCapacity()) + 1;
        return random;
    }

    public int generateSeatNumber(){
        int seatNumber = generateRandom();
        while(this.bookedSeats.contains(seatNumber)){
            seatNumber = generateRandom();
        }
        this.bookedSeats.add(seatNumber);
        return seatNumber;
    }

    public void addPassenger(Passenger passenger1) {
        if(availableSeats()>0) {
            this.passengers.add(passenger1);
            this.availableSeats -= 1;
            passenger1.setSeatNumber(generateSeatNumber());
        }
    }


    public int getPassengers() {
        return this.passengers.size();
    }

    public int availableSeats() {
        return this.availableSeats;
    }

    public int numberOfBagsChecked(){
        int totalBags = 0;

        for(int i=0; i < getPassengers(); i++){
            totalBags += this.passengers.get(i).getNumberOfBags();
        }
        return totalBags;
    }

    public int getBookedSeats() {
        return this.bookedSeats.size();
    }
}
