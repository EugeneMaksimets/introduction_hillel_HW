public class NumberOne {
    public static void main(String[] args) {
        int sum = 0;
        int counter = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i);
                sum = sum + i;

                counter++;

            }
            if (counter == 5) {
                break;
            }

        }
        System.out.println("Sum = " + sum);
    }
}
