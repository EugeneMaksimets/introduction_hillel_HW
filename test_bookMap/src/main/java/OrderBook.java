import java.util.HashMap;

public class OrderBook {
    private HashMap<Integer, Integer> bidBuy = new HashMap<>();
    private HashMap<Integer, Integer> askSell = new HashMap<>();

    public HashMap<Integer, Integer> getBidBuy() {
        return bidBuy;
    }

    public HashMap<Integer, Integer> getAskSell() {
        return askSell;
    }

}
