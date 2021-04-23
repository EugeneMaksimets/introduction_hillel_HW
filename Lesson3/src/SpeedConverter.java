import java.util.Scanner;

public class SpeedConverter {


    public static void main(String[] args) {
        final String HELLO_TEXT = "Введите скорость в километрах = ";
        System.out.println(HELLO_TEXT);
        Scanner speedScanner = new Scanner(System.in);
        double kilometersPerHour = speedScanner.nextDouble();
//        double kilometersPerHour = 25.43;
        /*System.out.println(toMilesPerHour(kilometersPerHour));*/
        printConversion(toMilesPerHour(kilometersPerHour), kilometersPerHour);

    }

    public static long toMilesPerHour(double kilometersPerHour) {
        final double KOF_SPEED = 1.609;
        if (kilometersPerHour < 0) {
            return -1;
        }
        double result = kilometersPerHour / KOF_SPEED;
        return Math.round(result);
    }

    public static void printConversion(long toMilesPerHour, double kilometersPerHour) {
        final String TEXT_KILOMETERS_PER_HOUR = " km/h = ";
        final String TEXT_MILES_PER_HOUR = " mi/h";
        final String TEXT_ERROR = "Неверное значение";
        String textFinal;
        if (toMilesPerHour == -1) {
            textFinal = TEXT_ERROR;
        } else {
            textFinal = kilometersPerHour + TEXT_KILOMETERS_PER_HOUR + toMilesPerHour + TEXT_MILES_PER_HOUR;
        }
        System.out.println(textFinal);

    }


}
