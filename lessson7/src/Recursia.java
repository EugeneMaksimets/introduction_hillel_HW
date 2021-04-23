import java.util.Scanner;

public class Recursia {
    public static void main(String[] arg) {

        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Введите число: ");
        int sum = 0;
        int number = scannerInt.nextInt();
        int result = recursion(number);
        System.out.println("Сумма чисел: " + result);

    }

    public static int recursion(int number) {
        if (number > 10) {
            int tempvar = number % 10;
            int remain = number / 10;
            return tempvar + recursion(remain);
        } else {
            number = -1;
            return number;
        }

    }
}
