public class Passenger {
    public String name;
    public String lastName;
    public long passport;

    public Passenger(String name, String lastName, long passport) {
        this.name = name;
        this.lastName = lastName;
        this.passport = passport;

    }

    public String toString() {
        return "PassengerInfo" +
                "{name= " + name +
                ", lastName=" + lastName +
                ", passport= " + passport +
                "}, ";
    }
}
