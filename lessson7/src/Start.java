public class Start {
    public static void main(String[] args) {
        int startNumber = 10;
        int finishNumber = 100;
        while (startNumber <= finishNumber) {
            if (startNumber % 2 == 0) {
                System.out.println(startNumber);

            }
            startNumber++;

        }
    }
}
