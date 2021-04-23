public class newLessson {
    public static void main(String[] args) {
        int[] arr = {3, 7, 11, 15, 19, 33, 50};
        int findNumber = 33;
        int found = binarySerch(arr, findNumber);
        System.out.println(found);
    }

    public static int binarySerch(int[] arr, int findNumber) {
        int low = 0;
        int hight = arr.length - 1;
        while (low <= hight) {
            int mid = (low + hight) / 2;
            if (arr[mid] == findNumber) {
                return mid;
            }
            if (findNumber > arr[mid]) {
                low = mid - 1;

            } else {
                hight = mid - 1;
            }
        }
        return -1;

    }
}
