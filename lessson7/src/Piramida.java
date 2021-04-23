public class Piramida {
    public static void main(String[] args) {
        int num = 1;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < i; j++) {
                System.out.println(num);
                num++;
            }
            System.out.println();
        }

    }
}