import java.util.HashMap;
import java.util.regex.Matcher;

public class ServiceUpdateBook {
    public static void updateValidation(String operation, OrderBook orderBook) {
        Matcher matcherEndAsk = ServiceQueryBook.PATTERN_END_ASK.matcher(operation);
        Matcher matcherEndBid = ServiceQueryBook.PATTERN_END_BID.matcher(operation);
        if (matcherEndAsk.find())
            addToHashMap(operation, orderBook.getAskSell());
        else if (matcherEndBid.find())
            addToHashMap(operation, orderBook.getBidBuy());
    }

    private static void addToHashMap(String operation, HashMap<Integer, Integer> hashMap) {
        String[] infoOperation = operation.split(",");
        try {
            int price = Integer.parseInt(infoOperation[1]);
            int amount = Integer.parseInt(infoOperation[2]);
            if (hashMap.containsKey(price))
                hashMap.replace(price, hashMap.get(price) + amount);
            else
                hashMap.put(price, amount);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
