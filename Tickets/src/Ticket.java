public class Ticket {
    public int sitNumber;
    public final FlightInfo flightInfo;
    private final Passenger passenger;

    public Ticket(int sitNumber, FlightInfo flightInfo, Passenger passenger) {
        this.sitNumber = sitNumber;
        this.flightInfo = flightInfo;
        this.passenger = passenger;

    }

    public int getSitNumber() {
        return sitNumber;
    }

    public int getCost() {
        return flightInfo.getCost();
    }

    @Override
    public String toString() {
        return "Ticket {sitNumber=" + sitNumber +
                ", flightInfo=" + flightInfo.toString() +
                "\n passengerInfo=" + passenger.toString() +
                " ticket price= " + getCost() +
                " $ }";
    }
}
