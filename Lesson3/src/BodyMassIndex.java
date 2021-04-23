import java.util.Scanner;

public class BodyMassIndex {

    public static void main(String[] args) {
        final String NAME_TEXT = "Введите имя: ";
        final String WEIGHT_TEXT = "Введите вес в килограмах: ";
        final String HEIGHT_TEXT = "Введите рост в сантиметрах: ";
        System.out.println(NAME_TEXT);
        Scanner humanScanner = new Scanner(System.in);
        String name = humanScanner.next();
        System.out.println(WEIGHT_TEXT);
        int wight = humanScanner.nextInt();
        System.out.println(HEIGHT_TEXT);
        double height = humanScanner.nextDouble() / 100;
//        System.out.println(BodyMassIndex(wight, height));
//        System.out.println(Interpretation(BodyMassIndex(wight, height)));
        printResult(name, wight, height, bodyMassIndex(wight, height), interpretation(bodyMassIndex(wight, height)));

    }

    public static double bodyMassIndex(int wight, double height) {
        //formula I = m / h pow2
        double result = wight / (Math.pow(height, 2));

        return Math.round(result);

    }

    public static String interpretation(double result) {
        final String TEXT_DEFICIT = "\n Выраженный дефицит массы тела";
        final String TEXT_LIGHT_DEFICIT = "\n Недостаточная (дефицит) масса тела";
        final String TEXT_NORM = "\n Норма";
        final String TEXT_LIGHT_EXES = "\n Избыточная масса тела (предожирение)";
        final String TEXT_EXES = "\n Ожирение";
        final String TEXT_HARD_EXES = "\n Ожирение резкое";
        final String TEXT_HARDEST_EXES = "\n Очень резкое ожирение";
        String massIndex;
        if (result < 16) {
            massIndex = TEXT_DEFICIT;

        } else if (result >= 16 && result < 18.5) {
            massIndex = TEXT_LIGHT_DEFICIT;

        } else if (result >= 18.5 && result < 25) {
            massIndex = TEXT_NORM;

        } else if (result >= 25 && result < 30) {
            massIndex = TEXT_LIGHT_EXES;

        } else if (result >= 30 && result < 35) {
            massIndex = TEXT_EXES;

        } else if (result <= 35 && result < 40) {
            massIndex = TEXT_HARD_EXES;

        } else {
            massIndex = TEXT_HARDEST_EXES;
        }
        return massIndex;
    }

    public static void printResult(String name, double wight, double height, double result, String massIndex) {
        final String FINAL_TEXT_WIGHT = " ваш вес ";
        final String FINAL_TEXT_HEIGHT = "ваш рост ";
        final String FINAL_TEXT_RESULT = "\n Индекс массы тела = ";
        final String TEXT_KG = " килограма ";
        final String TEXT_METR = " метра ";
        System.out.println(name + FINAL_TEXT_WIGHT + wight + TEXT_KG + FINAL_TEXT_HEIGHT + height +
                TEXT_METR + FINAL_TEXT_RESULT + result + massIndex);

    }


}