import java.util.Collections;
import java.util.Set;

public class ServiceDeleteFromBook {
    public static void validationDelete (String operation, OrderBook orderBook) {
        try {
            String[] operationArray = operation.split(",");
            if (operationArray[1].equals("sell")) {
                Set<Integer> keySet = orderBook.getBidBuy().keySet();
                int max = Collections.max(keySet);
                orderBook.getBidBuy().replace(max, orderBook.getBidBuy().get(max) - Integer.parseInt(operationArray[2]));
//                System.out.println(max + "," + orderBook.getBidBuy().get(max));
            } else if (operationArray[2].equals("buy")) {
                Set<Integer> keySet = orderBook.getAskSell().keySet();
                int min = Collections.min(keySet);
                orderBook.getAskSell().replace(min, orderBook.getAskSell().get(min) - Integer.parseInt(operationArray[2]));
//                System.out.println(min + "," + orderBook.getAskSell().get(min));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
