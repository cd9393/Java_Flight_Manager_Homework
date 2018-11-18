public class FlightManager {

    Flight flight;
    int maximumBaggageWeight;

    public FlightManager(Flight flight) {
        this.flight = flight;
        this.maximumBaggageWeight = (this.flight.getPlaneType().getWeight()/2);
    }

    public int baggageWeightPerPassenger() {
        int bagWeight = (this.maximumBaggageWeight/this.flight.getPlaneType().getCapacity());
        return bagWeight;
    }

    public int checkedBaggageWeight() {
        int totalBaggageWeight = this.flight.numberOfBagsChecked() * baggageWeightPerPassenger();
        return totalBaggageWeight;
    }


    public int remainingBaggageWeight() {
        return this.maximumBaggageWeight - checkedBaggageWeight();
    }

    public void bookPassenger(Passenger passenger, Flight flight) {
        this.flight.addPassenger(passenger);
        passenger.setFlight(flight);
    }
}
