import java.util.Scanner;

public class LessonHypotenuse {
    public static void main(String[] args) {
        Scanner cS = new Scanner(System.in);
        System.out.println("Введите сторону а = ");
        int numberA = cS.nextInt();
        System.out.println("Введите сторону b = ");
        int numberB = cS.nextInt();
        /*final String TEXT_ERROR = "Не верное значение";*/
        final String TEXT_HYPOTENUSE = "Гипотенуза = ";
        String cText;


        if (numberA <= 0 || numberB <= 0) {
            /*cText = TEXT_ERROR;*/
            return;


        } else {

            double c = Math.sqrt(Math.pow(numberA, 2) + Math.pow(numberB, 2));
            cText = TEXT_HYPOTENUSE + c;

        }
        System.out.println(cText);
    }

}
