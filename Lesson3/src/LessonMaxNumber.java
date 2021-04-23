import java.util.Scanner;


public class LessonMaxNumber {
    public static void main(String[] args) {
        Scanner cS = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = cS.nextInt();
        System.out.println("Введите второе число: ");
        int b = cS.nextInt();
        System.out.println("Введите третие число: ");
        int c = cS.nextInt();

        if (a > b && b > c) {
            System.out.println(a);
        } else if (b > a && b > c) {
            System.out.println(b);

        } else {
            System.out.println(c);
        }
    }
}