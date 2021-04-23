
public class Second {
    public static void main(String[] args) {
        int[][] array = new int[7][5];
        int[] arrayOne = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Строка №" + i + " ");
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 11) - 5;
                System.out.print(array[i][j] + " ");
                if (j == 0) arrayOne[i] = array[i][j];
                else arrayOne[i] *= array[i][j];
                if (j == array[i].length - 1)
                    System.out.println(" ");
            }
        }

        int max = 0;
        int maxModul = 0;
        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = i; j < arrayOne.length; j++)
                if (Math.abs(arrayOne[i]) > max) {
                    max = arrayOne[i];
                    maxModul = i;
                } else if (Math.abs(arrayOne[j]) == max) {
                    max = arrayOne[j];
                    maxModul = j;
                }
        }
        System.out.println("Строка с наибольшим по модулю произведением элементов (" + max + ") имеет индекс - " + maxModul);
    }
}



