

public class Number {
    public static void main(String[] args) {
        int number = 125;
        System.out.println(sumDigits(number));

    }

    public static int sumDigits(int number) {
        int sum = 0;
        if (number < 10) {
            sum = -1;
        }
        while (number >= 10) {
            int currentDigit;
            currentDigit = number % 10;
            sum = sum + currentDigit;
            number = number / 10;
            currentDigit = number % 10;
            sum = sum + currentDigit;
            number = number / 10;
            sum = sum + number;
                /*sum += number % 10;
                number /= 10;
                System.out.println(sum);*/

        }


        return sum;

    }

}
