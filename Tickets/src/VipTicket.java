public class VipTicket extends Ticket {
    private final Meal meal;
    private final Baggage baggage;

    public VipTicket(int sitNumber, FlightInfo flightInfo, Passenger passenger, Meal meal, Baggage baggage) {
        super(sitNumber, flightInfo, passenger);
        this.sitNumber = sitNumber;
        this.meal = meal;
        this.baggage = baggage;

    }

    public int getCost() {
        return meal.getPrice() + baggage.getFee() + flightInfo.getCost();

    }

    @Override
    public String toString() {
        return "ipTicket{sitNumber=" + sitNumber +
                ", meal=" + meal.toString() +
                "\nbaggage=" + baggage.toString() +
                ", ticket price=" + getCost() + " $ }";
    }
}
