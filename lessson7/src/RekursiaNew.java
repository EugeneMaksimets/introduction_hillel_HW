import java.util.Scanner;

public class RekursiaNew {
    public static void main(String[] arg) {

        Scanner s = new Scanner(System.in);
        System.out.println("Введите число: ");
        int sum = 0;
        int scanerInt = s.nextInt();
        int number = recursion(scanerInt);
        System.out.println("Сумма чисел: " + number);

    }

    public static int recursion(int number) {
        if (number / 10 >= 1) {
            int firstNumber = number % 10;
            int secondNum = number / 10;
            return firstNumber + recursion(secondNum);
        } else {
            return number;
        }

    }
}
