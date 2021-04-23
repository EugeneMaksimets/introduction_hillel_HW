public class Factarial {
    public static void main(String[] args) {
        int number = 5;
        int factarial = 1;

        for (int i = 1; i <= number; i++) {
            factarial *= i;

        }
        System.out.println(factarial);
        System.out.println(fact(number));
    }

    static int fact(int number) {
        if (number == 1) {
            return 1;
        }
        int stop = number * fact(number - 1);
        return stop;
    }

}
