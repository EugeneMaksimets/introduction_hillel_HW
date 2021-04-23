public class Dog extends Animal {


    public Dog(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return "Я собака. Меня зовут - " + super.getName();
    }
}
