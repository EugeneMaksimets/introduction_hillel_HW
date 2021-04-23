import java.util.SplittableRandom;

public class First {
    public static void main(String[] args) {
        int[][] array = new int[6][9];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                SplittableRandom random = new SplittableRandom();
                array[i][j] = random.nextInt(-99, 100);
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("\n");
        }
        

        int min = array[0][0];
        for (
                int i = 0;
                i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > min) min = array[i][j];
            }
        }
        System.out.println(" ");
        System.out.println("Значение максимального элемента массива = " + min);
    }
}

