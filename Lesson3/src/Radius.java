import java.util.Scanner;

public class Radius {

    public static void main(String[] args) {
        Scanner radiusScan = new Scanner(System.in);
        System.out.println("Введите радиус = ");
        double radius = radiusScan.nextDouble();
        // formula P = 2* п * r
        // S = п * r(kvadrat)
        double perimeter = 2 * Math.PI * radius;
        double aria = Math.PI * Math.pow(radius, 2);

        System.out.println("Перимитр = " + perimeter);
        System.out.println("Площадь = " + aria);
    }
}