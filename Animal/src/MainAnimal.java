import java.util.Scanner;

public class MainAnimal {

    public static void main(String[] args) {
        System.out.println("Введите ключ: ");
        scanCheck();
    }

    public static void scanCheck() {
        Scanner scanKey = new Scanner(System.in);
        String key = scanKey.next();
        AnimalFactory.getAnimalByKey(key);
        Animal abstractAnimal = AnimalFactory.getAnimalByKey(key);

        if (AnimalFactory.getAnimalByKey(key) == null) {
            System.out.println("Не могу создать Animal \n Введите другой ключ: ");
            scanCheck();


        } else {
            System.out.println(abstractAnimal.getName());
            System.exit(0);
        }
    }
}