import java.util.Scanner;

public class DaysInMonth {

    public static void main(String[] args) {


        Scanner yearScan = new Scanner(System.in);
        System.out.println("Введите год: ");
        int year = yearScan.nextInt();
        final double YEAR_REMAINDER_FROM_FOUR = year % 4;
        final double YEAR_REMAINDER_FROM_HUNDRED = year % 100;
        final double YEAR_REMAINDER_FROM_FOUR_HUNDRED = year % 400;
        boolean yearLeap;
        if (year <= 0) {
            return;
        } else if (YEAR_REMAINDER_FROM_FOUR == 0 && YEAR_REMAINDER_FROM_HUNDRED > 0
                || YEAR_REMAINDER_FROM_FOUR_HUNDRED == 0) {
            yearLeap = true;
        } else {

            yearLeap = false;

        }

        System.out.println("Введите номер месяца: ");
        int numberMonth = yearScan.nextInt();
        final String JANUARY = "Январь ";
        final String FEBRUARY = "Февраль ";
        final String MARCH = "Март ";
        final String APRIL = "Апрель ";
        final String MAY = "Май ";
        final String JUNE = "Июнь ";
        final String JULY = "Июль ";
        final String AUGUST = "Август ";
        final String SEPTEMBER = "Сентябрь ";
        final String OCTOBER = "Октябрь ";
        final String NOVEMBER = "Ноябрь ";
        final String DECEMBER = "Декабрь ";
        final String THIRTY_ONE = " года - 31 день";
        final String THIRTY = " года - 30 дней";
        final String TWENTY_NINE = " года - 29 дней";
        final String TWENTY_EIGHT = " года - 28 дней";
        String monthString = null;
        String finalText;

        if (numberMonth > 12 || numberMonth <= 0) {
            return;
        } else if (numberMonth == 1 || numberMonth == 3 || numberMonth == 5 || numberMonth == 7 || numberMonth == 8
                || numberMonth == 10 || numberMonth == 12) {
            if (numberMonth == 1) {
                monthString = JANUARY;
            } else if (numberMonth == 3) {
                monthString = MARCH;
            } else if (numberMonth == 5) {
                monthString = MAY;
            } else if (numberMonth == 7) {
                monthString = JULY;
            } else if (numberMonth == 8) {
                monthString = AUGUST;
            } else if (numberMonth == 10) {
                monthString = OCTOBER;
            } else if (numberMonth == 12) {
                monthString = DECEMBER;
            }


            finalText = monthString + year + THIRTY_ONE;
            System.out.println(finalText);
        } else if (numberMonth == 2 && yearLeap == true) {
            monthString = FEBRUARY;
            finalText = monthString + year + TWENTY_NINE;


        } else if (numberMonth == 2 && yearLeap == false) {
            monthString = FEBRUARY;
            finalText = monthString + year + TWENTY_EIGHT;
            System.out.println(finalText);
        } else {
            if (numberMonth == 4) {
                monthString = APRIL;
            } else if (numberMonth == 6) {
                monthString = JUNE;
            } else if (numberMonth == 9) {
                monthString = SEPTEMBER;
            } else if (numberMonth == 11) {
                monthString = NOVEMBER;
            }
            finalText = monthString + year + THIRTY;



        }

        System.out.println(finalText);
    }
}
