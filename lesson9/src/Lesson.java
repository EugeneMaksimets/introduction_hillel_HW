import java.util.Arrays;
import java.util.Scanner;

public class Lesson {
    static Scanner scaner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите число в масиве:");

        int count = scaner.nextInt();
        int[] arr = readInt(count);
        System.out.println(Arrays.toString(arr));
        int minElement = findMin(arr);
        System.out.println("Min El = " + minElement);

    }

    public static int[] readInt(int count) {
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите данные массива");
            int element = scaner.nextInt();
            array[i] = element;

        }
        return array;

    }

    static int findMin(int[] array) {
        /*int minEl = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            minEl = array[i];

        }*/
        int minEl = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minEl) {
                minEl = array[i];
            }

        }
        return minEl;
    }

}
