public abstract class Flowers {
    private final String name;
    private final int price;


    public Flowers(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return getName() + getPrice();
    }
}