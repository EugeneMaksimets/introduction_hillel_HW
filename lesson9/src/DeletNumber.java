import java.util.Arrays;
import java.util.Scanner;

public class DeletNumber {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 2, 3, 0, 4, 2};
        print(arr);
        Scanner scaner = new Scanner(System.in);
        System.out.println("Введите цифру коотрую удалить из масива: ");
        int delete = scaner.nextInt();
        int [] arrWithoutNumber = removeElement(arr,delete);
        System.out.println(Arrays.toString(arrWithoutNumber));

    }

    public static int[] removeElement(int arr[], int delete) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == delete) {
                count++;
            } else {
                arr[i - count] = arr[i];
            }
        }

        int[] newArray = new int[arr.length - count];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            System.out.println("В масиве есть следующие значений: " + arr[i]);
        }

    }
}
