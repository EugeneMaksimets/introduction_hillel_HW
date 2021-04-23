

import java.util.Scanner;

public class ArrayDemo {
    static Scanner scaner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите число в масиве:");
        int count = scaner.nextInt();
        int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Введите данные массива");
            int element = scaner.nextInt();
            arr[i] = element;

        }
        /*print(arr);*/
        int sumArr = sumArray(arr);
        int midArr = midArray(sumArr, count);
        int maxElement = findMax(arr);
        System.out.println("Сумма чисел в масиве = " + sumArr);
        System.out.println("Средние арефмитическое число суммы масива = " + midArr);
        System.out.println("Максимальное значение в масиве = " + maxElement);
        System.out.println("Введите на сколько уведичить новый масив: ");
        int nextCount = scaner.nextInt();
        int[] megaArray = nextArray(nextCount, arr);
        reverse(megaArray);


    }

    public static void reverse(int[] megaArray) {
        for (int i = 0; i < megaArray.length / 2; i++) {
            int revers = megaArray[i];
            megaArray[i] = megaArray[megaArray.length - 1 - i];
            megaArray[megaArray.length - 1 - i] = revers;
//             System.out.println(Arrays.toString(megaArray));
            print(megaArray);
        }
    }

    static void print(int[] megaArray) {
        for (int i = 0; i < megaArray.length; i++) {

            System.out.println(megaArray[i]);
        }

    }
      /*  static void print(int[] arr) {
        for (int element : arr) {
            System.out.println(element);
        }
    }*/


    public static int[] nextArray(int nextCount, int[] arr) {

        int[] theNewArray = new int[nextCount];
        for (int i = 0; i < theNewArray.length; i++) {
            System.out.println("Введите данные массива");
            int element = scaner.nextInt();
            theNewArray[i] = element;


        }
        int[] megaArray = new int[arr.length + theNewArray.length];
        int theNewCount = 0;
        for (int i = 0; i < arr.length; i++) {
            megaArray[i] = arr[i];
            theNewCount++;
        }
        for (int j = 0; j < theNewArray.length; j++) {
            megaArray[theNewCount++] = theNewArray[j];
        }

        return megaArray;
    }


    public static int findMax(int[] array) {
        int maxEl = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxEl) {
                maxEl = array[i];
            }
        }
        return maxEl;
    }


    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static int midArray(int sumArr, int count) {
        int midNumber = sumArr / count;
        return midNumber;

    }


}
