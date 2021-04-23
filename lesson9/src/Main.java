public class Main {

    public static void main(String[] args) {
        int[] array = new int[5];
        print(array);

    }

    static void print(int[] arr) /*{
        for (int element : arr) {
            System.out.println(element);
        }*/ {
        for (int i = 0; i < arr.length; i++){

        System.out.println(arr[i]);
        }

    }
}
