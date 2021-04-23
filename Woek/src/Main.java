public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Test.Car car = new Test.Car("Зеленый", 1223);
        Test.Person person = new Test.Person(car, "Ваня");


        Test.Person clone = (Test.Person) person.clone();
        System.out.println(person);
        System.out.println(clone);
        clone.name = new String("Женя");
        clone.car.color = "Красный";
        System.out.println(person);
        System.out.println(clone);
        System.out.println(car.hashCode());
        System.out.println(car.equals(car));


    }


}





