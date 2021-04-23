import java.util.SplittableRandom;

public class Third {
    public static void main(String[] args) {
        int column = 5;
        int line = 3;
        int[][] array = new int[line][column];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                SplittableRandom random = new SplittableRandom();
                array[i][j] = random.nextInt(0, 10);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        int min;

        for (int i = 0; i < array.length; i++) {
            for (int j = array[i].length - 1; j > 0; j--) {
                if (array[i][j] < array[i][j - 1]) {
                    min = array[i][j];
                    array[i][j] = array[i][j - 1];
                    array[i][j - 1] = min;
                }
            }
        }
        int max = 0, temp_index = 0;
        ;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == 0) max = array[i][j];
                else {
                    if (max < array[i][j]) {
                        max = array[i][j];
                        temp_index = j;
                    }
                }
                if (j == array[i].length - 1) {
                    int temp = array[i][column - 1];
                    array[i][column - 1] = array[i][temp_index];
                    array[i][temp_index] = temp;
                }
            }
        }
        System.out.println("\n Перемещеные \n");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                System.out.print(array[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}

