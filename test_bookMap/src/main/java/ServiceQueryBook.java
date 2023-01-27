import java.util.Collections;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceQueryBook {
    public static final Pattern PATTERN_END_ASK = Pattern.compile("ask$");
    public static final Pattern PATTERN_END_BID = Pattern.compile("bid$");
    private static final Pattern PATTERN_END_NUMBER = Pattern.compile("[0-9]$");

    public static void queryValidation(String operation, OrderBook orderBook) {
        Matcher matcherEndAsk = PATTERN_END_ASK.matcher(operation);
        Matcher matcherEndBid = PATTERN_END_BID.matcher(operation);
        Matcher matcherEndNumber = PATTERN_END_NUMBER.matcher(operation);
        if (matcherEndAsk.find()) {
            System.out.println("ask");
            Set<Integer> keySet = orderBook.getAskSell().keySet();
            int max = Collections.max(keySet);
            System.out.println(max + "," + orderBook.getAskSell().get(max));
        } else if (matcherEndBid.find()) {
            Set<Integer> keySet = orderBook.getBidBuy().keySet();
            int min = Collections.min(keySet);
            System.out.println(min + "," + orderBook.getBidBuy().get(min));
        } else if (matcherEndNumber.find()) {
            String[] operationArray = operation.split(",");
            int number = 0;
            try {
                number = Integer.parseInt(operationArray[2]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (orderBook.getBidBuy().get(number) != null) {
                System.out.println(orderBook.getBidBuy().get(number));
            }
            if (orderBook.getAskSell().get(number) != null) {
                System.out.println(orderBook.getAskSell().get(number));
            }
        }
    }
}
