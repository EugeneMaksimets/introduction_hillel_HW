
public class FahrenheitToCelsius {

    public static void main(String[] args) {
        double TF = 212.0;

        System.out.println(TF + " градусов по Фарангейту = " + convertCelsiumToFahrenheit() + " по Цедьсию");
    }

    public static double convertCelsiumToFahrenheit() {
        double TF = 212.0;
        double TC = (TF - 32) * 5 / 9;
        return TC;

    }
}