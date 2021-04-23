import java.util.Arrays;

public class Lesson10 {
    public static void main(String[] args) {


        int[] arr = {7, 10, 5, 3, 8, 4, 2, 9, 6};
        for (int i = 0; i < arr.length; i++) {
            int minElIndex = 1;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < arr[minElIndex]) {
                    minElIndex = j;

                }


            }
            if (minElIndex != i) {
                int temp = arr[minElIndex];
                arr[i] = arr[minElIndex];
                arr[minElIndex] = temp;

            }
            System.out.println(Arrays.toString(arr));


        }
    }

}
