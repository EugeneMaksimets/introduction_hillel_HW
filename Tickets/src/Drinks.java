public enum Drinks {
    YES(0, "Алкогольный", 50),

    NO(1, "Безалкогольный", 50);

    private final int var;
    private final String description;
    private final int price;

    Drinks(int var, String description, int price) {
        this.var = var;
        this.description = description;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getVar() {
        return var;
    }

    public String getDescription() {
        return description;
    }


    public String toString() {
        return "Menu{" +
                "var=" + var +
                ", description='" + description + '\'' +
                ", price=" + price + '$' +
                '}';
    }
}
