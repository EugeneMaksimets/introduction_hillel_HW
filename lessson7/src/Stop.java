public class Stop {
    public static void main(String[] args) {
        int number = 125;
        sumDigits(number);

    }

    public static int sumDigits(int number) {
        int sum = 0;
        if (number < 10) {
            sum = -1;
        }
        while (number >= 10) {
            
                sum += number % 10;
                number /= 10;
                System.out.println(sum);

        }


        return sum;

    }

}


