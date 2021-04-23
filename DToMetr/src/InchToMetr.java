public class InchToMetr {

    public static void main(String[] args) {
        double inch = 1000.0;

        System.out.println(inch + " дюьмов = " + convertInchToMetr() + " метров");
    }

    public static double convertInchToMetr() {
        double inch = 1000.0;
        double metr = inch * 0.0254;
        return metr;

    }
}

