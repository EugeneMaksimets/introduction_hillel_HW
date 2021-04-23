import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlowerPack pack = new FlowerPack();
        System.out.println("Введите желаемое количество цветков в букете: ");
        Scanner scan = new Scanner(System.in);
        int chek = scan.nextInt();
        int count = 0;
        System.out.println("Введите цифру что бы добавить цветок: \n '1' Что бы добавить Розу\n" +
                " '2' Что бы добавить Тюльпан \n '3' Что бы дообавить Ромашку \n '4' Что бы добавит Гвоздику");
        check2(pack, scan, chek, count);
        System.out.println(pack.toString());
    }

    private static void check2(FlowerPack pack, Scanner scan, int chek, int count) {
        if (count < chek) {
            check(pack, scan, chek);
        }
    }

    private static void check(FlowerPack pack, Scanner scan, int chek) {
        int count;
        for (count = 0; count < chek; count++) {

            int name = scan.nextInt();
            switch (name) {
                case 1:
                    pack.add(new Rose());
                    System.out.println();
                    break;
                case 2:
                    pack.add(new Tulip());
                    break;
                case 3:
                    pack.add(new Chamomile());
                    break;
                case 4:
                    pack.add(new Carnation());
                    break;
            }
        }
        check2(pack, scan, chek, count);
    }
}
