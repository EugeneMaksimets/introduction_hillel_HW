import java.util.Scanner;

public class Table {


    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int integer = 0;
        System.out.println("Введите чиселко(1-9):");
        integer = scn.nextInt();
        System.out.print("\n");
        for (int i = 1; i < 10; i++) {
            System.out.println(integer + " * " + i + " = " + integer * i);
        }
    }
}

