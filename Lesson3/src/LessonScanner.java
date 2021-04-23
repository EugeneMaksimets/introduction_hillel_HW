import java.util.Scanner;

public class LessonScanner {
    public static void main(String[] args) {
        Scanner cS = new Scanner(System.in);
        int numberA = cS.nextInt();
        int numberB = cS.nextInt();
        int c;
        if (numberA <= numberB) {
            c = numberA + numberB;
        } else {
            c = numberA - numberB;
        }
        System.out.print(c);
    }
}
