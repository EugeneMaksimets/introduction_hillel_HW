import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidationService {
    private static final Pattern PATTERN_QUERY = Pattern.compile("^q");
    private static final Pattern PATTERN_UPDATE = Pattern.compile("^u");
    private static final Pattern PATTERN_DELETE = Pattern.compile("^o");
    private static final String INPUT = "input.txt";

    private static String resultFromFile = null;

    public static void stringToArray(OrderBook book) {
        try {
            resultFromFile = getResourceFileAsString(INPUT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert resultFromFile != null;
        String[] arrayFromString = resultFromFile.split("\n");

        for (String operation : arrayFromString) {
            validation(operation, book);
        }
    }

    private static String getResourceFileAsString(String fileName) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(fileName)) {
            if (is == null) return null;
            try (InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader reader = new BufferedReader(isr)) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        }
    }

    private static void validation(String lineToValidation, OrderBook orderBook) {
        Matcher matcherQuery = PATTERN_QUERY.matcher(lineToValidation);
        Matcher matcherUpdate = PATTERN_UPDATE.matcher(lineToValidation);
        Matcher matcherDelete = PATTERN_DELETE.matcher(lineToValidation);

        if (matcherQuery.find())
            ServiceQueryBook.queryValidation(lineToValidation,orderBook);
        else if (matcherUpdate.find())
            ServiceUpdateBook.updateValidation(lineToValidation, orderBook);
        else if (matcherDelete.find())
            ServiceDeleteFromBook.validationDelete(lineToValidation, orderBook);
    }
}
