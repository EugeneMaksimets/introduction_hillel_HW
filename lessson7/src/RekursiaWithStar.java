import java.util.Scanner;

public class RekursiaWithStar {

    public static void main(String[] arg) {

        Scanner s = new Scanner(System.in);
        System.out.println("Введите число: ");
        int sum = 0;
        int scanerInt = s.nextInt();
        int number = recursion(scanerInt);
        System.out.println("Сумма чисел: " + number);

    }

    public static int recursion(int number) {
        if (1 + number % 3 == 0) {
            int firstNumber = number % 10;
            int secondNum = number / 3;
            return secondNum;
        } else {
            return number;
        }

    }
}

