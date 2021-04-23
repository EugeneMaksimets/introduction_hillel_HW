import java.util.Scanner;


public class LeapYear {
    public static void main(String[] args) {
        Scanner newScan = new Scanner(System.in);
        System.out.println("Введите год: ");
        int year = newScan.nextInt();
        final double YEAR_REMAINDER_FROM_FOUR = year % 4;
        final double YEAR_REMAINDER_FROM_HUNDRED = year % 100;
        final double YEAR_REMAINDER_FROM_FOUR_HUNDRED = year % 400;
        final String TEXT_YEAR_LEAP = "-й год представляет собой високосный год (в нем 366 дней)";
        final String TEXT_NO_YEAR_LEAP = "-й год не является високосным (365 дней)";
        String finalText;
/* если год делится на 4(если нет то элсэ) то пробуем делить на 100(если не делится то высокотный) если делиться то
пробуем делить на 400, если  делится на то высокостный если нет то элсэ*/
        //        if (year % YEAR_REMAINDER_FROM_HUNDRED == 0 && YEAR_REMAINDER_FROM_FOUR_HUNDRED == 0) {
//            System.out.println("yes");
//        } else if (YEAR_REMAINDER_FROM_FOUR == 0 && YEAR_REMAINDER_FROM_HUNDRED > 0) {
//            System.out.println("yes");
//        } else if (YEAR_REMAINDER_FROM_HUNDRED == 0) {
//            System.out.println("no");
//        } else {
//            System.out.println("no");
        if (YEAR_REMAINDER_FROM_FOUR == 0 && YEAR_REMAINDER_FROM_HUNDRED > 0
                || YEAR_REMAINDER_FROM_FOUR_HUNDRED == 0) {
            finalText = year + TEXT_YEAR_LEAP;
        } else {
            finalText = year + TEXT_NO_YEAR_LEAP;
        }
        System.out.println(finalText);
    }


}
