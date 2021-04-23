import java.util.Scanner;


public class DaysWeek {
    public static void main(String[] args) {
        final String TEXT_HELLO = "Введите какой по счету сегодня день недели:";
        System.out.println(TEXT_HELLO);
        Scanner dayScanner = new Scanner(System.in);
        int day = dayScanner.nextInt();
        printDayOfTheWeek(day);
        String day1 = Integer.toString(day);
        printDayOfTheWeek(day1);


    }

    public static void printDayOfTheWeek(int day) {
        String finalText = null;
        if (day > 7 || day <= 0) {
            finalText = "Invalid day";
        } else {
            switch (day) {
                case 1:
                    finalText = "Понедельник";
                    break;
                case 2:
                    finalText = "Вторник";
                    break;
                case 3:
                    finalText = "Среда";
                    break;
                case 4:
                    finalText = "Четверг";
                    break;
                case 5:
                    finalText = "Пятница";
                    break;
                case 6:
                    finalText = "Суббота";
                    break;
                case 7:
                    finalText = "Воскресенье";
                    break;
            }

        }
        System.out.println(finalText);

    }

    public static void printDayOfTheWeek(String day) {
        String newFinalText;
        int dayInt = Integer.parseInt(day);
        if (dayInt >= 8 || dayInt <= 0) {
            newFinalText = "Invalid day";
        } else if (dayInt == 1) {
            newFinalText = "Понедельник";

        } else if (dayInt == 2) {
            newFinalText = "Вторник";
        } else if (dayInt == 3) {
            newFinalText = "Среда";
        } else if (dayInt == 4) {
            newFinalText = "Четверг";
        } else if (dayInt == 5) {
            newFinalText = "Пятница";
        } else if (dayInt == 6) {
            newFinalText = "Суббота";
        } else {
            newFinalText = "Воскресенье";

        }
        System.out.println(newFinalText);
    }
}

