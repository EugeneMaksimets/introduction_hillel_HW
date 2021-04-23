import java.util.Scanner;

public class MiddleNumber {
    public static void main(String[] args) {
        Scanner numberScan = new Scanner(System.in);
        final String NEW_NUMBER = "Введите число";
        final String TEXT_SUM_NUMBER = "Сумма чисел = ";
        final String TEXT_MIDDLE_NUMBER = "Средние число чисел = ";
        System.out.println(NEW_NUMBER);
        int firstNumber = numberScan.nextInt();
        System.out.println(NEW_NUMBER);
        int secondNumber = numberScan.nextInt();
        System.out.println(NEW_NUMBER);
        int thirdNumber = numberScan.nextInt();
        System.out.println(NEW_NUMBER);
        int fourNumber = numberScan.nextInt();
        System.out.println(NEW_NUMBER);
        int fiveNumber = numberScan.nextInt();
        int sumNumber = firstNumber + secondNumber + thirdNumber + fourNumber + fiveNumber;
        int middleNumber = sumNumber / 5;
        System.out.println(TEXT_SUM_NUMBER + sumNumber);
        System.out.println(TEXT_MIDDLE_NUMBER + middleNumber);
    }
}
