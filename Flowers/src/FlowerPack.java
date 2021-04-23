import java.util.ArrayList;

public class FlowerPack extends ArrayList<Flowers> {
    public int getPackPrice() {
        int sum = 0;
        for (Flowers flowers : this) {
            sum += flowers.getPrice();
        }
        return sum;
    }

    public String toString() {
        return "Общая стоимость букета: " + getPackPrice();
    }
}