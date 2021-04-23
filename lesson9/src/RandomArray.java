import java.util.Arrays;
import java.util.SplittableRandom;

public class RandomArray {
    public static void main(String[] args) {
        int[] arr = new int[40];
        for (int i = 0; i < arr.length; i++) {
            SplittableRandom random = new SplittableRandom();
            arr[i] = random.nextInt(10, 100);

        }
        print(arr);
        boolean chek = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                chek = false;
                break;
            }
        }
        if (chek) {
            System.out.println("Массив является строго возрастающей последовательностью");
        } else {
            System.out.println("Массив не является строго возрастающей последовательностью");
        }


//        System.out.println(Arrays.toString(arr));

    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }

    }

}
