public class Formula {
    public static void main(String[] args) {
        int a = 3;
        int b = -14;
        int c = -5;
        final int DISCRIMINANT = (b * b) - (4 * a * c);
        // final int DISCRIMINANT = 0;
        // final int DISCRIMINANT = -1;
        // System.out.println(DISCRIMINANT);
        // formula = a * x * x + b * x + c = 0 ;
        if (DISCRIMINANT > 0) {
            System.out.println("x1 = " + (-b + Math.sqrt(DISCRIMINANT)) / (2 * a));
            System.out.println("x2 = " + (-b - Math.sqrt(DISCRIMINANT)) / (2 * a));

        } else if (DISCRIMINANT == 0) {
            System.out.println("x = " + (-b) / (2 * a));
        } else if (DISCRIMINANT < 0) {
            System.out.println("Уровнение не имеет корней");
        }

    }
}
