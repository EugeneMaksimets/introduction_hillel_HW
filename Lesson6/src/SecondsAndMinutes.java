import java.util.Scanner;

public class SecondsAndMinutes {
    public static void main(String[] args) {
        Scanner timeScanner = new Scanner(System.in);
        System.out.println("Введите количество минут:");
        long minutes = timeScanner.nextInt();
        System.out.println("Введите количество секунд:");
        long second = timeScanner.nextInt();
        String result = getDurationString(second, minutes);
        System.out.println(result);

    }

    public static String getDurationString(long second, long minutes) {
        String textFirst;


        if (minutes >= 0 && second >= 0 || second <= 59) {


            long hour1 = minutes / 60;
            long newSecond = Long.parseLong(getDurationString(second));
            long min1 = newSecond;
            long hour2 = min1 / 60;
            long hour = hour1 + hour2;

            long min2 = minutes % 60;
            long min3 = min1 % 60;
            long min = min2 + min3;
            long sec = second % 60;


            textFirst = String.format("%02dh:%02dm:%02ds", hour, min, sec);
            // textFirst = String.format("%02d:%02d:%02d", hour, min, sec);


        } else {
            textFirst = "Invalid value";
        }
        return textFirst;
    }

    public static String getDurationString(long second) {
        String textDouble;
        if (second < 0) {
            textDouble = "Invalid value";
        } else {
            long min1 = second / 60;
            textDouble = Long.toString(min1);
        }
        return textDouble;

    }

}
